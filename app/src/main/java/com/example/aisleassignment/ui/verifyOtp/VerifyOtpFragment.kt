package com.example.aisleassignment.ui.verifyOtp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.aisleassignment.R
import com.example.aisleassignment.data.request.VerifyOtpRequest
import com.example.aisleassignment.databinding.VerifyOtpFragmentBinding
import com.example.aisleassignment.prefs.PreferenceHelper
import org.koin.androidx.viewmodel.ext.android.viewModel

class VerifyOtpFragment: Fragment() {

    private lateinit var binding: VerifyOtpFragmentBinding
    private val viewModel by viewModel<VerifyOtpViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = VerifyOtpFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        val num = bundle?.get("number").toString()
        binding.mobileNumberText.text = num
        viewModel.setCountDownTimer()
        setUpObserver()

        binding.mobileNumberText.setOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.verifyOTpBtn.setOnClickListener {
            val otp = binding.otpEdt.text.toString()
            if (otp.isNullOrBlank()){
                binding.otpEdt.error = "Please enter otp"
            }else{
                viewModel.verifyOtp(VerifyOtpRequest(num,otp))
            }
        }

    }

    private fun setUpObserver() {
        viewModel.verifyOtpResponse.observe(viewLifecycleOwner){
            if (it.token.isNullOrEmpty().not()){
                PreferenceHelper.saveString("auth_token", it?.token!!)
                findNavController().navigate(R.id.action_verifyOtpFragment_to_homeFragment)
            }
            else{
                Toast.makeText(requireContext(), "Invalid OTP", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.getTimerText().observe(viewLifecycleOwner){
            binding.timerTxt.text = String.format(getString(R.string.text_timer),it)
        }
    }
}