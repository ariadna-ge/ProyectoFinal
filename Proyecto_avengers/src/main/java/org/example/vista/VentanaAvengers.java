package org.example.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaAvengers extends JFrame{
    //etiquetas
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblAlias;
    private JLabel lblPoder;
    private JLabel lblOcupacion;
    private JLabel lblURL;
    private JLabel lblImagen;
    private JLabel lblTexto;

    //cuadros de texto
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtAlias;
    private JTextField txtPoder;
    private JTextField txtOcupacion;
    private JTextField txtURL;

    //botones
    private JButton btnAgregar;
    private JButton btnCargar;
    private JButton btnActualizar;
    private JButton btnBorrar;

    //paneles
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private GridLayout layout;
    private JScrollPane scrollPane;
    private JTable tblTablaAvengers;

    public VentanaAvengers(String title) throws HeadlessException {
        super(title);
        this.setSize(1000, 600);
        layout = new GridLayout(2, 2);
        this.getContentPane().setLayout(layout);
        //cambia la información relacionada con el diseño e invalida la jerarquía de componentes

        //estructura del panel 1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(153, 103, 252));

        lblTexto = new JLabel("Ingresa los datos para agregar el avenger que mas te agrade:)");
        lblId = new JLabel("Id: ");
        txtId = new JTextField(2);
        txtId.setText("O");
        txtId.setEnabled(false);
        lblNombre = new JLabel("Nombre Personal: ");
        txtNombre = new JTextField(15);
        lblAlias = new JLabel("Nombre de Avenger: ");
        txtAlias = new JTextField(10);
        lblPoder = new JLabel("Poder: ");
        txtPoder = new JTextField(20);
        lblOcupacion = new JLabel("Ocupacion: ");
        txtOcupacion = new JTextField(15);
        lblURL = new JLabel("URL: ");
        txtURL = new JTextField(20);
        btnAgregar = new JButton("Agregar");

        panel1.add(lblId);
        panel1.add(txtId);
        panel1.add(lblNombre);
        panel1.add(txtNombre);
        panel1.add(lblAlias);
        panel1.add(txtAlias);
        panel1.add(lblPoder);
        panel1.add(txtPoder);
        panel1.add(lblOcupacion);
        panel1.add(txtOcupacion);
        panel1.add(lblURL);
        panel1.add(txtURL);
        panel1.add(btnAgregar);
        panel1.add(lblTexto);

        //estructura del panel 2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(123, 219, 22));
        btnCargar = new JButton("Cargar");
        panel2.add(btnCargar);
        tblTablaAvengers = new JTable();
        scrollPane = new JScrollPane(tblTablaAvengers);
        panel2.add(scrollPane);

        //estructura del panel 3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(250, 216, 7));
        lblImagen = new JLabel("Avenger ... ");
        panel3.add(lblImagen);

        //estructura del panel 4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(85, 208, 246));
        lblTexto = new JLabel("Ingresa los datos para actualizar o eliminar el avenger");
        lblId = new JLabel("Id: ");
        txtId = new JTextField(2);
        lblNombre = new JLabel("Nombre Personal: ");
        txtNombre = new JTextField(15);
        lblAlias = new JLabel("Nombre de Avenger: ");
        txtAlias = new JTextField(10);
        lblPoder = new JLabel("Poder: ");
        txtPoder = new JTextField(20);
        lblOcupacion = new JLabel("Ocupacion: ");
        txtOcupacion = new JTextField(15);
        lblURL = new JLabel("URL: ");
        txtURL = new JTextField(20);
        btnActualizar = new JButton("Actualizar");
        btnBorrar = new JButton("Eliminar");

        panel4.add(lblId);
        panel4.add(txtId);
        panel4.add(lblNombre);
        panel4.add(txtNombre);
        panel4.add(lblAlias);
        panel4.add(txtAlias);
        panel4.add(lblPoder);
        panel4.add(txtPoder);
        panel4.add(lblOcupacion);
        panel4.add(txtOcupacion);
        panel4.add(lblURL);
        panel4.add(txtURL);
        panel4.add(btnActualizar);
        panel4.add(btnBorrar);
        panel4.add(lblTexto);

        this.getContentPane().add(panel1, 0);
        this.getContentPane().add(panel2, 1);
        this.getContentPane().add(panel3, 2);
        this.getContentPane().add(panel4, 3);


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JLabel getLblAlias() {
        return lblAlias;
    }

    public void setLblAlias(JLabel lblAlias) {
        this.lblAlias = lblAlias;
    }

    public JLabel getLblPoder() {
        return lblPoder;
    }

    public void setLblPoder(JLabel lblPoder) {
        this.lblPoder = lblPoder;
    }

    public JLabel getLblOcupacion() {
        return lblOcupacion;
    }

    public void setLblOcupacion(JLabel lblOcupacion) {
        this.lblOcupacion = lblOcupacion;
    }

    public JLabel getLblURL() {
        return lblURL;
    }

    public void setLblURL(JLabel lblURL) {
        this.lblURL = lblURL;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtAlias() {
        return txtAlias;
    }

    public void setTxtAlias(JTextField txtAlias) {
        this.txtAlias = txtAlias;
    }

    public JTextField getTxtPoder() {
        return txtPoder;
    }

    public void setTxtPoder(JTextField txtPoder) {
        this.txtPoder = txtPoder;
    }

    public JTextField getTxtOcupacion() {
        return txtOcupacion;
    }

    public void setTxtOcupacion(JTextField txtOcupacion) {
        this.txtOcupacion = txtOcupacion;
    }

    public JTextField getTxtURL() {
        return txtURL;
    }

    public void setTxtURL(JTextField txtURL) {
        this.txtURL = txtURL;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }

    public void setBtnBorrar(JButton btnBorrar) {
        this.btnBorrar = btnBorrar;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JTable getTblTablaAvengers() {
        return tblTablaAvengers;
    }

    public void setTblTablaAvengers(JTable tblTablaAvengers) {
        this.tblTablaAvengers = tblTablaAvengers;
    }

    public JLabel getLblImagen() {
        return lblImagen;
    }

    public void setLblImagen(JLabel lblImagen) {
        this.lblImagen = lblImagen;
    }

    public JLabel getLblTexto() {
        return lblTexto;
    }

    public void setLblTexto(JLabel lblTexto) {
        this.lblTexto = lblTexto;
    }

    public void limpiar(){
        txtNombre.setText("");
        txtAlias.setText("");
        txtPoder.setText("");
        txtOcupacion.setText("");
        txtURL.setText("");
    }
}
