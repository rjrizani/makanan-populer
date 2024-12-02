package com.dicoding.myrecyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class detail : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_MORE_INFO = "extra_more_info"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        val name = intent.getStringExtra(EXTRA_NAME)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION) // Jika ada deskripsi

        val photo = intent.getStringExtra(EXTRA_PHOTO)
        val moreInfo = intent.getStringExtra(EXTRA_MORE_INFO)
        val tvMoreInfo: TextView = findViewById(R.id.tv_more_info)
        tvMoreInfo.text = moreInfo


        val tvItemName: TextView = findViewById(R.id.tv_item_name)
        val tvItemDescription: TextView = findViewById(R.id.tv_item_description)
        val imgItemPhoto: ImageView = findViewById(R.id.img_photo)



        tvItemDescription.text = description
        Glide.with(this)
            .load(photo)
            .transform(CenterCrop(), RoundedCorners(40))
            .into(imgItemPhoto)


        tvItemName.text = name

        //about button
        val btnAbout: Button = findViewById(R.id.tv_btnprofil)
        btnAbout.setOnClickListener {
            val intent = Intent(this, about::class.java)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.detailxml)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}