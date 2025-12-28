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
 * @version P05
 */
public class SolarSystem {
    public ArrayList<CelestialBody> getBodies() {
		return bodies;
	}

	public void setBodies(ArrayList<CelestialBody> bodies) {
		this.bodies = bodies;
	}

	private String name;
    private ArrayList<CelestialBody> bodies;

    /**
     * Constructs a SolarSystem with a given name and an initial capacity for celestial bodies.
     *
     * @param name      the name of the solar system
     * @param numBodies the initial capacity for celestial bodies in the solar system
     */
    public SolarSystem(String name) {
        this.name = name;
        this.bodies = new ArrayList<CelestialBody>();
   
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
   
        this.bodies.add(newBody);
    }
    
    public String getName() {
    	return this.name;
    }
    
    public ArrayList<CelestialBody> getCelestialBodies(){
    	return this.bodies;
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
     * Counts the number of CelestialBodies present in the SolarSystem.
     * @return the number of Bodies present in the SolarSystem.
     */
    public int countCelestialBodies() {
    	
    	return bodies.size();
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
        if (bodies.size() != 0) {
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
