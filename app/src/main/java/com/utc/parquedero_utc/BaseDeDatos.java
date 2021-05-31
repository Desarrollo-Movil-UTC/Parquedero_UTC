package com.utc.parquedero_utc;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/*
@autores:Sandoval,Sanchez,Rovayo
@creación: 31/05/2021
@Modificación: 31/05/2021
@descripción: Metodo para iniciar sesión
*/

public class BaseDeDatos extends SQLiteOpenHelper {

    private static final String nombreBdd="bdd_parqueadero_utc"; // definir el nombre de la base de datos
    private static final int versionBdd=1; // definir la version de la base de datos
    private static final String tablaUsuario="create table usuario(id_usu integer primary key autoincrement, nombre_usu text," +
            "apellido_usu text, email_usu text,telefono_usu text, direccion_usu txt,password_usu text,fecha_regis_usu text)";//definir la estructura de la tabla de usuarios
    //constructor
    public BaseDeDatos (Context contexto){
        super(contexto, nombreBdd, null, versionBdd);
    }

    //proceso1
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tablaUsuario);// ejecutando el query ddl para crear la tabla usuario con sus atributos
    }
    //proceso2
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuario");// elimina de la version anterior de la tabla usuario
        db.execSQL(tablaUsuario); // ejecucion del codigo para crear la tabla usuario con nueva estructura
    }

    // proceso 3: insertar datos
    public boolean agregarUsuario(String nombre, String apellido, String email, String telefono, String direccion ,String password, String fecha_regis_usu){
        SQLiteDatabase miBdd = getWritableDatabase(); // llamando a la base de datos en el objeto miBdd

        if(miBdd!=null){// validando que existan datos en la base de datos
            miBdd.execSQL("insert into usuario(nombre_usu,apellido_usu, email_usu,telefono_usu, " +
                                                "direccion_usu, password_usu,fecha_regis_usu) " +
                    "values('"+nombre+"','"+apellido+"','"+email+"','"+telefono+"','"+direccion+"','"+password+"','"+fecha_regis_usu+"')");//ejecutando la sentencia de insercion sql
            miBdd.close(); //cerrando la conexion a la base de datos
            return true; //retorno cuando la insercion es exitosa
        }
        return false;// retorno cuando no exista la base de datos
    }

    //Proceso 4: consultar por email y password al iniciar sesion
    public Cursor obtenerUsuarioPorEmailPassword(String email, String password){

        SQLiteDatabase miBdd = getWritableDatabase(); //llamando a la bdd

        Cursor usuario = miBdd.rawQuery("select * from usuario where " +
                "email_usu='"+email+"' and password_usu='"+password+"';",null);

        if(usuario.moveToFirst()){ //verifica que el objeto usuario tenga resultados
            return usuario; //retorna los datos encontrados

        }else{ //no se encuentra el usuario
            return null;
        }
    }
}
