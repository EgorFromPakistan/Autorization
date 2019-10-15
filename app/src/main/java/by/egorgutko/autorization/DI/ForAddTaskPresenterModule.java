package by.egorgutko.autorization.DI;

import by.egorgutko.autorization.fragments.add.ForAddTaskPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class ForAddTaskPresenterModule {

    @Provides
    ForAddTaskPresenter provideForAddTaskPresenter() {
        return new ForAddTaskPresenter();
    }

}
