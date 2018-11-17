package com.example.carlos.menuheroes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Collections;
import java.util.List;

public class puntajesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntajes);
        MostrarScores();
    }

    protected void MostrarScores() {
        //Mandamos a llamar la lista de puntajes
        List<Integer> listaScores = ListaScores.puntajes;

        //Los ordenamos de mayor a menor
        Collections.sort(listaScores);
        Collections.reverse(listaScores);

        //Creamos un adaptador para mostrar la lista en el listview
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1,listaScores);
        ListView lv = findViewById(R.id.lvPuntajes);
        lv.setAdapter(adapter);


    }
}
