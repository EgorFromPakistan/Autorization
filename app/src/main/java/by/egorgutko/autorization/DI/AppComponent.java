package by.egorgutko.autorization.DI;

import by.egorgutko.autorization.fragments.add.ForAddFragment;
import by.egorgutko.autorization.fragments.list.ForListFragment;
import dagger.Component;

@Component()
public interface AppComponent {

    void injectForListPresenter(ForListFragment forListFragment);
    void injectForAddFragmentPresenter(ForAddFragment forAddFragment);
}
