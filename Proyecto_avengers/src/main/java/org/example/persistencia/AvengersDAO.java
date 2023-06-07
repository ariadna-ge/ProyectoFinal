package org.example.persistencia;

import org.example.modelo.Avengers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//Uso del patron de diseño DAO, para encapsular la fuente de datos
public class AvengersDAO implements InterfaceAvengers{
    public AvengersDAO() {
    }
    //recibe objeto de transferencia
    //No se incluye try y catch porque SQL esta diciendo que existe una excepcion
    @Override
    public boolean insert(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO avengers(nombre, alias, poder, ocupacion, url) VALUES (?, ?, ?, ?, ?)";
        int rowCount= 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("avengers.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1,((Avengers)obj).getNombre());
        pstm.setString(2,((Avengers)obj).getAlias());
        pstm.setString(3,((Avengers)obj).getPoder());
        pstm.setString(4,((Avengers)obj).getOcupacion());
        pstm.setString(5,((Avengers)obj).getUrl());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }
    @Override
    public boolean update(Object obj) throws SQLException {
        //existe un objeto generico
        //uso de comodines y set para campos extensos
        String sqlUpdate = "UPDATE avengers SET nombre= ?, alias=?, poder=?, ocupacion=?, url=? WHERE id =?; ";
        int rowCount= 0;
        //numero de registros modificados
        PreparedStatement pstm = ConexionSingleton.getInstance("avengers.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1,((Avengers)obj).getNombre());
        pstm.setString(2,((Avengers)obj).getAlias());
        pstm.setString(3,((Avengers)obj).getPoder());
        pstm.setString(4,((Avengers)obj).getOcupacion());
        pstm.setString(5,((Avengers)obj).getUrl());
        pstm.setInt(6, ((Avengers)obj).getId());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }


    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM avengers WHERE id =?;";
        int rowCount= 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("avengers.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, Integer.parseInt(id));
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public Object searchId(String id) throws SQLException {
        String sql = "SELECT * FROM avengers WHERE id = ?; ";
        Avengers avengers = null;
        PreparedStatement pstm = ConexionSingleton.getInstance("avengers.db").getConnection().prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            avengers = new Avengers(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6));
            return avengers;
        } return null;
    }

    @Override
    public ArrayList show() throws SQLException {
        String sql = "SELECT * FROM avengers";
        ArrayList<Avengers> resultado = new ArrayList<>();
        Statement stm = ConexionSingleton.getInstance("avengers.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sql);
        //excuteQuery realizar un select
        while (rst.next()) {
            resultado.add(new Avengers(rst.getInt(1), rst.getString(2), rst.getString(3),
                    rst.getString(4), rst.getString(5), rst.getString(6)));
        }
        return resultado;
    }
}