package br.com.book.room.clientes.mapper;



import br.com.book.room.clientes.model.DTO.ClientDTO;
import br.com.book.room.clientes.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public final class ClientMapper {

    private ClientMapper() {
    }
    public static Client convertToUsuario(ClientDTO clientDTO) {

        return new Client(
                clientDTO.getName(),
                clientDTO.getBirthDate(),
                clientDTO.getCountry(),
                clientDTO.getCPF(),
                clientDTO.getPassport(),
                clientDTO.getAddress(),
                clientDTO.getCellphone(),
                clientDTO.getEmail());
    }

//    public static UsuarioResponseDto convertToUsuarioResponseDto(
//            Usuario usuario
//    ) {
//        return new UsuarioResponseDto(
//                usuario.id(),
//                usuario.username(),
//                usuario.roles()
//                        .stream()
//                        .map(
//                                Role::nome
//                        ).collect(Collectors.toSet()),
//                usuario.dataCriacao()
//        );
//    }

}
