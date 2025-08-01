package com.wimobile.android.test

import android.content.BroadcastReceiver
import android.content.Context
import androidx.lifecycle.Lifecycle
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testViewModelNotNull() {
        activityRule.scenario.onActivity { activity ->
            assertNotNull("El ViewModel no debe ser nulo", activity.viewModel)
        }
    }

    @Test
    fun testTextViewUpdatesWithViewModelData() {
        activityRule.scenario.onActivity { activity ->
            activity.viewModel.setData("Nuevo valor")
            assertEquals("Nuevo valor", activity.textView.text.toString())
        }
    }

    @Test
    fun testUnregisterReceiverOnDestroy() {
        val scenario = activityRule.scenario
        lateinit var receiver: BroadcastReceiver
        lateinit var context: Context

        scenario.onActivity { activity ->
            val receiverField = MainActivity::class.java.getDeclaredField("myReceiver")
            receiverField.isAccessible = true
            receiver = receiverField.get(activity) as BroadcastReceiver
            context = activity
            assertNotNull("El receiver debería haber sido registrado en...", receiver)
        }

        runBlocking {
            withContext(Dispatchers.IO) {
                scenario.moveToState(Lifecycle.State.DESTROYED)
            }
        }

        try {
            context.unregisterReceiver(receiver)
            fail("El receiver aún estaba registrado después de... ")
        } catch (_: IllegalArgumentException) {
            assertTrue(true)
        } catch (_: IllegalStateException) {
            assertTrue(true)
        }
    }
}
