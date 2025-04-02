package com.wimobile.android.test

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
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
    fun text_view_no_contiene_texto_correcto() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.onActivity { activity ->
            assertNotNull("La Activity no debería ser null", activity)

            assertEquals(
                "Texto esperado no coincide",
                "Hola, Android!",
                activity.findViewById<TextView>(R.id.textView).text
            )
        }
        scenario.close()
    }

    @Test
    fun testUnregisterReceiverOnDestroy() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        scenario.onActivity { activity ->
            val context = ApplicationProvider.getApplicationContext<Context>()
            val receiverField = MainActivity::class.java.getDeclaredField("myReceiver")
            receiverField.isAccessible = true
            val receiver = receiverField.get(activity) as BroadcastReceiver

            context.sendBroadcast(Intent(Intent.ACTION_BATTERY_CHANGED))
            activity.finish() // Simula el cierre de la actividad

            try {
                context.unregisterReceiver(receiver) // Debería lanzar una excepción si ya está desregistrado
                fail("El receiver aún estaba registrado después de onDestroy()")
            } catch (_: IllegalArgumentException) {
                // Correcto: el receiver ya fue desregistrado
            }
        }
    }
}
