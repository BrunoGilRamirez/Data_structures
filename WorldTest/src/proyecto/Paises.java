//esta es la interfaz donde se muestran las banderas y se insertan las respuestas
package proyecto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Paises extends JFrame{
    JPanel panel; 
    LDL P = new LDL();
    JTextField textPais= new JTextField();
    JLabel ejemplo = new JLabel();

 
     int pos=0;
    public Paises(){
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
       botones();
    }
    
    
  
  
     void panel(){
        panel= new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.CYAN);
         this.add(panel); //panelbotones();
     //panel.add(panelbotones);
    }
    private void botones(){
        ImageIcon eva = new ImageIcon("check.png");
        JButton Botonevaluar = new JButton(""); Botonevaluar.setIcon(new ImageIcon(eva.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH)));Botonevaluar.setBorderPainted(false);Botonevaluar.setBackground(Color.cyan);
        Botonevaluar.setBounds(120,380, 70, 60); 
        ImageIcon hom = new ImageIcon("hogar.png");
        JButton botonregresar = new JButton("Regresar al menu");botonregresar.setIcon(new ImageIcon(hom.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));botonregresar.setBorderPainted(false);botonregresar.setBackground(Color.cyan);
        botonregresar.setBounds(265,380, 70, 70);
        ImageIcon pic = new ImageIcon("flecha.png");//se carga la imagen para usarse de icono
        JButton botonant = new JButton("");botonant.setIcon(new ImageIcon(pic.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); botonant.setBorderPainted(false);//se le agrega un icono 
        botonant.setBounds(20,120, 70, 68); 
        botonant.setBackground(Color.cyan);
        ImageIcon pic1 =new ImageIcon("flecha1.png");   
        JButton botonsig = new JButton(""); botonsig.setIcon(new ImageIcon(pic1.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); botonsig.setBorderPainted(false);
        botonsig.setBackground(Color.cyan);
        botonsig.setBounds(400,120, 70, 68);
        JTextField Respuesta= new JTextField();Respuesta.setBounds(250,335, 140, 30); 
        panel.add(Respuesta);
        panel.add(Botonevaluar); Botonevaluar.setVisible(false);
        panel.add(botonregresar); 
        panel.add(botonant);
        panel.add(botonsig);
        //AQUI EMPIEZAN LOS LISTENER DE LOS BOTONES. las acciones despues de oprimir un boton 
        ActionListener regresarmenu= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Interfaz ventana = new Interfaz();
                P.limpiar();
                dispose();
                ventana.setVisible(true);
                }
        } ; botonregresar.addActionListener(regresarmenu);
        
        ActionListener siguiente= new ActionListener() {//accion del botonsig>>
            @Override
            public void actionPerformed(ActionEvent e) {              
                if(pos==3) {
                    Botonevaluar.setVisible(true);
                    botonsig.setVisible(false);
                }
                if(pos<4){
                    pos++;
                    textPais.setText(P.pais(pos));
                    ImageIcon ima = new ImageIcon(P.direccion(pos));
                    Icon icono =new ImageIcon(ima.getImage().getScaledInstance(ejemplo.getWidth(),ejemplo.getHeight(), Image.SCALE_DEFAULT));
                    ejemplo.setIcon(icono);  
                    String texto = Respuesta.getText();
                    Nodo act=P.actual(pos);
                    act.resp=texto;
                    Nodo act1=P.actual1(pos);

                    if(act1.resp.equals("")){
                        Respuesta.setText("");
                    }else{
                        Respuesta.setText(act1.resp);
                 }
              
                  
            }else{
                 Toolkit.getDefaultToolkit().beep();
                 String texto = Respuesta.getText();
                 Nodo act=P.actual(5);
                 act.resp=texto;
                }
            }
        };botonsig.addActionListener(siguiente);
    
     
        ActionListener anterior= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {             
            
              if(pos==4){
               botonsig.setVisible(true);   
              }  
              if(pos>0){
              pos--;
              textPais.setText(P.pais(pos));    
              ImageIcon ima = new ImageIcon(P.direccion(pos));
              Icon icono =new ImageIcon(ima.getImage().getScaledInstance(ejemplo.getWidth(),ejemplo.getHeight(), Image.SCALE_DEFAULT));
              ejemplo.setIcon(icono);
              Nodo act=P.actual1(pos);
              Respuesta.setText(act.resp);       
            }else{
                    Toolkit.getDefaultToolkit().beep();
                }     
            }          
        }; botonant.addActionListener(anterior);
        
        ActionListener evaluar= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int posi=0;
                posi=P.evaluar();           
                segundo seg=new segundo(P,posi);
                seg.setVisible(true);
                dispose();  
            }             
        }; Botonevaluar.addActionListener(evaluar);
    }
    
    private void etiquetas(){
        JLabel tex1= new JLabel("           Escriba correctamente la capital del pais \n"); tex1.setFont(new Font("arial",Font.PLAIN,20));
        tex1.setBounds(10,-125, 500, 300);
        JLabel tex2=new JLabel("Pais:\n");tex2.setFont(new Font("arial",Font.PLAIN,20));
        tex2.setBounds(100,160, 500, 300);        
        JLabel tex3=new JLabel("Capital:\n");tex3.setFont(new Font("arial",Font.PLAIN,20));
         tex3.setBounds(250,160, 500, 300); 
        panel.add(tex1);
        panel.add(tex2);
        panel.add(tex3);
        textPais.setBounds(100,335, 140, 30); 
        panel.add(textPais);
        ejemplo.setBounds(100, 40, 280, 250);
        panel.add(ejemplo);
    }
    
    
}


