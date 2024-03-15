package util;

import models.Cliente;
import java.io.*;
import java.util.List;

public class PersistenciaUtil {

    private static final String CAMINHO_CLIENTES = "clientes.dat";
    private static final String CAMINHO_VEICULOS = "veiculos.dat";

    public static void salvarClientes(List<Cliente> clientes) {
        salvarObjeto(CAMINHO_CLIENTES, clientes);
    }

    public static List<Cliente> carregarClientes() {
        return (List<Cliente>) carregarObjeto(CAMINHO_CLIENTES);
    }

    public static void salvarVeiculos(List<Veiculo> veiculos) {
        salvarObjeto(CAMINHO_VEICULOS, veiculos);
    }

    public static List<Veiculo> carregarVeiculos() {
        return (List<Veiculo>) carregarObjeto(CAMINHO_VEICULOS);
    }

    private static void salvarObjeto(String caminho, Object objeto) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeObject(objeto);
        } catch (IOException e) {
            System.err.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    private static Object carregarObjeto(String caminho) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            return ois.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
            return null;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar arquivo: " + e.getMessage());
            return null;
        }
    }
}
