package shapes;

import java.awt.*;
import java.util.List;
import java.util.*;

/**
 * Created by Niklas on 2016-02-14.
 */
public class Triangle extends Shape {
    public Triangle(int x, int y, int sizeX, int sizeY, double rotation){
        super(x,y);
        this.scale(sizeX,sizeY);
        this.rotate(rotation);
    }
    public Triangle(int x, int y, int sizeX, int sizeY){
        super(x,y);
        this.scale(sizeX,sizeY);
    }
    public Triangle(int x, int y, double rotation){
        super(x,y);
        this.rotate(rotation);
    }
    public Triangle(int x, int y){
        super(x,y);
    }

    private List<Point> getCorners(){
        // DIT952.polygons.Triangle has three corners
        java.util.List<Point> corners = new ArrayList<>(3);

        Point center = getCenterPoint();
        int[][] offsets = {
                { 0,             -getScaleY()*58/100},
                {-getScaleX()/2,  getScaleY()*29/100},
                { getScaleX()/2,  getScaleY()*29/100}
        };

        for (int i = 0; i < 3; i++){
            // start from center, find corner
            Point newCorner = new Point(center.x+offsets[i][0], center.y+offsets[i][1]);


            // rotate by 'getRotation' degrees
            double alpha = Math.toRadians(getRotation());
            double newX = center.x + (newCorner.x - center.x) * Math.cos(alpha) - (newCorner.y - center.y) * Math.sin(alpha);
            double newY = center.y + (newCorner.x - center.x) * Math.sin(alpha) + (newCorner.y - center.y) * Math.cos(alpha);
            newCorner.move((int) newX, (int) newY);

            corners.add(newCorner);
        }
        return corners;
    }

    public void paint(Graphics g){
        java.util.List<Point> corners = getCorners();
        // first and last point should be the same
        corners.add(corners.get(0));
        Point from = null;
        for (Point to : corners){
            if (from != null){
                g.drawLine(from.x, from.y, to.x, to.y);
            }
            from = to;
        }

    }
}

