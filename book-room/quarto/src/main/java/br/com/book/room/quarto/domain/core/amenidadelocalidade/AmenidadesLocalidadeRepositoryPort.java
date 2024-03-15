package br.com.book.room.quarto.domain.core.amenidadelocalidade;

import br.com.book.room.quarto.infrastructure.database.postgres.entity.AmenidadesLocalidadeEntityId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AmenidadesLocalidadeRepositoryPort {

	Page<AmenidadesLocalidade> findAllAmenidadesLocalidade(Pageable pageable);

	AmenidadesLocalidade findAmenidadesLocalidadeById(AmenidadesLocalidadeEntityId id);

	AmenidadesLocalidade saveAmenidadesLocalidade(AmenidadesLocalidade amenidadesLocalidade);

	void deleteAmenidadesLocalidadeById(Long idLocalidade, Long idAmenidade);

	AmenidadesLocalidade alterarAmenidadesLocalidade(AmenidadesLocalidadeEntityId id,
			AmenidadesLocalidade amenidadesLocalidade);

	AmenidadesLocalidade atualizarQuantidadePorId(AmenidadesLocalidadeId id, Integer quantidade);

}