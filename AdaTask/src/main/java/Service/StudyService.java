package Service;

import Controller.Main;
//import Domain.PersonalTask;
import Domain.PersonalTask;
import Domain.StudyTask;
import Repository.StudyRepository;

import java.util.ArrayList;
import java.util.List;

public class StudyService implements Service<StudyTask>{
    private final StudyRepository taskRepository;
    public StudyService(StudyRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void adicionarTask(StudyTask task,  List<StudyTask> list) {
        taskRepository.adicionar(task, list);
        System.out.println("Task adicionada com sucesso.");
    }

    public  void deletarTask(Integer idTask, List<StudyTask> taskList) {
      //  if (validacaoDeletar(idTask,taskList )) {
            taskRepository.deletar(idTask,taskList);
       // } else {
        //    mainInstance.negarDeletarTarefa();
      //  }
    }

    public  Boolean validacaoDeletar(Integer idTask, List<StudyTask> list) {
        return taskRepository.getTaskById(idTask, list) != null;
    }
    public List<StudyTask> getTasksList() {
        return taskRepository.tasksListStudy;
    }
}
