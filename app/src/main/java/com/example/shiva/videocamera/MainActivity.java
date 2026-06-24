package com.example.shiva.videocamera;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    Button b1;
    VideoView v1;
    Uri u1;
    //uniform resource identifier uri fullform
    MediaController m1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        v1=(VideoView)findViewById(R.id.videoView);
        m1=new MediaController(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(i,99);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==99)
        {
            u1=data.getData();
            v1.setVideoURI(u1);
            v1.setMediaController(m1);
            m1.setAnchorView(v1);
            v1.start();

        }
        else
        {
            Toast.makeText(MainActivity.this, "there is some hardware problem", Toast.LENGTH_SHORT).show();
        }
    }
}
