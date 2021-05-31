package com.utc.parquedero_utc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/*
@autores:Sandoval,Sanchez,Rovayo
@creación: 31/05/2021
@Modificación: 31/05/2021
@descripción: inicio de sesion.
*/

public class MainActivity extends AppCompatActivity {

    //ENTRADA
    EditText textEmailLogin, textPasswordLogin;
    BaseDeDatos bdd;

    //PROCESO 1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Mapeo de elementos XML a JAVA
        textEmailLogin=(EditText)findViewById(R.id.textEmailLogin);
        textPasswordLogin=(EditText)findViewById(R.id.textPasswordLogin);
        bdd=new BaseDeDatos(getApplicationContext()); //instanciando la base de datos en el objeto bdd
    }

    //PROCESO 2
    public void abrirPantallaRegistro(View vista){ //metodo para abrir ventana de registro
        Intent pantallaRegistro= new Intent(getApplicationContext(),formRegister.class); //creando in intent para invocar a registro activity
        startActivity(pantallaRegistro); //iniciamos la pantalla de Registro
    }

    //PROCESO 3: BOTON INGRESAR
    public void iniciarSesion(View vista){
        //capturar los valores ingresados en el campo Email y Password y consultarlos en la bdd
        String email = textEmailLogin.getText().toString(); //capturando el valor de email ingresado
        String password = textPasswordLogin.getText().toString(); //capturando el valor de password ingresado

        //invocar al metodo consulta usuario en la bdd
        Cursor usuarioEncontrado = bdd.obtenerUsuarioPorEmailPassword(email,password);

        if (usuarioEncontrado!=null){ //cuando el email y contraseña ingresados sean correctos

            //obteniendo el valor del email almacenado en la bdd desde su indice
            String emailBdd = usuarioEncontrado.getString(3).toString();

            //obteniendo el valor del nombre y apellido almacenado en la bdd desde su indice
            String nombreBdd = usuarioEncontrado.getString(1).toString();
            String apellidoBdd = usuarioEncontrado.getString(2).toString();

            //mensaje de bienvenida
            Toast.makeText(getApplicationContext(),"Bienvenido "+nombreBdd+" "+apellidoBdd, Toast.LENGTH_LONG).show();

            finish(); //cierra el formulario de inicio de sesion

            //creando un intent para manejar la ventana/activity menu
            Intent pantallaMenu = new Intent(getApplicationContext(),MenuActivity.class);
            startActivity(pantallaMenu); //abriendo la ventana de menu de opciones

        }else{
            //para el caso de que el usuarioEncontrado sea nulo se muestra un mensaje de error
            Toast.makeText(getApplicationContext(),"Email o Contraseña Incorrectos", Toast.LENGTH_LONG).show();
            textPasswordLogin.setText(""); //limpiando el valor del campo contraseña
        }
    }

}