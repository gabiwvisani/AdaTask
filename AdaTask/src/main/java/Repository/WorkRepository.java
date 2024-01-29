package Repository;

import Domain.BaseTask;
import Domain.WorkTask;

import java.util.ArrayList;

public class WorkRepository<W extends BaseTask> extends TaskRepository<WorkTask>{
    final public ArrayList<WorkTask> tasksListWork = new ArrayList<>();
    /*@Override
    public void adicionar(StudyTask task, ArrayList<StudyTask> list) {
        list.add(task);
        System.out.println("Task adicionada com sucesso.");
    }
    //@Override
    public void deletar(Integer idTask, ArrayList<WorkTask> list) {
        Iterator<WorkTask> iterator = list.iterator();
        while (iterator.hasNext()) {
            WorkTask task = iterator.next();
            if (task.getIdTask().equals(idTask)) {
                iterator.remove();
                System.out.println("Task removida com sucesso.");
                return;
            }
        }
    }
    @Override
    public void editar(WorkTask task, ArrayList<WorkTask> list) {
        //editar();
        System.out.println("editado");
    }

    public WorkTask getTaskById(Integer idTask, Class<WorkTask> taskClass, ArrayList<StudyTask> list) {
        for (WorkTask task : list) {
            if (task.getIdTask().equals(idTask) && taskClass.isInstance(task)) {
                return taskClass.cast(task);
            }
        }
        return null;
    }*/
}
