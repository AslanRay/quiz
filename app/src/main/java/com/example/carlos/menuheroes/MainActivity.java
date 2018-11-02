package com.example.carlos.menuheroes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button botonJuego;
    private Button botonPuntajes;
    private Button botonAcerca;
    private Button botonSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonJuego=(Button) findViewById(R.id.btnJuego);
        botonPuntajes=(Button) findViewById(R.id.btnPuntajes);
        botonAcerca=(Button) findViewById(R.id.btnAcerca);
        botonSalir=(Button) findViewById(R.id.btnSalir);


        botonJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,juegoActivity.class);
                startActivity(intent);
            }
        });

        botonPuntajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,puntajesActivity.class);
                startActivity(intent);
            }
        });

        botonAcerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,acercaActivity.class);
                startActivity(intent);
            }
        });

        botonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
