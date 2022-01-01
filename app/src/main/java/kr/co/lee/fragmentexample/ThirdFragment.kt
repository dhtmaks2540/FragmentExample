package kr.co.lee.fragmentexample

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ThirdFragment: Fragment(R.layout.fragment_third) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        logMessage("onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        logMessage("onStart")
    }

    override fun onResume() {
        super.onResume()
        logMessage("onResume")
    }

    override fun onPause() {
        super.onPause()
        logMessage("onPause")
    }

    override fun onStop() {
        super.onStop()
        logMessage("onStop")
    }

    override fun onDetach() {
        super.onDetach()
        logMessage("onDetach")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        logMessage("onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        logMessage("onDestroy")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logMessage("onCreate")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        logMessage("onAttach")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logMessage("onViewCreated")
    }

    private fun logMessage(message: String) {
        Log.i("ThirdFragment", "수명주기메소드 : $message")
    }
}