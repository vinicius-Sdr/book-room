package br.com.book.room.quarto.infrastructure.database.postgres.repository;

import java.util.Optional;

import br.com.book.room.quarto.applicaton.exception.BookRoomEntityNotFoundException;
import br.com.book.room.quarto.applicaton.exception.BookRoomUniqueViolationException;
import br.com.book.room.quarto.domain.core.localidade.Localidade;
import br.com.book.room.quarto.domain.core.localidade.LocalidadeRepositoryPort;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.LocalidadeEntity;
import br.com.book.room.quarto.infrastructure.database.postgres.mapper.LocalidadeMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;

public interface LocalidadeRepository extends JpaRepository<LocalidadeEntity, Long>, LocalidadeRepositoryPort {

	String LOCALIDADE_NAO_ENCONTRADA = "Localidade não encontrada";

	String LOCALIDADE_JA_CADASTRADA = "Localidade já cadastrada";

	default Page<Localidade> findAllLocalidades(Pageable pageable) {
		Page<LocalidadeEntity> entities = findAll(pageable);
		return entities.map(LocalidadeMapper::toDomain);
	}

	default Localidade findLocalidadeById(Long id) {
		Optional<LocalidadeEntity> entity = findById(id);
		return entity.map(LocalidadeMapper::toDomain)
			.orElseThrow(() -> new BookRoomEntityNotFoundException(LOCALIDADE_NAO_ENCONTRADA));
	}

	default Localidade saveLocalidade(Localidade localidade) {
		LocalidadeEntity savedEntity = null;
		try {
			LocalidadeEntity entity = LocalidadeMapper.toEntity(localidade);
			savedEntity = save(entity);
		}
		catch (DataIntegrityViolationException e) {
			throw new BookRoomUniqueViolationException(LOCALIDADE_JA_CADASTRADA, e);
		}
		return LocalidadeMapper.toDomain(savedEntity);
	}

	default void deleteLocalidadeById(Long id) {
		var localidade = findLocalidadeById(id);
		deleteById(localidade.id());
	}

	default Localidade alterarLocalidade(Long id, Localidade localidade) {
		LocalidadeEntity entity = null;
		LocalidadeEntity savedEntity = null;
		try {
			entity = getReferenceById(id);
			if (!entity.getNome().equalsIgnoreCase(localidade.nome())) {
				entity.setNome(localidade.nome());
			}
			entity.setRuaAv(localidade.ruaAv());
			entity.setNumero(localidade.numero());
			entity.setCep(localidade.cep());
			entity.setCidade(localidade.cidade());
			entity.setEstado(localidade.estado());
			savedEntity = save(entity);
		}
		catch (jakarta.persistence.EntityNotFoundException e) {
			throw new BookRoomEntityNotFoundException(LOCALIDADE_NAO_ENCONTRADA, e);
		}
		catch (DataIntegrityViolationException e) {
			throw new BookRoomUniqueViolationException(LOCALIDADE_JA_CADASTRADA, e);
		}
		return LocalidadeMapper.toDomain(savedEntity);
	}

}