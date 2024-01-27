package Service;

import Repository.Repository;
import Repository.TaskRepository;
import Domain.PersonalTask;
import Domain.BaseTask;
import Domain.WorkTask;
import Domain.StudyTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Controller.Main;
//import Domain.Task;

public class TaskService {
    private final Repository<BaseTask> taskRepository;
    public TaskService(Repository<BaseTask> taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void adicionarTask(BaseTask task, Main mainInstance) {
        taskRepository.adicionar(task);
        System.out.println("Task adicionada com sucesso.");
    }

    public void deletarTask(Integer idTask, List<BaseTask> taskList, Main mainInstance) {
        if (validacaoDeletar(idTask)) {
            taskRepository.deletar(idTask);
        } else {
            mainInstance.negarDeletarTarefa();
        }
    }

    public  Boolean validacaoDeletar(Integer idTask) {
        return taskRepository.getTaskById(idTask, BaseTask.class) != null;
    }
}