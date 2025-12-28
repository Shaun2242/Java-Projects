package acsse.csc2a.nova.gui;

import java.io.File;

import acsse.csc2a.nova.file.SolarSystemFileHandler;
import acsse.csc2a.nova.models.CelestialBody;
import acsse.csc2a.nova.models.SolarSystem;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * VBox-based GUI component to display and animate a SolarSystem.
 */
public class SolarSystemDisplayBox extends VBox {
    private SolarSystem solarSystem;
    private MenuBar menuBar;
    private SolarSystemDisplayCanvas solarCanvas;
    private AnimationTimer timer;
    private long lastFrameTime = 0;

    private final double SLOW_DOWN_FACTOR = 0.8;     // Slow-motion tuning
    private final double EARTH_YEAR_SEC = 10.0;      // Seconds per Earth year (for orbit speed)

    /**
     * Constructor for the SolarSystemDisplayBox.
     * @param width  Width of the display canvas.
     * @param height Height of the display canvas.
     */
    public SolarSystemDisplayBox(int width, int height) {
        // Inherit VBox and create the SolarSystem display Canvas
        solarCanvas = new SolarSystemDisplayCanvas(width, height);

        // Create the menu bar
        CreateMenuBar();

        // Add children to VBox
        this.getChildren().addAll(menuBar, solarCanvas);

        // Stretch the canvas vertically
        VBox.setVgrow(solarCanvas, Priority.ALWAYS);

        // Animation timer (do not change)
        this.timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (solarSystem != null) {
                    if (lastFrameTime > 0) {
                        long deltaNanos = now - lastFrameTime;
                        double deltaSeconds = deltaNanos / 1_000_000_000.0;

                        double adjustedDelta = deltaSeconds * SLOW_DOWN_FACTOR;

                        for (CelestialBody body : solarSystem.getCelestialBodies()) {
                            body.update(adjustedDelta);
                        }
                    }
                    solarCanvas.redrawCanvas();
                }
                lastFrameTime = now;
            }
        };
    }

    /**
     * Starts the animation timer (simulation).
     */
    private void StartSimulation() {
        timer.start();
    }

    /**
     * Stops the animation timer (simulation).
     */
    private void StopSimulation() {
        timer.stop();
    }

    /**
     * Creates and initializes the menu bar and menu items.
     */
    private void CreateMenuBar() {
        menuBar = new MenuBar();

        // File Menu
        Menu fileMenu = new Menu("File");
        MenuItem loadLayout = new MenuItem("Load Layout File");

        loadLayout.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Solar System Layout File");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
            File selectedFile = fileChooser.showOpenDialog(new Stage());

            if (selectedFile != null) {
                SolarSystem ss = SolarSystemFileHandler.readLayout(selectedFile);
                if (ss != null) {
                    this.solarSystem = ss;
                    setupSolarCanvas(ss);
                }
            }
        });

        fileMenu.getItems().add(loadLayout);

        // Simulation Menu
        Menu simMenu = new Menu("Simulation");

        MenuItem startSim = new MenuItem("Start");
        startSim.setOnAction(e -> StartSimulation());

        MenuItem stopSim = new MenuItem("Stop");
        stopSim.setOnAction(e -> StopSimulation());

        simMenu.getItems().addAll(startSim, stopSim);

        // Add menus to menu bar
        menuBar.getMenus().addAll(fileMenu, simMenu);
    }

    /**
     * Prepares and configures the solar system model before display (do not change).
     * @param solarSystem The solar system to be visualized.
     */
    private void setupSolarCanvas(SolarSystem solarSystem) {
        for (CelestialBody cb : solarSystem.getCelestialBodies()) {
            cb.calculateOrbitSpeed(EARTH_YEAR_SEC);
        }

        double planetStep = 360.0 /
                solarSystem.getCelestialBodies().stream()
                        .filter(cb -> cb.getParent() != null &&
                                      cb.getParent().getParent() == null) // planets only
                        .count();

        double nextPlanetAngle = 0.0;

        for (CelestialBody cb : solarSystem.getCelestialBodies()) {
            if (cb.getParent() == null) {          // Sun
                cb.setInitialPhase(0);
            } else if (cb.getParent().getParent() == null) { // planets
                cb.setInitialPhase(nextPlanetAngle);
                nextPlanetAngle += planetStep;
            } else {                               // moons or others
                cb.setInitialPhase(Math.random() * 360.0);
            }
        }

        // show on canvas
        solarCanvas.setSolarSystem(solarSystem);
    }
}
