package org.example;

import org.example.controlador.ControladorAvengers;
import org.example.modelo.Avengers;
import org.example.persistencia.AvengersDAO;
import org.example.vista.VentanaAvengers;

import java.sql.SQLException;

public class DriverAvengers {
    public static void main(String[] args) {
        System.out.println("Hello world!");
      VentanaAvengers view = new VentanaAvengers("AVENGERS");
      ControladorAvengers controller = new ControladorAvengers(view);

    }
}