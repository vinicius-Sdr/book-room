package br.com.book.room.quarto.infrastructure.database.postgres.repository;

import br.com.book.room.quarto.domain.core.predio.Predio;
import br.com.book.room.quarto.domain.core.predio.PredioRepositoryPort;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.LocalidadeEntity;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.PredioEntity;
import br.com.book.room.quarto.infrastructure.database.postgres.mapper.LocalidadeMapper;
import br.com.book.room.quarto.infrastructure.database.postgres.mapper.PredioMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PredioRepository extends JpaRepository<PredioEntity, Long>, PredioRepositoryPort {

	@Override
	default Page<Predio> findAllPredios(Pageable pageable) {
		Page<PredioEntity> entities = findAll(pageable);
		return entities.map(PredioMapper::toDomain);
	}

	@Override
	default Predio findPredioById(Long id) {
		PredioEntity entity = findById(id).orElseThrow(() -> new RuntimeException("Predio not found"));
		return PredioMapper.toDomain(entity);
	}

	@Override
	default Predio savePredio(Predio predio) {
		PredioEntity entity = PredioMapper.toEntity(predio);
		PredioEntity savedEntity = save(entity);
		return PredioMapper.toDomain(savedEntity);
	}

	@Override
	default void deletePredioById(Long id) {
		deleteById(id);
	}

	@Override
	default Predio alterarPredio(Long id, Predio predio) {
		PredioEntity entity = findById(id).orElseThrow(() -> new RuntimeException("Predio not found"));
		entity.setNome(predio.nome());
		LocalidadeEntity localidadeEntity = LocalidadeMapper.toEntity(predio.localidade());
		entity.setLocalidade(localidadeEntity);
		PredioEntity savedEntity = save(entity);
		return PredioMapper.toDomain(savedEntity);
	}

}