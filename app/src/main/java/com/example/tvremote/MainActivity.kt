package com.example.tvremote

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Set up button listeners to send ADB shell commands
        findViewById<Button>(R.id.btnUp).setOnClickListener { sendAdbCommand("input keyevent KEYCODE_DPAD_UP") }
        findViewById<Button>(R.id.btnDown).setOnClickListener { sendAdbCommand("input keyevent KEYCODE_DPAD_DOWN") }
        findViewById<Button>(R.id.btnLeft).setOnClickListener { sendAdbCommand("input keyevent KEYCODE_DPAD_LEFT") }
        findViewById<Button>(R.id.btnRight).setOnClickListener { sendAdbCommand("input keyevent KEYCODE_DPAD_RIGHT") }
        findViewById<Button>(R.id.btnOk).setOnClickListener { sendAdbCommand("input keyevent KEYCODE_DPAD_CENTER") }
        findViewById<Button>(R.id.btnHome).setOnClickListener { sendAdbCommand("input keyevent KEYCODE_HOME") }
        findViewById<Button>(R.id.btnBack).setOnClickListener { sendAdbCommand("input keyevent KEYCODE_BACK") }
        findViewById<Button>(R.id.btnVolumeUp).setOnClickListener { sendAdbCommand("input keyevent KEYCODE_VOLUME_UP") }
        findViewById<Button>(R.id.btnVolumeDown).setOnClickListener { sendAdbCommand("input keyevent KEYCODE_VOLUME_DOWN") }
        findViewById<Button>(R.id.btnPower).setOnClickListener { sendAdbCommand("input keyevent KEYCODE_POWER") }
    }
    
    // Execute the command on the device shell.
    private fun sendAdbCommand(command: String) {
        try {
            val process = Runtime.getRuntime().exec(arrayOf("sh", "-c", command))
            val reader = BufferedReader(InputStreamReader(process.inputStream))
            while (reader.readLine() != null) {
                // Optionally, process or log output.
            }
            process.waitFor()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
