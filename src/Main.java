import controller.*;
import models.*;
import util.*;
import view.MenuPrincipal;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        menu.exibirMenu();

        /* VeiculoController veiculoController = new VeiculoController();
        ImprimirBuscaController impressora = new ImprimirBuscaController();

                                               //TESTE CADASTRO VEÍCULO //
                Veiculo fusca = new Veiculo("Fusca", TipoVeiculo.PEQUENO);
                Veiculo fusca2 = new Veiculo("Fusca", TipoVeiculo.PEQUENO);
                Veiculo gol = new Veiculo("Gol", TipoVeiculo.PEQUENO);
                Veiculo sentra = new Veiculo("Sentra", TipoVeiculo.PEQUENO);
                Veiculo Mercedes = new Veiculo("Mercedes", TipoVeiculo.PEQUENO);

                veiculoController.adicionarVeiculo(fusca);
                veiculoController.adicionarVeiculo(fusca2);
                veiculoController.adicionarVeiculo(gol);
                veiculoController.adicionarVeiculo(sentra);
                veiculoController.adicionarVeiculo(Mercedes);

                List<Veiculo> veiculosCadastrados = veiculoController.listarVeiculos();
                System.out.println("\nVeículos cadastrados:");
                for (Veiculo veiculo : veiculosCadastrados) {
                    System.out.println("Placa: " + veiculo.getPlaca() + ", Nome: " + veiculo.getNome() + ", Tipo: " + veiculo.getTipo());
                }

                // Buscando veículos por nome
                List<Veiculo> resultadoBusca = veiculoController.buscarVeiculosPorNome("r");
                impressora.imprimirBusca(resultadoBusca);

                // Paginando os veículos
                List<Veiculo> veiculosPaginados = Paginacao.paginar(resultadoBusca, 3, 1);
                impressora.imprimirBusca(veiculosPaginados);* /


                                                // TESTE CADASTRO CLIENTE //
                PessoaFisica pessoaFisica = new PessoaFisica("João Silva", "(11) 1234-5678");
                System.out.println("\nNome: " + pessoaFisica.getNome());
                System.out.println("Telefone: " + pessoaFisica.getTelefone());
                System.out.println("CPF: " + pessoaFisica.getCpf());

                // Criando uma pessoa jurídica
                PessoaJuridica pessoaJuridica = new PessoaJuridica("Empresa ABC", "(21) 9876-5432");
                System.out.println("Nome: " + pessoaJuridica.getNome());
                System.out.println("Telefone: " + pessoaJuridica.getTelefone());
                System.out.println("CNPJ: " + pessoaJuridica.getCnpj());
        */


    }


    }

