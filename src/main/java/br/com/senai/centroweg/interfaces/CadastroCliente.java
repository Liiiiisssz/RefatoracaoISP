package br.com.senai.centroweg.interfaces;

public interface CadastroCliente {
    void cadastrarCliente(String nome, String email);
    String buscarClientePorEmail(String email);
}
