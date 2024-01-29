package Repository;

import Domain.BaseTask;
import Service.TaskService;

import java.util.ArrayList;
import java.util.Iterator;

public interface Repository <T>{
    void adicionar(T t, ArrayList<T> list);
    void deletar(Integer i, ArrayList<T> list);

    void editar(T t, ArrayList<T> list);
      <T extends BaseTask> T getTaskById(Integer idTask, Class<T> taskClass);


}
