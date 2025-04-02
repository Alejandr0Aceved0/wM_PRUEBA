package com.wimobile.android.implementation

import android.os.Looper
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Test
import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows

@RunWith(RobolectricTestRunner::class)
class ViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun testCounterIncrement() {
        Shadows.shadowOf(Looper.getMainLooper()).idle()

        val viewModel = CounterViewModel()
        viewModel.increment()

        assertEquals(1, viewModel.counter.value)
    }
}
