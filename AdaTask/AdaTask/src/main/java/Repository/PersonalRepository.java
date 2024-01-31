package Repository;


import Domain.PersonalTask;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PersonalRepository extends TaskRepository<PersonalTask>{
    final public ArrayList<PersonalTask> tasksListPersonal = new ArrayList<>();

    public void editarTask(PersonalTask task, Boolean envolveOutrasPessoas, String pessoasEnvolvidas, LocalDateTime dataTask, String descricao, Integer quantidadeMinutosTask, String prioridade, Boolean finalizado) {
        if (envolveOutrasPessoas != null) {
            task.setEnvolveOutrasPessoas(envolveOutrasPessoas);
        }
        if(pessoasEnvolvidas!=null){
            task.setPessoasEnvolvidas(pessoasEnvolvidas);
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
