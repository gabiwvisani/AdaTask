package Controller;

import Domain.PersonalTask;
import Domain.StudyTask;
import Repository.TaskRepository;
import Service.PersonalService;
import Service.StudyService;
//import Service.TaskService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudyController implements ControllerBase<StudyTask> {
    private final StudyService studyService;
   // private final Main app;

    public StudyController(StudyService studyService) {
        this.studyService = studyService;
       // this.app = app;
    }
    public  StudyTask editarTarefa(Integer idEditar) {
        StudyTask task = encontrarTarefa(idEditar, studyService.getTasksList());
        if (task != null) {
            //editaDescricao();
            return task;
        } else {
            System.out.println("Tarefa não encontrada para edição.");
            return null;
        }
    }
    public void deletarTarefa(Integer idDeletar){
        if(studyService.validacaoDeletar(idDeletar, studyService.getTasksList() )) {
            studyService.deletarTask(idDeletar, studyService.getTasksList());
        }else{
            negarDeletarTarefa();
        }
    }
    public void negarDeletarTarefa(){
        System.out.println("Por favor digite um idTarefa que exista.");
       // app.deletarTask();
    }
    public void verificarTarefa() {
        if (studyService.getTasksList().isEmpty()) {
            System.out.println("Não há tarefas de estudo cadastradas.");
        } else {
            System.out.println("Tarefas de estudo cadastradas:");
            for (StudyTask task : studyService.getTasksList()) {
                exibirInformacoesTarefa(task);
            }
        }
    }

    public void exibirInformacoesTarefa(StudyTask task) {
        System.out.println("ID: " + task.getIdTask());
        System.out.println("Descrição: " + task.getDescricao());
        System.out.println("Minutos: " + task.getQuantidadeMinutosTask());
        System.out.println("Prioridade: " + task.getPrioridade());
        System.out.println("Matéria: " + task.getMateria());
        System.out.println("Data da tarefa: " + task.getDataTask());
        System.out.println("Finalizado: " + task.getFinalizado());
        System.out.println("----------------------------------");
    }
    public void adicionarTarefa(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Criando uma tarefa de estudo:");
        System.out.println("Informe a descrição da tarefa:");
        String descricao = scanner.nextLine();

        System.out.println("Informe a quantidade de minutos para a tarefa:");
        int quantidadeMinutos = scanner.nextInt();

        System.out.println("Informe a prioridade da tarefa:");
        String prioridade = scanner.next();

        scanner.nextLine();  // Consumir a quebra de linha pendente

        System.out.println("Informe a matéria de estudo:");
        String materia = scanner.nextLine();

        System.out.println("Informe a data limite da tarefa (formato: dd/MM/yyyy):");
        String dataInput = scanner.next();
        dataInput=dataInput +" 00:00";
        LocalDateTime dataTarefa = LocalDateTime.parse(dataInput, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));


        StudyTask studyTask =   new StudyTask(materia, 0, dataTarefa, descricao, quantidadeMinutos, prioridade, false);

        studyService.adicionarTask(studyTask, studyService.getTasksList());

    }
}
