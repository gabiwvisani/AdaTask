package Controller;

import java.util.Scanner;

import Domain.BaseTask;
import Repository.Repository;
import Repository.TaskRepository;
import Service.TaskService;

import javax.management.ObjectInstance;

public class Main {
    public static void main(String[] args) {
        Main app =new Main();
        app.executar();

    }

    public void executar() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Você gostaria de verificar, adicionar, deletar ou editar? Ou digite 'sair' para encerrar.");
            String tipoAcao = scan.nextLine().toLowerCase().trim();
            switch (tipoAcao) {
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
                    scan.close();
                    System.exit(0);
                default:
                    System.out.println("Por favor, digite uma das opções: verificar, adicionar, deletar, editar ou sair.");
            }
        }
    }
    public  void verificarTarefa(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Você gostaria de verificar todas as suas tarefas cadastradas, ou só as tarefas de algum tipo? Todas, pessoal, estudos ou trabalho? Ou digite menu para voltar para o começo.");
        String tipoTarefa = scan.nextLine().toLowerCase().trim();
        if (tipoTarefa.equals("Todas")){

        }else if(tipoTarefa.equals("pessoal")){
            PersonalController.verificarTarefasPessoais();
        }else if(tipoTarefa.equals("estudos")){
            StudyController.verificarTarefasEstudos();
        }else if(tipoTarefa.equals("trabalho")){
            WorkController.verificarTarefasTrabalho();
        }else if (tipoTarefa.equals("menu")){
            executar();
        }else{
            System.out.println("Por favor digite uma das opções: Todas, pessoal, estudos, trabalho ou menu.");
            verificarTarefa();
        }
    }
    public  void adicionarTarefa(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Qual tipo de tarefa você gostaria de adicionar? Pessoal, estudos ou trabalho? Ou digite menu para voltar para o começo.");
        String tipoTarefa = scan.nextLine();
        if(tipoTarefa.equals("pessoal")){
            PersonalController.adicionarTarefasPessoais();
        }else if(tipoTarefa.equals("estudos")){
            StudyController.adicionarTarefasEstudos();
        }else if(tipoTarefa.equals("trabalho")){
            WorkController.adicionarTarefasTrabalho();
        }else if (tipoTarefa.equals("menu")){
            executar();
        }else{
            System.out.println("Por favor digite uma das opções: Todas, pessoal, estudos, trabalho ou menu.");
            adicionarTarefa();
        }
    }

    public void deletarTask(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Qual tarefa você gostaria de deletar? Digite o id da tarefa. Ou digite -1 para voltar para o começo.");
        try{
            Integer idDeletar = scan.nextInt();
            if(idDeletar==-1){
                return;
            }
            TaskService.deletarTask(idDeletar, this);
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
        Scanner scan = new Scanner(System.in);
        System.out.println("Qual tarefa você gostaria de editar? Digite o id da tarefa. Ou digite -1 para voltar para o começo.");
        Integer idEditar = scan.nextInt();
    }


}
