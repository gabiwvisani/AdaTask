package Controller;


public class ControllerInicial implements ConsoleInputValidator{

private String tipoAcao;
private String tipoTarefa;
    private final PersonalController personalController;
    private final StudyController studyController;
    private final WorkController workController;

    public ControllerInicial(PersonalController personalController, StudyController studyController,
                             WorkController workController ) {
        this.personalController = personalController;
        this.studyController = studyController;
        this.workController = workController;
    }
    public String getTipoAcao() {
        return tipoAcao;
    }
    public void setTipoAcao() {
        this.tipoAcao =validateStringInput("Escolha uma ação: verificar, adicionar, deletar, editar ou sair.\n","Opção não válida.").toLowerCase().trim();
    }
    public void iniciar(){
        System.out.println("----------------------------------------------------");
        System.out.println("                        AdaTask                     ");
        System.out.println("----------------------------------------------------");
        executar();
    }

    public void executar() {
        while (true) {
        setTipoAcao();
            switch (this.tipoAcao) {
                case "verificar":
                    verificarTarefa();
                    break;
                case "adicionar":
                    adicionarTarefa();
                    break;
                case "deletar":
                    deletarTask();
                    break;
                case "editar":
                    editarTarefa();
                    break;
                case "sair":
                    System.out.println("Encerrando o programa.");
                    System.exit(0);
                default:
                    System.out.println("Por favor, digite uma das opções: verificar, adicionar, deletar, editar ou sair.");
                    setTipoAcao();
            }
            System.out.println("---------------------------------------------------");
        }
    }
    public String getTipoTarefa() {
        return tipoTarefa;
    }
    public void setTipoTarefa() {
        this.tipoTarefa = validateStringInput("Escolha o tipo de tarefa: pessoal, estudos, trabalho ou menu para voltar.\n","Opção não válida.").toLowerCase().trim();
    }

    public  void verificarTarefa(){
        setTipoTarefa();
        switch (this.tipoTarefa) {
            case "pessoal":
                personalController.verificarTarefa();
                break;
            case "estudos":
                studyController.verificarTarefa();
                break;
            case "trabalho":
                workController.verificarTarefa();
                break;
            case "menu":
                executar();
                break;
        }
    }
    public void adicionarTarefa(){
        setTipoTarefa();
        switch (this.tipoTarefa){
            case "pessoal":
                personalController.adicionarTarefa();
            break;
            case"estudos":
                studyController.adicionarTarefa();
            break;
            case "trabalho":
                workController.adicionarTarefa();
            break;
            case "menu":
                executar();
            break;
        }
    }

    public void deletarTask(){
        setTipoTarefa();
        Integer idDeletar = validatePositiveIntegerInput("Qual tarefa você gostaria de deletar? Digite o ID da tarefa.","Por favor, digite uma opção válida.");
            switch (this.tipoTarefa) {
                case "pessoal":
                    personalController.deletarTarefa(idDeletar);
                    break;
                case "estudos":
                    studyController.deletarTarefa(idDeletar);
                    break;
                case "trabalho":
                    workController.deletarTarefa(idDeletar);
                    break;
                case "menu":
                    executar();
                    break;
            }
    }
    public  void editarTarefa(){
        setTipoTarefa();
        Integer idEditar= validatePositiveIntegerInput("Qual tarefa você gostaria de editar? Digite o id da tarefa.", "Por favor digite um número inteiro.");
            switch (this.tipoTarefa) {
                case "pessoal":
                    personalController.editarTarefa(idEditar);
                    break;
                case "estudos":
                    studyController.editarTarefa(idEditar);
                    break;
                case "trabalho":
                    workController.editarTarefa(idEditar);
                    break;
                case "menu":
                    executar();
                    break;
            }
    }
}
