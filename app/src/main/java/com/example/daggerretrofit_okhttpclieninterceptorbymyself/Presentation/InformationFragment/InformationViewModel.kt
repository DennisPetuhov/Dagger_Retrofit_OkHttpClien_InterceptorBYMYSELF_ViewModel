package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.InformationFragment


import androidx.lifecycle.viewModelScope
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Api.ApiState
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Api.Status
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.InformationRequestUseCase.InformationRequestUseCase
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain.UseCase.SharedPreferences.DeleteDataFromPreferences.DeleteDataFromSharedPreferencesUseCase
import com.example.daggerretrofit_okhttpclieninterceptorbymyself.Presentation.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

class InformationViewModel @Inject constructor(
    val deleteDataFromSharedPreferencesfUseCase: DeleteDataFromSharedPreferencesUseCase,
    val informationRequestUseCase:InformationRequestUseCase

    ) : BaseViewModel() {

    val textFlow: StateFlow<String> get() = _textFlow
   private val _textFlow: MutableStateFlow<String> = MutableStateFlow("")



    val flowInformationRequest: StateFlow<ApiState<String>> get() = mutableFlowInformationRequest
    private var mutableFlowInformationRequest: MutableStateFlow<ApiState<String>> =
        MutableStateFlow(ApiState("", Status.LOADING, null))

    fun textToTextView(txt:String){
        _textFlow.value = txt

    }



    fun informationRequest() {
        mutableFlowInformationRequest.value = ApiState.loading()
        viewModelScope.launch(Dispatchers.IO) {
            informationRequestUseCase.getInformationRequestUseCase().catch {
                mutableFlowInformationRequest.value = ApiState.error(it.message)
            }.collect {
                mutableFlowInformationRequest.value = ApiState.success(it.data)
            }


        }


    }


    fun deleteDataFromSharedPreferences(key: String) {
        deleteDataFromSharedPreferencesfUseCase.deleteSharedPreferences(key)
    }

}