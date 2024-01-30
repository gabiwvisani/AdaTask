package Controller;

import java.util.List;
import java.util.Scanner;
import Domain.BaseTask;

 public interface ControllerBase <T extends BaseTask> {
    public void adicionarTarefa();
    public void verificarTarefa();
    public void exibirInformacoesTarefa(T task);
    public void deletarTarefa(Integer idDeletar);
    //public  T editarTarefa(Integer idEditar);
   // void editaDescricao();
   /* {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nova descrição: ");
        String novaDescricao = scanner.nextLine();
        T.setDescricao(novaDescricao);
    }*/
   /* public <T> T encontrarTarefa(Integer id, List<T> list) {
        for (T task : list) {
            if (task.getIdTask().equals(id)) {
                return task;
            }
        }
        return null; // Retorna null se a tarefa não for encontrada.
    }*/
     public default <T extends BaseTask> T encontrarTarefa(Integer id, List<T> list) {
         for (T task : list) {
             if (task.getIdTask().equals(id)) {
                 return task;
             }
         }
         return null; // Retorna null se a tarefa não for encontrada.
     }
}
