package by.egorgutko.autorization.DI;

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
