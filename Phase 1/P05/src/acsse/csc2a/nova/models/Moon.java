package acsse.csc2a.nova.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a Moon, which is a type of celestial body.
 * <p>
 * A Moon has an additional attribute representing its metal composition.
 * The allowed metal values are defined in the nested {@code MoonMetal} enum.
 * </p>
 * 
 * @author Mr. Orfao
 * @version P04
 */
public class Moon extends CelestialBody {

    /**
     * Enum representing the metal types for a Moon.
     */
    public enum MoonMetal {
        IRON, NICKEL, LEAD;
    }
    
    /** The metal composition of the Moon. */
    private MoonMetal metal;
    
    // Moon: has its MOON Metal enum values and then its parent name.
    private final static Pattern MOON_PATTERN = Pattern.compile(String.format("%s(IRON|NICKEL|LEAD)\\s+\\w+", BASE_PATTERN));
    
    /**
     * Constructs a Moon with the specified attributes.
     *
     * @param name   the name of the Moon (may include square brackets, which are removed)
     * @param radius the radius of the Moon
     * @param colour the colour of the Moon as defined by {@link EColour}
     * @param parent the parent celestial body of the Moon
     * @param metal  the metal composition of the Moon
     */
    public Moon(String name, int radius, EColour colour, CelestialBody parent, MoonMetal metal) {
        super(name, radius, colour, parent);
        this.metal = metal;
    }
    
    /**
     * Validates if the provided line is a Moon representation
     * @param line   the String representation of the Moon (name, colour, radius, MOON Metal, parent)
     */
    public static boolean validate(String line) {
    	Matcher m = MOON_PATTERN.matcher(line);
    	return m.matches();
    
    }
    
    /**
     * Returns a formatted string representation of the Moon.
     * <p>
     * The string includes the Moon's details (name, colour, and radius) inherited from
     * {@link CelestialBody}, followed by its metal composition and the parent's name (or "none" if no parent exists),
     * with each field separated by a TAB character.
     * </p>
     *
     * @return a TAB-separated string representation of the Moon
     */
    @Override
    public String toString() {
        String parent = (getParent() == null) ? "None" : getParent().getName();
        return String.format("%s\t%s\t%s\t%.2f", super.toString(), metal, parent, getDistanceFromParent());
    }
    
    /**
     * Retrieves the metal composition of the Moon.
     *
     * @return the metal composition as a {@code MoonMetal}
     */
    public MoonMetal getMetal() {
        return metal;
    }
    
    /**
     * Sets the metal composition of the Moon.
     *
     * @param metal the new metal composition to set
     */
    public void setMetal(MoonMetal metal) {
        this.metal = metal;
    }
}
