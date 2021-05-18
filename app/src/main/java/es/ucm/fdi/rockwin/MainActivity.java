package es.ucm.fdi.rockwin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private EditText etCorreo;
    private EditText etContraseña;
    private Button btnRegistrar;
    private Button btnAcceder;

    private String nombre = "";
    private String correo = "";
    private String contraseña = "";
    private FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    FirebaseAnalytics analytics ;
    private String titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etCorreo = (EditText) findViewById(R.id.et_correo);
        etContraseña = (EditText) findViewById(R.id.et_contraseña);
        btnRegistrar = (Button) findViewById(R.id.btn_registrar);
        btnAcceder = (Button) findViewById(R.id.btn_acceder);
    analytics = FirebaseAnalytics.getInstance(this);

    registrarUsuario();

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();


        }

    private void registrarUsuario(){
  titulo = "Autenticacion";
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                correo = etCorreo.getText().toString();
                contraseña = etContraseña.getText().toString();


                if(!correo.isEmpty()&& !contraseña.isEmpty()){
                    mAuth.createUserWithEmailAndPassword(correo,contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull  Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                mostrarPerfil(correo);
                            }else
                                Toast.makeText(MainActivity.this, "Email Incorrecto", Toast.LENGTH_SHORT).show();

                        }
                    });
                }else
                    Toast.makeText(MainActivity.this, "Debe rellenar los campos", Toast.LENGTH_SHORT).show();

            }
        });

        btnAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                correo = etCorreo.getText().toString();
                contraseña = etContraseña.getText().toString();


                if(!correo.isEmpty()&& !contraseña.isEmpty()){
                    mAuth.signInWithEmailAndPassword(correo,contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull  Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                mostrarPerfil(correo);
                            }else
                                Toast.makeText(MainActivity.this, "Email Incorrecto", Toast.LENGTH_SHORT).show();

                        }
                    });
                }else
                    Toast.makeText(MainActivity.this, "Debe rellenar los campos", Toast.LENGTH_SHORT).show();

            }
        });


    }


    public void mostrarPerfil(String correo){

        Intent perfilIntent = new Intent (this,PerfilUsuario.class);
       perfilIntent.putExtra("correo",correo);
        startActivity(perfilIntent);

    }

}