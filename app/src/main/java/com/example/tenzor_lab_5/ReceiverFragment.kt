package com.example.tenzor_lab_5

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI

class ReceiverFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val readButton = view.findViewById<Button>(R.id.button_read)
        val message = view.findViewById<TextView>(R.id.message_text_box)
        val messageText = arguments?.getString("message") ?: ""

        val viewModel = ViewModelProvider(requireActivity()).get(ReceiverViewModel::class.java)
        message.setText(messageText)
        viewModel.getMessage().observe(viewLifecycleOwner, Observer<String> { msg ->
            view.findViewById<TextView>(R.id.message_text_box).setText(msg)
        })

        readButton.setOnClickListener {
            viewModel.storeMessage(getString(R.string.message_read))
            readButton.setText(R.string.all_messages_read)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "ReceiverFragment"
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        return inflater.inflate(R.layout.fragment_receiver, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = ReceiverFragment()
    }
}

