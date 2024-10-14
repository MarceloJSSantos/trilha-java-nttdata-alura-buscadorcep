package br.com.alura.mjss.buscadorcep.modelos;

public record Endereco(String cep,
                       String logradouro,
                       String complemento,
                       String bairro,
                       String localidade,
                       String uf,
                       String estado) {
}