//esta interfaz muestra el resultado
package proyecto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class segundo extends JFrame{
    JPanel panel;
    JTextField text= new JTextField();
    JLabel ejemplo = new JLabel();


    int pos=0;
    public segundo(LDL P,int aciertos){
        setSize(500, 500);setIconImage( new ImageIcon("continentes.png").getImage());
        setTitle("Adivina la Capital");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        panel= new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.CYAN);
         this.add(panel);
        ImageIcon hom=new ImageIcon("hogar.png");
        JButton menuback = new JButton(""); menuback.setIcon(new ImageIcon(hom.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH))); menuback.setBorderPainted(false); menuback.setBackground(Color.cyan);
        menuback.setBounds(110,220, 100, 100);
        ImageIcon off = new ImageIcon("off.png");
        JButton salirr = new JButton(""); salirr.setIcon(new ImageIcon(off.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH)));  salirr.setBorderPainted(false);salirr.setBackground(Color.cyan);
           salirr.setBounds(265,220, 110, 100);
        if(aciertos==5){
           JLabel tex1= new JLabel("FELICIDADES OBTUVO 5/5 ACIERTOS \n");
           tex1.setBounds(180,-50, 500, 300);
           panel.add(tex1);
        }else{
               JLabel tex2=new JLabel("Obtuvo \n" +aciertos+"/5 aciertos\n");
               tex2.setBounds(170,-50, 500, 300);  
               tex2.setFont(new Font("arial",Font.PLAIN,20));
              panel.add(tex2);
           }
        panel.add(menuback);
        panel.add(salirr);
        ActionListener salir= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }; salirr.addActionListener(salir);
        ActionListener menu= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
          Interfaz ventana = new Interfaz();
               P.limpiar();
                dispose();
                ventana.setVisible(true);
            }
        }; menuback.addActionListener(menu);
    }
}

