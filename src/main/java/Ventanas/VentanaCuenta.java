/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;


import ViajarDB.Ciudad;
import ViajarDB.CiudadDB;
import ViajarDB.Usuario;
import ViajarDB.UsuarioDB;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;

/**
 *
 * @author diego
 */
public class VentanaCuenta extends FrameManager{
    
     
    private JTextField textNom;
    private JTextField textApe;
    private JTextField textCalle;
    private JTextField textCiudad;
    private JTextField textNumTel;
    private JDateChooser dateNac;
    private JTextField textMail;
    private JTextField textPass;
    
   
    public VentanaCuenta(Usuario u){
            
        
        UsuarioDB db=new UsuarioDB();
        java.util.Locale.setDefault(java.util.Locale.forLanguageTag("es-AR"));
        VentanaCuenta self = this;

        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        JLabel labelq = new JLabel("Mis Datos");  
        labelq.setFont(new Font("Arial",3,20));
        labelq.setForeground(Color.black);
        labelq.setHorizontalAlignment(JLabel.CENTER);
        panelTitulo.add(labelq);
        
        

        //----Mostrar informacion del usuario
        //-------- PANEL 1-----------------
        
        JPanel panel1 = new JPanel();
        GridBagLayout gBag1 = new GridBagLayout ();
        GridBagConstraints gRes1 = new GridBagConstraints ();
        panel1.setLayout(gBag1);
        panel1.setBackground(Color.WHITE);
          
    //----foto     
        ImageIcon imagen;
        JLabel imgAvatar = new JLabel();
        String genero=u.getGenero();
        if (genero.equals("f")){
             imagen = new ImageIcon(getClass().getResource("/avatarFchica.jpg"));
             imgAvatar.setIcon(imagen);
        }
        else{
            imagen = new ImageIcon(getClass().getResource("/avatarMchica.jpg"));
            imgAvatar.setIcon(imagen);
            
        }
     /*  imgAvatar.setHorizontalAlignment(JLabel.CENTER);
        gRes1.gridx = 1;
        gRes1.gridy = 0;
        gRes1.gridwidth =GridBagConstraints.RELATIVE;
        //gRes1.gridheight=3;
        gRes1.anchor = GridBagConstraints.CENTER;
        gRes1.fill = GridBagConstraints.NONE;
        gRes1.insets = new Insets(0,0,20,40);
        panel1.add(imgAvatar,gRes1);*/
        
        
         imgAvatar.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseEntered(MouseEvent e) {
               imgAvatar.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 3));
               imgAvatar.setToolTipText("click para cambiar foto");
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
              
                imgAvatar.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
            }
            
            
        });
         
        JPanel panelfoto = new JPanel(); 
        GridBagLayout gBagf = new GridBagLayout ();
        GridBagConstraints gResf = new GridBagConstraints ();
        panelfoto.setLayout(gBagf);
        panelfoto.setBackground(Color.WHITE);
        gResf.gridx = 0;
        gResf.gridy = 0;
        gResf.gridwidth =1;
        gResf.fill = GridBagConstraints.NONE;
         gResf.insets = new Insets(10,0,20,0);
        panelfoto.add(imgAvatar,gResf);
        
        
      
        
        textNom = new JTextField(u.getNombre());
        textNom.setColumns(15);
        textNom.setFont(new Font("Arial",3,18));
       // textNom.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
        textNom.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        
      textNom.addMouseListener(new MouseAdapter() {
           /* @Override
            public void mouseReleased(MouseEvent e) {
                textNom.setText((""));
                
            }*/
          
          @Override
            public void mouseEntered(MouseEvent e) {
               textNom.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 3));
               textNom.setToolTipText("click para editar");
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
              
                textNom.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
            }
          
          
        });
      
      
        textApe = new JTextField(u.getApellido());
        textApe.setColumns(15);
        textApe.setFont(new Font("Arial",3,18));
        //textApe.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
        textApe.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        textApe.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            
            /*@Override
            public void mouseReleased(MouseEvent e) {
                textApe.setText((""));
                
            }*/
            
            @Override
            public void mouseEntered(MouseEvent e) {
               textApe.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 3));
               textApe.setToolTipText("click para editar");
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
              
                textApe.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
            }
          
            
            
            
        });
       
        JPanel panelnYa = new JPanel();
        panelnYa.setLayout(new BoxLayout(panelnYa, BoxLayout.Y_AXIS));
        panelnYa.setBackground(Color.WHITE);
        textNom.setAlignmentX (panelnYa.CENTER_ALIGNMENT);
      
        panelnYa.add(textNom);
      
        panelnYa.add (Box.createRigidArea (new Dimension (5,10)));   
        textApe.setAlignmentX (panelnYa.CENTER_ALIGNMENT);
        panelnYa.add(textApe);
       
        panel1.add(panelfoto,gRes1);
        gResf.gridx = 1;
        gResf.gridy = 0;
        gResf.gridwidth =1;
        gResf.fill = GridBagConstraints.NONE;
        
        panel1.add(panelnYa,gRes1);
      
    //NOMBRE--------------------
 /*      JLabel laNombre = new JLabel("Nombre:");  
        laNombre.setFont(new Font("arial",3,12));
        laNombre.setForeground(Color.BLACK);
        laNombre.setHorizontalAlignment(JLabel.LEFT);
        gRes1.gridx = 0;
        gRes1.gridy = 1;
        gRes1.gridwidth =1;
        gRes1.anchor = GridBagConstraints.NORTH;
        gRes1.fill = GridBagConstraints.HORIZONTAL;
        gRes1.insets = new Insets(0,0,10,0);
        panel1.add(laNombre,gRes1);
        textNom = new JTextField(u.getNombre());
        textNom.setColumns(15);
        gRes1.gridx = 1;
        gRes1.gridy = 1;
        gRes1.gridwidth =GridBagConstraints.REMAINDER;
      
        gRes1.anchor = GridBagConstraints.NORTH;
        gRes1.fill = GridBagConstraints.HORIZONTAL;
        gRes1.insets = new Insets(0,0,10,0);
        panel1.add(textNom,gRes1);
        
       
        
      textNom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                textNom.setText((""));
                
            }
        });
        
        //APELLIDO--------------------
        JLabel laApellido = new JLabel("Apellido:");  
        laApellido.setFont(new Font("arial",3,12));
        laApellido.setForeground(Color.BLACK);
        laApellido.setHorizontalAlignment(JLabel.LEFT);
        gRes1.gridx = 0;
        gRes1.gridy =2;
        
        gRes1.gridwidth =1;
        gRes1.anchor = GridBagConstraints.NORTH;
        gRes1.fill = GridBagConstraints.HORIZONTAL;
        gRes1.insets = new Insets(0,0,10,0);
        panel1.add(laApellido,gRes1);
        textApe = new JTextField(u.getApellido());
        textApe.setColumns(15);
        gRes1.gridx = 1;
        gRes1.gridy =2;
        gRes1.gridwidth =GridBagConstraints.REMAINDER;
        gRes1.insets = new Insets(0,0,10,0);
        panel1.add(textApe,gRes1);
        
        textApe.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                textApe.setText((""));
                
            }
        });*/
        
        //GENERO--------------------------------
        JLabel laGenero = new JLabel("Genero:");  
        laGenero.setFont(new Font("arial",3,12));
        laGenero.setForeground(Color.BLACK);
        laGenero.setHorizontalAlignment(JLabel.LEFT);
        gRes1.gridx =0;
        gRes1.gridy =3;
        gRes1.gridwidth =1;
        gRes1.anchor = GridBagConstraints.WEST;
        gRes1.fill = GridBagConstraints.HORIZONTAL;
        gRes1.insets = new Insets(20,0,10,0);
        panel1.add(laGenero,gRes1);
        
        
        JPanel panelMoF = new JPanel();
        panelMoF.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
        panelMoF.setBackground(Color.white);
        //TitledBorder borde1 = new TitledBorder("");
        //panelMoF.setBorder(borde1);
        JRadioButton RBm = new JRadioButton("Masculino");
        //RBm.setSelected(true);
        RBm.setBackground(Color.WHITE);
        JRadioButton RBf = new JRadioButton("Femenino");
        RBf.setBackground(Color.WHITE);
         if (u.getGenero().equals("m"))
            RBm.setSelected(true);
        else
            RBf.setSelected(true);
        ButtonGroup RB=new ButtonGroup();
        RB.add(RBm);
        RB.add(RBf);
        panelMoF.add(RBm);
        panelMoF.add(RBf);
        gRes1.gridx =1;
        gRes1.gridy =3;
        panel1.add(panelMoF,gRes1);
  
        
        //---------Direccion
        JLabel laDireccion = new JLabel("Direccion:");  
        laDireccion.setFont(new Font("arial",3,12));
        laDireccion.setForeground(Color.BLACK);
        laDireccion.setHorizontalAlignment(JLabel.LEFT);
        gRes1.gridx = 0;
        gRes1.gridy = 4;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(laDireccion,gRes1);
        textCalle = new JTextField(u.getDireccion());
        textCalle.setColumns(25); 
        gRes1.gridx =1;
        gRes1.gridy = 4;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(textCalle,gRes1);
        
        textCalle.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                textCalle.setText((""));
                
            }
        });
        
        //-----Ciudad
        
        JLabel labelCiudad = new JLabel("Ciudad:");  
        labelCiudad.setFont(new Font("arial",3,12));
        labelCiudad.setForeground(Color.black);
        labelCiudad.setHorizontalAlignment(JLabel.LEFT);
        gRes1.gridx = 0;
        gRes1.gridy = 5;
        gRes1.gridwidth =1;
        gRes1.anchor = GridBagConstraints.WEST;
        gRes1.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(labelCiudad,gRes1);
        
        CiudadDB ciudadMg = new CiudadDB();  
        JComboBox comboOrigen = new JComboBox();
	comboOrigen.setBackground(Color.WHITE);
        Iterator<Ciudad> it = ciudadMg.getCiudades().iterator();
        ArrayList <String> aux = new ArrayList<String>();
        gRes1.gridx = 1;
        gRes1.gridy = 5;
        gRes1.gridwidth =1;
        comboOrigen.addItem(u.getCiudad());
        for (Ciudad nombre : ciudadMg.getCiudades()) {
            String nom = (nombre.getNombre());
            comboOrigen.addItem(nom);
        }
        
        //cb.getItemAt(cb.getSelectedIndex()); 
        panel1.add(comboOrigen,gRes1);
        
        
        //Telefono
        
        JLabel laTel = new JLabel("Telefono:");  
        laTel.setFont(new Font("arial",3,12));
        laTel.setForeground(Color.BLACK);
        laTel.setHorizontalAlignment(JLabel.LEFT);
        gRes1.gridx = 0;
        gRes1.gridy = 6;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(laTel,gRes1);
     
        textNumTel = new JTextField(u.getTelefono());
        textNumTel.setColumns(15);
        gRes1.gridx =1;
        gRes1.gridy = 6;
        gRes1.gridwidth =1;
        gRes1.fill = GridBagConstraints.NONE;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(textNumTel,gRes1);
                  
        textNumTel.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                textNumTel.setText((""));
            }
        });
        
        
        //--Fecha Nacimiento
        JLabel laFechaNac = new JLabel("Fecha de nacimiento:");  
        laFechaNac.setFont(new Font("arial",3,12));
        laFechaNac.setForeground(Color.BLACK);
        laFechaNac.setHorizontalAlignment(JLabel.LEFT);
        gRes1.gridx = 0;
        gRes1.gridy = 7;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(laFechaNac,gRes1);
        
        
        dateNac = new JDateChooser(u.getFecha_nacimiento());
        gRes1.gridx =1;
        gRes1.gridy = 7;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        gRes1.ipadx = 20;
        //gRes2.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(dateNac,gRes1);
        
        //Mail
        JLabel laMail = new JLabel("Mail:");  
        laMail.setFont(new Font("arial",3,12));
        laMail.setForeground(Color.BLACK);
        laMail.setHorizontalAlignment(JLabel.LEFT);
        gRes1.gridx = 0;
        gRes1.gridy = 8;
        gRes1.gridwidth =1;
        gRes1.anchor = GridBagConstraints.WEST;
        gRes1.fill = GridBagConstraints.HORIZONTAL;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(laMail,gRes1);
        textMail = new JTextField(u.getMail());
        textMail.setColumns(20);
        gRes1.gridx = 1;
        gRes1.gridy = 8;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(textMail,gRes1);
        
        //Contraseña
        JLabel labelPassReg = new JLabel("Contraseña:");
        labelPassReg.setForeground(Color.BLACK);
        labelPassReg.setHorizontalAlignment(JLabel.LEFT);
        gRes1.gridx =0;
        gRes1.gridy = 9;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(labelPassReg,gRes1);
        textPass = new JTextField(u.getPass());
        textPass.setColumns(10);
        gRes1.gridx =1;
        gRes1.gridy = 9;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,10);
        panel1.add(textPass,gRes1);
    
//-----PANEL 3-------------------------
       
        JPanel panel3 = new JPanel(); 
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 100,0));
        //panel3.setBackground(Color.LIGHT_GRAY);
        Boton botonActualizar=new Boton("ACTUALIZAR");
        panel3.add(botonActualizar);
        Boton botonEliminar=new Boton("ELIMINAR CUENTA");
        panel3.add(botonEliminar);       
        Boton botonVolver=new Boton("VOLVER");
        panel3.add(botonVolver);
        
        botonVolver.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                
                VentanaViajes viajes = new VentanaViajes(u);
                viajes.setVisible(true);
                self.setVisible(false);
                
            }
        });
        
        
         
        botonActualizar.addMouseListener(new MouseAdapter() { 
            @Override
            public void mouseClicked(MouseEvent e) {
                Date fec=dateNac.getDate();
                SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd");
                String fecha_nacimiento=sdf.format(fec);
                String id=Integer.toString(u.getId_usuario());
                System.out.println(fecha_nacimiento);
                String genero;
               
                
                
                if (RBm.isSelected() == true) {
                    genero = "m";
                } else {
                    genero = "f";
                }
                String Ciudad = (String)comboOrigen.getItemAt(comboOrigen.getSelectedIndex());
                db.updateUser(id,textNom.getText(),textApe.getText(),textCalle.getText(),Ciudad,genero,textNumTel.getText(),fecha_nacimiento,textMail.getText(),textPass.getText());
                u.setNombre(textNom.getText());
                u.setApellido(textApe.getText());
                u.setDireccion(textCalle.getText());
                u.setCiudad(Ciudad);
                u.setTelefono(textNumTel.getText());
                u.setFecha_nacimiento(fec);
                u.setMail(textMail.getText());
                u.setPass(textPass.getText());
                u.setGenero(genero);
                JOptionPane.showMessageDialog(self,"Sus datos han sido actualizados");
            }
        });
        
        
        
         
        botonEliminar.addMouseListener(new MouseAdapter() { 
            @Override
            public void mouseClicked(MouseEvent e) {
                    UIManager.put("OptionPane.yesButtonText", "Si");
                    int n = JOptionPane.showConfirmDialog(self, "¿Estas seguro que deseas eliminar tu cuenta?","Mensaje",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (n== JOptionPane.YES_OPTION)
                    {
                        String id=Integer.toString(u.getId_usuario());
                        db.deleteCuenta(id);
                    }
                    
            }
        });
        
        

               
        
        
        this.setTitle("Mi cuenta");
 
        
        
//-----panel Titulo
        res.gridx=0;
        res.gridy=1;
        res.gridwidth=GridBagConstraints.RELATIVE;
        res.anchor = GridBagConstraints.CENTER;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(0,0,0,0);
        this.add(panelTitulo,res);
        
//------panel editar datos
        res.gridx=0;
        res.gridy=2;
        res.gridwidth=GridBagConstraints.REMAINDER;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(0,150,10,150);
        //res.ipady = 40;
        //res.ipadx = 40;
        this.add(panel1,res);
            
     
//------panel Botones
        res.gridx=0;
        res.gridy=3;
        res.gridwidth=GridBagConstraints.REMAINDER;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(10,0,10,0);
        res.ipady = 0;
        this.add(panel3,res);     
        
         
        
        
        
        
        
        
        
        
        
        
        
        
//----Titulo
/*        res.gridx=0;
        res.gridy=0;
       //res.gridheight=GridBagConstraints.REMAINDER;
        res.gridwidth=GridBagConstraints.REMAINDER;
        res.weightx=1;
        res.weighty=1;
        res.anchor = GridBagConstraints.CENTER;
        res.fill = GridBagConstraints.HORIZONTAL;
        this.add(panelTitulo,res);
 
//-----panel1
        res.gridx=0;
        res.gridy=2;
        //res.gridheight=GridBagConstraints.RELATIVE;
        res.gridwidth=GridBagConstraints.REMAINDER;
        res.weightx=0.0;
        res.weighty=0.0;
        res.anchor = GridBagConstraints.NORTH;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(0,30,0,30);//arriba izquierda abajo derecha
        this.add(panel1,res);
        
        //-----panel3
        res.gridx=0;
        res.gridy=3;
        //res.gridheight=GridBagConstraints.REMAINDER;
        res.gridwidth=GridBagConstraints.REMAINDER;
       // res.weightx=0.1;
       // res.weighty=0.3;
        res.anchor = GridBagConstraints.WEST;
        res.fill = GridBagConstraints.BOTH;   
        res.insets = new Insets(20,0 ,0,0);
        this.add(panel3,res);*/
             
        
    }
       
}
