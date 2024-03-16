package br.com.book.room.quarto.infrastructure.database.postgres.repository;

import java.util.Optional;

import br.com.book.room.quarto.applicaton.exception.BookRoomEntityNotFoundException;
import br.com.book.room.quarto.applicaton.exception.BookRoomUniqueViolationException;
import br.com.book.room.quarto.domain.core.tipo.Tipo;
import br.com.book.room.quarto.domain.core.tipo.TipoRepositoryPort;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.TipoEntity;
import br.com.book.room.quarto.infrastructure.database.postgres.mapper.TipoMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRepository extends JpaRepository<TipoEntity, Long>, TipoRepositoryPort {

	String TIPO_NAO_ENCONTRADO = "Tipo não encontrado";

	String TIPO_JA_CADASTRADO = "Tipo já cadastrado";

	default Page<Tipo> findAllTipos(Pageable pageable) {
		Page<TipoEntity> entities = findAll(pageable);
		return entities.map(TipoMapper::toDomain);
	}

	default Tipo findTipoById(Long id) {
		Optional<TipoEntity> entity = findById(id);
		return entity.map(TipoMapper::toDomain)
			.orElseThrow(() -> new BookRoomEntityNotFoundException(TIPO_NAO_ENCONTRADO));
	}

	default Tipo saveTipo(Tipo tipo) {
		TipoEntity savedEntity = null;
		try {
			TipoEntity entity = TipoMapper.toEntity(tipo);
			savedEntity = save(entity);
		}
		catch (DataIntegrityViolationException e) {
			throw new BookRoomUniqueViolationException(TIPO_JA_CADASTRADO, e);
		}
		return TipoMapper.toDomain(savedEntity);
	}

	default void deleteTipoById(Long id) {
		try {
			var tipo = findTipoById(id);
			deleteById(tipo.id());
		}
		catch (DataIntegrityViolationException e) {
			throw new BookRoomEntityNotFoundException("Tipo não pode ser excluído pois está vinculado a outras tabelas",
					e);
		}
	}

	default Tipo alterarTipo(Long id, Tipo tipo) {
		TipoEntity entity = null;
		TipoEntity savedEntity = null;
		try {
			entity = getReferenceById(id);
			if (!entity.getNome().equalsIgnoreCase(tipo.nome())) {
				entity.setNome(tipo.nome());
			}
			if (!entity.getCategoria().equalsIgnoreCase(tipo.categoria())) {
				entity.setCategoria(tipo.categoria());
			}
			savedEntity = save(entity);
		}
		catch (jakarta.persistence.EntityNotFoundException e) {
			throw new BookRoomEntityNotFoundException(TIPO_NAO_ENCONTRADO, e);
		}
		catch (DataIntegrityViolationException e) {
			throw new BookRoomUniqueViolationException(TIPO_JA_CADASTRADO, e);
		}
		return TipoMapper.toDomain(savedEntity);
	}

}