package Repository;

import Service.TaskService;
import Domain.BaseTask;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskRepository implements Repository<BaseTask> {
    final public static List<BaseTask> tasksList = new ArrayList<>();
    @Override
    public void adicionar(BaseTask task) {
        tasksList.add(task);
        System.out.println("Task adicionada com sucesso.");
    }
    //@Override
    public void deletar(Integer idTask) {
        Iterator<BaseTask> iterator = tasksList.iterator();
        while (iterator.hasNext()) {
            BaseTask task = iterator.next();
            if (task.getIdTask().equals(idTask)) {
                iterator.remove();
                System.out.println("Task removida com sucesso.");
                return;
            }
        }
    }
    @Override
    public void editar(BaseTask task) {
        //editar();
        System.out.println("editado");
    }

    public  <T extends BaseTask> T getTaskById(Integer idTask, Class<T> taskClass) {
        for (BaseTask task : tasksList) {
            if (task.getIdTask().equals(idTask) && taskClass.isInstance(task)) {
                return taskClass.cast(task);
            }
        }
        return null;
    }
}
