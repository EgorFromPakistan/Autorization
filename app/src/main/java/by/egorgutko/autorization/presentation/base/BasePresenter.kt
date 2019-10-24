package by.egorgutko.autorization.presentation.base

abstract class BasePresenter<View> {

    protected var mView: View? = null

    fun attachView(view: View) {
        mView = view
    }

    fun detachView() {
        mView = null
    }
}
