package vboyko.gb.libs.firstMVP.screens.tracker

import android.media.RingtoneManager
import android.net.Uri
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

class TrackerFragment : MvpAppCompatFragment(), TrackerView, IBackListener {
    companion object {
        fun newInstance() = TrackerFragment()
    }

    private val presenter: TrackerPresenter by moxyPresenter {
        TrackerPresenter(App.instance.router, AppScreens())
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
        binding.startButton.setOnClickListener { presenter.startPressed() }
        binding.stopButton.setOnClickListener { presenter.stopPressed() }
        binding.commitButton.setOnClickListener { presenter.commitPressed() }
        binding.discardButton.setOnClickListener { presenter.discardPressed() }
        binding.editEntitiesButton.setOnClickListener { presenter.editEntitiesButtonPressed() }
    }

    override fun backPressed() = presenter.backPressed()

    override fun setDisplay(text: String) {
        binding.timerDisplay.text = text
    }

    override fun showStart(show: Boolean) = setVisible(binding.startButton, show)
    override fun showStop(show: Boolean) = setVisible(binding.stopButton, show)
    override fun showCommit(show: Boolean) = setVisible(binding.commitButton, show)
    override fun showDiscard(show: Boolean) = setVisible(binding.discardButton, show)

    override fun playAlarm() {
        val notification: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val r = RingtoneManager.getRingtone(requireContext(), notification)
        r.play()
    }

    private fun setVisible(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }
}