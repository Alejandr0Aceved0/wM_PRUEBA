package com.wimobile.android.implementation

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityIntegrationTest {

    @Test
    fun test_counter_viewmodel_inicializado() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.onActivity { activity ->
            val viewModel = activity.viewModel
            assertNotNull("CounterViewModel no fue inicializado en MainActivity", viewModel)
        }
    }
}
