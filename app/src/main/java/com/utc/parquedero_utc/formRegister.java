package com.utc.parquedero_utc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/*
@autores:Sandoval,Sanchez,Rovayo
@creación/ 16/05/2021
@fModificación 18/05/2021
@descripción: registrar usuario.
*/

public class formRegister extends AppCompatActivity {

    //ENTRADA
    EditText txtNombreRegistro,
            txtApellidoRegistro,
            txtEmailRegistro,
            txtTelefonoRegistro,
            txtDireccionRegistro,
            txtPasswordRegistro,
            txtPasswordConfirmada; //definiendo objetos para capturar datos desde la vista
            BaseDeDatos miBdd;
    //PROCESO 1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_register);

        //Mapeo de elementos XML a objetos JAVA
        txtNombreRegistro=(EditText)findViewById(R.id.txtNombreRegistro);
        txtApellidoRegistro=(EditText)findViewById(R.id.txtApellidoRegistro);
        txtEmailRegistro=(EditText)findViewById(R.id.txtEmailRegistro);
        txtTelefonoRegistro=(EditText)findViewById(R.id.txtTelefonoRegistro);
        txtDireccionRegistro=(EditText)findViewById(R.id.txtDireccionRegistro);
        txtPasswordRegistro=(EditText)findViewById(R.id.txtPasswordRegistro);
        txtPasswordConfirmada=(EditText)findViewById(R.id.txtPasswordConfirmada);
        miBdd=new BaseDeDatos(getApplicationContext());// instaciar construir la base de datos en el objeto miBdd
    }

    //PROCESO 2
    public void registrarUsuario(View vista){
        //Capturando los valores ingresados por el usuario en variables Java de tipo String.
        String nombre=txtNombreRegistro.getText().toString();
        String apellido=txtApellidoRegistro.getText().toString();
        String email=txtEmailRegistro.getText().toString();
        String telefono=txtTelefonoRegistro.getText().toString();
        String direccion=txtDireccionRegistro.getText().toString();
        String password=txtPasswordRegistro.getText().toString();
        String passwordConfirmada=txtPasswordConfirmada.getText().toString();


        if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() ||telefono.isEmpty()
                                || direccion.isEmpty() || password.isEmpty()){
            Toast.makeText(getApplicationContext(), "Para continuar con el registro llene todos los campos solicitados",
                    Toast.LENGTH_LONG).show(); //mostrando mensaje de campo vacio
        } else {
            if (password.length() < 6){
                Toast.makeText(getApplicationContext(), "Ingrese una contraseña mínimo de 6 dígitos",
                        Toast.LENGTH_LONG).show(); //mostrando mensaje de contraseña invalida
            }
            else {
                //finish(); //si los campos estan completos y password es valido guarda registro

                if (password.equals(passwordConfirmada)) {
                    miBdd.agregarUsuario(nombre,apellido,email,telefono, direccion,password);
                    Toast.makeText(getApplicationContext(), "Usuario registrado correctamente",
                            Toast.LENGTH_LONG).show(); //mostrando mensaje de usuario registrado
                    finish();
                } else{
                    Toast.makeText(getApplicationContext(), "Las contraseñas ingresadas no coinciden",
                            Toast.LENGTH_LONG).show(); //mostrando un mensaje de error/alerta
                }

            }
        }
    }
}
