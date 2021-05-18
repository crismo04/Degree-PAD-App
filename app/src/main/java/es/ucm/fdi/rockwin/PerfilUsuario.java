package es.ucm.fdi.rockwin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PerfilUsuario extends AppCompatActivity {

    Button b_juegoBasico, b_juegoPoliticos, b_instrucciones, b_desconexion;
    private TextView email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);

        b_instrucciones= (Button) findViewById(R.id.instrucciones);
        b_juegoBasico = (Button) findViewById(R.id.button_juegoBasico);
        b_juegoPoliticos = (Button) findViewById(R.id.button_juegoPoliticos);
        b_desconexion = (Button) findViewById(R.id.button3);

        //nombre del usuario
        email = (TextView) findViewById(R.id.tv_correo);
        String e = getIntent().getStringExtra("correo");
        setup(e);

        //iniciar el juego normal
        b_juegoBasico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerfilUsuario.this, JuegoBasico.class);
                startActivity(intent);
            }
        });

        //iniciar el juego con políticos
        b_juegoPoliticos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerfilUsuario.this, JuegoPoliticos.class);
                startActivity(intent);
            }
        });

        //Instrucciones generales de la aplicación
        b_instrucciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerfilUsuario.this, Instrucciones.class);
                startActivity(intent);
            }
        });

        b_desconexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerfilUsuario.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
    private void setup(String correo){

        email.setText(correo);

    }

}