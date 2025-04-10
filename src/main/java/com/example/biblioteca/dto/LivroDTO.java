package com.example.biblioteca.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroDTO {

    @NotBlank(message = "Title is required.")
    private String titulo;

    @NotBlank(message = "Author is required.")
    private String autor;

    @NotNull(message = "Quantity is required.")
    @Min(value = 0, message = "Quantity can't be negative.")
    private int quantidadeEstoque;
}
