package vboyko.gb.libs.firstMVP

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(val router: Router, val screen: IAppScreens) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screen.tracker())
    }

    fun backClicked() {
        router.exit()
    }
}