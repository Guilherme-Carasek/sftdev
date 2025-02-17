package com.example.ex_05

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.ActivityInfo
import android.os.BatteryManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.ex_05.databinding.ActivityAppRelogioBinding

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class App_Relogio : AppCompatActivity() {



    private lateinit var binding: ActivityAppRelogioBinding
    private var isChecked = true


    val bateriaReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent != null){
                val nivel: Int = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)
                binding.textBattery.text = nivel.toString()
            }
        }
        
    }


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAppRelogioBinding.inflate(layoutInflater)
        setContentView(binding.root)


        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        }else{
            window.addFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN )
        }

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)

        registerReceiver(bateriaReceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))

        binding.checkboxBattery.setOnClickListener{
            if (isChecked) {
                isChecked=false
                binding.textBattery.visibility = View.GONE
            } else{
                isChecked = true
                binding.textBattery.visibility = View.VISIBLE
            }
        }


        binding.preferencesButton.setOnClickListener{
            binding.linearBattery.visibility = View.VISIBLE
            binding.linearBattery.animate().translationY(0F).setDuration(
                resources.getInteger(android.R.integer.config_mediumAnimTime).toLong()
            )

        }

        binding.closePreferencesButton.setOnClickListener{
            binding.linearBattery.animate().translationY(binding.linearBattery.measuredHeight.toFloat()).setDuration(
                resources.getInteger(android.R.integer.config_mediumAnimTime).toLong()
            )
        }
    }


}