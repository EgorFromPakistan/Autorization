package by.egorgutko.autorization.DI;

import by.egorgutko.autorization.DI.forAdd.ForAddTaskComponent;
import by.egorgutko.autorization.DI.forList.ForListTaskComponent;
import dagger.Component;

@Component
public interface MyAppComponent {
    ForAddTaskComponent forAddTaskComponent();
    ForListTaskComponent forListTaskComponent();
}
