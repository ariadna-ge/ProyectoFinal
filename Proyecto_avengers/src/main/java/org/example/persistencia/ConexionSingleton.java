package org.example.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSingleton {
    private String baseDatos;
    public static ConexionSingleton _instance;
    private Connection connection;

    //constructor que evita el acceso de terceros
    private ConexionSingleton(String database) {
        this.baseDatos = database;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:"+this.baseDatos);
        } catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ConexionSingleton getInstance(String baseDatos) {
        if(_instance == null){
            _instance = new ConexionSingleton(baseDatos);
        }else{
            System.out.println("Ya fue creada.");
        }
        return _instance;
    }
    //metodo de acceso a la conexion de datos
    public Connection getConnection() {
        return connection;
    }
}
/*El patron singleton evita que se creen conexiones de más*/