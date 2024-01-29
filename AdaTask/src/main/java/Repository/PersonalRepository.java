package Repository;

import Domain.PersonalTask;

import java.util.ArrayList;
import java.util.Iterator;

public class PersonalRepository extends TaskRepository{
    final public ArrayList<PersonalTask> tasksListPersonal = new ArrayList<>();
    @Override
    public void adicionar(PersonalTask task, ArrayList<PersonalTask> list) {
        list.add(task);
        System.out.println("Task adicionada com sucesso.");
    }
    //@Override
    public void deletar(Integer idTask, ArrayList<PersonalTask> list) {
        Iterator<PersonalTask> iterator = list.iterator();
        while (iterator.hasNext()) {
            PersonalTask task = iterator.next();
            if (task.getIdTask().equals(idTask)) {
                iterator.remove();
                System.out.println("Task removida com sucesso.");
                return;
            }
        }
    }
    @Override
    public void editar(PersonalTask task, ArrayList<PersonalTask> list) {
        //editar();
        System.out.println("editado");
    }

    public PersonalTask getTaskById(Integer idTask, Class<PersonalTask> taskClass, ArrayList<PersonalTask> list) {
        for (PersonalTask task : list) {
            if (task.getIdTask().equals(idTask) && taskClass.isInstance(task)) {
                return taskClass.cast(task);
            }
        }
        return null;
    }
}
