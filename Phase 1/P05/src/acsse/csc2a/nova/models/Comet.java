package acsse.csc2a.nova.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a comet, which is a type of celestial body characterized by its radiation attribute.
 * <p>
 * A {@code Comet} extends {@link CelestialBody} and includes a unique radiation property.
 * The radiation is typically represented as a lowercase string.
 * </p>
 * 
 * @author Mr. Orfao
 * @version P04
 */
public class Comet extends CelestialBody {

    /** The radiation attribute of the comet. */
    private String radiation;
 // Comet: has a radiation string (lowercase) and then its parent name.
    private final static Pattern COMET_PATTERN = Pattern.compile(String.format("%s[a-z]+\\s+\\w+", BASE_PATTERN));
    
    /**
     * Constructs a {@code Comet} with the specified name, radius, colour, parent celestial body, and radiation.
     * <p>
     * The name may include square brackets, which are removed by the superclass constructor.
     * </p>
     *
     * @param name      the name of the comet
     * @param radius    the radius of the comet
     * @param colour    the colour of the comet, represented by an {@link EColour}
     * @param parent    the parent celestial body of the comet, or {@code null} if none exists
     * @param radiation the radiation attribute of the comet (should be a lowercase string)
     */
    public Comet(String name, int radius, EColour colour, CelestialBody parent, String radiation) {
        super(name, radius, colour, parent);
        this.radiation = radiation;
    }
    
    /**
     * Validates if the provided line is a Comet representation
     * @param line   the String representation of the Comet (name, colour, radius, radiation, parent)
     */
    public static boolean validate(String line) {
    	Matcher m = COMET_PATTERN.matcher(line);
    	return m.matches();
    
    }
    
   
    /**
     * Retrieves the radiation attribute of the comet.
     *
     * @return the radiation attribute as a {@code String}
     */
    public String getRadiation() {
        return radiation;
    }
    
    /**
     * Sets the radiation attribute of the comet.
     *
     * @param radiation the new radiation attribute to set
     */
    public void setRadiation(String radiation) {
        this.radiation = radiation;
    }
    
    /**
     * Returns a formatted string representation of the comet.
     * <p>
     * The output includes the celestial body's details (name, colour, and radius) followed by
     * the comet's radiation attribute and the parent celestial body's name (or "none" if no parent exists),
     * all separated by TAB characters.
     * </p>
     *
     * @return a TAB-separated string representing the comet
     */
    @Override
    public String toString() {
        String parent = (getParent() == null) ? "None" : getParent().getName();
        return String.format("%s\t%s\t%s\t%.2f", super.toString(), radiation, parent,getDistanceFromParent());
    }
    
}
