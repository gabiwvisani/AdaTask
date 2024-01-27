package Controller;

import Domain.PersonalTask;

import java.time.LocalDateTime;
import java.util.Scanner;
import Service.TaskService;

public class PersonalController {
    public static void verificarTarefasPessoais(){

    }
    public void adicionarTarefasPessoais(){
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
        TaskService.adicionarTask(personalTask, this);
    }
}
