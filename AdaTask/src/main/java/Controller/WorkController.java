package Controller;

import Domain.PersonalTask;
import Domain.StudyTask;
import Domain.WorkTask;
import Repository.TaskRepository;
import Service.StudyService;
//import Service.TaskService;
import Service.WorkService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WorkController implements ControllerBase<WorkTask> {
    private final WorkService workService;
   // private final Main app;

    public WorkController(WorkService workService) {
        this.workService = workService;
       // this.app = app;
    }
    public WorkTask editarTarefa(Integer idEditar) {
        WorkTask task = encontrarTarefa(idEditar, workService.getTasksList());
        if (task != null) {
         //   editaDescricao();
            return task;
        } else {
            System.out.println("Tarefa não encontrada para edição.");
            return null;
        }
    }
    public void deletarTarefa(Integer idDeletar) {
        if(workService.validacaoDeletar(idDeletar, workService.getTasksList() )) {
            workService.deletarTask(idDeletar, workService.getTasksList());
        }else{
            negarDeletarTarefa();
        }
    }
    public void negarDeletarTarefa(){
        System.out.println("Por favor digite um idTarefa que exista.");
        //app.deletarTask();
    }
    public void verificarTarefa() {
        if (workService.getTasksList().isEmpty()) {
            System.out.println("Não há tarefas de trabalho cadastradas.");
        } else {
            System.out.println("Tarefas de trabalho cadastradas:");
            for (WorkTask task : workService.getTasksList()) {
                exibirInformacoesTarefa(task);
            }
        }
    }

    public void exibirInformacoesTarefa(WorkTask task) {
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

        System.out.println("Informe a data limite da tarefa (formato: dd/MM/yyyy):");
        String dataInput = scanner.next();
        dataInput=dataInput +" 00:00";
        LocalDateTime dataTarefa = LocalDateTime.parse(dataInput, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));


        WorkTask workTask =   new WorkTask(0, dataTarefa, descricao, quantidadeMinutos, prioridade, false, envolveOutrosColegas, colegasDeTarefa);
        //TaskService.adicionarTask(workTask, TaskRepository.tasksListWork);
        workService.adicionarTask(workTask, workService.getTasksList());

    }
}
