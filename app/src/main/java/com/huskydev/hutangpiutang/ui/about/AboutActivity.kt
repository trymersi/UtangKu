package com.huskydev.hutangpiutang.ui.about

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.huskydev.hutangpiutang.BuildConfig
import com.huskydev.hutangpiutang.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupContent()
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener { finish() }
    }

    private fun setupContent() {
        binding.tvVersion.text = "Versi ${BuildConfig.VERSION_NAME}"

        binding.btnPrivacy.setOnClickListener {
            // Replace with actual privacy policy URL if needed
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://policies.google.com/privacy"))
            startActivity(intent)
        }
    }
}
