package acsse.csc2a.nova.pattern;

import acsse.csc2a.nova.models.*;
import acsse.csc2a.nova.util.DrawUtils;
import acsse.csc2a.nova.util.DrawUtils.RenderInfo;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawSolarSystemVisitor implements AbstractVisitor {
	
	  //implement your visit methods. NB, call the following method to get the correct positioning for drawing: RenderInfo i = DrawUtils.locateBody(celestialBody, graphicsContext);

    private GraphicsContext gc;

    public DrawSolarSystemVisitor(GraphicsContext gc) {
        this.gc = gc;
    }

    @Override
    public void visit(Star star) {
        drawBody(star);
    }

    @Override
    public void visit(Planet planet) {
        drawBody(planet);
    }

    @Override
    public void visit(Moon moon) {
        drawBody(moon);
    }


    private void drawBody(CelestialBody body) {
        RenderInfo info = DrawUtils.locateBody(body, gc);
        gc.setFill(DrawUtils.toPaint(body.getEColour()));
        //gc.fillOval(info.getX(), info.getY(), info.getSize(), info.getSize());

        // Draw body name above
        gc.setFill(Color.WHITE);
       // gc.fillText(body.getName(), info.getX(), info.getY() - 5);
    }

	@Override
	public void visit(Comet comet) {
		drawBody(comet);		
	}
}
