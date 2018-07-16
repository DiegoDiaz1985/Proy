/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

/**
 *
 * @author diego
 */
import ViajarDB.AutoDB;
import ViajarDB.Usuario;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author diego
 */
public class VentanaAuto extends FrameManager{
    
    private JTextField textMarca;
    private JTextField textModelo;
    private JComboBox comboColor;
    private JComboBox comboCombustible;
    private JTextField textPatente;
    private JComboBox comboAire;
    private JComboBox comboCalefaccion;
    private JTextField textCantAsientos;
    private JComboBox comboCalificacion;
    private JComboBox comboBaul;
    
    
    
    public VentanaAuto(Usuario u){
       final AutoDB adb=new AutoDB();
    
    /*va a mostrar segun la activacion de los botones: agregar auto, Editar mis autos, Eliminar auto */ 
    
    
        java.util.Locale.setDefault(java.util.Locale.forLanguageTag("es-AR"));
        VentanaAuto self = this;

        //----Mostrar los datos provenientes de un auto
        
        // agregar auto
        JPanel panelFoto = new JPanel();
        GridBagLayout gBag4 = new GridBagLayout();
        GridBagConstraints gRes4 = new GridBagConstraints();
        panelFoto.setLayout(gBag4);
        panelFoto.setBackground(Color.WHITE);
        //-------- PANEL 1-----------------
        
        JPanel panel1 = new JPanel();
        GridBagLayout gBag1 = new GridBagLayout ();
        GridBagConstraints gRes1 = new GridBagConstraints ();
        panel1.setLayout(gBag1);
        panel1.setBackground(Color.WHITE);
        
        JLabel laReg = new JLabel("Ingrese los datos del auto");  
        laReg.setFont(new Font("Calibri",3,22));
        laReg.setForeground(Color.BLACK);
        gRes1.gridx = 0;
        gRes1.gridy = 0;
        gRes1.gridwidth =GridBagConstraints.REMAINDER; 
        gRes1.anchor = GridBagConstraints.CENTER;
        gRes1.insets = new Insets(0,0,50,10);
        panel1.add(laReg,gRes1);
        
            
        //MARCA--------------------
        JLabel laMarca = new JLabel("Marca:");  
        laMarca.setFont(new Font("arial",3,12));
        laMarca.setForeground(Color.BLACK);
        laMarca.setHorizontalAlignment(JLabel.RIGHT);
        gRes1.gridx = 0;
        gRes1.gridy = 1;
        gRes1.gridwidth =1;
        gRes1.anchor = GridBagConstraints.WEST;
        gRes1.fill = GridBagConstraints.HORIZONTAL;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(laMarca,gRes1);
        textMarca = new JTextField();
        textMarca.setColumns(25);
        gRes1.gridx = 1;
        gRes1.gridy = 1;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(textMarca,gRes1);
        
        textMarca.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                textMarca.setText((""));
                
            }
        });
        
        //MODELO--------------------
        JLabel laModelo = new JLabel("Modelo:");  
        laModelo.setFont(new Font("arial",3,12));
        laModelo.setForeground(Color.BLACK);
        laModelo.setHorizontalAlignment(JLabel.RIGHT);
        gRes1.gridx = 2;
        gRes1.gridy = 1;
        gRes1.gridwidth =1;
        gRes1.anchor = GridBagConstraints.WEST;
        gRes1.fill = GridBagConstraints.HORIZONTAL;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(laModelo,gRes1);
        textModelo = new JTextField();
        textModelo.setColumns(25);
        gRes1.gridx = 3;
        gRes1.gridy = 1;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(textModelo,gRes1);
        
        textModelo.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                textModelo.setText((""));
                
            }
        });
        
        //COLOR--------------------
        JLabel laColor = new JLabel("Color:");  
        laColor.setFont(new Font("arial",3,12));
        laColor.setForeground(Color.BLACK);
        laColor.setHorizontalAlignment(JLabel.RIGHT);
        gRes1.gridx = 0;
        gRes1.gridy = 2;
        gRes1.gridwidth =1;
        gRes1.anchor = GridBagConstraints.WEST;
        gRes1.fill = GridBagConstraints.HORIZONTAL;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(laColor,gRes1);
        comboColor = new JComboBox();
        comboColor.addItem("AMARILLO");
        comboColor.addItem("AZUL");
        comboColor.addItem("BLANCO");
        comboColor.addItem("CELESTE");
        comboColor.addItem("MARRON");
        comboColor.addItem("NEGRO");
        comboColor.addItem("ROSA");
        comboColor.addItem("ROJO");
        comboColor.addItem("VERDE");
        comboColor.addItem("OTRO");
        gRes1.gridx = 1;
        gRes1.gridy = 2;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(comboColor,gRes1);
        
        comboColor.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                //comboColor
                
            }
        });
        
        //COMBUSTIBLE--------------------
        JLabel laCombustible = new JLabel("Combustible:");  
        laCombustible.setFont(new Font("arial",3,12));
        laCombustible.setForeground(Color.BLACK);
        laCombustible.setHorizontalAlignment(JLabel.RIGHT);
        gRes1.gridx = 2;
        gRes1.gridy = 2;
        gRes1.gridwidth =1;
        gRes1.anchor = GridBagConstraints.WEST;
        gRes1.fill = GridBagConstraints.HORIZONTAL;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(laCombustible,gRes1);
        comboCombustible = new JComboBox();
        comboCombustible.addItem("NAFTA");
        comboCombustible.addItem("DIESEL");
        comboCombustible.addItem("GAS");
        gRes1.gridx = 3;
        gRes1.gridy = 2;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(comboCombustible,gRes1);
        
        comboCombustible.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                //comboCombustible
                
            }
        });
        
        //PATENTE--------------------
        JLabel laPatente = new JLabel("Patente:");  
        laPatente.setFont(new Font("arial",3,12));
        laPatente.setForeground(Color.BLACK);
        laPatente.setHorizontalAlignment(JLabel.RIGHT);
        gRes1.gridx = 0;
        gRes1.gridy = 3;
        gRes1.gridwidth =1;
        gRes1.anchor = GridBagConstraints.WEST;
        gRes1.fill = GridBagConstraints.HORIZONTAL;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(laPatente,gRes1);
        textPatente = new JTextField();
        textPatente.setColumns(25);
        gRes1.gridx = 1;
        gRes1.gridy = 3;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(textPatente,gRes1);
        
        textPatente.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                textPatente.setText((""));
                
            }
        });
        
        //AIRE--------------------
        JLabel laAire = new JLabel("Aire:");  
        laAire.setFont(new Font("arial",3,12));
        laAire.setForeground(Color.BLACK);
        laAire.setHorizontalAlignment(JLabel.RIGHT);
        gRes1.gridx = 2;
        gRes1.gridy = 3;
        gRes1.gridwidth =1;
        gRes1.anchor = GridBagConstraints.WEST;
        gRes1.fill = GridBagConstraints.HORIZONTAL;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(laAire,gRes1);
        comboAire = new JComboBox();
        comboAire.addItem("Si");
        comboAire.addItem("No");
        gRes1.gridx = 3;
        gRes1.gridy = 3;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(comboAire,gRes1);
        
        comboAire.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                //comboAire
                
            }
        });
        
        //Calefaccion--------------------
        JLabel laCalefaccion = new JLabel("Calefacción:");  
        laCalefaccion.setFont(new Font("arial",3,12));
        laCalefaccion.setForeground(Color.BLACK);
        laCalefaccion.setHorizontalAlignment(JLabel.RIGHT);
        gRes1.gridx = 0;
        gRes1.gridy = 4;
        gRes1.gridwidth =1;
        gRes1.anchor = GridBagConstraints.WEST;
        gRes1.fill = GridBagConstraints.HORIZONTAL;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(laCalefaccion,gRes1);
        comboCalefaccion = new JComboBox();
        comboCalefaccion.addItem("Si");
        comboCalefaccion.addItem("No");
        gRes1.gridx = 1;
        gRes1.gridy = 4;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(comboCalefaccion,gRes1);
        
        comboCalefaccion.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                //comboCalefaccion
                
            }
        });
        
        //Cantidad de asientos--------------------
        JLabel laAsientos = new JLabel("Cantidad de asientos:");  
        laAsientos.setFont(new Font("arial",3,12));
        laAsientos.setForeground(Color.BLACK);
        laAsientos.setHorizontalAlignment(JLabel.RIGHT);
        gRes1.gridx = 2;
        gRes1.gridy = 4;
        gRes1.gridwidth =1;
        gRes1.anchor = GridBagConstraints.WEST;
        gRes1.fill = GridBagConstraints.HORIZONTAL;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(laAsientos,gRes1);
        textCantAsientos = new JTextField();
        textCantAsientos.setColumns(25);
        gRes1.gridx = 3;
        gRes1.gridy = 4;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(textCantAsientos,gRes1);
        
        textCantAsientos.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                textCantAsientos.setText((""));
                
            }
        });
        
        //Calificacion--------------------
        JLabel laCalificacion = new JLabel("Califique el estado del auto:");  
        laCalificacion.setFont(new Font("arial",3,12));
        laCalificacion.setForeground(Color.BLACK);
        laCalificacion.setHorizontalAlignment(JLabel.RIGHT);
        gRes1.gridx = 0;
        gRes1.gridy = 5;
        gRes1.gridwidth =1;
        gRes1.anchor = GridBagConstraints.EAST;
        gRes1.fill = GridBagConstraints.HORIZONTAL;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(laCalificacion,gRes1);
        comboCalificacion = new JComboBox();
        for (int i=0;i<10;i++){
            comboCalificacion.addItem(i+1);
        }
        gRes1.gridx = 1;
        gRes1.gridy = 5;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(comboCalificacion,gRes1);
        
        comboCalificacion.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                //comboCalificacion.
                
            }
        });
        
        //Baul--------------------
        JLabel laBaul = new JLabel("Tamaño de baul:");  
        laBaul.setFont(new Font("arial",3,12));
        laBaul.setForeground(Color.BLACK);
        laBaul.setHorizontalAlignment(JLabel.RIGHT);
        gRes1.gridx = 2;
        gRes1.gridy = 5;
        gRes1.gridwidth =1;
        gRes1.anchor = GridBagConstraints.EAST;
        gRes1.fill = GridBagConstraints.HORIZONTAL;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(laBaul,gRes1);
        comboBaul = new JComboBox();
        comboBaul.addItem("CHICO");
        comboBaul.addItem("MEDIANO");
        comboBaul.addItem("GRANDE");
        gRes1.gridx = 3;
        gRes1.gridy = 5;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(comboBaul,gRes1);
        
        comboBaul.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                //comboBaul.
                
            }
        });
        
        
        //Auto(id_auto,marca,modelo,color,combustible,patente,aire,calefaccion,cantAsientos,calificacion,baul);
        
 
    //-----panel1
        res.gridx=0;
        res.gridy=1;
        res.gridwidth=GridBagConstraints.RELATIVE;
        res.anchor = GridBagConstraints.CENTER;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(0,10 ,0,0);
        this.add(panel1,res);
    //-----panel2
        JPanel panel2 = new JPanel();
        
        GridBagLayout gBag3 = new GridBagLayout ();
        GridBagConstraints gRes3 = new GridBagConstraints ();
        panel2.setLayout(gBag3);
        
        /*GridBagLayout gBag2 = new GridBagLayout ();
        GridBagConstraints gRes2 = new GridBagConstraints ();
        panel2.setLayout(gBag2);*/
        
        panel2.setBackground(Color.LIGHT_GRAY);
            
              
        Boton botonRegistrar=new Boton("Registrar Auto");
        gRes3.gridx =1;
        gRes3.gridy =1;
        gRes3.gridwidth =1;
        gRes3.gridheight =0;
        gRes3.weightx = 1.0;
        gRes3.weighty = 1.0;
        gRes3.anchor = GridBagConstraints.CENTER;
        gRes3.fill = GridBagConstraints.NONE;
        gRes3.insets = new Insets(0,0,0,30);
        panel2.add(botonRegistrar,gRes3);
        
        botonRegistrar.addMouseListener(new MouseAdapter() { 
            @Override
            public void mouseClicked(MouseEvent e) {
                String marca=textMarca.getText();
                String modelo=textModelo.getText();
                String color=String.valueOf(comboColor.getSelectedItem());
                String combustible=String.valueOf(comboCombustible.getSelectedItem());
                String patente=textPatente.getText();
                String aire;
                String calefaccion;
                String cantAsientos=textCantAsientos.getText();
                String calificacion=String.valueOf(comboCalificacion.getSelectedItem());
                String baul=String.valueOf(comboBaul.getSelectedItem());
                String id_usuario=Integer.toString(u.getId_usuario());
                String foto=" ";//falta asignar la foto
                if (comboAire.getSelectedItem().toString()=="Si")
                    aire="0";
                else
                    aire="1";
                if (comboCalefaccion.getSelectedItem().toString()=="Si")
                    calefaccion="0";
                else
                    calefaccion="1";
                adb.addCar(marca, modelo, color, combustible, patente, aire, calefaccion, cantAsientos, calificacion, baul, foto, id_usuario);
                JOptionPane.showMessageDialog(self,"El auto se registro satisfactoriamente");
                VentanaMisAutos va = new VentanaMisAutos(u);
                va.setVisible(true);
                self.setVisible(false);
            }
        });
        
        
              
        Boton botonVolver=new Boton("Volver");
        gRes3.gridx =2;
        gRes3.gridy =1;
        gRes3.gridwidth =1;
        gRes3.gridheight =0;
        gRes3.weightx = 1.0;
        gRes3.weighty = 1.0;
        gRes3.anchor = GridBagConstraints.CENTER;
        gRes3.fill = GridBagConstraints.NONE;
        gRes3.insets = new Insets(0,0,0,30);
        panel2.add(botonVolver,gRes3);
        
        botonVolver.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                
                VentanaMisAutos va = new VentanaMisAutos(u);
                va.setVisible(true);
                self.setVisible(false);
                
            }
        });
    
        //-----panel2
        res.gridx=0;
        res.gridy=2;
        res.gridheight=GridBagConstraints.REMAINDER;
        res.gridwidth=GridBagConstraints.RELATIVE;
        res.weightx=0.1;
        res.weighty=0.3;
        res.anchor = GridBagConstraints.WEST;
        res.fill = GridBagConstraints.BOTH;
        this.add(panel2,res);
        Boton botonRegistrarFoto=new Boton("Agregar Foto");
        gRes3.gridx =3;
        gRes3.gridy =1;
        gRes3.gridwidth =1;
        gRes3.gridheight =0;
        gRes3.weightx = 1.0;
        gRes3.weighty = 1.0;
        gRes3.anchor = GridBagConstraints.CENTER;
        gRes3.fill = GridBagConstraints.NONE;
        gRes3.insets = new Insets(0,0,0,30);
        panel2.add(botonRegistrarFoto,gRes3);
        
        
        botonRegistrarFoto.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(self,"En un futuro se podra agregar la foto");
                VentanaMisAutos va = new VentanaMisAutos(u);
                va.setVisible(true);
                self.setVisible(false);
                
            }
        });
    }   
}

