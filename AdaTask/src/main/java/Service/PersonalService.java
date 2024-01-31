package Service;

import Domain.PersonalTask;
import Repository.PersonalRepository;
import java.util.List;

public class PersonalService implements Service<PersonalTask>, EnvolveMaisPessoas{
    private final PersonalRepository taskRepository;
    public PersonalService(PersonalRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void adicionarTask(PersonalTask task,  List<PersonalTask> list) {
        taskRepository.adicionar(task, list);
    }

    public  void deletarTask(Integer idTask, List<PersonalTask> taskList) {
      taskRepository.deletar(idTask,taskList);
    }

    public  Boolean validacaoDeletar(Integer idTask, List<PersonalTask> list) {
        return taskRepository.getTaskById(idTask, list) != null;
    }

    public List<PersonalTask> getTasksList() {
        return taskRepository.tasksListPersonal;
    }
}
