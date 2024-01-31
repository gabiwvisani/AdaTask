package Controller;

import Domain.StudyTask;
import Service.StudyService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class StudyController implements ControllerBase<StudyTask> {
    private final StudyService studyService;

    public StudyController(StudyService studyService) {
        this.studyService = studyService;
    }
    public StudyTask editarTarefa(Integer idEditar) {
        StudyTask task = encontrarTarefa(idEditar, studyService.getTasksList());
        if (task != null) {
            String novaDescricao=null;
            String novaMateria=null;
            LocalDateTime dataTarefa=null;
            Integer novaQuantidadeMinutosTask=null;
            String novaPrioridade=null;
            Boolean finalizadoInput=null;
            Boolean continuarEditar=true;
            while(continuarEditar){
            Integer campo =validatePositiveIntegerInput("Escolha um campo para editar a tarefa n"
                            +idEditar+
                            "Escolha um campo para editar a tarefa n" + idEditar +
                            ": \n1 - Descrição da tarefa\n2 - Data Limite\n" +
                            "3 - Quantidade de minutos necessários para concluir a tarefa\n" +
                            "4 - Prioridade (baixa, média, alta)\n5 - Matéria\n" +
                            "6 - A tarefa está finalizada (Sim ou Não)\n",
                    "Opção inválida.\n");
                switch (campo) {
                    case 1:
                        System.out.println("Nova descrição: ");
                         novaDescricao = validateStringInput("Nova descrição: ", "");

                        break;
                    case 2:
                         dataTarefa = validateDateTimeInput("Nova data Limite: (formato: dd/MM/yyyy HH:mm): ", "Digite uma data maior ou igual a atual seguindo o formato formato: dd/MM/yyyy HH:mm");

                        break;
                    case 3:
                         novaQuantidadeMinutosTask = validatePositiveIntegerInput("Quantidade de minutos necessários para concluir a tarefa: ", "Digite um inteiro maior ou igual a 0.");

                        break;
                    case 4:
                         novaPrioridade = validateStringPrioridadeInput("Prioridade (baixa, média, alta): ", "Digite baixa, média ou alta.");
                        task.setPrioridade(novaPrioridade);
                        break;
                    case 5:
                         novaMateria = validateStringInput("Nova matéria: ", "");

                        break;
                    case 6:
                         finalizadoInput=validateYesNoInput("A tarefa está finalizada? (Sim ou Não): ","Digite sim ou não");

                        break;
                    default:
                        editarTarefa(idEditar);
                        throw new IllegalStateException("Valor inválido no campo " + campo);
            }
                continuarEditar =validateYesNoInput("Editar mais campos? (Sim ou não).", "");
            }
            studyService.editarTask( task, novaMateria,  dataTarefa,  novaDescricao,  novaQuantidadeMinutosTask,  novaPrioridade,  finalizadoInput);
            return task;
        } else {
            System.out.println("Tarefa de estudo não encontrada para edição.\n ");
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
        System.out.println("Por favor digite um id que exista.\n");
    }
    public void verificarTarefa() {
        if (studyService.getTasksList().isEmpty()) {
            System.out.println("Não há tarefas de estudo cadastradas.\n");
        } else {
            System.out.println("Tarefas de estudo cadastradas: ");
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
        System.out.println("Data da tarefa: " + task.getDataTask().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        System.out.println("Finalizado: " + task.getFinalizado());
        System.out.println("----------------------------------");
    }
    public void adicionarTarefa(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Criando uma tarefa de estudo: ");
        String descricao = validateStringInput("Informe a descrição da tarefa: ","");

        int quantidadeMinutos = validatePositiveIntegerInput("Informe a quantidade de minutos para a tarefa: ","Digite um número inteiro");

        String prioridade = validateStringPrioridadeInput("Informe a prioridade da tarefa (baixa, média, alta): ","Digite baixa, média ou alta.");

        String materia = validateStringInput("Informe a matéria de estudo: ","");

        LocalDateTime dataTarefa =  validateDateTimeInput("Nova data Limite: (formato: dd/MM/yyyy HH:mm): ", "Digite uma data maior ou igual a atual seguindo o formato formato: dd/MM/yyyy HH:mm");

        StudyTask studyTask =   new StudyTask(materia, 0, dataTarefa, descricao, quantidadeMinutos, prioridade, false);

        studyService.adicionarTask(studyTask, studyService.getTasksList());

    }
}
