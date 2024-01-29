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

public class TaskService<T extends BaseTask> {
    private final Repository<T> taskRepository;
    public TaskService(Repository<T> taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void adicionarTask(T task,  List<T> list) {
        taskRepository.adicionar(task, list);
        System.out.println("Task adicionada com sucesso.");
    }

    public  void deletarTask(Integer idTask, List<T> taskList, Main mainInstance) {
        if (validacaoDeletar(idTask)) {
            taskRepository.deletar(idTask);
        } else {
            mainInstance.negarDeletarTarefa();
        }
    }

    public static Boolean validacaoDeletar(Integer idTask) {
        return taskRepository.getTaskById(idTask, T) != null;
    }
}