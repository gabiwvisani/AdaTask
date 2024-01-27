package Controller;

import Domain.PersonalTask;
import Domain.StudyTask;
import Service.TaskService;

import java.time.LocalDateTime;
import java.util.Scanner;

public class StudyController {
    public static void verificarTarefasEstudos(){

    }
    public void adicionarTarefasEstudos(){
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
        TaskService.adicionarTask(studyTask, this);

    }
}
