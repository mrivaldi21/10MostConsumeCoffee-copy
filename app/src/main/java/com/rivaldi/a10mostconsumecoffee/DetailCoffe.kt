package com.rivaldi.a10mostconsumecoffee

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.rivaldi.a10mostconsumecoffee.databinding.ActivityDetailCoffeBinding

class DetailCoffe : AppCompatActivity() {
    private lateinit var binding: ActivityDetailCoffeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //ViewBinding
        binding = ActivityDetailCoffeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataCoffe = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Coffe>("key_coffe", Coffe::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Coffe>("key_coffe")
        }

        //ViewBinding to interface
        if (dataCoffe != null) {
            Glide.with(this)
                .load(dataCoffe.photo)
                .transform(CenterInside(), RoundedCorners(24))
                .into(binding.imgDetail)
            binding.tvNameDetail.text = dataCoffe.name
            binding.tvDescriptionDetail.text = dataCoffe.description
//            binding.tvDescriptionDetail.text = task.execute("bard").toString()

        } else {
            Log.i("info:", "Data cannot be retrived")
        }
    }


}