package com.utc.parquedero_utc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/*
@autores:Sandoval,Sanchez,Rovayo
@creación: 31/05/2021
@Modificación: 31/05/2021
@descripción: ventana menu de opciones
*/

public class MenuActivity extends AppCompatActivity {

    //PROCESO 2
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    //PROCESO 2
    public void cerrarOpciones(View vista){ //metodo para cerrar la ventana de menu de opciones
        Intent pantallaLogin= new Intent(getApplicationContext(),MainActivity.class);
        startActivity(pantallaLogin); //iniciamos la pantalla de Login
    }
}