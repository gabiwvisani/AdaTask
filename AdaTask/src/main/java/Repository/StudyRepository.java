package Repository;

import Domain.PersonalTask;
import Domain.StudyTask;

import java.util.ArrayList;
import java.util.Iterator;

public class StudyRepository extends TaskRepository<StudyTask>{
    final public ArrayList<StudyTask> tasksListStudy = new ArrayList<>();
    @Override
    public void adicionar(StudyTask task, ArrayList<StudyTask> list) {
        list.add(task);
        System.out.println("Task adicionada com sucesso.");
    }
    //@Override
    public void deletar(Integer idTask, ArrayList<StudyTask> list) {
        Iterator<StudyTask> iterator = list.iterator();
        while (iterator.hasNext()) {
            StudyTask task = iterator.next();
            if (task.getIdTask().equals(idTask)) {
                iterator.remove();
                System.out.println("Task removida com sucesso.");
                return;
            }
        }
    }
    @Override
    public void editar(StudyTask task, ArrayList<StudyTask> list) {
        //editar();
        System.out.println("editado");
    }

    public StudyTask getTaskById(Integer idTask, Class<StudyTask> taskClass, ArrayList<StudyTask> list) {
        for (StudyTask task : list) {
            if (task.getIdTask().equals(idTask) && taskClass.isInstance(task)) {
                return taskClass.cast(task);
            }
        }
        return null;
    }
}
