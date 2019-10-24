package by.egorgutko.autorization.DI

import by.egorgutko.autorization.DI.forAdd.ForAddTaskPresenterModule
import by.egorgutko.autorization.DI.forAdd.ForAddTaskSubComponent
import by.egorgutko.autorization.DI.forList.ForListPresenterModule
import by.egorgutko.autorization.DI.forList.ForListTaskSubComponent

class DaggerController(private val myAppComponent: MyAppComponent) {
    var forAddTAskComponent: ForAddTaskSubComponent? = null
        private set
    var forListTaskSubComponent: ForListTaskSubComponent? = null
        private set

    fun initForAddTaskSubController() {
        if (forAddTAskComponent == null) {
            forAddTAskComponent = myAppComponent.add(ForAddTaskPresenterModule())
        }
    }

    fun initForListSubComponent() {
        if (forListTaskSubComponent == null) {
            forListTaskSubComponent = myAppComponent.add(ForListPresenterModule())
        }
    }


}
