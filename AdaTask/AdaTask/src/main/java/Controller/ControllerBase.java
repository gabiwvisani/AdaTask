package Controller;

import java.util.List;
import Domain.BaseTask;

 public interface ControllerBase <T extends BaseTask> extends ConsoleInputValidator {
    public void adicionarTarefa();
    public void verificarTarefa();
    public void exibirInformacoesTarefa(T task);
    public void deletarTarefa(Integer idDeletar);
     public default <T extends BaseTask> T encontrarTarefa(Integer id, List<T> list) {
         for (T task : list) {
             if (task.getIdTask().equals(id)) {
                 return task;
             }
         }
         return null;
     }

}