package acsse.csc2a.nova.gui;

import acsse.csc2a.nova.models.SolarSystem;
import acsse.csc2a.nova.models.CelestialBody;
import acsse.csc2a.nova.pattern.DrawSolarSystemVisitor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Canvas class responsible for rendering the SolarSystem using a Visitor pattern.
 */
public class SolarSystemDisplayCanvas extends Canvas {

    private SolarSystem solarSystem;
    private final GraphicsContext gc;
    private DrawSolarSystemVisitor visitor;

    /**
     * Constructor that sets the canvas dimensions and caches the GraphicsContext.
     * @param width Width of the canvas.
     * @param height Height of the canvas.
     */
    public SolarSystemDisplayCanvas(int width, int height) {
        // Set the width and height
        setWidth(width);
        setHeight(height);

        // Cache your graphics context
        this.gc = getGraphicsContext2D();
    }

    /**
     * Sets the current SolarSystem and initializes the visitor.
     * @param ss The SolarSystem to display.
     */
    public void setSolarSystem(SolarSystem ss) {
        // Set your solarSystem
        this.solarSystem = ss;

        // Create your visitor
        this.visitor = new DrawSolarSystemVisitor(gc);

        // Draw your canvas
        redrawCanvas();
    }

    /**
     * Redraws the canvas by painting the background and drawing celestial bodies.
     */
    public void redrawCanvas() {
        // Draw the background (space is black)
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, getWidth(), getHeight());

        // Draw the SolarSystem using your visitor
        if (solarSystem != null) {
            for (CelestialBody body : solarSystem.getCelestialBodies()) {
                body.accept(visitor); // Visit each CelestialBody to draw it
            }
        }
    }
}


