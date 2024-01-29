package Repository;

import Domain.BaseTask;

import java.util.ArrayList;
import java.util.Iterator;

abstract public class TaskRepository<T extends BaseTask>  {

    public void adicionar(T task, ArrayList<T> list) {
        list.add(task);
        System.out.println("Task adicionada com sucesso.");
    }
    //@Override
    public void deletar(Integer idTask,ArrayList<T> list) {
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

    public void editar(T task, ArrayList<T> list) {
        //editar();
        System.out.println("editado");
    }

    public  T getTaskById(Integer idTask,  ArrayList<T> list) {
        for (T task : list) {
            if (task.getIdTask().equals(idTask)) {
                return task;
            }
        }
        return null;
    }
}
