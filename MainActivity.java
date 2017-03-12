package com.example.bruno.applibrubru;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // relier les objets créés à des commandes pour pouvoir les utiliser
        Button btn1 = (Button)findViewById(R.id.button1);

        // utiliser un bouton pour aller vers une autre activité
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,FichierJson.class);
                startActivity(i);

            }



        });











    }
}


