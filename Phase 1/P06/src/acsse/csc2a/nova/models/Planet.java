package acsse.csc2a.nova.models;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import acsse.csc2a.nova.pattern.AbstractVisitable;
import acsse.csc2a.nova.pattern.AbstractVisitor;
import acsse.csc2a.nova.pattern.DrawSolarSystemVisitor;

/**
 * Represents a Planet, which is a type of celestial body.
 * <p>
 * A Planet has an additional attribute called habitability,
 * which represents a floating-point value indicating its habitability index.
 * </p>
 * 
 * @author Mr. Orfao
 * @version P05
 */
public  class Planet extends CelestialBody {

    /** The habitability index of the planet. */
    private float habitable;
    
 // Planet: has a habitability float and then its parent name.
 	private final static Pattern PLANET_PATTERN =Pattern.compile(String.format("%s\\d+\\.\\d+\\s+\\w+", BASE_PATTERN));
     
    /**
     * Constructs a Planet with the specified attributes.
     *
     * @param name      the name of the planet (may include square brackets, which are removed)
     * @param radius    the radius of the planet
     * @param colour    the colour of the planet as defined by {@link EColour}
     * @param parent    the parent celestial body of the planet
     * @param habitable the habitability index (float) of the planet
     */
    public Planet(String name, int radius, EColour colour, CelestialBody parent, float habitable) {
        super(name, radius, colour, parent);
        this.habitable = habitable;
        this.orbitSpeed = 10;
    }
    
    /**
     * Validates if the provided line is a Planet representation
     * @param line   the String representation of the Planet (name, colour, radius, habitability, parent)
     */
    public static boolean validate(String line) {
    	Matcher m = PLANET_PATTERN.matcher(line);
    	return m.matches();
    
    }
    
    /**
     * Returns a formatted string representation of the planet.
     * <p>
     * The string includes the planet's details (name, colour, and radius) inherited from
     * {@link CelestialBody}, followed by its habitability index (formatted as a float)
     * and the parent's name (or "none" if no parent exists), with fields separated by TABs.
     * </p>
     *
     * @return a TAB-separated string representation of the planet
     */
    @Override
    public String toString() {
        String parent = (getParent() == null) ? "none" : getParent().getName();
        //use Locale.US for '.' separation of floats
        return String.format(Locale.US,"%s\t%.2f\t%s\t%s\t(%s; %s)", super.toString(), habitable, parent, this.getDistanceFromParent(), this.getxCoord(),this.getyCoord());
    }
    
    /**
     * Retrieves the habitability index of the planet.
     *
     * @return the habitability index as a float
     */
    public float getHabitable() {
        return habitable;
    }
    
    /**
     * Sets the habitability index of the planet.
     *
     * @param habitable the new habitability index to set
     */
    public void setHabitable(float habitable) {
        this.habitable = habitable;
    }
    
    @Override
	public CelestialBody getParent() {
        return this.parent; // or custom logic
    }

	@Override
	public void accept(DrawSolarSystemVisitor visitor) {
		// TODO Auto-generated method stub
		
	}


}
