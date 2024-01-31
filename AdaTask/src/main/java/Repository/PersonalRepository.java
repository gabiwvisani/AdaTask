package Repository;


import Domain.PersonalTask;
import java.util.ArrayList;

public class PersonalRepository extends TaskRepository<PersonalTask>{
    final public ArrayList<PersonalTask> tasksListPersonal = new ArrayList<>();
}
