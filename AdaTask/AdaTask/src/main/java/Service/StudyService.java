package Service;

//import Domain.PersonalTask;
import Domain.StudyTask;
import Repository.StudyRepository;

import java.time.LocalDateTime;
import java.util.List;

public class StudyService implements Service<StudyTask>{
    private final StudyRepository taskRepository;
    public StudyService(StudyRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void adicionarTask(StudyTask task,  List<StudyTask> list) {
        taskRepository.adicionar(task, list);
    }

    public  void deletarTask(Integer idTask, List<StudyTask> taskList) {
            taskRepository.deletar(idTask,taskList);
    }

    public  Boolean validacaoDeletar(Integer idTask, List<StudyTask> list) {
        return taskRepository.getTaskById(idTask, list) != null;
    }
    public List<StudyTask> getTasksList() {
        return taskRepository.tasksListStudy;
    }
    public void editarTask(StudyTask task, String materia, LocalDateTime dataTask, String descricao, Integer quantidadeMinutosTask, String prioridade, Boolean finalizado) {
        taskRepository.editarTask( task,  materia,  dataTask,  descricao,  quantidadeMinutosTask,  prioridade,  finalizado) ;
    }
}
