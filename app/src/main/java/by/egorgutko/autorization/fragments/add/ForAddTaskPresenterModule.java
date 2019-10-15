package by.egorgutko.autorization.fragments.add;

import dagger.Module;
import dagger.Provides;

@Module
public class ForAddTaskPresenterModule {

    @Provides
    ForAddTaskPresenter provideForAddTaskPresenter() {
        return new ForAddTaskPresenter();
    }

}
