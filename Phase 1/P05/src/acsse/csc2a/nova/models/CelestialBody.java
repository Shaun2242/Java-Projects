package acsse.csc2a.nova.models;

/**
 * Represents a celestial body within a solar system.
 * <p>
 * Each celestial body has a name, a colour, and a radius. Optionally, it can have a parent celestial body.
 * The name provided may include square brackets, which are removed during construction.
 * </p>
 * 
 * @author Mr. Orfao
 * @version P04
 */
public abstract class CelestialBody implements IUpdateable {
    private String name;
    private EColour colour;
    private int radius;
    private CelestialBody parent;
    protected double yCoord;
    protected double xCoord;
    protected double distanceFromParent;
    
    // All celestial bodies have the name, colour, and radius.
    protected final static String BASE_PATTERN = "\\[\\w+\\]\\s(RED|GREEN|BLUE|CYAN|MAGENTA|YELLOW)\\s\\d+\\s";

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
     */
    public CelestialBody(String name, int radius, EColour colour, CelestialBody parent) {
        // Remove the brackets from the name
        name = name.replace("[", "");
        name = name.replace("]", "");
        this.name = name;
        this.colour = colour;
        this.radius = radius;
        this.parent = parent;
        this.yCoord = 0.0;
        this.xCoord = 0.0;
    }
    
    
    @Override
    public void update(double time) {  	
    	double rad_conversion = time * Math.PI / 180;
    	this.xCoord = distanceFromParent * Math.cos(rad_conversion);
    	this.yCoord = distanceFromParent * Math.sin(rad_conversion);
    }
    
    
    public double getxCoord() {
    	return this.xCoord;
    }
    
    public double getyCoord() {
    	return this.yCoord;
    }
    
    
    /**
	 * @return the distanceFromParent
	 */
	public double getDistanceFromParent() {
		return distanceFromParent;
	}


	/**
	 * @param distanceFromParent the distanceFromParent to set
	 */
	public void setDistanceFromParent(double distanceFromParent) {
		this.distanceFromParent = distanceFromParent;
	}


	/**
	 * @param yCoord the yCoord to set
	 */
	public void setyCoord(double yCoord) {
		this.yCoord = yCoord;
	}


	/**
	 * @param xCoord the xCoord to set
	 */
	public void setxCoord(double xCoord) {
		this.xCoord = xCoord;
	}


	/**
     * Constructs a {@code CelestialBody} with the specified name, radius, and colour.
     * <p>
     * This constructor assumes that the celestial body has no parent.
     * </p>
     *
     * @param name   the name of the celestial body (may include square brackets which are removed)
     * @param radius the radius of the celestial body
     * @param colour the colour of the celestial body
     */
    public CelestialBody(String name, int radius, EColour colour) {
        this(name, radius, colour, null);
    }

    /**
     * Returns the name of the celestial body.
     *
     * @return the celestial body's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the celestial body.
     *
     * @param name the new name of the celestial body
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the colour of the celestial body.
     *
     * @return the celestial body's colour
     */
    public EColour getColour() {
        return colour;
    }

    /**
     * Sets the colour of the celestial body.
     *
     * @param colour the new colour of the celestial body
     */
    public void setColour(EColour colour) {
        this.colour = colour;
    }

    /**
     * Returns the parent celestial body.
     *
     * @return the parent celestial body, or {@code null} if none exists
     */
    public CelestialBody getParent() {
        return parent;
    }

    /**
     * Sets the parent celestial body.
     *
     * @param parent the celestial body to set as the parent
     */
    public void setParent(CelestialBody parent) {
        this.parent = parent;
    }
    
    /**
     * Returns the radius of the CelestialBody.
     *
     * @return the radius of the CelestialBody.
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Sets the radius of the CelestialBody.
     *
     * @param radius the radius of the CelestialBody.
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * Returns a formatted string representation of the celestial body.
     * <p>
     * The string contains the name, colour, and radius of the celestial body,
     * separated by TAB characters.
     * </p>
     *
     * @return a TAB-separated string representation of the celestial body
     */
    @Override
    public String toString() {
        return String.format("%s\t%s\t%d", name, colour, radius);
    }
    
}
