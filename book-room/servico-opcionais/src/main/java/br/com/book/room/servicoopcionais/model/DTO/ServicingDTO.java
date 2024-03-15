package br.com.book.room.servicoopcionais.model.DTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServicingDTO {

    @NotBlank(message = "O nome do serviço deve ser preenchido")
    private String serviceName;

    private String description;

    @NotNull(message = "O preço unitário do serviço não pode ser vázio")
    private double price;


}
