package com.example.androidfanavari40205

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidfanavari40205.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton
import java.net.URL

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //1
        setContentView(R.layout.activity_main)
        val buttonTodo : MaterialButton = findViewById(R.id.buttonTodoList)
    //روش غیراستاندارد برای صدا کردن 1
        buttonTodo.setOnClickListener {
            createAlarm("test",12,15)
        }


        //2
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //2 روش استاندارد

        //زمان کلیک کردن به کارهای زیر را انجام دهد
        binding.buttonEditProfile.setOnClickListener {
            val intent = Intent(this,DashboardActivity::class.java)
            startActivity(intent)
        }

        //explicit intent =  یعنی عملیات و انتقال های درون برنامه ای
        //implicit intent =  یعنی عملیات و انتقال به صفحه های خارج از برنامه مثل ایمیل


        binding.imageViewProfile.setOnClickListener {
            openWebPage("https://www.fanavari.co")
        }



        /*enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
    }


    private fun createAlarm(message: String,hour: Int,minute: Int){
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply{
            putExtra(AlarmClock.EXTRA_MESSAGE,message)
            putExtra(AlarmClock.EXTRA_HOUR,hour)
            putExtra(AlarmClock.EXTRA_MINUTES,minute)
        }
        //if (intent.resolveActivity(packageManager) != null){
        startActivity(intent)
        //}
    }
    private fun openWebPage(url: String){
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }
}