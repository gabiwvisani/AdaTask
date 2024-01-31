import Controller.ControllerInicial;
import Controller.PersonalController;
import Controller.StudyController;
import Controller.WorkController;
import Repository.PersonalRepository;
import Repository.StudyRepository;
import Repository.WorkRepository;
import Service.PersonalService;
import Service.StudyService;
import Service.WorkService;

public class Main {
    public static void main(String[] args) {
        ControllerInicial app =new ControllerInicial(new PersonalController(new PersonalService(new PersonalRepository())),
                new StudyController(new StudyService(new StudyRepository())),
                new WorkController(new WorkService(new WorkRepository())));
        app.iniciar();
    }
}
