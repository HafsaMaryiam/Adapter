package com.example.adaptertask1

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import com.example.adaptertask1.databinding.ActivityVideoBinding

class VideoActivity : AppCompatActivity() {

    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        videoView = findViewById(R.id.video_view)

        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.video)
        videoView.setVideoURI(videoUri)
        videoView.start()
//        MediaController() mediaController = new MediaController(this)
//        mediaController = MediaController(this@VideoActivity)
//        mediaController!.setAnchorView(videoView)
//        videoView.setMediaController(mediaController)
    }
}