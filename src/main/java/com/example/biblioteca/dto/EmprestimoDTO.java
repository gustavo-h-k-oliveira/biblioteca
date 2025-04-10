package com.example.biblioteca.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmprestimoDTO {

    @NotNull(message = "User ID is required.")
    private Long id_usuario;

    @NotNull(message = "Book ID is required.")
    private Long id_livro;

    @NotNull(message = "A loan date is required.")
    @PastOrPresent(message = "The loan date can't be in the future.")
    private LocalDate dataEmprestimo;

    @NotNull(message = "A return date is required.")
    @FutureOrPresent(message = "The return date can't be in the past.")
    private LocalDate dataDevolucao;

    @NotBlank(message = "Status is required.")
    private String status;
}