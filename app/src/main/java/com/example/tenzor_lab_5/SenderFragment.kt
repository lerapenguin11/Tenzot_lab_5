package com.example.tenzor_lab_5

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText

class SenderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "SenderFragment"

        return inflater.inflate(R.layout.fragment_sender, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sendButton = requireView().findViewById<Button>(R.id.send_button)
        val inputText = requireView().findViewById<TextInputEditText>(R.id.text_input)

        sendButton.setOnClickListener {
            val fragment = ReceiverFragment()
            val bundle = Bundle();
            bundle.putString("message", inputText.text.toString())
            ViewModelProvider(requireActivity())
                .get(ReceiverViewModel::class.java)
                .getMessage()
                .removeObservers(requireActivity())
            fragment.arguments = bundle
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment, "ReceiverFragment")
                .addToBackStack(null)
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SenderFragment()
    }
}
