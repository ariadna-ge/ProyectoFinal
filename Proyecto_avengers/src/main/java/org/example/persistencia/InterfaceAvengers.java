package org.example.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;

public interface InterfaceAvengers {
    //declaracion de metodos de las clases que van a tener acceso a la base de datos
    //metodos con un objeto de transferencia con informacion que se va a insertar, mostrara un true o false
    public abstract boolean update(Object obj) throws SQLException;
    public abstract boolean insert(Object obj) throws SQLException;
    public abstract boolean delete(String id) throws SQLException;
    public abstract Object searchId(String id) throws SQLException;
    public abstract ArrayList show() throws SQLException;
}