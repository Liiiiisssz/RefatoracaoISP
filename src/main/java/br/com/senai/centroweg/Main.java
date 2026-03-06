package br.com.senai.centroweg;

import br.com.senai.centroweg.cliente.ClienteComumService;
import br.com.senai.centroweg.cliente.ClienteVIPService;

public class  Main {
    public static void main(String[] args) {

        ClienteComumService clienteComum = new ClienteComumService();
        ClienteVIPService clienteVIP = new ClienteVIPService();

        clienteComum.cadastrarCliente("Elis", "elis@gmail.com");
        clienteComum.buscarClientePorEmail("elis@gmail.com");

        clienteVIP.cadastrarCliente("Kael", "luih@gmail.com");
        clienteVIP.buscarClientePorEmail("luih@gmail.com");
        clienteVIP.enviarNotificacao("luih@gmail.com", "Venha fazer seu tratamento de calvice");
        clienteVIP.aplicarDescontoVIP("luih@gmail.com", 0.2);
    }
}