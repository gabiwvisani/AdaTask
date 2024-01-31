package Repository;

import Domain.BaseTask;
import java.util.Iterator;
import java.util.List;

abstract public class TaskRepository<T extends BaseTask>  {

    public void adicionar(T task, List<T> list) {
        list.add(task);
        System.out.println("Task adicionada com sucesso.");
    }
    public void deletar(Integer idTask, List<T> list) {
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            T task = iterator.next();
            if (task.getIdTask().equals(idTask)) {
                iterator.remove();
                System.out.println("Task removida com sucesso.");
                return;
            }
        }
    }

    public  T getTaskById(Integer idTask,  List<T> list) {
        for (T task : list) {
            if (task.getIdTask().equals(idTask)) {
                return task;
            }
        }
        return null;
    }
}
