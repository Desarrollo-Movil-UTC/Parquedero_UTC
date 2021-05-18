package com.utc.parquedero_utc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/*
@autores:Sandoval,Sanchez,Rovayo
@creación/ 16/05/2021
@fModificación 17/05/2021
@descripción: inicio de sesion.
*/

public class MainActivity extends AppCompatActivity {
    //proceso1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //proceso2

    public void abrirPantallaRegistro(View vista){ //metodo para abrir ventana de registro
        Intent pantallaRegistro= new Intent(getApplicationContext(),formRegister.class); //creando in intnt para invocar a registro activicty
        startActivity(pantallaRegistro); //iniciamos la pantalla de Registro
    }

}