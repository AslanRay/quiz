package com.example.carlos.menuheroes;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

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
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1,listaScores) {
            @NonNull
            @Override
            //Sobreescribimos getView para poder mostrar el texto en el centro de la pantalla
            //y con un tamano de letra grande
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView tv = (TextView) super.getView(position, convertView, parent);
                tv.setGravity(Gravity.CENTER);
                tv.setTextSize(50);
                return tv;
            }
        };
        ListView lv = findViewById(R.id.lvPuntajes);
        lv.setAdapter(adapter);


    }
}
