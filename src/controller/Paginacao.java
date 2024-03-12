package controller;

import java.util.List;

public class Paginacao {

    public static <T> List<T> paginar(List<T> lista, int tamanhoPagina, int numeroPagina) {
        int fromIndex = (numeroPagina - 1) * tamanhoPagina;
        if (lista == null || lista.size() < fromIndex) {
            return List.of(); // Retorna lista vazia se não houver dados suficientes para a página solicitada
        }

        // Calcula o índice final
        int toIndex = Math.min(fromIndex + tamanhoPagina, lista.size());

        return lista.subList(fromIndex, toIndex);

        // uso:
        // List<Veiculo> veiculosPaginados = Paginacao.paginar(listaDeVeiculos, tamanhoPagina, numeroPagina);
    }
}
