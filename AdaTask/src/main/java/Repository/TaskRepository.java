package Repository;

import Domain.BaseTask;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract public class TaskRepository<T extends BaseTask> implements Repository<T> {
    //final public static List<T> tasksList = new ArrayList<>();
    final public  ArrayList<T> tasksListPersonal = new ArrayList<>();
    final public  ArrayList<T> tasksListStudy = new ArrayList<>();
    final public  ArrayList<T> tasksListWork = new ArrayList<>();
    @Override
    public void adicionar(T task, ArrayList<T> list) {
        list.add(task);
        System.out.println("Task adicionada com sucesso.");
    }
    //@Override
    public void deletar(Integer idTask, ArrayList<T> list) {
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
    @Override
    public void editar(T task, ArrayList<T> list) {
        //editar();
        System.out.println("editado");
    }

    public  <T extends BaseTask> T getTaskById(Integer idTask, Class<T> taskClass, ArrayList<T> list) {
        for (T task : list) {
            if (task.getIdTask().equals(idTask) && taskClass.isInstance(task)) {
                return taskClass.cast(task);
            }
        }
        return null;
    }
}
