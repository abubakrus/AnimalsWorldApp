package com.example.animalsworldapp.presentation.extensions

import androidx.lifecycle.Observer
//
//class EventObserver<T>(private val onEventUnhandledContent: (T) -> Unit) : Observer<Event<T>> {
//    override fun onChanged(value: Event<T>?) {
//        value?.getContentIfNotHandled()?.let {
//            onEventUnhandledContent(it)
//        }
//    }
//}
//
//open class Event<out T>(private val content: T) {
//
//    var hasBeenHandled = false
//        private set // Запретить внешний доступ
//
//
//    fun getContentIfNotHandled(): T? {
//        return if (hasBeenHandled) {
//            null
//        } else {
//            hasBeenHandled = true
//            content
//        }
//    }
//
//    fun peekContent(): T = content
//}