package br.com.book.room.quarto.infrastructure.database.postgres.repository;

import java.util.Optional;

import br.com.book.room.quarto.applicaton.exception.BookRoomUniqueViolationException;
import br.com.book.room.quarto.applicaton.exception.BookRoomEntityNotFoundException;
import br.com.book.room.quarto.domain.core.amenidade.Amenidade;
import br.com.book.room.quarto.domain.core.amenidade.AmenidadeRepositoryPort;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.AmenidadeEntity;
import br.com.book.room.quarto.infrastructure.database.postgres.mapper.AmenidadeMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmenidadeRepository extends JpaRepository<AmenidadeEntity, Long>, AmenidadeRepositoryPort {

	String AMENIDADE_JA_CADASTRADA = "Amenidade já cadastrada";

	String AMENIDADE_NAO_ENCONTRADA = "Amenidade não encontrada";

	default Page<Amenidade> findAllAmenidades(Pageable pageable) {
		Page<AmenidadeEntity> entities = findAll(pageable);
		return entities.map(AmenidadeMapper::toDomain);
	}

	default Amenidade findAmenidadeById(Long id) {
		Optional<AmenidadeEntity> entity = findById(id);
		return entity.map(AmenidadeMapper::toDomain)
			.orElseThrow(() -> new BookRoomEntityNotFoundException(AMENIDADE_NAO_ENCONTRADA));
	}

	default Amenidade saveAmenidade(Amenidade amenidade) {
		AmenidadeEntity savedEntity = null;
		try {
			AmenidadeEntity entity = AmenidadeMapper.toEntity(amenidade);
			savedEntity = save(entity);

		}
		catch (DataIntegrityViolationException e) {
			throw new BookRoomUniqueViolationException(AMENIDADE_JA_CADASTRADA, e);
		}
		return AmenidadeMapper.toDomain(savedEntity);
	}

	default void deleteAmenidadeById(Long id) {
		var amenidade = findAmenidadeById(id);
		try {

			deleteById(amenidade.id());
		}
		catch (DataIntegrityViolationException e) {
			throw new BookRoomUniqueViolationException(
					"Amenidade não pode ser excluído pois está vinculado a outras tabelas", e);
		}

	}

	default Amenidade alterarAmenidade(Long id, Amenidade amenidade) {
		AmenidadeEntity entity = null;
		try {

			entity = getReferenceById(id);
			if (!entity.getDescricao().equalsIgnoreCase(amenidade.descricao())) {
				entity.setDescricao(amenidade.descricao());
				entity = save(entity);
			}

		}
		catch (jakarta.persistence.EntityNotFoundException e) {
			throw new BookRoomEntityNotFoundException(AMENIDADE_NAO_ENCONTRADA, e);
		}
		catch (DataIntegrityViolationException e) {
			throw new BookRoomUniqueViolationException(AMENIDADE_JA_CADASTRADA, e);
		}
		return AmenidadeMapper.toDomain(entity);
	}

}