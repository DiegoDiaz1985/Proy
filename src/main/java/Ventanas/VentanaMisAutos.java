/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import ViajarDB.Auto;
import ViajarDB.AutoDB;
import ViajarDB.Usuario;
import ViajarDB.ViajeDB;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author diego
 */

public class VentanaMisAutos extends FrameManager{
    private String[] nombreColumnas;
    final AutoDB autos = new AutoDB();
    private int idAuto;
    private Auto auto;
    private JTextField textMarca;
    private JTextField textModelo;
    private JComboBox comboColor;
    private JComboBox comboCombustible;
    private JTextField textPatente;
    private JComboBox comboAire;
    private JComboBox comboCalefaccion;
    private JTextField textCantAsientos;
    private JComboBox comboBaul;
    private JComboBox comboCalificacion;
    private ImageIcon imagen;
        
    
    
    
    /*
    Esta ventana mostrara el listado de autos que tengo
    y la posibilidad de agregar, editar y eliminar un auto
    */
    
   
    
    public VentanaMisAutos(Usuario u){
        java.util.Locale.setDefault(java.util.Locale.forLanguageTag("es-AR"));
        VentanaMisAutos self = this;
        JLabel img = new JLabel();    
        final String[] nombreColumnas = {"id","Marca","Modelo","Color","Combustible","Patente","Aire","Calefacción","Cantidad de asientos","Calificación","Baul"};       
        final DefaultTableModel modTabla = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
      
                return false;
            }
            
        };
        JTable tablaAutos = new JTable(modTabla);
        ArrayList <Auto> arrAutos = new ArrayList<>(); 
        arrAutos=autos.ObtenerAutosUsuario(u.getId_usuario());
        modTabla.setDataVector(cargarTabla(arrAutos),nombreColumnas);
             //------------oculto la primer columna del id-------------------------ale
        tablaAutos.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaAutos.getColumnModel().getColumn(0).setMinWidth(0);
        tablaAutos.getColumnModel().getColumn(0).setPreferredWidth(0);
        tablaAutos.setPreferredScrollableViewportSize(new Dimension(650, 200));
        
        tablaAutos.setAutoResizeMode (JTable.AUTO_RESIZE_OFF); 
        TableColumn col;
        int ancho;
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.LEFT);
        // --- columna 1   
        col = tablaAutos.getColumnModel ().getColumn(1);
        ancho = 100;  
        col.setPreferredWidth (ancho);
        tablaAutos.getColumnModel().getColumn(1).setCellRenderer(dtcr);    
        // --- columna 2  
        col = tablaAutos.getColumnModel ().getColumn(2);
        ancho = 160;  
        col.setPreferredWidth (ancho);
        tablaAutos.getColumnModel().getColumn(2).setCellRenderer(dtcr);    
        
        
        JPanel panelListar = new JPanel();
        GridBagLayout gBag = new GridBagLayout ();
        GridBagConstraints gRes = new GridBagConstraints ();
        panelListar.setLayout(gBag);
        panelListar.setBackground(Color.white);
        TitledBorder borde = new TitledBorder("Listado de mis autos:");
        borde.setTitleFont(new Font("Arial",3,22));
        panelListar.setBorder(borde);
        
        GridBagConstraints gRes3 = new GridBagConstraints ();
        gRes3.gridx=0;
        gRes3.gridy=1;
        gRes3.weightx=1;
        gRes3.weighty=1;
        //gRes3.anchor = GridBagConstraints.NORTH;
        gRes3.fill = GridBagConstraints.BOTH;
        gRes3.insets = new Insets(20,0,0,0);
        panelListar.add(new JScrollPane(tablaAutos),gRes3);
        
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        //panelBotones.setBackground(Color.WHITE);
        Boton botonAgregarAuto=new Boton("Agregar Auto");
        botonAgregarAuto.setAlignmentX (panelBotones.CENTER_ALIGNMENT);
        panelBotones.add(botonAgregarAuto);
        panelBotones.add (Box.createRigidArea (new Dimension (15,15)));
       // Boton botonEditarAuto=new Boton("Actualizar Datos");
       // botonEditarAuto.setAlignmentX (panelBotones.CENTER_ALIGNMENT);
        //panelBotones.add(botonEditarAuto);
        // panelBotones.add (Box.createRigidArea (new Dimension (15,15)));
        Boton botonEliminarAuto=new Boton("Eliminar Auto");
        botonEliminarAuto.setAlignmentX (panelBotones.CENTER_ALIGNMENT);
        panelBotones.add(botonEliminarAuto);
       // Boton botonVolver=new Boton("Volver");
      //  panelBotones.add(botonVolver);

// panel inferior
        
        JPanel panelInferior = new JPanel();
        //panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER, 100,0));
        Boton botonActualizar=new Boton("Actualizar");
       // botonEditarAuto.setAlignmentX (panelBotones.CENTER_ALIGNMENT);
        panelInferior.add(botonActualizar);
        Boton botonVolver=new Boton("Volver");
       // botonVolver.setAlignmentX (panelInferior.CENTER_ALIGNMENT);
        panelInferior.add(botonVolver);
       // panelInferior.add (Box.createRigidArea (new Dimension (15,15)));
      
        
         //-----------------datos del auto---------------------------------------
       
       
        
        
        
        JPanel panelDetalleAuto1 = new JPanel();
        GridBagLayout gBaga1 = new GridBagLayout ();
        GridBagConstraints resa1 = new GridBagConstraints ();
        panelDetalleAuto1.setLayout(gBaga1);
        panelDetalleAuto1.setBackground(Color.WHITE);
        
        JLabel labelMarca=new JLabel("Marca: ");
        labelMarca.setHorizontalAlignment(JLabel.LEFT);
        resa1.gridx=0;
        resa1.gridy=0;
        resa1.gridwidth=1;
        resa1.fill = GridBagConstraints.HORIZONTAL;
        resa1.insets = new Insets(10,0,10,0);
        panelDetalleAuto1.add(labelMarca,resa1);
        textMarca=new JTextField("                                              ");
        resa1.gridx=1;
        resa1.gridy=0;
        resa1.gridwidth= GridBagConstraints.REMAINDER;
        resa1.insets = new Insets(10,0,10,0);
        panelDetalleAuto1.add(textMarca,resa1);
      
        
        JLabel labelModelo=new JLabel("Modelo: ");
        labelModelo.setHorizontalAlignment(JLabel.LEFT);
        resa1.gridx=0;
        resa1.gridy=1;
        resa1.gridwidth=1;
        resa1.insets = new Insets(10,0,10,0);
        panelDetalleAuto1.add(labelModelo,resa1);
        textModelo=new JTextField("");
        resa1.gridx=1;
        resa1.gridy=1;
        resa1.gridwidth=GridBagConstraints.REMAINDER;
        resa1.insets = new Insets(10,0,10,0);
        panelDetalleAuto1.add(textModelo,resa1);
        
        JLabel labelPatente=new JLabel("Patente: ");
        labelPatente.setHorizontalAlignment(JLabel.LEFT);
        resa1.gridx=0;
        resa1.gridy=2;
        resa1.gridwidth=1;
        resa1.insets = new Insets(10,0,10,0);
        panelDetalleAuto1.add(labelPatente,resa1);
        textPatente=new JTextField("");
        resa1.gridx=1;
        resa1.gridy=2;
        resa1.gridwidth=GridBagConstraints.REMAINDER;
        resa1.insets = new Insets(10,0,10,0);
        panelDetalleAuto1.add(textPatente,resa1);
       
        JLabel labelColor=new JLabel("Color: ");
        labelColor.setHorizontalAlignment(JLabel.LEFT);
        resa1.gridx=0;
        resa1.gridy=3;
        resa1.gridwidth=1;
        resa1.insets = new Insets(10,0,10,0);
        panelDetalleAuto1.add(labelColor,resa1);
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
        resa1.gridx=1;
        resa1.gridy=3;
        //resa1.gridwidth=1;
        resa1.insets = new Insets(10,0,10,0);
        panelDetalleAuto1.add(comboColor,resa1);
               
        
        JLabel labelCombustible=new JLabel("Combustible: ");
        labelCombustible.setHorizontalAlignment(JLabel.LEFT);
        resa1.gridx=0;
        resa1.gridy=4;
        resa1.gridwidth=1;
        resa1.insets = new Insets(10,0,10,0);
        panelDetalleAuto1.add(labelCombustible,resa1);
        comboCombustible = new JComboBox();
        comboCombustible.addItem("NAFTA");
        comboCombustible.addItem("DIESEL");
        comboCombustible.addItem("GAS");
        resa1.gridx=1;
        resa1.gridy=4;
       // resa1.gridwidth=1;
        resa1.insets = new Insets(10,0,10,0);
        panelDetalleAuto1.add(comboCombustible,resa1);
        
       
        JPanel panelDetalleAuto2 = new JPanel();
        GridBagLayout gBaga2 = new GridBagLayout ();
        GridBagConstraints resa2 = new GridBagConstraints ();
        panelDetalleAuto2.setLayout(gBaga2);
        panelDetalleAuto2.setBackground(Color.WHITE);
        //TitledBorder borde3 = new TitledBorder("");
        //borde3.setTitleFont(new Font("Arial",3,14));
       // panelDetalleAuto2.setBorder(borde3);
        
        
        
        JLabel labelAire=new JLabel(" Aire acondicionado:");
        labelAire.setHorizontalAlignment(JLabel.LEFT);
        resa2.gridx=0;
        resa2.gridy=0;
        resa2.gridwidth=1;
        resa2.anchor = GridBagConstraints.EAST;
        resa2.fill = GridBagConstraints.HORIZONTAL;
        resa2.insets = new Insets(10,0,10,0);
        panelDetalleAuto2.add(labelAire,resa2);
        comboAire = new JComboBox();
        comboAire.addItem("Si");
        comboAire.addItem("No");
        resa2.gridx=1;
        resa2.gridy=0;
        resa2.gridwidth=GridBagConstraints.REMAINDER;
        resa2.insets = new Insets(10,0,10,0);
        panelDetalleAuto2.add(comboAire,resa2);
        
        
        JLabel labelCalefaccion=new JLabel(" Calefaccion:");
        labelCalefaccion.setHorizontalAlignment(JLabel.LEFT);
        resa2.gridx=0;
        resa2.gridy=1;
        resa2.gridwidth=1;
        resa2.insets = new Insets(10,0,10,0);
        panelDetalleAuto2.add(labelCalefaccion,resa2);
        comboCalefaccion = new JComboBox();
        comboCalefaccion.addItem("Si");
        comboCalefaccion.addItem("No");
        resa2.gridx=1;
        resa2.gridy=1;
        resa2.gridwidth=GridBagConstraints.REMAINDER;;
        resa2.insets = new Insets(10,0,10,0);
        panelDetalleAuto2.add(comboCalefaccion,resa2);
       
        
        JLabel labelCantidad=new JLabel(" Cantidad de Asientos: ");
        labelCantidad.setHorizontalAlignment(JLabel.LEFT);
        resa2.gridx=0;
        resa2.gridy=2;
        resa2.gridwidth=1;
        resa2.insets = new Insets(10,0,10,0);
        panelDetalleAuto2.add(labelCantidad,resa2);
        textCantAsientos=new JTextField("               ");
        resa2.gridx=1;
        resa2.gridy=2;
        resa2.gridwidth=GridBagConstraints.REMAINDER;;
        resa2.insets = new Insets(10,0,10,0);
        panelDetalleAuto2.add(textCantAsientos,resa2);
        
        JLabel labelBaul=new JLabel(" Capacidad del Baul: ");
        labelBaul.setHorizontalAlignment(JLabel.LEFT);
        resa2.gridx=0;
        resa2.gridy=3;
        resa2.gridwidth=1;
        resa2.insets = new Insets(10,0,10,0);
        panelDetalleAuto2.add(labelBaul,resa2);
        comboBaul = new JComboBox();
        comboBaul.addItem("CHICO");
        comboBaul.addItem("MEDIANO");
        comboBaul.addItem("GRANDE");
        resa2.gridx=1;
        resa2.gridy=3;
        resa2.gridwidth=GridBagConstraints.REMAINDER;
        resa2.insets = new Insets(10,0,10,0);
        panelDetalleAuto2.add(comboBaul,resa2);
        
        JLabel labelCalificacion=new JLabel(" Calificacion: ");
        labelCalificacion.setHorizontalAlignment(JLabel.LEFT);
        resa2.gridx=0;
        resa2.gridy=4;
        resa2.gridwidth=1;
        resa2.insets = new Insets(10,0,10,0);
        panelDetalleAuto2.add(labelCalificacion,resa2);
        comboCalificacion = new JComboBox();
        for (int i=0;i<10;i++){
            comboCalificacion.addItem(i+1);
        }
        resa2.gridx=1;
        resa2.gridy=4;
        resa2.gridwidth=GridBagConstraints.REMAINDER;
        resa2.insets = new Insets(10,0,10,0);
        panelDetalleAuto2.add(comboCalificacion,resa2);
         
        
           
        
        
        
        
        JPanel panelDetalleAuto = new JPanel();
        GridBagLayout gBag2 = new GridBagLayout ();
        GridBagConstraints res2 = new GridBagConstraints ();
        panelDetalleAuto.setLayout(gBag2);
        panelDetalleAuto.setBackground(Color.WHITE);
        TitledBorder borde2 = new TitledBorder("Editar datos:");
        borde2.setTitleFont(new Font("Arial",3,14));
        panelDetalleAuto.setBorder(borde2);
        
        res2.gridx=0;
        res2.gridy=0;
        res2.gridwidth=GridBagConstraints.RELATIVE;
        res2.anchor = GridBagConstraints.WEST;
        res2.fill = GridBagConstraints.BOTH;
        res2.insets = new Insets(10,10,10,10);
        panelDetalleAuto.add(panelDetalleAuto1,res2);
        res2.gridx=1;
        res2.gridy=0;
        res2.gridwidth=GridBagConstraints.RELATIVE;
        res2.anchor = GridBagConstraints.EAST;
        res2.fill = GridBagConstraints.BOTH;
        res2.insets = new Insets(10,10,10,10);
        panelDetalleAuto.add(panelDetalleAuto2,res2);
        JPanel panelFoto = new JPanel();
        res2.gridx=0;
        res2.gridy=0;
        res2.gridwidth=GridBagConstraints.RELATIVE;
        res2.anchor = GridBagConstraints.EAST;
        res2.fill = GridBagConstraints.BOTH;
        res2.insets = new Insets(10,10,10,10);
        imagen = new ImageIcon(getClass().getResource("/auto1.jpg"));
        
        
        tablaAutos.addMouseListener(new MouseAdapter(){
          
        @Override
            public void mouseClicked(MouseEvent e) {
                AutoDB a = new AutoDB();
                //auto=null;
                //tablaViajes.getSelectedRows()
                String id=String.valueOf(tablaAutos.getValueAt(tablaAutos.getSelectedRow(), 0));
                idAuto=Integer.parseInt(id);
                
                auto=a.ObtenerDatosAuto(idAuto);
                textMarca.setText(auto.getMarca());
                textModelo.setText(auto.getModelo());
                textPatente.setText(auto.getPatente());
                textCantAsientos.setText(String.valueOf((int)auto.getCantidad_de_asientos()));
                if(auto.getAire_acondicionado())
                    comboAire.setSelectedIndex(0);
                else
                    comboAire.setSelectedIndex(1);
                if(auto.getCalefaccion())
                    comboCalefaccion.setSelectedIndex(0);
                else
                    comboCalefaccion.setSelectedIndex(1);
                
                for (int j=0;j<10;j++){
                    if (auto.getCalificacion()==Short.parseShort(comboCalificacion.getItemAt(j).toString()))
                        comboCalificacion.setSelectedIndex(j);   
                }
                               
                for (int j=0;j<10;j++){
                    if (auto.getColor().equals(comboColor.getItemAt(j).toString()))
                        comboColor.setSelectedIndex(j);   
                }
                               
                for (int j=0;j<3;j++){
                    if (auto.getCombustible().equals(comboCombustible.getItemAt(j).toString()))
                        comboCombustible.setSelectedIndex(j);   
                }
                
                         
                for (int j=0;j<3;j++){
                    if (auto.getCapacidad_baul().equals(comboBaul.getItemAt(j).toString()))
                        comboBaul.setSelectedIndex(j);   
                } 
                               
                if (!(auto.getFoto()).equals(" ")&&(imagen==null))
                    imagen = new ImageIcon(getClass().getResource(auto.getFoto()));
                JLabel img = new JLabel();
                img.setIcon(imagen);
                resa2.gridx=0;
                resa2.gridy=0;
                resa2.gridwidth=GridBagConstraints.REMAINDER;
                resa2.insets = new Insets(10,10,10,10);
                panelFoto.add(img,resa2);
        
                
             }
               
               
        });
        
        img.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseEntered(MouseEvent e) {
               img.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 3));
               img.setToolTipText("click para cambiar foto");
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
              
                img.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
            }
            
            
        }); 
         
         
        
        
        botonVolver.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                
                VentanaViajes viajes = new VentanaViajes(u);
                viajes.setVisible(true);
                self.setVisible(false);
                
            }
        });
        
        botonAgregarAuto.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                
                VentanaAuto va=new VentanaAuto(u);
                va.setVisible(true);
                self.setVisible(false);
                
            }
        });
        
        botonActualizar.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                String marca=textMarca.getText();
                String modelo=textModelo.getText();
                String color=String.valueOf(comboColor.getSelectedItem());
                String combustible=String.valueOf(comboCombustible.getSelectedItem());
                String patente=textPatente.getText();
                String aire=String.valueOf(comboAire.getSelectedItem());
                String calefaccion=String.valueOf(comboCalefaccion.getSelectedItem());
                String cantAsientos=textCantAsientos.getText();
                String calificacion=String.valueOf(comboCalificacion.getSelectedItem());
                String baul=String.valueOf(comboBaul.getSelectedItem());
                String foto=" ";//falta asignar la foto
                if (comboAire.getSelectedItem().toString()=="Si")
                    aire="0";
                else
                    aire="1";
                if (comboCalefaccion.getSelectedItem().toString()=="Si")
                    calefaccion="0";
                else
                    calefaccion="1";
                autos.updateCar(marca, modelo, color, combustible, patente, aire, calefaccion, cantAsientos, calificacion, baul, foto,auto.getId_auto());
                JOptionPane.showMessageDialog(self,"El auto se ha actualizado satisfactoriamente");
                VentanaViajes viajes = new VentanaViajes(u);
                viajes.setVisible(true);
                self.setVisible(false);
            }
        });
        
        
        botonEliminarAuto.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                
                ViajeDB viajes = new ViajeDB();
                //pregunto hay viajes con este auto en el futuro??
                if (viajes.existeAutoEnViajePendiente(auto.getId_auto()))
                        JOptionPane.showMessageDialog(self,"Su auto no puede ser eliminado, debe eliminar algun viaje pendiente en el que se encuentra el auto");
                    else
                    {
                        autos.deleteCar(auto.getId_auto());
                        JOptionPane.showMessageDialog(self,"Su auto a sido eliminado");
                    }
                VentanaMisAutos au = new VentanaMisAutos(u);
                au.setVisible(true);
                self.setVisible(false);
                
            }
        });
        
        
        Boton botonRegistrarFoto=new Boton("Agregar Foto");
        gRes3.gridx =0;
        gRes3.gridy =1;
        gRes3.gridwidth =1;
        gRes3.gridheight =0;
        gRes3.weightx = 1.0;
        gRes3.weighty = 1.0;
        gRes3.anchor = GridBagConstraints.CENTER;
        gRes3.fill = GridBagConstraints.NONE;
        gRes3.insets = new Insets(0,0,0,30);
        panelFoto.add(botonRegistrarFoto,gRes3);
        
        
        botonRegistrarFoto.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(self,"En un futuro se podra agregar la foto");
                VentanaMisAutos va = new VentanaMisAutos(u);
                va.setVisible(true);
                self.setVisible(false);
                
            }
        });
        
        //----Listar Autos
        res.gridx=0;
        res.gridy=1;
        res.gridwidth=GridBagConstraints.RELATIVE;
        //res.gridheight=GridBagConstraints.RELATIVE;
       // res.weightx=0;
       // res.weighty=0;
        //res.anchor = GridBagConstraints.NORTH;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(0,50,0,0);
        this.add(panelListar,res);
        
        // panel de botones
        res.gridx=1;
        res.gridy=1;
        res.gridwidth=GridBagConstraints.REMAINDER;
        //res.gridheight=GridBagConstraints.RELATIVE;
       // res.weightx=0;
        //res.weighty=0.2;
        res.anchor = GridBagConstraints.CENTER;
        res.fill = GridBagConstraints.NONE;
        res.insets = new Insets(0,0,20,0);
        this.add(panelBotones,res);
        
        
            
        //----detalle Auto
        res.gridx=0;
        res.gridy=2;
        res.gridwidth=GridBagConstraints.RELATIVE;
        //res.gridheight=GridBagConstraints.RELATIVE;
        //res.weightx=1;
        //res.weighty=0;
        res.anchor = GridBagConstraints.WEST;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(0,50,0,0);
        this.add(panelDetalleAuto,res);
        
        // panel foto
        res.gridx=1;
        res.gridy=2;
        res.gridwidth=GridBagConstraints.RELATIVE;
        //res.gridheight=GridBagConstraints.RELATIVE;
        //res.weightx=1;
        //res.weighty=1;
        //res.anchor = GridBagConstraints.NORTH;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(20,0,0,0);
        this.add(panelFoto,res);

        // panel inferior
        res.gridx=0;
        res.gridy=3;
        res.gridwidth=GridBagConstraints.RELATIVE;
        //res.gridheight=GridBagConstraints.RELATIVE;
        //res.weightx=1;
        //res.weighty=1;
        //res.anchor = GridBagConstraints.NORTH;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(20,0,0,0);
        this.add(panelInferior,res);
        
        
        
    
    }
    
     public Object[][] cargarTabla(ArrayList<Auto> arrAutos){
        
        int max= arrAutos.size();
        Object[][] datos= new Object[max][11];    
        int i=0;
        for(Auto vAux : arrAutos){
            if(vAux.getCuenta())    
            {
               datos[i][0]=vAux.getId_auto();
               datos[i][1]=vAux.getMarca();
               datos[i][2]=vAux.getModelo();
               datos[i][3]=vAux.getColor();
               datos[i][4]=vAux.getCombustible();
               datos[i][5]=vAux.getPatente();
               if (vAux.getAire_acondicionado())
                   datos[i][6]="Si";
               else
                   datos[i][6]="No";
               if (vAux.getCalefaccion())
                   datos[i][7]="Si";
               else
                   datos[i][7]="No";
               datos[i][8]=vAux.getCantidad_de_asientos();
               datos[i][9]=vAux.getCalificacion();
               datos[i][10]=vAux.getCapacidad_baul();
            }
               
            i++;
            
        }
        
        return datos;
        
    }
    
}
