package Service;

import Controller.Main;
import Domain.PersonalTask;
import Domain.WorkTask;
import Repository.StudyRepository;
import Repository.WorkRepository;

import java.util.ArrayList;
import java.util.List;

public class WorkService implements Service<WorkTask>{
    private final WorkRepository<WorkTask> taskRepository;
    public WorkService(WorkRepository<WorkTask> taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void adicionarTask(WorkTask task,  ArrayList<WorkTask> list) {
        taskRepository.adicionar(task, list);
        System.out.println("Task adicionada com sucesso.");
    }

    public  void deletarTask(Integer idTask, ArrayList<WorkTask> taskList, Main mainInstance) {
        if (validacaoDeletar(idTask,taskList )) {
            taskRepository.deletar(idTask,taskList);
        } else {
            mainInstance.negarDeletarTarefa();
        }
    }

    public  Boolean validacaoDeletar(Integer idTask, ArrayList<WorkTask> list) {
        return taskRepository.getTaskById(idTask, list) != null;
    }
    public List<WorkTask> getTasksList() {
        return taskRepository.tasksListWork;
    }
}
