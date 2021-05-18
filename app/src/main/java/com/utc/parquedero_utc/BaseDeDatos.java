package com.utc.parquedero_utc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/*
@autores:Sandoval,Sanchez,Rovayo
@creación/ 18/05/2021
@Modificación 18/05/2021
@descripción: Base de datos.
*/

public class BaseDeDatos extends SQLiteOpenHelper {
    private static final String nombreBdd="bdd_parqueadero_utc"; // definir el nombre de la base de datos
    private static final int versionBdd=1; // definir la version de la base de datos
    private static final String tablaUsuario="create table usuario(id_usu integer primary key autoincrement, nombre_usu text," +
            "apellido_usu text, email_usu text,telefono_usu text, direccion_usu txt,password_usu text)";//definir la estructura de la tabla de usuarios
    //contructor
    public BaseDeDatos (Context contexto){
        super(contexto, nombreBdd, null, versionBdd);
    }
    @Override
    //proceso1
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tablaUsuario);// ejecutando el query ddl para crear la tabla usuario con sus atributos
    }
    //proceso2
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuario");// elimina de la version anterior de la tabla usuario
        db.execSQL(tablaUsuario); // ejecucion del codigo para crear la tabla usuario con nueva estructura
    }
    // proceso 3
    public boolean agregarUsuario(String nombre, String apellido, String email, String telefono, String direccion ,String password){
        SQLiteDatabase miBdd = getWritableDatabase(); // llamando a la base de datos en el objeto miBdd
        if(miBdd!=null){// validando que existan datos en la vase de datos
            miBdd.execSQL("insert into usuario(nombre_usu,apellido_usu, email_usu,telefono_usu, direccion_usu, password_usu) " +
                    "values('"+nombre+"','"+apellido+"','"+email+"','"+telefono+"','"+direccion+"','"+password+"')");//ejecutando la sentencia de insercion sql
            miBdd.close(); //cerrando la conexion a la base de datos
            return true; //retorno cuando la insercion es exitosa
        }
        return false;// retorno cuando no exista la base de datos
    }
}
