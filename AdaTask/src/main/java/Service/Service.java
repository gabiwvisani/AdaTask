package Service;

import Controller.Main;
import Domain.BaseTask;

import java.util.ArrayList;
import java.util.List;

public interface Service <T extends BaseTask> {
    public void adicionarTask(T task,  ArrayList<T> list) ;

    public  void deletarTask(Integer idTask, ArrayList<T> taskList, Main mainInstance) ;

    public  Boolean validacaoDeletar(Integer idTask, ArrayList<T> taskList) ;
}
