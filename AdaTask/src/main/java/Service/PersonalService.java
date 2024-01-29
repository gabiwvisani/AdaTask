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

    public void adicionarTask(PersonalTask task,  List<PersonalTask> list) {
        taskRepository.adicionar(task, list);
        System.out.println("Task adicionada com sucesso.");
    }

    public  void deletarTask(Integer idTask, List<PersonalTask> taskList) {
        //if (validacaoDeletar(idTask,taskList )) {
            taskRepository.deletar(idTask,taskList);
       // } else {
       //     negarDeletarTarefa();
       // }
    }

    public  Boolean validacaoDeletar(Integer idTask, List<PersonalTask> list) {
        return taskRepository.getTaskById(idTask, list) != null;
    }

    public List<PersonalTask> getTasksList() {
        return taskRepository.tasksListPersonal;
    }
}
