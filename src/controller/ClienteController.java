package controller;

import models.Cliente;
import models.PessoaFisica;
import models.PessoaJuridica;
import util.TipoCliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteController {

    private List<Cliente> clientes;

    public ClienteController() {
        this.clientes = new ArrayList<>();
    }

    public void cadastrarCliente(String nome, TipoCliente tipo){
        if (tipo.equals(TipoCliente.PF)){
            cadastrarPF(nome);
        } else {
            cadastrarPJ(nome);
        }
    }

    private Cliente cadastrarPF(String nome){
        PessoaFisica novoCliente = new PessoaFisica(nome);
        this.clientes.add(novoCliente);
        informarCadastroCliente(novoCliente);

        return novoCliente;
    }

    private Cliente cadastrarPJ(String nome){
        PessoaJuridica novoCliente = new PessoaJuridica(nome);
        this.clientes.add(novoCliente);
        informarCadastroCliente(novoCliente);

        return novoCliente;
    }

    public TipoCliente solicitarTipoCliente(){
        TipoCliente tipo = null;
        boolean tipoValido = false;
        Scanner scanner = new Scanner(System.in);

        while (!tipoValido) {

            try {
                System.out.print("O cliente é Pessoa Física ou Jurídica? (PF ou PJ): ");
                String tipoStr = scanner.next().toUpperCase();
                tipo = TipoCliente.valueOf(tipoStr);
                tipoValido = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo de cliente inválido. Por favor, insira PF ou PJ: ");
                scanner.nextLine();
            }
        }

        return tipo;
    }

    private boolean documentoNaoExistente(String documento) {
        for (Cliente cliente : clientes) {
            if (cliente.getDocumento().equals(documento)) {
                return true;
            }
        }
        return false;
    }

    public Cliente getUltimoClienteCadastrado() {
        if (!clientes.isEmpty()) {
            return clientes.get(clientes.size() - 1);
        }
        return null;
    }

    private void informarCadastroCliente(Cliente novoCliente){
        if (!documentoNaoExistente(novoCliente.getDocumento())) {
            System.out.println("Erro: Cliente já cadastrado.");
            //TODO TRATAR ERRO
        }

        System.out.println("Documento cadastrado automaticamente");
        System.out.println("Cliente cadastrado com sucesso!\n");
    }

    public Cliente buscarClientePorDocumento(String documento) {
        for (Cliente cliente : clientes) {
            if (cliente.getDocumento().equals(documento)) {
                return cliente;
            }
        }
        return null; //TODO tratar null
    }

    public List<Cliente> listarClientes() {
        return this.clientes;
    }
}
