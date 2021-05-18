package es.ucm.fdi.rockwin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class JuegoPoliticos extends AppCompatActivity {

    private Integer cont_piedra = 0;
    private Integer cont_papel = 0;
    private Integer cont_tijera = 0;
    private int min = 1;
    private int max = 3;
    ImageButton b_Sanchez, b_Abascal, b_Iglesias;
    TextView display;
    TextView display2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_politicos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        b_Sanchez = (ImageButton) findViewById(R.id.sanchez);
        b_Abascal = (ImageButton) findViewById(R.id.abascal);
        b_Iglesias = (ImageButton) findViewById(R.id.iglesias);
        display = (TextView) findViewById(R.id.textView);
        display2 = (TextView) findViewById(R.id.textView2);

        b_Sanchez.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) { // sanchez = 1, abascal = 2 y igleasias = 3
                // TODO Auto-generated method stub
                cont_piedra++;
                Random r = new Random();
                int value = r.nextInt(max + min) + min;
                if(cont_piedra == value){
                    display.setText("Ganó la izquierda moderada");
                    display2.setText("La máquina eligió: Pedro Sánchez");
                }
                else if (cont_piedra - value == -1){
                    display.setText("Te ha ganado la ultraderecha   ");
                    display2.setText("La máquina eligió: Santiago Abascal");
                }
                else{
                    display.setText("Ganas pero hay que hacer pactos");
                    display2.setText("La máquina eligió: Pablo Iglesias");

                }
                cont_piedra--;

            }
        });

        b_Abascal.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {// piedra = 1, papel = 2 y tijeras = 3
                // TODO Auto-generated method stub
                cont_papel++;
                Random r = new Random();
                int value = r.nextInt(max + min) + min;
                if(cont_papel == value){
                    display.setText("Eres el macho alfa de España");
                    display2.setText("La máquina eligió: Pedro Sánchez");
                }
                else if (cont_papel - value == -1){
                    display.setText("Madrid es nuestra");
                    display2.setText("La máquina eligió: Santiago Abascal");

                }
                else{
                    display.setText("Los pactistas independes ganaron");
                    display2.setText("La máquina eligió: Pablo Iglesias");
                }
                cont_papel--;
            }
        });

        b_Iglesias.setOnClickListener(new View.OnClickListener() {// piedra = 1, papel = 2 y tijeras = 3

            public void onClick(View v) {
                // TODO Auto-generated method stub
                cont_tijera++;
                Random r = new Random();
                int value = r.nextInt(max + min) + min;
                if(cont_tijera == value){
                    display.setText("Una izquierda más moderada te ha ganado");
                    display2.setText("La máquina eligió: Pedro Sánchez");
                }
                else if (cont_tijera - value == -1){
                    display.setText("Derrocamos a la ultraderecha fascista");
                    display2.setText("La máquina eligió: Santiago Abascal");
                }
                else{
                    display.setText("Cortate la coleta que no hemos ganado");
                    display2.setText("La máquina eligió: Pablo Iglesias");
                }
                cont_tijera--;
            }
        });
    }

}