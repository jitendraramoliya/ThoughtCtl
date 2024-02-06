package com.thoughtctlapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.ImgurData
import com.thoughtctlapp.repository.ImgRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val imgRepository: ImgRepository) : ViewModel() {

    public val imgurList: StateFlow<List<ImgurData>>
        get() = imgRepository.imgList

    init {
        viewModelScope.launch {
            imgRepository.getImgList()
        }
    }

}