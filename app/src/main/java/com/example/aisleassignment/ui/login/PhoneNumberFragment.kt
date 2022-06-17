package com.example.aisleassignment.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.example.aisleassignment.R
import com.example.aisleassignment.data.request.OtpRequest
import com.example.aisleassignment.databinding.PhoneNumberFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PhoneNumberFragment: Fragment() {
    private lateinit var binding: PhoneNumberFragmentBinding
    private val viewModel by viewModel<PhoneNumberViewModel>()
    private var number: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PhoneNumberFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpObserver()

        binding.sendOtpBtn.setOnClickListener {
            val countryCode = binding.countryCodeEdt.text.toString()
            number = countryCode+""+binding.phoneNumberEdt.text.toString()
            viewModel.sendOTP(OtpRequest(number))
        }

    }

    private fun setUpObserver() {
        viewModel.sendOtpResponse.observe(viewLifecycleOwner){
            if (it.status){
                viewModel.sendOtpResponse = MutableLiveData()
                val bundle = Bundle()
                bundle.putString("number", number)
                findNavController().navigate(R.id.action_phoneNumberFragment_to_verifyOtpFragment, bundle)
            }
        }
    }
}