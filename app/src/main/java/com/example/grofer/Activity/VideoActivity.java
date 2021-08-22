package com.example.grofer.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import com.example.grofer.R;


public class VideoActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        VideoView videoView = findViewById(R.id.video_view);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.grofervideo;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        videoView.setOnCompletionListener(mp -> {
            Intent intent = new Intent(VideoActivity.this, HomeActivity.class);
            startActivity(intent);
            String[] permission = {Manifest.permission.ACCESS_FINE_LOCATION,};
            ActivityCompat.requestPermissions(VideoActivity.this, permission,REQUEST_CODE );
            finish();
        });
        videoView.start();
    }
}