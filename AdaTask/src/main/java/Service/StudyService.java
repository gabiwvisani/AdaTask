package Service;

import Controller.Main;
//import Domain.PersonalTask;
import Domain.PersonalTask;
import Domain.StudyTask;
import Repository.StudyRepository;

import java.util.ArrayList;
import java.util.List;

public class StudyService implements Service<StudyTask>{
    private final StudyRepository<StudyTask> taskRepository;
    public StudyService(StudyRepository<StudyTask> taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void adicionarTask(StudyTask task,  ArrayList<StudyTask> list) {
        taskRepository.adicionar(task, list);
        System.out.println("Task adicionada com sucesso.");
    }

    public  void deletarTask(Integer idTask, ArrayList<StudyTask> taskList, Main mainInstance) {
        if (validacaoDeletar(idTask,taskList )) {
            taskRepository.deletar(idTask,taskList);
        } else {
            mainInstance.negarDeletarTarefa();
        }
    }

    public  Boolean validacaoDeletar(Integer idTask, ArrayList<StudyTask> list) {
        return taskRepository.getTaskById(idTask, list) != null;
    }
    public List<StudyTask> getTasksList() {
        return taskRepository.tasksListStudy;
    }
}
