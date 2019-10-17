package by.egorgutko.autorization.DI;


import by.egorgutko.autorization.fragments.add.ForAddFragment;
import dagger.Subcomponent;

@ForModuleScope
@Subcomponent(modules = ForAddTaskPresenterModule.class)
public interface ForAddTaskComponent {
    void inject(ForAddFragment forAddFragment);
}
