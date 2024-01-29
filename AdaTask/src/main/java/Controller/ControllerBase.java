package Controller;

import java.awt.*;
import java.util.Scanner;
import Domain.BaseTask;

abstract public class ControllerBase <T extends BaseTask> {
    public void adicionarTarefa(){};
    public void verificarTarefa(List<T> Tasks){};
    private void exibirInformacoesTarefa(T task){};
    public void deletarTarefa(Integer idDeletar){};
    public  T editarTarefa(Integer idEditar){};
    void editaDescricao(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nova descrição: ");
        String novaDescricao = scanner.nextLine();
        T.setDescricao(novaDescricao);
    }
    private T encontrarTarefa(Integer id, List<T> list) {
        for (T task : list) {
            if (task.getIdTask().equals(id)) {
                return task;
            }
        }
        return null; // Retorna null se a tarefa não for encontrada.
    }
}
