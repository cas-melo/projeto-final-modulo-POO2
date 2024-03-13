import controller.ImprimirBuscaController;
import controller.VeiculoController;

public class Main {
    public static void main(String[] args) {
        VeiculoController veiculoController = new VeiculoController();
        ImprimirBuscaController impressora = new ImprimirBuscaController();

        //MenuPrincipal menu = new MenuPrincipal();
        //menu.exibirMenu();


                                        // TESTES //
        /*Veiculo fusca = new Pequeno("A67ASD","Fusca", TipoVeiculo.PEQUENO);
        Veiculo fusca2 = new Pequeno("A67ASD","Fusca 2", TipoVeiculo.PEQUENO);
        Veiculo gol = new Pequeno("A67ASD","Gol", TipoVeiculo.PEQUENO);
        Veiculo sentra = new Medio("RXA1232","Sentra", TipoVeiculo.PEQUENO);
        Veiculo Mercedes = new SUV("A67ASD","Mercedes", TipoVeiculo.PEQUENO);

        veiculoController.adicionarVeiculo(fusca);
        veiculoController.adicionarVeiculo(fusca2);
        veiculoController.adicionarVeiculo(gol);
        veiculoController.adicionarVeiculo(sentra);
        veiculoController.adicionarVeiculo(Mercedes);


        // Buscando veículos por nome
        List<Veiculo> resultadoBusca = veiculoController.buscarVeiculosPorNome("r");
        impressora.imprimirBusca(resultadoBusca);

        // Paginando os veículos
        List<Veiculo> veiculosPaginados = Paginacao.paginar(resultadoBusca, 3, 1);
        impressora.imprimirBusca(veiculosPaginados);*/


    }
}

