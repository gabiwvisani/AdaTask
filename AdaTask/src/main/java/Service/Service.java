package Service;

import Controller.Main;
import Domain.BaseTask;
import Domain.PersonalTask;

import java.util.ArrayList;
import java.util.List;

public interface Service <T extends BaseTask> {
    public List<T> getTasksList();
    public void adicionarTask(T task,  List<T> list) ;

    public  void deletarTask(Integer idTask, List<T> taskList) ;

    public  Boolean validacaoDeletar(Integer idTask, List<T> taskList) ;

    public default Boolean validacaoPrioricade(String prioridade){
        if(prioridade.toLowerCase().trim().equals("alta")||prioridade.toLowerCase().trim().equals("média")||prioridade.toLowerCase().trim().equals("baixa")){
            return true;
        }else{
            return false;
        }
    }
}
