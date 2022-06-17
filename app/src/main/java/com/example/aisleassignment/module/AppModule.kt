package com.example.aisleassignment.module

import com.example.aisleassignment.data.repository.HomeRepository
import com.example.aisleassignment.data.repository.LoginRepository
import com.example.aisleassignment.network.AisleServiceFactory
import com.example.aisleassignment.repository.loginRepository.LoginRepositoryImpl
import com.example.aisleassignment.repository.noteRepository.HomeRepositoryImpl
import com.example.aisleassignment.ui.home.HomeViewModel
import com.example.aisleassignment.ui.login.PhoneNumberViewModel
import com.example.aisleassignment.ui.verifyOtp.VerifyOtpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    single { AisleServiceFactory.makeAisleService() } // network
}


val repositoryModule = module {
    single <LoginRepository>{LoginRepositoryImpl(aisleService = get())  }
    single <HomeRepository>{HomeRepositoryImpl(aisleService = get())  }
}

val viewModelModule = module {
    //dashboard view model
    viewModel{ PhoneNumberViewModel(get()) }
    viewModel { VerifyOtpViewModel(get()) }
    viewModel { HomeViewModel(get()) }
}

val adapterModule = module {
    //dashboard view model
//    single { ListAdapter() }
}