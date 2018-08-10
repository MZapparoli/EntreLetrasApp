package br.com.entreletras.Main;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import br.com.entreletras.R;

import static br.com.entreletras.R.styleable.View;



public class Galeria extends AppCompatActivity {

    ImageButton bt1;
    ImageButton bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);
        bt1 = (ImageButton) findViewById(R.id.video1);
        bt2 = (ImageButton) findViewById(R.id.video2);
      //  bt3 = (ImageButton) findViewById(R.id.video3);
      //  bt4 = (ImageButton) findViewById(R.id.video4);



        setTitle("Galeria");

        bt1.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View v) {

                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=ERi-XrWtaWA")));
                Log.i("Video", "Video Playing....");

            }
        });

        bt1.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View v) {

                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=75BmygB_mic")));
                Log.i("Video", "Video Playing....");

            }
        });

    }



}
