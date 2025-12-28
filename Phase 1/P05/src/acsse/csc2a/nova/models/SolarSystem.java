package acsse.csc2a.nova.models;
import java.util.ArrayList;

/**
 * Represents a solar system that contains multiple celestial bodies.
 * <p>
 * A SolarSystem has a name and maintains an array of {@link CelestialBody} objects.
 * It supports adding new celestial bodies and dynamically expands the internal storage as needed.
 * </p>
 * 
 * @author Mr. Orfao
 * @version P03
 */
public class SolarSystem {
    private String name;
    //private CelestialBody[] bodies;
    private ArrayList<CelestialBody> bodies;
    private int bodyIndex;

    /**
     * Constructs a SolarSystem with a given name and an initial capacity for celestial bodies.
     *
     * @param name      the name of the solar system
     * @param numBodies the initial capacity for celestial bodies in the solar system
     */
    public SolarSystem(String name, int numBodies) {
        this.name = name;
        //this.bodies = new CelestialBody[numBodies];
        this.bodies = new ArrayList<>();
        this.bodyIndex = 0;
    }

    /**
     * Adds a new celestial body to the solar system.
     * <p>
     * If the internal array reaches its capacity, it is expanded by one slot to accommodate additional bodies.
     * </p>
     *
     * @param newBody the celestial body to be added
     */
    public void addBody(CelestialBody newBody) {
       /* if (bodyIndex >= bodies.size()) {
            growArray();
        }*/
        //this.bodies[bodyIndex] = newBody;
        this.bodies.add(newBody);
        this.bodyIndex++;
    }
    
    /**
     * Retrieves a celestial body from the solar system by its name.
     *
     * @param name the name of the celestial body to search for
     * @return the {@code CelestialBody} with the matching name, or {@code null} if not found
     */
    public CelestialBody getBodyFromName(String name) {
        for (CelestialBody celestialBody : bodies) {
            if (celestialBody != null && celestialBody.getName().equals(name)) {
                return celestialBody;
            }
        }
        return null;
    }
                    
    /**
	 * @return the bodies
	 */
	public ArrayList<CelestialBody> getCelestialBodies() {
		return bodies;
	}

	/**
	 * @param bodies the bodies to set
	 */
	public void settCelestialBodies(ArrayList<CelestialBody> bodies) {
		this.bodies = bodies;
	}

	
    
    public String getName() {
    	
    	return this.name;
    }
    
    
    /**
     * Dynamically expands the internal array of celestial bodies by one slot.
     */
    /*private void growArray() {
        // Create a new array with one extra slot.
        CelestialBody[] tempArr = new CelestialBody[bodies.length + 1];
        // Copy existing elements into the new array.
        System.arraycopy(bodies, 0, tempArr, 0, bodies.length);
        // Assign the new array back to the instance variable.
        bodies = tempArr;
    }*/
    
    /**
     * Counts the number of CelestialBodies present in the SolarSystem.
     * @return the number of Bodies present in the SolarSystem.
     */
    public int countCelestialBodies() {
    	int count = 0;
    	for(CelestialBody cb : bodies) {
    		if(cb != null) {
    			count ++;
    		}
    	}
    	return count;
    }

    /**
     * Returns a formatted string representation of the solar system and its celestial bodies.
     * <p>
     * The string begins with the solar system's name, followed by each celestial body's details
     * on a new line.
     * </p>
     *
     * @return a string containing the solar system name and its celestial bodies
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(name);
        if (bodyIndex != 0) {
            sb.append("\n");
        }
        for (CelestialBody celestialBody : bodies) {
            if (celestialBody != null) {
                sb.append(String.format("%s%n", celestialBody));
            }
        }
        return sb.toString();
    }
}
