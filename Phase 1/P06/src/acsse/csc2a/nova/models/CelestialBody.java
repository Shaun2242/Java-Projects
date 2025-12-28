package acsse.csc2a.nova.models;

import acsse.csc2a.nova.pattern.DrawSolarSystemVisitor;

/**
 * Represents a celestial body within a solar system.
 * <p>
 * Each celestial body has a name, a colour, a radius, and optionally, a parent celestial body.
 * </p>
 * 
 * @author Mr. Orfao
 * @version P05
 */
public abstract class CelestialBody implements IUpdateable {
    private String name;
    private EColour colour;
    private int radius;
    public CelestialBody parent;
    protected final static String BASE_PATTERN = "\\[\\w+\\]\\s(RED|GREEN|BLUE|CYAN|MAGENTA|YELLOW)\\s\\d+\\s";

    private double xCoord;
    private double yCoord;
    private double distanceFromParent;

    private double orbitalPeriod;  // Orbital period in Earth years
    protected double orbitSpeed;   // Orbital speed in degrees per second or radians per second

    /**
     * Constructs a {@code CelestialBody} with the specified name, radius, colour, and parent.
     * <p>
     * If the provided name contains square brackets, they are removed before storing.
     * </p>
     *
     * @param name   the name of the celestial body (may include square brackets which are removed)
     * @param radius the radius of the celestial body
     * @param colour the colour of the celestial body
     * @param parent the parent celestial body; may be {@code null} if none exists
     * @param orbitalPeriod the orbital period in Earth years
     */
    public CelestialBody(String name, int radius, EColour colour, CelestialBody parent, double orbitalPeriod) {
        name = name.replace("[", "").replace("]", "");
        this.name = name;
        this.colour = colour;
        this.radius = radius;
        this.parent = parent;
        this.orbitalPeriod = orbitalPeriod;
    }

    // Additional constructor without orbital period if needed (defaults to 0 or some value)
    public CelestialBody(String name, int radius, EColour colour, CelestialBody parent) {
        this(name, radius, colour, parent, 0);  // Default orbital period to 0 for objects without orbit
    }

    // Getter and Setter methods for name, colour, radius, and parent

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(double orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    /**
     * Calculates the orbit speed based on the orbital period.
     * The speed is in degrees per second.
     *
     * @param EARTH_YEAR_SEC the number of seconds in one Earth year in the simulation
     */
    public void calculateOrbitSpeed(double EARTH_YEAR_SEC) {
        if (this.orbitalPeriod > 0) {
            // Calculate orbital speed in degrees per second
            double simulatedTimeForOneOrbit = this.orbitalPeriod * EARTH_YEAR_SEC;
            this.orbitSpeed = 360.0 / simulatedTimeForOneOrbit; // 360 degrees per full orbit
        } else {
            this.orbitSpeed = 0; // Static, e.g., Sun (no orbit)
        }
    }

    public double getxCoord() {
        return xCoord;
    }

    public void setxCoord(double xCoord) {
        this.xCoord = xCoord;
    }

    public double getyCoord() {
        return yCoord;
    }

    public void setyCoord(double yCoord) {
        this.yCoord = yCoord;
    }

    public double getDistanceFromParent() {
        return distanceFromParent;
    }

    public void setDistanceFromParent(double distanceFromParent) {
        this.distanceFromParent = distanceFromParent;
    }

    @Override
    public void update(double t) {
        t = convertDegreesToRadians(t);
        t = t % (2 * Math.PI);  // Ensure t is within the range (0, 2π)

        // Calculate new coordinates
        this.xCoord = distanceFromParent * Math.cos(t);
        this.yCoord = distanceFromParent * Math.sin(t);
    }

    private static double convertDegreesToRadians(double degrees) {
        return degrees * Math.PI / 180;
    }

    /**
     * Returns a formatted string representation of the celestial body.
     *
     * @return a TAB-separated string representation of the celestial body
     */
    @Override
    public String toString() {
        return String.format("%s\t%s\t%d", name, colour, radius);
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CelestialBody getParent() {
        return parent;
    }

	public abstract void accept(DrawSolarSystemVisitor visitor);

	public EColour getEColour() {
		return colour;
	}

	public void setEColour(EColour colour) {
		this.colour = colour;
	}

	public void setInitialPhase(double nextPlanetAngle) {
		// TODO Auto-generated method stub
		
	}

}
