package br.com.book.room.quarto.infrastructure.database.postgres.mapper;

import br.com.book.room.quarto.domain.core.quarto.Quarto;
import br.com.book.room.quarto.infrastructure.database.postgres.entity.QuartoEntity;

public final class QuartoMapper {

	private QuartoMapper() {
	}

	public static QuartoEntity toEntity(Quarto quarto) {

		return QuartoEntity.builder()
			.predio(PredioMapper.toEntity(quarto.predio()))
			.localidade(LocalidadeMapper.toEntity(quarto.localidade()))
			.totalPessoas(quarto.totalPessoas())
			.valorDiaria(quarto.valorDiaria())
			.quantidadeQuartos(quarto.quantidadeQuartos())
			.tipo(TipoMapper.toEntity(quarto.tipo()))
			.identicacao(quarto.identicacao())
			.build();

	}

	public static Quarto toDomain(QuartoEntity savedQuarto) {

		return new Quarto(savedQuarto.getId(), PredioMapper.toDomain(savedQuarto.getPredio()),
				LocalidadeMapper.toDomain(savedQuarto.getLocalidade()), savedQuarto.getIdenticacao(),
				savedQuarto.getTotalPessoas(), TipoMapper.toDomain(savedQuarto.getTipo()), savedQuarto.getValorDiaria(),
				savedQuarto.getQuantidadeQuartos());
	}

	public static QuartoEntity updateEntityFromDomain(Quarto quarto, QuartoEntity entity) {
		entity.setPredio(PredioMapper.toEntity(quarto.predio()));
		entity.setLocalidade(LocalidadeMapper.toEntity(quarto.localidade()));
		entity.setTotalPessoas(quarto.totalPessoas());
		entity.setValorDiaria(quarto.valorDiaria());
		entity.setQuantidadeQuartos(quarto.quantidadeQuartos());
		entity.setIdenticacao(quarto.identicacao());

		var tipo = TipoMapper.toEntity(quarto.tipo());

		if (!entity.getTipo().equals(tipo))
			entity.setTipo(tipo);

		return entity;
	}

}
