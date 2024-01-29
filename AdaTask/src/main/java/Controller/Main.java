package Controller;

import java.util.Scanner;

import Domain.BaseTask;
import Domain.PersonalTask;
import Repository.Repository;
import Repository.TaskRepository;
import Service.TaskService;

import javax.management.ObjectInstance;

public class Main {
    public static void main(String[] args) {
        Main app =new Main();
       // TaskRepository rep=new TaskRepository();
        app.executar();

    }
private String tipoAcao;
private String tipoTarefa;
    public String getTipoAcao() {
        return tipoAcao;
    }
    public void setTipoAcao() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Você gostaria de verificar, adicionar, deletar ou editar? Ou digite 'sair' para encerrar.");
        this.tipoAcao = scan.nextLine().toLowerCase().trim();
        scan.close();
    }

    public void executar() {
        setTipoAcao();
        while (true) {
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
            }
        }
    }
    public String getTipoTarefa() {
        return tipoTarefa;
    }
    public void setTipoTarefa() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Você gostaria realizar sua ação em qual tipo de tarefas? Pessoal, estudos ou trabalho? Ou digite menu para voltar para o começo.");
        this.tipoTarefa = scan.nextLine().toLowerCase().trim();
    }

    public static void verificarTarefa(){
        setTipoTarefa();
        switch (this.tipoTarefa) {
            case "pessoal":
                PersonalController.verificarTarefa(TaskRepository.tasksListPersonal);
                break;
            case "estudos":
                StudyController.verificarTarefa(TaskRepository.tasksListStudy);
                break;
            case "trabalho":
                WorkController.verificarTarefa(TaskRepository.tasksListWork);
                break;
            case "menu":
                executar();
                break;
            default:
                System.out.println("Por favor, digite uma opção válida.");
                verificarTarefa();
        }
    }
    public void adicionarTarefa(){
        setTipoTarefa();
        switch (this.tipoTarefa){
            case "pessoal":
            PersonalController.adicionarTarefa();
            break;
            case"estudos":
            StudyController.adicionarTarefa();
            break;
            case "trabalho":
            WorkController.adicionarTarefa();
            break;
            case "menu":
            executar();
            break;
            default:
            System.out.println("Por favor digite uma das opções: Todas, pessoal, estudos, trabalho ou menu.");
            adicionarTarefa();
        }
    }

    public void deletarTask(){
        setTipoTarefa();
        Scanner scan = new Scanner(System.in);
        System.out.println("Qual tarefa você gostaria de deletar? Digite o id da tarefa.");
        try{
            Integer idDeletar = scan.nextInt();
            switch (this.tipoTarefa) {
                case "pessoal":
                    PersonalController.deletarTarefa(idDeletar);
                    break;
                case "estudos":
                    StudyController.deletarTarefa(idDeletar);
                    break;
                case "trabalho":
                    WorkController.deletarTarefa(idDeletar);
                    break;
                case "menu":
                    executar();
                    break;
            }
        }catch(Exception e){
            System.out.println("Por favor digite um número inteiro.");
            deletarTask();
        }

    }
    public  void negarDeletarTarefa(){
        System.out.println("Por favor digite um idTarefa que exista.");
        deletarTask();
    }
    public  void editarTarefa(){
        setTipoTarefa();
        Scanner scan = new Scanner(System.in);
        System.out.println("Qual tarefa você gostaria de editar? Digite o id da tarefa.");
        try{
            Integer idEditar = scan.nextInt();
            switch (this.tipoTarefa) {
                case "pessoal":
                    PersonalController.editarTarefa(idEditar);
                    break;
                case "estudos":
                    StudyController.editarTarefa(idEditar);
                    break;
                case "trabalho":
                    WorkController.editarTarefa(idEditar);
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
