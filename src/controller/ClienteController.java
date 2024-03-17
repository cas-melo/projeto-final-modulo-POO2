package controller;

import models.Cliente;
import models.PessoaFisica;
import models.PessoaJuridica;
import models.Veiculo;
import services.AluguelService;
import util.GeradorCNPJ;
import util.GeradorCPF;
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

    public void alterarCliente(String documento, String nome, TipoCliente tipo) {
        Cliente clienteExistente = buscarClientePorDocumento(documento);

        Cliente novoCliente;
        if (clienteExistente instanceof PessoaFisica) {
            PessoaFisica pf = (PessoaFisica) clienteExistente;
            novoCliente = new PessoaFisica(nome);
            pf.setDocumento(GeradorCPF.gerarCPF());
        } else {
            PessoaJuridica pj = (PessoaJuridica) clienteExistente;
            novoCliente = new PessoaJuridica(nome);
            pj.setDocumento(GeradorCNPJ.gerarCNPJ());
        }

        clientes.remove(clienteExistente);
        clientes.add(novoCliente);
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


    // TODO remover esse metodo listaDeClientes ( obsoleto )
    public List<Cliente> listaDeClientes() {
        return this.clientes;
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

            System.out.println("\nVeículos:");
            for (Veiculo veiculo : veiculos) {
                System.out.println("Modelo: " + veiculo.getMarca() + " " + veiculo.getModelo() +
                        " | Placa: " + veiculo.getPlaca() + " | Tipo: " + veiculo.getTipo());
            }
        }
    }
}
