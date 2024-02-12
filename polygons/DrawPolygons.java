package polygons;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class DrawPolygons extends JComponent{
    public ArrayList<Polygon> polygons;
    public boolean direction = true;
    public int ticker = 0;
    public JFrame frame;

    public DrawPolygons(){
        polygons = new ArrayList<>(10);
        // still want definiton of what polygons to be drawn outside constructor
        // constructior takign a list or array of polygons and potentially method for adding polygons
        polygons.add(new Square(50,50,this));
        polygons.add(new Triangle(100,100,this));
        polygons.add(new Rectangle(50,150,this));

    }//constructor

    public void update(){
        ticker++;
        int value = direction ? 10 : -10; // TODO: functional decomposition : updateTravel...(directions)
        for (Polygon p: polygons){ // TODO: functional decomposition : updateAllPolygons(polygons)
            p.updateCenter(p.centerPoint.x+value, p.centerPoint.y+value);
        }
        if (ticker > 10) {// TODO: functional decomposition : tick(), move ticker++; here
            direction = !direction;
            ticker = 0;
        }
    }

    @Override
    public void paint(Graphics g) { // väldefinerad
        for (Polygon currentPolygon : polygons) {
            currentPolygon.paint(g);
        }
    }//paint

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        DrawPolygons polygons = new DrawPolygons();
        polygons.frame = frame;

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(30,30,300,300);
        frame.getContentPane().add(polygons);
        frame.setVisible(true);


        try {// TODO: functional decomposition : pause()
            while (true) {
                Thread.sleep(500);
                polygons.update();
            }
        } catch (InterruptedException e) {}

    }//main

}//DIT952.polygons.DrawPolygons