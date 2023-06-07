package org.example.controlador;

import org.example.modelo.Avengers;
import org.example.modelo.ModeloTablaAvengers;
import org.example.vista.VentanaAvengers;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class ControladorAvengers extends MouseAdapter {
    private final VentanaAvengers view;
    private final ModeloTablaAvengers modelo;

    public ControladorAvengers(VentanaAvengers view) {
        this.view = view;
        modelo= new ModeloTablaAvengers();
        this.view.getTblTablaAvengers().setModel(modelo);

        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnActualizar().addMouseListener(this);
        this.view.getBtnBorrar().addMouseListener(this);

        this.view.getTblTablaAvengers().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ImageIcon aceptar = new ImageIcon("aceptado.png");
        ImageIcon actualizar = new ImageIcon("actualizado.png");
        ImageIcon cargar = new ImageIcon("cargando.png");
        ImageIcon eliminar = new ImageIcon("eliminado.png");
        ImageIcon error = new ImageIcon("error.png");
        ImageIcon info = new ImageIcon("info.png");


        //boton agregar
            /*if (this.view.getTxtNombre().getText().equals("") && this.view.getTxtAlias().getText().equals("") && this.view.getTxtPoder().getText().equals("") && this.view.getTxtOcupacion().getText().equals("") && this.view.getTxtURL().getText().equals("")){
                JOptionPane.showMessageDialog(view, "Se encuentran campos vacios", "AVISO", JOptionPane.ERROR_MESSAGE, info);
            }else {}*/
        if (e.getSource() == this.view.getBtnAgregar()) {
            Avengers avengers = new Avengers();
            //avengers.setId(0);
            avengers.setNombre(this.view.getTxtNombre().getText());
            avengers.setAlias(this.view.getTxtAlias().getText());
            avengers.setPoder(this.view.getTxtPoder().getText());
            avengers.setOcupacion(this.view.getTxtOcupacion().getText());
            avengers.setUrl(this.view.getTxtURL().getText());

            if (modelo.agregarAvenger(avengers)) {
                JOptionPane.showMessageDialog(view, "Los datos se agregaron correctamente", "AGREGAR", JOptionPane.INFORMATION_MESSAGE, actualizar);
                this.view.getTblTablaAvengers().updateUI();
            } else {
                JOptionPane.showMessageDialog(view, "No se agregaron los datos correctamente", "ERROR", JOptionPane.INFORMATION_MESSAGE, error);
            }
            modelo.cargarDatos();
            this.view.getTblTablaAvengers().setModel(modelo);
            this.view.getTblTablaAvengers().updateUI();
            this.view.limpiar();
        }

        if (e.getSource() == this.view.getBtnCargar()) {
            modelo.cargarDatos();
            this.view.getTblTablaAvengers().setModel(modelo);
            this.view.getTblTablaAvengers().updateUI();
            JOptionPane.showMessageDialog(view, "Se cargo correctamente", "CARGANDO", JOptionPane.INFORMATION_MESSAGE, cargar);

        }

        //mostrar imagen a traves de la url
        if(e.getSource() == this.view.getTblTablaAvengers()){
            int indice= this.view.getTblTablaAvengers().getSelectedRow();
            //Recibo un índice entero, lo saco del arreglo y ese es el y regreso un objeto de tipo de avenger
            Avengers tmp= modelo.getAvengerAtIndex(indice);
            //Declaro un avenger temporal, para obtener un avenger en cierto índice que se obtuvo seleccionando la tabla
            try{
                this.view.getLblImagen().setIcon(tmp.getFotoUrl());
                this.view.getLblImagen().setText("");
                JOptionPane.showMessageDialog(view, "Imagen identificada correctamente", "CARGANDO", JOptionPane.INFORMATION_MESSAGE, cargar);
                //quitar el texto del label al mostrar la imagen
            }catch (MalformedURLException malf){
                JOptionPane.showMessageDialog(view, "URL no identificada", "AVISO", JOptionPane.INFORMATION_MESSAGE, error);
                System.out.println(e);
            }
        }

        //boton actualizar
        if (e.getSource() == this.view.getBtnActualizar()) {
            Avengers avengers = new Avengers();
            avengers.setId(Integer.parseInt(this.view.getTxtId().getText()));
            avengers.setNombre(this.view.getTxtNombre().getText());
            avengers.setAlias(this.view.getTxtAlias().getText());
            avengers.setPoder(this.view.getTxtPoder().getText());
            avengers.setOcupacion(this.view.getTxtOcupacion().getText());
            avengers.setUrl(this.view.getTxtURL().getText());

            if (modelo.actualizarAvenger(avengers)) {
                JOptionPane.showMessageDialog(view, "Los datos se actualizaron correctamente", "ACTUALIZACION", JOptionPane.INFORMATION_MESSAGE, actualizar);
                this.view.getTblTablaAvengers().updateUI();
            } else {
                JOptionPane.showMessageDialog(view, "No se actualizo correctamente", "ERROR", JOptionPane.INFORMATION_MESSAGE, error);
            }

            modelo.cargarDatos();
            this.view.getTblTablaAvengers().setModel(modelo);
            this.view.getTblTablaAvengers().updateUI();
            this.view.limpiar();
        }

        //boton borrar
        if (e.getSource() == this.view.getBtnBorrar()){
            String id = this.view.getTxtId().getText();
            int yes = JOptionPane.showConfirmDialog(view, "Vas a eliminar este avenger?", "AVISO", JOptionPane.INFORMATION_MESSAGE);
            if (yes == JOptionPane.YES_NO_OPTION){
                this.modelo.eliminarAvenger(id);
                JOptionPane.showMessageDialog(view, "Se elimino correctamente", "ELIMINADO", JOptionPane.INFORMATION_MESSAGE, eliminar);
            } else {
                JOptionPane.showMessageDialog(view, "No se elimino correctamente", "ERROR", JOptionPane.INFORMATION_MESSAGE, error);
            }
            modelo.cargarDatos();
            this.view.getTblTablaAvengers().setModel(modelo);
            this.view.getTblTablaAvengers().updateUI();
            this.view.limpiar();
        }
    }
}