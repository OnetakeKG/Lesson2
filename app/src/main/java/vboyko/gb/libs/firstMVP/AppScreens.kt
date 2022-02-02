package vboyko.gb.libs.firstMVP

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import vboyko.gb.libs.firstMVP.screens.entities.EntitiesFragment
import vboyko.gb.libs.firstMVP.screens.tracker.TrackerFragment


class AppScreens : IAppScreens {
    override fun tracker(): Screen = FragmentScreen { TrackerFragment.newInstance() }

    override fun entities(): Screen = FragmentScreen { EntitiesFragment.newInstance() }
}