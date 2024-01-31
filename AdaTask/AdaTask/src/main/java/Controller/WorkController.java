package Controller;

import Domain.WorkTask;
import Service.WorkService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class WorkController implements ControllerBase<WorkTask> {
    private final WorkService workService;

    public WorkController(WorkService workService) {
        this.workService = workService;
    }
    public WorkTask editarTarefa(Integer idEditar) {
        WorkTask task = encontrarTarefa(idEditar, workService.getTasksList());
        if (task != null) {
            String novaDescricao=null;
            Boolean envolveOutrosColegas=null;
            LocalDateTime dataTarefa=null;
            Integer novaQuantidadeMinutosTask=null;
            String novaPrioridade=null;
            String colegasDeTarefa=null;
            Boolean finalizadoInput=null;
            System.out.print( workService.envolveMaisPessoas(task.getEnvolveOutrosColegas(),"Não se esqueça de comunicar seus colegas dessa alteração na tarefa.\n"));
            Boolean continuarEditar=true;
            while(continuarEditar){
            Integer campo = validatePositiveIntegerInput(
                    "Escolha um campo para editar a tarefa n" + idEditar +
                            ": \n1 - Descrição da tarefa\n2 - Data Limite\n" +
                            "3 - Quantidade de minutos necessários para concluir a tarefa\n" +
                            "4 - Prioridade (baixa, média, alta)\n5 - Task envolve outros colegas (true/false)\n" +
                            "6 - Colegas envolvidos\n7 - A tarefa está finalizada (Sim ou Não)\n",
                    "Opção inválida.\n"
            );

                switch (campo) {
                    case 1:
                         novaDescricao = validateStringInput("Nova descrição: ", "");

                        break;
                    case 2:
                        dataTarefa = validateDateTimeInput("Nova data Limite: (formato: dd/MM/yyyy HH:mm): ", "Digite uma data maior ou igual a atual seguindo o formato formato: dd/MM/yyyy HH:mm");

                        break;
                    case 3:
                         novaQuantidadeMinutosTask = validatePositiveIntegerInput(
                                "Quantidade de minutos necessários para concluir a tarefa: ",
                                "Digite um inteiro maior ou igual a 0."
                        );

                        break;
                    case 4:
                         novaPrioridade = validateStringPrioridadeInput(
                                "Prioridade (baixa, média, alta): ",
                                "Digite baixa, média ou alta."
                        );

                        break;
                    case 5:
                         envolveOutrosColegas = validateYesNoInput(
                                "Task envolve outros colegas? (Sim ou Não): ",
                                "Digite sim ou não"
                        );

                        break;
                    case 6:
                        if (task.getEnvolveOutrosColegas()) {
                            System.out.print( workService.envolveMaisPessoas(task.getEnvolveOutrosColegas(),"Não se esqueça de comunicar seus novos colegas dessa tarefa\n"));
                             colegasDeTarefa = validateStringInput(
                                    "Informe os colegas envolvidos: ",
                                    ""
                            );

                        } else {
                            System.out.println("Primeiro você deve alterar o parâmetro de que há outros colegas para inserir os colegas envolvidos.");
                        }
                        break;
                    case 7:
                         finalizadoInput = validateYesNoInput(
                                "A tarefa está finalizada? (Sim ou Não): ",
                                "Digite sim ou não"
                        );

                        break;
                    default:
                        throw new IllegalStateException("Valor inválido no campo " + campo);
                }
                continuarEditar =validateYesNoInput("Editar mais campos? (Sim ou não).", "");
            }
            workService.editarTask( task, envolveOutrosColegas,  colegasDeTarefa,  dataTarefa,  novaDescricao,  novaQuantidadeMinutosTask,  novaPrioridade,  finalizadoInput);
            return task;
        } else {
            System.out.println("Tarefa de trabalho não encontrada para edição.");
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
        System.out.println("Envolvendo outros colegas: " + (task.getEnvolveOutrosColegas()? "Sim" : "Não"));;
        System.out.println("Colegas envolvidos: " + task.getColegasDeTarefa());
        System.out.println("Data da tarefa: " + task.getDataTask().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        System.out.println("Finalizado: " + task.getFinalizado());
        System.out.println("----------------------------------");
    }
    public void adicionarTarefa(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Criando uma tarefa de trabalho: ");
        String descricao = validateStringInput("Informe a descrição da tarefa: ", "");
        int quantidadeMinutos = validatePositiveIntegerInput("Informe a quantidade de minutos para a tarefa: ", "Digite um número inteiro");
        String prioridade = validateStringPrioridadeInput("Informe a prioridade da tarefa (baixa, média, alta): ", "Digite baixa, média ou alta.");

        Boolean envolveOutrosColegas = validateYesNoInput("A tarefa envolve outros colegas? (Sim ou Não): ", "Digite sim ou não");
        String colegasDeTarefa = "";

        if (envolveOutrosColegas) {
            colegasDeTarefa = validateStringInput("Informe os colegas envolvidos: ", "");
        }
        LocalDateTime dataTarefa=LocalDateTime.of(2024,2,3,0,0);
        while(!workService.isWeekday(dataTarefa)) {
            dataTarefa = validateDateTimeInput(
                    "Digite data Limite: (formato: dd/MM/yyyy HH:mm): ",
                    "Digite uma data maior ou igual a atual seguindo o formato formato: dd/MM/yyyy HH:mm"
            );
            if(!workService.isWeekday(dataTarefa)){
                System.out.println("É importante ter um tempo de descanso do trabalho, por isso não é permitido marcar tarefas de trabalho no final de semana.\n");
            }
        }
        System.out.print( workService.envolveMaisPessoas(envolveOutrosColegas,"Não se esqueça de comunicar seus colegas dessa tarefa\n"));
        WorkTask workTask =   new WorkTask(0, dataTarefa, descricao, quantidadeMinutos, prioridade, false, envolveOutrosColegas, colegasDeTarefa);
        workService.adicionarTask(workTask, workService.getTasksList());

    }
}
