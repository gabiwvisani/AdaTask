package Controller;

import Domain.PersonalTask;
import Domain.StudyTask;
import Domain.WorkTask;
import Repository.TaskRepository;
import Service.TaskService;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WorkController extends ControllerBase {
    public WorkTask editarTarefa(Integer idEditar) {
        WorkTask task = encontrarTarefa(idEditar, TaskRepository.tasksListWork);
        if (task != null) {
            editaDescricao();
            return task;
        } else {
            System.out.println("Tarefa não encontrada para edição.");
            return null;
        }
    }
    public void deletarTarefa(Integer idDeletar) {
        TaskService.deletarTask(idDeletar,  TaskRepository.tasksListWork);
    }
    public void verificarTarefa(List<WorkTask> workTasks) {
        if (workTasks.isEmpty()) {
            System.out.println("Não há tarefas de trabalho cadastradas.");
        } else {
            System.out.println("Tarefas de trabalho cadastradas:");
            for (WorkTask task : workTasks) {
                exibirInformacoesTarefa(task);
            }
        }
    }

    private void exibirInformacoesTarefa(WorkTask task) {
        System.out.println("ID: " + task.getIdTask());
        System.out.println("Descrição: " + task.getDescricao());
        System.out.println("Minutos: " + task.getQuantidadeMinutosTask());
        System.out.println("Prioridade: " + task.getPrioridade());
        System.out.println("Envolvendo outros colegas: " + task.getEnvolveOutrosColegas());
        System.out.println("Colegas envolvidos: " + task.getColegasDeTarefa());
        System.out.println("Data da tarefa: " + task.getDataTask());
        System.out.println("Finalizado: " + task.getFinalizado());
        System.out.println("----------------------------------");
    }
    public void adicionarTarefa(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Criando uma tarefa de trabalho:");
        System.out.println("Informe a descrição da tarefa:");
        String descricao = scanner.nextLine();

        System.out.println("Informe a quantidade de minutos para a tarefa:");
        int quantidadeMinutos = scanner.nextInt();

        System.out.println("Informe a prioridade da tarefa:");
        String prioridade = scanner.next();

        System.out.println("A tarefa envolve outros colegas? (true/false):");
        boolean envolveOutrosColegas = scanner.nextBoolean();

        String colegasDeTarefa = "";
        if (envolveOutrosColegas) {
            System.out.println("Informe os colegas envolvidos:");
            scanner.nextLine();  // Consumir a quebra de linha pendente
            colegasDeTarefa = scanner.nextLine();
        }

        LocalDateTime dataAtual = LocalDateTime.now();

        WorkTask workTask =   new WorkTask(0, dataAtual, descricao, quantidadeMinutos, prioridade, false, envolveOutrosColegas, colegasDeTarefa);
        TaskService.adicionarTask(workTask, TaskRepository.tasksListWork);

    }
}
