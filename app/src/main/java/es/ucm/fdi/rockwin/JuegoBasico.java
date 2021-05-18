package es.ucm.fdi.rockwin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class JuegoBasico extends AppCompatActivity {
    private Integer cont_piedra = 0;
    private Integer cont_papel = 0;
    private Integer cont_tijera = 0;
    private int min = 1;
    private int max = 3;
    ImageButton b_piedra, b_papel, b_tijera;
    TextView display;
    TextView display2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_basico);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        b_piedra = (ImageButton) findViewById(R.id.piedra);
        b_papel = (ImageButton) findViewById(R.id.papel);
        b_tijera = (ImageButton) findViewById(R.id.tijera);
        display = (TextView) findViewById(R.id.textView);
        display2 = (TextView) findViewById(R.id.textView2);

        b_piedra.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) { // piedra = 1, papel = 2 y tijeras = 3
                // TODO Auto-generated method stub
                cont_piedra++;
                Random r = new Random();
                int value = r.nextInt(max + min) + min;
                if(cont_piedra == value){
                    display.setText("Empate");
                    display2.setText("La máquina eligió: PIEDRA");
                }
                else if (cont_piedra - value == -1){
                    display.setText("Pierdes");
                    display2.setText("La máquina eligió: PAPEL");
                }
                else{
                    display.setText("Ganas");
                    display2.setText("La máquina eligió: TIJERAS");

                }
                cont_piedra--;

            }
        });

        b_papel.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {// piedra = 1, papel = 2 y tijeras = 3
                // TODO Auto-generated method stub
                cont_papel++;
                Random r = new Random();
                int value = r.nextInt(max + min) + min;
                if(cont_papel == value){
                    display.setText("Ganas");
                    display2.setText("La máquina eligió: PIEDRA");
                }
                else if (cont_papel - value == -1){
                    display.setText("Empate");
                    display2.setText("La máquina eligió: PAPEL");

                }
                else{
                    display.setText("Pierdes");
                    display2.setText("La máquina eligió: TIJERAS");
                }
                cont_papel--;
            }
        });

        b_tijera.setOnClickListener(new View.OnClickListener() {// piedra = 1, papel = 2 y tijeras = 3

            public void onClick(View v) {
                // TODO Auto-generated method stub
                cont_tijera++;
                Random r = new Random();
                int value = r.nextInt(max + min) + min;
                if(cont_tijera == value){
                    display.setText("Pierdes");
                    display2.setText("La máquina eligió: PIEDRA");
                }
                else if (cont_tijera - value == -1){
                    display.setText("Ganas");
                    display2.setText("La máquina eligió: PAPEL");
                }
                else{
                    display.setText("Empate");
                    display2.setText("La máquina eligió: TIJERAS");
                }
                cont_tijera--;
            }
        });
    }

}