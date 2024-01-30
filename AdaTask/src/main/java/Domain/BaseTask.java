package Domain;
import java.util.Date;
import java.time.LocalDateTime;


abstract public class BaseTask {
    protected Integer idTask;
    protected LocalDateTime dataTask;
    protected String descricao;
    protected Integer quantidadeMinutosTask;
    protected String prioridade;
    protected Boolean finalizado;
    private static int lastId = 0;

    public BaseTask(Integer idTask, LocalDateTime dataTask, String descricao,
                    Integer quantidadeMinutosTask, String prioridade, Boolean finalizado) {
       // this.idTask = idTask;
        this.idTask = idTask == 0 ? generateId() : idTask;
        this.dataTask = dataTask;
        this.descricao = descricao;
        this.quantidadeMinutosTask = quantidadeMinutosTask;
        this.prioridade = prioridade;
        this.finalizado = finalizado;
    }
    private static int generateId() {
        return ++lastId;
    }

    public LocalDateTime getDataTask() {
        return dataTask;
    }

    public void setDataTask(LocalDateTime dataTask) {
        this.dataTask = dataTask;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidadeMinutosTask() {
        return quantidadeMinutosTask;
    }

    public void setQuantidadeMinutosTask(Integer quantidadeMinutosTask) {
        this.quantidadeMinutosTask = quantidadeMinutosTask;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(Boolean finalizado) {
        this.finalizado = finalizado;
    }

    public Integer getIdTask() {
        return idTask;
    }

    public void setIdTask(Integer idTask) {
        this.idTask = idTask;
    }

}
