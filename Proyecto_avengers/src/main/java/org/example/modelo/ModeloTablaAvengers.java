package org.example.modelo;

import org.example.persistencia.AvengersDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaAvengers implements TableModel {
    public static  final int COLUMNS = 6;
    private ArrayList<Avengers> datos;
    private AvengersDAO avengersDAO;

    public ModeloTablaAvengers() {
        avengersDAO = new AvengersDAO();
        datos = new ArrayList<>();
    }

    public ModeloTablaAvengers(ArrayList<Avengers> datos) {
        this.datos = datos;
        avengersDAO = new AvengersDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0:
                return "ID";
                case 1:
                return "Nombre";
                case 2:
                return "Alias";
                case 3:
                return "Poder";
                case 4:
                return "Ocupacion";
                case 5:
                return "Foto";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Avengers temporal = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return temporal.getId();
            case 1:
                return temporal.getNombre();
            case 2:
                return temporal.getAlias();
            case 3:
                return temporal.getPoder();
            case 4:
                return temporal.getOcupacion();
            case 5:
                return temporal.getUrl();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                break;
            case 1:
                datos.get(rowIndex).setNombre((String) aValue);
                break;
            case 2:
                datos.get(rowIndex).setAlias((String) aValue);
                break;
            case 3:
                datos.get(rowIndex).setPoder((String) aValue);
                break;
            case 4:
                datos.get(rowIndex).setOcupacion((String) aValue);
                break;
            case 5:
                datos.get(rowIndex).setUrl((String) aValue);
                break;
            default:
                System.out.println("No existen modificaciones");
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public void cargarDatos() {
    boolean rst = false;
        try{
            ArrayList<Avengers> tirar = avengersDAO.show();
            System.out.println(tirar);
                datos = avengersDAO.show();
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }
    public boolean agregarAvenger(Avengers avengers){
        boolean rst = false;
        try{
            if (avengersDAO.insert(avengers)){
               datos.add(avengers);
               rst= true;
            }else{
                rst = false;
                System.out.println("no se agregaron");
            }
        } catch (SQLException sql){
            System.out.println(sql.getMessage());
        }
        return rst;
    }

    public boolean actualizarAvenger(Avengers avengers) {
        boolean resultado = false;
        try {
            if (avengersDAO.update(avengers)) {
                resultado= true;
            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public  boolean eliminarAvenger(String indice){
        boolean resultado = true;
        try {
            if (avengersDAO.delete(indice)) {
                resultado= true;
            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public Avengers getAvengerAtIndex(int i){
        return datos.get(i);
    }
}
