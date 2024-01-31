package Service;

import Domain.PersonalTask;
import Domain.WorkTask;
import Repository.WorkRepository;
import java.util.List;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class WorkService implements Service<WorkTask>, EnvolveMaisPessoas{
    private final WorkRepository taskRepository;
    public WorkService(WorkRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void adicionarTask(WorkTask task,  List<WorkTask> list) {
        taskRepository.adicionar(task, list);
        System.out.println("Task adicionada com sucesso.");
    }
    public  boolean isWeekday(LocalDateTime dateTime) {
        DayOfWeek dayOfWeek = dateTime.getDayOfWeek();
        return dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
    }

    public  void deletarTask(Integer idTask, List<WorkTask> taskList) {
            taskRepository.deletar(idTask,taskList);
    }

    public  Boolean validacaoDeletar(Integer idTask, List<WorkTask> list) {
        return taskRepository.getTaskById(idTask, list) != null;
    }
    public List<WorkTask> getTasksList() {
        return taskRepository.tasksListWork;
    }
    public void editarTask(WorkTask task, Boolean envolveOutrasColegas, String colegasEnvolvidos, LocalDateTime dataTask, String descricao, Integer quantidadeMinutosTask, String prioridade, Boolean finalizado){
        taskRepository.editarTask(  task,  envolveOutrasColegas,  colegasEnvolvidos,  dataTask,  descricao,  quantidadeMinutosTask,  prioridade,  finalizado);
    }
}
