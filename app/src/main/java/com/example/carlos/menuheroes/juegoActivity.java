package com.example.carlos.menuheroes;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class juegoActivity extends AppCompatActivity {

    TextView tiempo,contadorTextView;

    Button b_answer1,b_answer2,b_answer3,b_answer4;

    ImageView iv_imagen;

    List<personajesElementos> list;

    Random r;

    int turn=1;

    Intent intent;

    boolean juegoTerminado=false;

    int contador=0;

    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        tiempo=(TextView) findViewById(R.id.tiempoTxt);
        contadorTextView=(TextView) findViewById(R.id.tv_contador);

        r=new Random();

        iv_imagen=(ImageView) findViewById(R.id.imageView);

        b_answer1=(Button) findViewById(R.id.button);
        b_answer2=(Button) findViewById(R.id.button2);
        b_answer3=(Button) findViewById(R.id.button3);
        b_answer4=(Button) findViewById(R.id.button4);

        list=new ArrayList<>();

        //Agrega todas las imagenes y nombres a la lista
        for(int i=0;i<new Database().answers.length;i++){
            list.add(new personajesElementos(new Database().answers[i],new Database().personajes[i]));
        }

        //Random de imagenes y respuesta
        Collections.shuffle(list);
        newQuestion(turn);




            String text=tiempo.getText().toString();

            //El contador va a empezar en cuanto inicie la actividad de jugar, los 30 segundos estan establecidos como 30 * 1000
            countDownTimer=new CountDownTimer(30*1000,1000) {
                @Override
                public void onTick(long millis) {
                    tiempo.setText("0:"+(int)(millis/1000));



                    b_answer1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //Revisa si la respuesta es correcta
                            if(b_answer1.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){

                                if(turn<list.size()){
                                    turn++;
                                    contador++;
                                    contadorTextView.setText("Aciertos: "+contador);
                                    newQuestion(turn);
                                }
                                else{
                                    juegoTerminado=true;
                                    onFinish();
                                }
                            }
                            else{
                                juegoTerminado=true;
                                Toast.makeText(juegoActivity.this,"Respuesta incorrecta",Toast.LENGTH_SHORT).show();
                                onFinish();
                            }
                        }
                    });

                    b_answer2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //Revisa si la respuesta es correcta
                            if(b_answer2.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){

                                if(turn<list.size()){
                                    turn++;
                                    contador++;
                                    contadorTextView.setText("Aciertos: "+contador);
                                    newQuestion(turn);
                                }
                                else{
                                    juegoTerminado=true;
                                    onFinish();
                                }
                            }
                            else{
                                juegoTerminado=true;
                                Toast.makeText(juegoActivity.this,"Respuesta incorrecta",Toast.LENGTH_SHORT).show();
                                onFinish();
                            }
                        }
                    });

                    b_answer3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //Revisa si la respuesta es correcta
                            if(b_answer3.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){

                                if(turn<list.size()){
                                    turn++;
                                    contador++;
                                    contadorTextView.setText("Aciertos: "+contador);
                                    newQuestion(turn);
                                }
                                else{
                                    juegoTerminado=true;
                                    onFinish();
                                }
                            }
                            else{
                                juegoTerminado=true;
                                Toast.makeText(juegoActivity.this,"Respuesta incorrecta",Toast.LENGTH_SHORT).show();
                                onFinish();
                            }
                        }
                    });

                    b_answer4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //Revisa si la respuesta es correcta
                            if(b_answer4.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){

                                if(turn<list.size()){
                                    turn++;
                                    contador++;
                                    contadorTextView.setText("Aciertos: "+contador);
                                    newQuestion(turn);
                                }
                                else{
                                    onFinish();
                                }
                            }
                            else{
                                juegoTerminado=true;
                                Toast.makeText(juegoActivity.this,"Respuesta incorrecta",Toast.LENGTH_SHORT).show();
                                onFinish();
                            }
                        }
                    });

                }

                @Override
                public void onFinish() {
                    tiempo.setText("0:0");
                    intent=new Intent(juegoActivity.this,resultadoActivity.class);
                    intent.putExtra("SCORE", contador);

                    //Agregamos el resultado del juego a la lista de puntajes
                    ListaScores.puntajes.add(contador);
                    startActivity(intent);
                }
            }.start();



    }

    private void newQuestion(int number){
        //Establece la imagen a la pantalla
        iv_imagen.setImageResource(list.get(number-1).getImage());

        //Decide en cual boton poner la respuesta correcta
        int correct_answer=r.nextInt(4)+1;

        int firstButton=number-1;
        int secondButton;
        int thirdButton;
        int fourthButton;

        switch (correct_answer){
            case 1:
                b_answer1.setText(list.get(firstButton).getName());

                do{
                    secondButton=r.nextInt(list.size());
                }while (secondButton==firstButton);

                do{
                    thirdButton=r.nextInt(list.size());
                }while (thirdButton==firstButton || thirdButton==secondButton);

                do{
                    fourthButton=r.nextInt(list.size());
                }while (fourthButton==firstButton || fourthButton==secondButton || fourthButton==thirdButton);

                b_answer2.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(fourthButton).getName());

                break;

            case 2:
                b_answer2.setText(list.get(firstButton).getName());

                do{
                    secondButton=r.nextInt(list.size());
                }while (secondButton==firstButton);

                do{
                    thirdButton=r.nextInt(list.size());
                }while (thirdButton==firstButton || thirdButton==secondButton);

                do{
                    fourthButton=r.nextInt(list.size());
                }while (fourthButton==firstButton || fourthButton==secondButton || fourthButton==thirdButton);

                b_answer1.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(fourthButton).getName());

                break;

            case 3:
                b_answer3.setText(list.get(firstButton).getName());

                do{
                    secondButton=r.nextInt(list.size());
                }while (secondButton==firstButton);

                do{
                    thirdButton=r.nextInt(list.size());
                }while (thirdButton==firstButton || thirdButton==secondButton);

                do{
                    fourthButton=r.nextInt(list.size());
                }while (fourthButton==firstButton || fourthButton==secondButton || fourthButton==thirdButton);

                b_answer2.setText(list.get(secondButton).getName());
                b_answer1.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(fourthButton).getName());

                break;

            case 4:
                b_answer4.setText(list.get(firstButton).getName());

                do{
                    secondButton=r.nextInt(list.size());
                }while (secondButton==firstButton);

                do{
                    thirdButton=r.nextInt(list.size());
                }while (thirdButton==firstButton || thirdButton==secondButton);

                do{
                    fourthButton=r.nextInt(list.size());
                }while (fourthButton==firstButton || fourthButton==secondButton || fourthButton==thirdButton);

                b_answer2.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer1.setText(list.get(fourthButton).getName());

                break;
        }
    }


    protected void onResume() {
        super.onResume();
        countDownTimer.start();
    }

    protected void onPause() {
        super.onPause();
        countDownTimer.cancel();
    }

}
