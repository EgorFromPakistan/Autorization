package by.egorgutko.autorization.DI;

import by.egorgutko.autorization.DI.forAdd.ForAddTaskPresenterModule;
import by.egorgutko.autorization.DI.forAdd.ForAddTaskSubComponent;
import by.egorgutko.autorization.DI.forList.ForListPresenterModule;
import by.egorgutko.autorization.DI.forList.ForListTaskSubComponent;

public class DaggerController {
    private ForAddTaskSubComponent forAddTaskSubComponent;
    private ForListTaskSubComponent forListTaskSubComponent;
    private MyAppComponent myAppComponent;

    public DaggerController(MyAppComponent myAppComponent) {
        this.myAppComponent = myAppComponent;
    }

    public void initForAddTaskSubController() {
        if (forAddTaskSubComponent == null) {
            forAddTaskSubComponent = myAppComponent.add(new ForAddTaskPresenterModule());
        }
    }

    public ForListTaskSubComponent getForListTaskSubComponent() {
        return forListTaskSubComponent;
    }

    public ForAddTaskSubComponent getForAddTAskComponent() {
        return forAddTaskSubComponent;
    }

    public void initForListSubComponent() {
        if (forListTaskSubComponent == null) {
            forListTaskSubComponent = myAppComponent.add(new ForListPresenterModule());
        }
    }


}
