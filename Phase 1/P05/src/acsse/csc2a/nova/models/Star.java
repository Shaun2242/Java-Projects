package acsse.csc2a.nova.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a Star, which is a type of celestial body with an age attribute.
 * <p>
 * A {@code Star} extends {@link CelestialBody} and includes an additional attribute, {@code age},
 * which represents the star's age.
 * </p>
 * 
 * @author Mr. Orfao
 * @version P04
 */
public class Star extends CelestialBody {
	// Star: has an age integer and then its parent name.
	private final static Pattern STAR_PATTERN = Pattern.compile(String.format("%s\\d+\\s+\\w+", BASE_PATTERN));
    
    /** The age of the star. */
    private int age;
    
    /**
     * Constructs a Star with the specified attributes.
     *
     * @param name   the name of the star (may include square brackets, which are removed)
     * @param radius the radius of the star
     * @param colour the colour of the star as defined by {@link EColour}
     * @param parent the parent celestial body of the star
     * @param age    the age of the star as an integer
     */
    public Star(String name, int radius, EColour colour, CelestialBody parent, int age) {
        super(name, radius, colour, parent);
        this.age = age;
    }
    
    /**
     * Validates if the provided line is a Star representation
     * @param line   the String representation of the Star (name, colour, radius, age, parent)
     */
    public static boolean validate(String line) {
    	Matcher m = STAR_PATTERN.matcher(line);
    	return m.matches();
    
    }
    
    /**
     * Returns a formatted string representation of the star.
     * <p>
     * The output includes the star's details (name, colour, and radius) inherited from
     * {@link CelestialBody}, followed by its age and the parent's name (or "none" if no parent exists),
     * with fields separated by TAB characters.
     * </p>
     *
     * @return a TAB-separated string representation of the star
     */
    @Override
    public String toString() {
        String parent = (getParent() == null) ? "None" : getParent().getName();
        return String.format("%s\t%d\t%s\t%.2f", super.toString(), age, parent,getDistanceFromParent());
    }
    
    /**
     * Retrieves the age of the star.
     *
     * @return the age of the star as an integer
     */
    public int getAge() {
        return age;
    }
    
    /**
     * Sets the age of the star.
     *
     * @param age the new age to set for the star
     */
    public void setAge(int age) {
        this.age = age;
    }
}
