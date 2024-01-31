package Repository;

import Domain.PersonalTask;
import Domain.StudyTask;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class StudyRepository extends TaskRepository<StudyTask>{
    final public ArrayList<StudyTask> tasksListStudy = new ArrayList<>();
    public void editarTask(StudyTask task, String materia, LocalDateTime dataTask, String descricao, Integer quantidadeMinutosTask, String prioridade, Boolean finalizado) {
        if (materia != null) {
            task.setMateria(materia);
        }
        if (dataTask != null) {
            task.setDataTask(dataTask);
        }
        if (descricao != null) {
            task.setDescricao(descricao);
        }
        if (quantidadeMinutosTask != null) {
            task.setQuantidadeMinutosTask(quantidadeMinutosTask);
        }
        if (prioridade != null) {
            task.setPrioridade(prioridade);
        }
        if (finalizado != null) {
            task.setFinalizado(finalizado);
        }
    }

}
