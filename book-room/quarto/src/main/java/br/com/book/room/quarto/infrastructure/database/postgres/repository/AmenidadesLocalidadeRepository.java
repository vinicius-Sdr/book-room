package br.com.book.room.quarto.infrastructure.database.postgres.repository;

import java.util.Optional;

import br.com.book.room.quarto.applicaton.exception.BookRoomDataIntegrityViolationException;
import br.com.book.room.quarto.applicaton.exception.BookRoomEntityNotFoundException;
import br.com.book.room.quarto.applicaton.exception.BookRoomUniqueViolationException;
import br.com.book.room.quarto.domain.core.amenidadelocalidade.AmenidadesLocalidade;
import br.com.book.room.quarto.domain.core.amenidadelocalidade.AmenidadesLocalidadeId;
import br.com.book.room.quarto.domain.core.amenidadelocalidade.AmenidadesLocalidadeRepositoryPort;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.AmenidadesLocalidadeEntity;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.AmenidadesLocalidadeEntityId;
import br.com.book.room.quarto.infrastructure.database.postgres.mapper.AmenidadesLocalidadeMapper;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmenidadesLocalidadeRepository extends
		JpaRepository<AmenidadesLocalidadeEntity, AmenidadesLocalidadeEntityId>, AmenidadesLocalidadeRepositoryPort {

	String AMENIDADES_LOCALIDADE_NAO_ENCONTRADA = "AmenidadesLocalidade não encontrada";

	String AMENIDADES_LOCALIDADE_JA_CADASTRADA = "AmenidadesLocalidade já cadastrada";

	@Override
	default Page<AmenidadesLocalidade> findAllAmenidadesLocalidade(Pageable pageable) {
		Page<AmenidadesLocalidadeEntity> entities = findAll(pageable);
		return entities.map(AmenidadesLocalidadeMapper::toDomain);
	}

	@Override
	default AmenidadesLocalidade findAmenidadesLocalidadeById(AmenidadesLocalidadeEntityId id) {
		return findById(id).map(AmenidadesLocalidadeMapper::toDomain)
			.orElseThrow(() -> new BookRoomEntityNotFoundException(AMENIDADES_LOCALIDADE_NAO_ENCONTRADA));
	}

	@Override
	default AmenidadesLocalidade saveAmenidadesLocalidade(AmenidadesLocalidade amenidadesLocalidade) {

		Optional<AmenidadesLocalidadeEntity> existingEntity = findById(new AmenidadesLocalidadeEntityId(
				amenidadesLocalidade.id().idLocalidade(), amenidadesLocalidade.id().idAmenidade()));

		if (existingEntity.isPresent()) {
			throw new BookRoomUniqueViolationException(AMENIDADES_LOCALIDADE_JA_CADASTRADA);
		}

		AmenidadesLocalidadeEntity entityToSave = AmenidadesLocalidadeMapper.toEntity(amenidadesLocalidade);
		AmenidadesLocalidadeEntity savedEntity = save(entityToSave);
		return AmenidadesLocalidadeMapper.toDomain(savedEntity);
	}

	@Override
	default void deleteAmenidadesLocalidadeById(Long idLocalidade, Long idAmenidade) {
		try {
			deleteById(new AmenidadesLocalidadeEntityId(idLocalidade, idAmenidade));
		}
		catch (DataIntegrityViolationException e) {
			throw new BookRoomDataIntegrityViolationException(
					"AmenidadesLocalidade não pode ser excluída pois está vinculada a outras tabelas", e);
		}
	}

	default AmenidadesLocalidade atualizarQuantidadePorId(AmenidadesLocalidadeId id, Integer quantidade) {
		AmenidadesLocalidadeEntity savedEntity = null;
		try {
			savedEntity = findById(new AmenidadesLocalidadeEntityId(id.idLocalidade(), id.idAmenidade()))
				.orElseThrow(() -> new RuntimeException(AMENIDADES_LOCALIDADE_NAO_ENCONTRADA));
			savedEntity.setQuantidade(quantidade);
			savedEntity = save(savedEntity);
		}
		catch (jakarta.persistence.EntityNotFoundException e) {
			throw new BookRoomEntityNotFoundException(AMENIDADES_LOCALIDADE_NAO_ENCONTRADA, e);
		}

		return AmenidadesLocalidadeMapper.toDomain(savedEntity);
	}

	@Override
	@Transactional
	default AmenidadesLocalidade alterarAmenidadesLocalidade(AmenidadesLocalidadeEntityId id,
			AmenidadesLocalidade amenidadesLocalidade) {
		AmenidadesLocalidadeEntity entity = null;
		AmenidadesLocalidadeEntity savedEntity = null;
		try {
			entity = findById(id).orElseThrow(() -> new RuntimeException(AMENIDADES_LOCALIDADE_NAO_ENCONTRADA));
			entity = AmenidadesLocalidadeMapper.toEntity(amenidadesLocalidade);
			savedEntity = save(entity);
		}
		catch (jakarta.persistence.EntityNotFoundException e) {
			throw new BookRoomEntityNotFoundException(AMENIDADES_LOCALIDADE_NAO_ENCONTRADA, e);
		}
		catch (DataIntegrityViolationException e) {
			throw new BookRoomUniqueViolationException(AMENIDADES_LOCALIDADE_JA_CADASTRADA, e);
		}
		return AmenidadesLocalidadeMapper.toDomain(savedEntity);
	}

}