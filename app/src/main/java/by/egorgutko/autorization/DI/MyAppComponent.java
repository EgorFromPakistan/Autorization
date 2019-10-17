package by.egorgutko.autorization.DI;

import dagger.Component;

@Component
public interface MyAppComponent {
    ForAddTaskComponent forAddTaskComponent();
    ForListTaskComponent forListTaskComponent();
}
