//package company.com;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.event.*;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.*;

public class Main extends JPanel implements ActionListener{
    Timer timer;
    int []xpoints= {25,145,145,25};
    int []ypoints= {25,25,115,115};
    int npoints=4;
    double alfa=15.0;
    double radians;
    double centerX=300.0;
    double centerY=300.0;
    Random rand = new Random();


    Main(){
        timer=new Timer(500,this);
    }
    public void paint(Graphics g){
        super.paint(g);
        float r = rand.nextFloat();
        float ga = rand.nextFloat();
        float b = rand.nextFloat();
        Color randomColor = new Color(r, ga, b);
        g.drawPolygon(xpoints,ypoints,npoints);
        g.setColor(randomColor);
        g.fillPolygon(xpoints,ypoints,npoints);

    }

    public void actionPerformed(ActionEvent e) {
        radians=Math.toRadians(alfa);
        double []tempX=new double[4];
        double []tempY=new double[4];
        for(int i=0;i<npoints;i++){
            tempX[i]=(xpoints[i]-centerX)*Math.cos(radians)+(centerY-ypoints[i])*Math.sin(radians)+centerX;
            tempY[i]=(xpoints[i]-centerX)*Math.sin(radians)+(ypoints[i]-centerY)*Math.cos(radians)+(centerY);
            xpoints[i]=(int)(tempX[i]);
            ypoints[i]=(int)(tempY[i]);

        }

        alfa++;
        if(alfa==360){
            alfa=15;
        }
        repaint();
    }




    public static void main(String[] a){
        JFrame window=new JFrame("Laborator5");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main m=new Main();
        window.getContentPane().add(m);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(600,600);
        window.setVisible(true);
        window.repaint();
        m.timer.start();
    }
}
 