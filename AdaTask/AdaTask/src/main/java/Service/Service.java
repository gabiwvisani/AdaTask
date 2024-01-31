package Service;

import Domain.BaseTask;

import java.util.List;

public interface Service <T extends BaseTask> {
    public List<T> getTasksList();
    public void adicionarTask(T task,  List<T> list) ;

    public  void deletarTask(Integer idTask, List<T> taskList) ;

    public  Boolean validacaoDeletar(Integer idTask, List<T> taskList) ;



}
