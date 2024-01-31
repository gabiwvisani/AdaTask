package Domain;

import java.time.LocalDateTime;

public class PersonalTask extends BaseTask {
    private Boolean envolveOutrasPessoas;
    private String pessoasEnvolvidas;



    public PersonalTask(Boolean envolveOutrasPessoas,String pessoasEnvolvidas,  Integer idTask, LocalDateTime dataTask, String descricao, Integer quantidadeMinutosTask, String prioridade, Boolean finalizado){
        super(idTask, dataTask, descricao, quantidadeMinutosTask, prioridade, finalizado);
        this.envolveOutrasPessoas=envolveOutrasPessoas;
        this.pessoasEnvolvidas=pessoasEnvolvidas;
    }
    public Boolean getEnvolveOutrasPessoas() {
        return envolveOutrasPessoas;
    }

    public void setEnvolveOutrasPessoas(Boolean envolveOutrasPessoas) {
        this.envolveOutrasPessoas = envolveOutrasPessoas;
    }

    public String getPessoasEnvolvidas() {
        return pessoasEnvolvidas;
    }

    public void setPessoasEnvolvidas(String pessoasEnvolvidas) {
        this.pessoasEnvolvidas = pessoasEnvolvidas;
    }
}
