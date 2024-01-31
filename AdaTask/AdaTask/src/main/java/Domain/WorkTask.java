package Domain;

import java.time.LocalDateTime;

public class WorkTask extends BaseTask{
    private Boolean envolveOutrosColegas;
    private String colegasDeTarefa;

    public WorkTask(Integer idTask, LocalDateTime dataTask, String descricao,
                    Integer quantidadeMinutosTask, String prioridade, Boolean finalizado,
                    Boolean envolveOutrosColegas, String colegasDeTarefa) {
        super(idTask, dataTask, descricao, quantidadeMinutosTask, prioridade, finalizado);
        this.envolveOutrosColegas = envolveOutrosColegas;
        this.colegasDeTarefa = colegasDeTarefa;
    }

    public Boolean getEnvolveOutrosColegas() {
        return envolveOutrosColegas;
    }

    public void setEnvolveOutrosColegas(Boolean envolveOutrosColegas) {
        this.envolveOutrosColegas = envolveOutrosColegas;
    }

    public String getColegasDeTarefa() {
        return colegasDeTarefa;
    }

    public void setColegasDeTarefa(String colegasDeTarefa) {
        this.colegasDeTarefa = colegasDeTarefa;
    }
}
