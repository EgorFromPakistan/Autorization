package by.egorgutko.autorization.DI;

import by.egorgutko.autorization.DI.forAdd.ForAddTaskPresenterModule;
import by.egorgutko.autorization.DI.forAdd.ForAddTaskSubComponent;
import by.egorgutko.autorization.DI.forList.ForListPresenterModule;
import by.egorgutko.autorization.DI.forList.ForListTaskSubComponent;
import dagger.Component;

@Component
public interface MyAppComponent {
    ForAddTaskSubComponent add(ForAddTaskPresenterModule forAddTaskPresenterModule );
    ForListTaskSubComponent add(ForListPresenterModule forListPresenterModule);
}