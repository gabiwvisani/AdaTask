package Repository;

import Domain.BaseTask;
import Service.TaskService;

import java.util.Iterator;

public interface Repository <T>{
    void adicionar(T t);
    void deletar(Integer i);

    void editar(T t);
    public  <T extends BaseTask> T getTaskById(Integer idTask, Class<T> taskClass);


}
