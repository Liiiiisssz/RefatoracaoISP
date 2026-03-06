package br.com.senai.centroweg.cliente;

import br.com.senai.centroweg.interfaces.CadastroCliente;

public class ClienteComumService implements CadastroCliente {
    @Override
    public void cadastrarCliente(String nome, String email) {
        System.out.println("COMUM: Cadastrando " + nome);
    }
    @Override
    public String buscarClientePorEmail(String email) {
        return "COMUM: Encontrado cliente com email " + email;
    }

}
