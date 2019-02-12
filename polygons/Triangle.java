package DIT952.polygons;

import java.awt.*;

/**
 * Created by Niklas on 2016-01-19.
 */
public class Triangle extends DIT952.polygons.Polygon {
    public Triangle(int x, int y, DrawPolygons drawer) {
        super(x,y,drawer);
    }

    @Override
    public void paint(Graphics g){
        g.drawLine(centerPoint.x, centerPoint.y-10, centerPoint.x-10, centerPoint.y+10);
        g.drawLine(centerPoint.x-10, centerPoint.y+10,
                centerPoint.x+10, centerPoint.y+10);
        g.drawLine(centerPoint.x+10, centerPoint.y+10, centerPoint.x, centerPoint.y-10);
    }
}
