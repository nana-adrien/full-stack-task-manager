package org.example.project.domain.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<State,Event>(defaultState:State): ViewModel(){
    val stateData= MutableStateFlow(defaultState)
    val state=stateData.asStateFlow()
    abstract fun onEventHandler(event:Event)
}