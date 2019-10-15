package by.egorgutko.autorization.DI;

import by.egorgutko.autorization.fragments.add.ForAddFragment;
import by.egorgutko.autorization.fragments.add.ForAddTaskPresenterModule;
import by.egorgutko.autorization.fragments.list.ForListFragment;
import by.egorgutko.autorization.fragments.list.ForListPresenterModule;
import dagger.Component;

@Component( modules = {ForAddTaskPresenterModule.class, ForListPresenterModule.class})
public interface AppComponent {

    void injectForListPresenter(ForListFragment forListFragment);
    void injectForAddFragmentPresenter(ForAddFragment forAddFragment);
}
