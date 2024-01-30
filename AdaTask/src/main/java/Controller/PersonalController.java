package Controller;

import Domain.PersonalTask;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Repository.PersonalRepository;
import Repository.TaskRepository;
import Service.PersonalService;

import javax.sound.midi.ControllerEventListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonalController implements ControllerBase<PersonalTask> {
    private final PersonalService personalService;
   // private final Main app;

    public PersonalController(PersonalService personalService) {
        this.personalService = personalService;
        //this.app = app;
    }

    /*private PersonalTask encontrarTarefa(Integer id, List<PersonalTask> list) {
        for (PersonalTask task : list) {
            if (task.getIdTask().equals(id)) {
                return task;
            }
        }
        return null;
    }*/
    public  PersonalTask editarTarefa(Integer idEditar) {
        PersonalTask task = encontrarTarefa(idEditar, personalService.getTasksList());
        if (task != null) {
            Scanner scan =new Scanner(System.in);
            System.out.println("Escolha um campo para editar a tarefa n"+idEditar+": \n1 - Descricao da tarefa\n2 - Data Limite\n3 - Quantidade de minutos necessários para concluir a tarefa\n4 - Prioridade (baixa, média, alta)\n5 - Task Envolve outras pessoas(S/N)\n6 -Pessoas envolvidas\n7 - A tarefa está finalizada (Sim ou Não)");
           try {
               Integer campo = scan.nextInt();
           switch (campo){
               case 1:
                   System.out.println("Nova descrição: ");
                   String novaDescricao = scan.nextLine();
                   task.setDescricao(novaDescricao);
                   break;
               case 2:
                   LocalDateTime dataTarefa = LocalDateTime.now().minusDays(1);
                   while(dataTarefa.isBefore(LocalDateTime.now())) {
                       System.out.println("Nova data Limite: (formato: dd/MM/yyyy HH:mm):");
                       try {
                           String dataInput = scan.next();
                           dataTarefa = LocalDateTime.parse(dataInput, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
                       }catch(Exception e) {
                           System.out.println("Digite seguindo o formato formato: dd/MM/yyyy HH:mm");
                       }
                       if(dataTarefa.isBefore(LocalDateTime.now())) {
                        System.out.println("A data deve ser maior o igual a atual");
                    }
                    }
                   }
                    task.setDataTask(dataTarefa);
                   break;
               case 3:
                   break;
               case 4:
                   break;
               case 5:
                   break;
               case 6:
                   break;
               case 7:
                   break;
           }
           }catch(Exception e){
               System.out.println("Opção inválida.");
               editarTarefa( idEditar);
           }
            // Aqui você solicita as informações atualizadas da tarefa ao usuário
            // e as atribui à tarefa antes de retorná-la.
            // Exemplo:
            // editaDescricao();
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
        if(personalService.validacaoDeletar(idDeletar, personalService.getTasksList() )) {
            personalService.deletarTask(idDeletar, personalService.getTasksList());
        }else{
            negarDeletarTarefa();
        }
    }
    public void negarDeletarTarefa(){
        System.out.println("Por favor digite um idTarefa que exista.");
        //app.deletarTask();
    }

    public void verificarTarefa(){
        if (personalService.getTasksList().isEmpty()) {
            System.out.println("Não há tarefas pessoais cadastradas.");
        } else {
            System.out.println("Tarefas pessoais cadastradas:");
            for (PersonalTask task : personalService.getTasksList()) {
                exibirInformacoesTarefa(task);
            }
        }

    }
    public void exibirInformacoesTarefa(PersonalTask task) {
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

        System.out.println("Informe a data e hora limite da tarefa (formato: dd/MM/yyyy HH:mm):");
        String dataInput = scanner.next();
        LocalDateTime dataTarefa = LocalDateTime.parse(dataInput, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));


        PersonalTask personalTask =  new PersonalTask(envolveOutrasPessoas, pessoasEnvolvidas, 0, dataTarefa, descricao, quantidadeMinutos, prioridade, false);
        personalService.adicionarTask(personalTask, personalService.getTasksList());
    }

}
