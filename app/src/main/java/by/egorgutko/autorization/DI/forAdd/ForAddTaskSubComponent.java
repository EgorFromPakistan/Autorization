package by.egorgutko.autorization.DI.forAdd;


import by.egorgutko.autorization.DI.ForModuleScope;
import by.egorgutko.autorization.fragments.add.ForAddFragment;
import dagger.Subcomponent;

@ForModuleScope
@Subcomponent(modules = ForAddTaskPresenterModule.class)
public interface ForAddTaskSubComponent {
    void inject(ForAddFragment forAddFragment);
}
