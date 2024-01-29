package Controller;

import Domain.PersonalTask;
import Domain.StudyTask;
import Repository.TaskRepository;
import Service.TaskService;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudyController extends ControllerBase {
    public  StudyTask editarTarefa(Integer idEditar) {
        StudyTask task = encontrarTarefa(idEditar, TaskRepository.tasksListStudy);
        if (task != null) {
            editaDescricao();
            return task;
        } else {
            System.out.println("Tarefa não encontrada para edição.");
            return null;
        }
    }
    public void deletarTarefa(Integer idDeletar) {
        TaskService.deletarTask(idDeletar,  TaskRepository.tasksListStudy);
    }
    public void verificarTarefa(List<StudyTask> studyTasks) {
        if (studyTasks.isEmpty()) {
            System.out.println("Não há tarefas de estudo cadastradas.");
        } else {
            System.out.println("Tarefas de estudo cadastradas:");
            for (StudyTask task : studyTasks) {
                exibirInformacoesTarefa(task);
            }
        }
    }

    private void exibirInformacoesTarefa(StudyTask task) {
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

        LocalDateTime dataAtual = LocalDateTime.now();

        StudyTask studyTask =   new StudyTask(materia, 0, dataAtual, descricao, quantidadeMinutos, prioridade, false);
        TaskService.adicionarTask(studyTask, TaskRepository.tasksListStudy);

    }
}
