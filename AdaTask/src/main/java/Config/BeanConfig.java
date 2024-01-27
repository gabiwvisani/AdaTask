package Config;

import Domain.BaseTask;
import Domain.PersonalTask;
import Repository.Repository;
import Repository.TaskRepository;

public class BeanConfig {
    public Repository<BaseTask> taskRepository() {
        return new TaskRepository();
    }

}
