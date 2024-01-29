package Service;

import Controller.Main;
import Domain.PersonalTask;
import Repository.PersonalRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonalService implements Service<PersonalTask>{
    private final PersonalRepository<PersonalTask> taskRepository;
    public PersonalService(PersonalRepository<PersonalTask> taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void adicionarTask(PersonalTask task,  ArrayList<PersonalTask> list) {
        taskRepository.adicionar(task, list);
        System.out.println("Task adicionada com sucesso.");
    }

    public  void deletarTask(Integer idTask, ArrayList<PersonalTask> taskList, Main mainInstance) {
        if (validacaoDeletar(idTask,taskList )) {
            taskRepository.deletar(idTask,taskList);
        } else {
            mainInstance.negarDeletarTarefa();
        }
    }

    public  Boolean validacaoDeletar(Integer idTask, ArrayList<PersonalTask> list) {
        return taskRepository.getTaskById(idTask, list) != null;
    }
}
