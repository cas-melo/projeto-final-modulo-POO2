package controller;

import exceptions.ClienteNaoEncontradoException;
import models.*;
import services.AluguelService;
import util.GeradorCNPJ;
import util.GeradorCPF;
import util.TipoCliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteController {

    private List<Cliente> clientes;
    private AluguelService aluguelService;

    public ClienteController(AluguelService aluguelService) {
        this.clientes = new ArrayList<>();
        this.aluguelService = aluguelService;
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
                System.out.println("Tipo de cliente inválido.");
                scanner.nextLine();
            }
        }

        return tipo;
    }

    public void alterarCliente(String documento, String nome, TipoCliente tipo) {
        Cliente clienteExistente = buscarClientePorDocumento(documento);

        try {
            if (clienteExistente == null) {
                throw new ClienteNaoEncontradoException("Documento " + documento + "não encontrado.");
            }
            Cliente novoCliente = null;
            boolean tipoAlterado = false;

            if (!clienteExistente.getNome().equals(nome)){
                clienteExistente.setNome(nome);
            }

            if ((clienteExistente instanceof PessoaFisica) && (tipo.equals(TipoCliente.PJ))) {
                tipoAlterado = true;
                novoCliente = new PessoaJuridica(nome);
                novoCliente.setDocumento(GeradorCNPJ.gerarCNPJ());
            } else if ((clienteExistente instanceof PessoaJuridica) && (tipo.equals(TipoCliente.PF))){
                tipoAlterado = true;
                novoCliente = new PessoaFisica(nome);
                novoCliente.setDocumento(GeradorCPF.gerarCPF());
            }

            if (tipoAlterado) {
                clientes.remove(clienteExistente);
                clientes.add(novoCliente);

                aluguelService.alterarClienteAluguel(clienteExistente, novoCliente); //TODO arrumar ou retirar
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (ClienteNaoEncontradoException clienteNaoEncontradoException) {
            System.out.println("Cliente não encontrado. Tente novamente!");
        } catch (Exception e) {
            System.out.println("Erro inesperado. Entre em contato com o suporte.");
            e.printStackTrace();
        }
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
            return;
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
        return null;
    }

    public void listarClientes() {
        System.out.println("\n### LISTA CLIENTES ###");


        for (Cliente cliente : clientes) {
            System.out.print("\nNome: " + cliente.getNome() + " | " + cliente.getTipoDocumento() + ": " +
                    cliente.getDocumento() + " | ");

            List<Veiculo> veiculos = AluguelService.getVeiculosPorCliente(cliente);


            if (veiculos.isEmpty()){
                System.out.println(" O cliente não possui veículos alugados.");
                return;
            }

            System.out.println("Veículos:");
            for (Veiculo veiculo : veiculos) {
                System.out.println("Modelo: " + veiculo.getMarca() + " " + veiculo.getModelo() +
                        " | Placa: " + veiculo.getPlaca() + " | Tipo: " + veiculo.getTipo());
            }
        }
    }
}
