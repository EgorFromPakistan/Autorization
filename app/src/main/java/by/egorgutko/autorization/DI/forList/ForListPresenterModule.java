package by.egorgutko.autorization.DI.forList;

import by.egorgutko.autorization.DI.ForModuleScope;
import by.egorgutko.autorization.fragments.list.ForListFragmentPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class ForListPresenterModule {

    @ForModuleScope
    @Provides
    ForListFragmentPresenter provideForListFragmentPresenter() {
        return new ForListFragmentPresenter();
    }
}
