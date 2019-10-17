package by.egorgutko.autorization.DI.forList;

import by.egorgutko.autorization.DI.ForModuleScope;
import by.egorgutko.autorization.fragments.list.ForListFragment;
import dagger.Subcomponent;

@ForModuleScope
@Subcomponent(modules = ForListPresenterModule.class)
public interface ForListTaskComponent {
    void inject(ForListFragment forListFragment);
}
