package by.egorgutko.autorization.DI.forAdd;

import by.egorgutko.autorization.DI.ForModuleScope;
import by.egorgutko.autorization.fragments.add.ForAddTaskPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class ForAddTaskPresenterModule {

    @ForModuleScope
    @Provides
    ForAddTaskPresenter provideForAddTaskPresenter() {
        return new ForAddTaskPresenter();
    }
}
