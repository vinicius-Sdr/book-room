package br.com.book.room.quarto.infrastructure.database.postgres.repository;

import br.com.book.room.quarto.applicaton.exception.BookRoomDataIntegrityViolationException;
import br.com.book.room.quarto.applicaton.exception.BookRoomEntityNotFoundException;
import br.com.book.room.quarto.applicaton.exception.BookRoomUniqueViolationException;
import br.com.book.room.quarto.domain.core.quarto.Quarto;
import br.com.book.room.quarto.domain.core.quarto.QuartoRepositoryPort;

import br.com.book.room.quarto.infrastructure.database.postgres.entity.QuartoEntity;
import br.com.book.room.quarto.infrastructure.database.postgres.mapper.QuartoMapper;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuartoRepository extends JpaRepository<QuartoEntity, Long>, QuartoRepositoryPort {

	default Quarto cadastrarQuarto(Quarto quarto) {
		QuartoEntity savedQuarto = null;

		try {
			savedQuarto = save(QuartoMapper.toEntity(quarto));
		}
		catch (DataIntegrityViolationException e) {
			throw new BookRoomUniqueViolationException(" já cadastrado");
		}

		return QuartoMapper.toDomain(savedQuarto);
	}

	default Page<Quarto> findAllQuartos(Pageable pageable) {
		Page<QuartoEntity> entities = findAll(pageable);
		return entities.map(QuartoMapper::toDomain);
	}

	default Quarto findQuartoById(Long id) {
		QuartoEntity entity = findById(id).orElseThrow(() -> new BookRoomEntityNotFoundException(" não encontrado"));
		return QuartoMapper.toDomain(entity);
	}

	default Quarto saveQuarto(Quarto quarto) {
		QuartoEntity savedEntity = null;
		try {
			QuartoEntity entity = QuartoMapper.toEntity(quarto);
			savedEntity = save(entity);
		}
		catch (DataIntegrityViolationException e) {
			throw new BookRoomUniqueViolationException(" já cadastrado", e);
		}
		return QuartoMapper.toDomain(savedEntity);
	}

	default void deleteQuartoById(Long id) {
		try {
			findQuartoById(id);
			deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new BookRoomDataIntegrityViolationException(
					" não pode ser excluído pois está vinculado a outras tabelas", e);
		}
	}

	default Quarto alterarQuarto(Long id, Quarto quarto) {
		QuartoEntity entity = findById(id).orElseThrow(() -> new BookRoomEntityNotFoundException(" não encontrado"));
		try {
			entity = save(QuartoMapper.updateEntityFromDomain(quarto, entity));

		}
		catch (jakarta.persistence.EntityNotFoundException e) {
			throw new BookRoomEntityNotFoundException(" não encontrado", e);
		}
		catch (DataIntegrityViolationException e) {
			throw new BookRoomUniqueViolationException(" já cadastrado", e);
		}
		return QuartoMapper.toDomain(entity);
	}

}