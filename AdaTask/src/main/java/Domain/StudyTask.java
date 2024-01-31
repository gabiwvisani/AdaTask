package Domain;

import java.time.LocalDateTime;

public class StudyTask extends BaseTask {
    private String materia;
    public StudyTask(String materia, Integer idTask, LocalDateTime dataTask, String descricao, Integer quantidadeMinutosTask,
                     String prioridade, Boolean finalizado) {
        super(idTask, dataTask, descricao, quantidadeMinutosTask, prioridade, finalizado);
        this.materia = materia;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
}
