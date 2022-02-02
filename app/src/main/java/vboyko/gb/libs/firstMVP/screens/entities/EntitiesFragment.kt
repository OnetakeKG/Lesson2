package vboyko.gb.libs.firstMVP.screens.entities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import vboyko.gb.libs.firstMVP.App
import vboyko.gb.libs.firstMVP.AppScreens
import vboyko.gb.libs.firstMVP.IBackListener
import vboyko.gb.libs.firstMVP.databinding.TrackerFragmentBinding

class EntitiesFragment : MvpAppCompatFragment(), EntitiesView, IBackListener {
    companion object {
        fun newInstance() = EntitiesFragment()
    }

    private val presenter: EntitiesPresenter by moxyPresenter {
        EntitiesPresenter(App.instance.router, AppScreens())
    }

    private var _binding: TrackerFragmentBinding? = null
    private val binding: TrackerFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = TrackerFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backFabButton.setOnClickListener { presenter.backPressed() }
    }

    override fun backPressed(): Boolean = presenter.backPressed()
}