package com.android.core.arch.ui.base

import com.android.core.arch.data.manager.DataManager
import com.android.core.arch.rx.SchedulerProvider

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable


/**
 * Base View Model for all View model which attached to activity
 * @author  Rohit Anvekar
 * @since   2019-02-14
 */
open class BaseViewModel<N>(val dataManager: DataManager,
                            val schedulerProvider: SchedulerProvider) : ViewModel() {
    open var navigator: N? = null
    val compositeDisposable: CompositeDisposable

    init {
        this.compositeDisposable = CompositeDisposable()
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

}


