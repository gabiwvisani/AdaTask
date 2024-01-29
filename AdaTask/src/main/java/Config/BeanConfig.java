package Config;

import Domain.BaseTask;
import Domain.PersonalTask;
import Repository.Repository;
import Repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class BeanConfig <?> {
    public Repository<?> taskRepository() {
        return new TaskRepository();
    }


}
