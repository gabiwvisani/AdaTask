package Controller;

import Domain.PersonalTask;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import Service.PersonalService;

public class PersonalController implements ControllerBase<PersonalTask> {
    private final PersonalService personalService;

    public PersonalController(PersonalService personalService) {
        this.personalService = personalService;
    }

    public  PersonalTask editarTarefa(Integer idEditar) {
        PersonalTask task = encontrarTarefa(idEditar, personalService.getTasksList());
        if (task != null) {
            String novaDescricao=null;
            Boolean envolveOutrasPessoasInput=null;
            LocalDateTime dataTarefa=null;
            Integer novaQuantidadeMinutosTask=null;
            String novaprioridade=null;
            String pessoasEnvolvidas=null;
            Boolean finalizadoInput=null;
            System.out.print( personalService.envolveMaisPessoas(task.getEnvolveOutrasPessoas(),"Não se esqueça de comunicar os outros envolvidos dessa mudança de tarefa\n"));

            Boolean continuarEditar=true;

            while(continuarEditar){
            Integer campo =validatePositiveIntegerInput("Escolha um campo para editar a tarefa n"
                    +idEditar+
                    ": \n1 - Descricao da tarefa\n2 - Data Limite\n" +
                    "3 - Quantidade de minutos necessários para concluir a tarefa\n" +
                    "4 - Prioridade (baixa, média, alta)\n" +
                    "5 - Task Envolve outras pessoas(S/N)\n6 -Pessoas envolvidas\n" +
                    "7 - A tarefa está finalizada (Sim ou Não)\n\n",
                    "Opção inválida.\n");
           switch (campo){
               case 1:
                    novaDescricao = validateStringInput("Nova descrição: ","");

                   break;
               case 2:
                    dataTarefa = validateDateTimeInput("Nova data Limite: (formato: dd/MM/yyyy HH:mm): ", "Digite uma data maior ou igual a atual seguindo o formato formato: dd/MM/yyyy HH:mm");

                   break;
               case 3:
                    novaQuantidadeMinutosTask=validatePositiveIntegerInput("Quantidade de minutos necessários para concluir a tarefa: ","Digite um inteiro maior ou igual a 0.");

                   break;
               case 4:
                    novaprioridade =validateStringPrioridadeInput("Prioridade (baixa, média, alta): ","Digite baixa, média ou alta.");

                   break;
               case 5:
                    envolveOutrasPessoasInput=validateYesNoInput("Task envolve outras pessoas? (Sim ou Não): ","Digite sim ou não");

                   break;
               case 6:
                   if(task.getEnvolveOutrasPessoas()==false){
                       System.out.println("primeiro você deve alterar o parametro de que há outras pessoas, para inserir as pessoas envolvidas.");
                       editarTarefa(idEditar);
                       break;
                   }
                   System.out.print( personalService.envolveMaisPessoas(task.getEnvolveOutrasPessoas(),"Não se esqueça de comunicar os novos envolvidos dessa tarefa\n"));
                   pessoasEnvolvidas=validateStringInput("Pessoas envolvidas: ","");
                   break;
               case 7:
                   finalizadoInput=validateYesNoInput("A tarefa está finalizada? (Sim ou Não): ","Digite sim ou não");

                   break;
               default:
                   editarTarefa(idEditar);
                   throw new IllegalStateException("Valor inválido no campo " + campo);

           }
                continuarEditar =validateYesNoInput("Editar mais campos? (Sim ou não).\n", "");
            }
            personalService.editarTask( task, envolveOutrasPessoasInput,  pessoasEnvolvidas,  dataTarefa,  novaDescricao,  novaQuantidadeMinutosTask,  novaprioridade,  finalizadoInput);
                return task;
        } else {
            System.out.println("Tarefa pessoal não encontrada para edição.");
            return null;
        }
    }

    public void deletarTarefa(Integer idDeletar) {
        if(personalService.validacaoDeletar(idDeletar, personalService.getTasksList() )) {
            personalService.deletarTask(idDeletar, personalService.getTasksList());
        }else{
            negarDeletarTarefa();
        }
    }
    public void negarDeletarTarefa(){
        System.out.println("Por favor digite um idTarefa que exista.");
    }

    public void verificarTarefa(){
        if (personalService.getTasksList().isEmpty()) {
            System.out.println("Não há tarefas pessoais cadastradas.");
        } else {
            System.out.println("Tarefas pessoais cadastradas: ");
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
        System.out.println("Envolvendo outras pessoas: " + (task.getEnvolveOutrasPessoas() ? "Sim" : "Não"));
        System.out.println("Pessoas envolvidas: " + task.getPessoasEnvolvidas());
        System.out.println("Data da tarefa: " + task.getDataTask().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        System.out.println("Finalizado: " + task.getFinalizado());
        System.out.println("----------------------------------");
    }

    public void adicionarTarefa(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Criando uma tarefa pessoal: ");

        String descricao = validateStringInput("Informe a descrição da tarefa: ","");

        int quantidadeMinutos = validatePositiveIntegerInput("Informe a quantidade de minutos para a tarefa: ","Digite um número inteiro");

        String prioridade = validateStringPrioridadeInput("Informe a prioridade da tarefa (baixa, média, alta): ","Digite baixa, média ou alta.");

        Boolean envolveOutrasPessoas=validateYesNoInput("Task envolve outras pessoas? (Sim ou Não): ","Digite sim ou não");

        String pessoasEnvolvidas ="";
        if (envolveOutrasPessoas) {
             pessoasEnvolvidas = validateStringInput("Informe as pessoas envolvidas: ","");
        }

        LocalDateTime dataTarefa =  validateDateTimeInput("Nova data Limite: (formato: dd/MM/yyyy HH:mm): ", "Digite uma data maior ou igual a atual seguindo o formato formato: dd/MM/yyyy HH:mm\n");
        System.out.print( personalService.envolveMaisPessoas(envolveOutrasPessoas,"Não se esqueça de comunicar os outros envolvidos dessa nova tarefa\n"));

        PersonalTask personalTask =  new PersonalTask(envolveOutrasPessoas, pessoasEnvolvidas, 0, dataTarefa, descricao, quantidadeMinutos, prioridade, false);
        personalService.adicionarTask(personalTask, personalService.getTasksList());
    }

}
