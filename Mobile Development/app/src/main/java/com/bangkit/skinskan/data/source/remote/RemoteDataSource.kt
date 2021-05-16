package com.bangkit.skinskan.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bangkit.skinskan.data.source.remote.network.ApiService
import com.bangkit.skinskan.data.source.remote.response.ResultResponse
import com.bangkit.skinskan.vo.ApiResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class RemoteDataSource private constructor(private val apiService: ApiService){

}