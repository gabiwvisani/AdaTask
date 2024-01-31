package Repository;

import Domain.PersonalTask;
import Domain.WorkTask;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class WorkRepository extends TaskRepository<WorkTask>{
    final public ArrayList<WorkTask> tasksListWork = new ArrayList<>();
    public void editarTask(WorkTask task, Boolean envolveOutrasColegas, String colegasEnvolvidos, LocalDateTime dataTask, String descricao, Integer quantidadeMinutosTask, String prioridade, Boolean finalizado) {
        if (envolveOutrasColegas != null) {
            task.setEnvolveOutrosColegas(envolveOutrasColegas);
        }
        if(colegasEnvolvidos!=null){
            task.setColegasDeTarefa(colegasEnvolvidos);
        }
        if (dataTask != null) {
            task.setDataTask(dataTask);
        }
        if (descricao != null) {
            task.setDescricao(descricao);
        }
        if (quantidadeMinutosTask != null) {
            task.setQuantidadeMinutosTask(quantidadeMinutosTask);
        }
        if (prioridade != null) {
            task.setPrioridade(prioridade);
        }
        if (finalizado != null) {
            task.setFinalizado(finalizado);
        }
    }

}
