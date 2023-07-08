//ESTA ES LA INTERFAZ PARA ELEGIR CONTINENTE
package proyecto;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class Interfaz extends JFrame{
 JPanel panel;

    public Interfaz(){
    //aqui debo de poner lo de la vetana excepto el visible
   setSize(500, 500);
   setIconImage( new ImageIcon("continentes.png").getImage());
   setTitle("Adivina la Capital");
   setLocationRelativeTo(null);
   componentes();
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
   
    }
    
    private void componentes(){
        panel();
        etiquetas();
        radiobotones();
        
    }
    
    
    private void panel(){
       
        panel= new JPanel(); 
        panel.setLayout(null);
        panel.setBackground(Color.CYAN);
         this.add(panel);
     
    }
    
   
    
     private void etiquetas(){

        JLabel text1=new JLabel("Seleccione un continente, le preguntaremos las"); text1.setFont(new Font("arial",Font.PLAIN,20));text1.setBounds(40,-125, 500, 300); 
        JLabel text2=new JLabel(" capitales de los paises del continente ");text2.setBounds(70,-100, 500, 300);text2.setFont(new Font("arial",Font.PLAIN,20));
        panel.add(text1);panel.add(text2);
     }
     
     
     private void radiobotones(){
        JRadioButton america = new JRadioButton("AMÉRICA",false);
        america.setBounds(190,120,100,50);
        JRadioButton africa = new JRadioButton("ÁFRICA",false);
        africa.setBounds(190,160,100,50);
        JRadioButton asia = new JRadioButton("ASIA",false);
        asia.setBounds(190,200,100,50);
        JRadioButton oceania = new JRadioButton("OCEANÍA",false);
        oceania.setBounds(190,240,100,50);
        JRadioButton euro = new JRadioButton("EUROPA",false);
        euro.setBounds(190,280,100,50);
        
        america.setBackground(Color.orange); africa.setBackground(Color.yellow);asia.setBackground(Color.RED);oceania.setBackground(Color.MAGENTA);euro.setBackground(Color.green); 
        
        panel.add(america);
        panel.add(africa);
        panel.add(asia);
        panel.add(oceania);
        panel.add(euro);
        
        
        ButtonGroup continentes= new ButtonGroup(); 
        continentes.add(america);
        continentes.add(africa);
        continentes.add(asia);
        continentes.add(oceania);
        continentes.add(euro);
        ImageIcon inicio = new ImageIcon("start.png");
       JButton comenzar = new JButton(""); comenzar.setIcon(new ImageIcon(inicio.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH))); comenzar.setBackground(Color.CYAN); comenzar.setBorderPainted(false);
        comenzar.setBounds(105,350, 110, 100); 
        ImageIcon off = new ImageIcon("off.png");
        JButton salirr = new JButton(""); salirr.setIcon(new ImageIcon(off.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH))); salirr.setBackground(Color.CYAN); salirr.setBorderPainted(false);
        salirr.setBounds(265,350, 110, 100);
      
        panel.add(comenzar);
        panel.add(salirr); 

       ActionListener salir= new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        } ;salirr.addActionListener(salir); 
        
    ActionListener Seleccion= new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
        Paises ventana2 = new Paises();
               if(america.isSelected()){
                   
                  ventana2.P.lectura("src/proyecto/America.txt"); //ventana2.panel();
                  ventana2.textPais.setText(ventana2.P.pais(ventana2.pos));
                  ImageIcon ima = new ImageIcon(ventana2.P.direccion(ventana2.pos));
                  Icon icono =new ImageIcon(ima.getImage().getScaledInstance(ventana2.ejemplo.getWidth(),ventana2.ejemplo.getHeight(), Image.SCALE_DEFAULT));
                  ventana2.ejemplo.setIcon(icono);//establece la primera foto de 
                 
                }else if(africa.isSelected()){
                  
                  ventana2.P.lectura("src/proyecto/Africa.txt");
                  ventana2.textPais.setText(ventana2.P.pais(ventana2.pos));
                  ImageIcon ima = new ImageIcon(ventana2.P.direccion(ventana2.pos));
                  Icon icono =new ImageIcon(ima.getImage().getScaledInstance(ventana2.ejemplo.getWidth(),ventana2.ejemplo.getHeight(), Image.SCALE_DEFAULT));
                  ventana2.ejemplo.setIcon(icono);
                  
            }else if(asia.isSelected()){
                 
                  ventana2.P.lectura("src/proyecto/Asia.txt");
                  ventana2.textPais.setText(ventana2.P.pais(ventana2.pos));
                  ImageIcon ima = new ImageIcon(ventana2.P.direccion(ventana2.pos));
                  Icon icono =new ImageIcon(ima.getImage().getScaledInstance(ventana2.ejemplo.getWidth(),ventana2.ejemplo.getHeight(), Image.SCALE_DEFAULT));
                  ventana2.ejemplo.setIcon(icono);
                  
            }else if(oceania.isSelected()){
                  
                  ventana2.P.lectura("src/proyecto/Oceania.txt");
                  ventana2.textPais.setText(ventana2.P.pais(ventana2.pos));
                  ImageIcon ima = new ImageIcon(ventana2.P.direccion(ventana2.pos));
                  Icon icono =new ImageIcon(ima.getImage().getScaledInstance(ventana2.ejemplo.getWidth(),ventana2.ejemplo.getHeight(), Image.SCALE_DEFAULT));
                  ventana2.ejemplo.setIcon(icono);
                  
            }else if(euro.isSelected()){
                 
                  ventana2.P.lectura("src/proyecto/Europa.txt");
                  ventana2.textPais.setText(ventana2.P.pais(ventana2.pos));
                  ImageIcon ima = new ImageIcon(ventana2.P.direccion(ventana2.pos));
                  Icon icono =new ImageIcon(ima.getImage().getScaledInstance(ventana2.ejemplo.getWidth(),ventana2.ejemplo.getHeight(), Image.SCALE_DEFAULT));
                  ventana2.ejemplo.setIcon(icono);
            }
               
                ventana2.setVisible(true);
                dispose();    
          }
                
                          
        } ;
        
        comenzar.addActionListener(Seleccion);
    
 
     
     }
     
    
    
}
