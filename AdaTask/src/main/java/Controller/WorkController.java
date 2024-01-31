package Controller;

import Domain.StudyTask;
import Domain.WorkTask;
import Service.TaskService;

import java.time.LocalDateTime;
import java.util.Scanner;

public class WorkController {
    public static void verificarTarefasTrabalho(){

    }
    public void adicionarTarefasTrabalho(){
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
        TaskService.adicionarTask(workTask, this);

    }
}
