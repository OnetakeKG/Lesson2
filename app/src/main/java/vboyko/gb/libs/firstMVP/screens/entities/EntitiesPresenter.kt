package vboyko.gb.libs.firstMVP.screens.entities

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import vboyko.gb.libs.firstMVP.IAppScreens

class EntitiesPresenter(private val router: Router, private val screens: IAppScreens) :
    MvpPresenter<EntitiesView>() {

    fun backPressed(): Boolean {
        router.navigateTo(screens.tracker())
        return true
    }
}