package Repository;

import Domain.WorkTask;

import java.util.ArrayList;

public class WorkRepository extends TaskRepository<WorkTask>{
    final public ArrayList<WorkTask> tasksListWork = new ArrayList<>();

}
