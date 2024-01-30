package Controller;

import java.util.Scanner;

import Repository.PersonalRepository;
import Repository.WorkRepository;
import Repository.StudyRepository;
import Service.PersonalService;
import Service.StudyService;
import Service.WorkService;

public class Main {
    public static void main(String[] args) {
        Main app =new Main(new PersonalController(new PersonalService(new PersonalRepository())),
                new StudyController(new StudyService(new StudyRepository())),
                new WorkController(new WorkService(new WorkRepository())));
       // TaskRepository rep=new TaskRepository();
        app.iniciar();

    }
private String tipoAcao;
private String tipoTarefa;
    private final PersonalController personalController;
    private final StudyController studyController;
    private final WorkController workController;

    public Main(PersonalController personalController, StudyController studyController,
                WorkController workController ) {
        this.personalController = personalController;
        this.studyController = studyController;
        this.workController = workController;
    }
    public String getTipoAcao() {
        return tipoAcao;
    }
    public void setTipoAcao() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Escolha uma ação: verificar, adicionar, deletar, editar ou sair.");
            this.tipoAcao = scan.nextLine().toLowerCase().trim();

        }catch (Exception e){
            System.out.println("Opção não válida.");
            setTipoAcao();
        }
    }
    public void iniciar(){
        System.out.println("-------------------------------------");
        System.out.println("               AdaTask               ");
        System.out.println("-------------------------------------");
        executar();
    }

    public void executar() {
        System.out.println("-------------------------------------");
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
        }
    }
    public String getTipoTarefa() {
        return tipoTarefa;
    }
    public void setTipoTarefa() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Escolha o tipo de tarefa: pessoal, estudos, trabalho ou menu para voltar.");
            this.tipoTarefa = scan.nextLine().toLowerCase().trim();
        }catch (Exception e){
            System.out.println("Opção não válida.");
            setTipoAcao();
        }
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
        Scanner scan = new Scanner(System.in);
        try{
        System.out.println("Qual tarefa você gostaria de deletar? Digite o ID da tarefa.");
            Integer idDeletar = scan.nextInt();
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
        }catch(Exception e){
            System.out.println("Por favor, digite uma opção válida.");
            deletarTask();
        }

    }
   /* public  void negarDeletarTarefa(){
        System.out.println("Por favor digite um idTarefa que exista.");
        deletarTask();
    }*/
    public  void editarTarefa(){
        setTipoTarefa();
        Scanner scan = new Scanner(System.in);
        System.out.println("Qual tarefa você gostaria de editar? Digite o id da tarefa.");
        try{
            Integer idEditar = scan.nextInt();
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
        }catch(Exception e){
            System.out.println("Por favor digite um número inteiro.");
            editarTarefa();
        }

    }


}
