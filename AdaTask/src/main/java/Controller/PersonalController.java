package Controller;

import Domain.PersonalTask;

import java.time.LocalDateTime;
import java.util.Scanner;

import Repository.TaskRepository;
import Service.TaskService;

import javax.sound.midi.ControllerEventListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonalController extends Controller {

    public  PersonalTask editarTarefa(Integer idEditar) {
        PersonalTask task = encontrarTarefa(idEditar, TaskRepository.tasksListPersonal);
        if (task != null) {
            // Aqui você solicita as informações atualizadas da tarefa ao usuário
            // e as atribui à tarefa antes de retorná-la.
            // Exemplo:
             editaDescricao();
            /*Scanner scanner = new Scanner(System.in);
            System.out.println("Nova descrição: ");
            String novaDescricao = scanner.nextLine();
            task.setDescricao(novaDescricao);*/

            // Faça o mesmo para outros atributos que você deseja editar.

            return task;
        } else {
            System.out.println("Tarefa pessoal não encontrada para edição.");
            return null;
        }
    }

    // Métodos auxiliares

    public void deletarTarefa(Integer idDeletar) {
        TaskService.deletarTask(idDeletar,  TaskRepository.tasksListPersonal);
    }


    public void verificarTarefa(List<PersonalTask> personalTasks){
        if (personalTasks.isEmpty()) {
            System.out.println("Não há tarefas pessoais cadastradas.");
        } else {
            System.out.println("Tarefas pessoais cadastradas:");
            for (PersonalTask task : personalTasks) {
                exibirInformacoesTarefa(task);
            }
        }

    }
    private void exibirInformacoesTarefa(PersonalTask task) {
        System.out.println("ID: " + task.getIdTask());
        System.out.println("Descrição: " + task.getDescricao());
        System.out.println("Minutos: " + task.getQuantidadeMinutosTask());
        System.out.println("Prioridade: " + task.getPrioridade());
        System.out.println("Envolvendo outras pessoas: " + task.getEnvolveOutrasPessoas());
        System.out.println("Pessoas envolvidas: " + task.getPessoasEnvolvidas());
        System.out.println("Data da tarefa: " + task.getDataTask());
        System.out.println("Finalizado: " + task.getFinalizado());
        System.out.println("----------------------------------");
    }

    public void adicionarTarefa(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Criando uma tarefa pessoal:");
        System.out.println("Informe a descrição da tarefa:");
        String descricao = scanner.nextLine();

        System.out.println("Informe a quantidade de minutos para a tarefa:");
        int quantidadeMinutos = scanner.nextInt();

        System.out.println("Informe a prioridade da tarefa:");
        String prioridade = scanner.next();

        System.out.println("A tarefa envolve outras pessoas? (true/false):");
        boolean envolveOutrasPessoas = scanner.nextBoolean();

        String pessoasEnvolvidas = "";
        if (envolveOutrasPessoas) {
            System.out.println("Informe as pessoas envolvidas:");
            scanner.nextLine();
            pessoasEnvolvidas = scanner.nextLine();
        }

        LocalDateTime dataAtual = LocalDateTime.now();

        PersonalTask personalTask =  new PersonalTask(envolveOutrasPessoas, pessoasEnvolvidas, 0, dataAtual, descricao, quantidadeMinutos, prioridade, false);
        TaskService.adicionarTask(personalTask, TaskRepository.tasksListPersonal);
    }
}
