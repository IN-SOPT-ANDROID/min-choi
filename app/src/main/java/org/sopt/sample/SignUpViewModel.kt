package org.sopt.sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {
    val id = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val idValidation: LiveData<Boolean> = Transformations.map(id) {
        it.length in 6..10
    }
    val passwordValidation: LiveData<Boolean> = Transformations.map(password) {
        it.length in 6..12
    }
}