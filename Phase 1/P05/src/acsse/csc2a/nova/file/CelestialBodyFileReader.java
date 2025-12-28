package acsse.csc2a.nova.file;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
//import java.util.regex.Pattern;

import acsse.csc2a.nova.models.CelestialBody;
import acsse.csc2a.nova.models.Comet;
import acsse.csc2a.nova.models.EColour;
import acsse.csc2a.nova.models.Moon;
import acsse.csc2a.nova.models.Moon.MoonMetal;
import acsse.csc2a.nova.models.Planet;
import acsse.csc2a.nova.models.SolarSystem;
import acsse.csc2a.nova.models.Star;

/**
 * Handles reading files that contain celestial body arrangement data.
 * <p>
 * The file is expected to contain TAB-separated fields representing the properties
 * of celestial bodies. The first field is the name (enclosed in square brackets),
 * followed by the colour, radius, a unique attribute (depending on the body type), and
 * the name of the parent celestial body.
 * </p>
 * <p>
 * The file supports multiple celestial body types (Star, Planet, Comet, and Moon), each
 * with its own validation pattern.
 * </p>
 *
 * @author Mr. Orfao
 * @version P03
 */
public class CelestialBodyFileReader {

    /**
     * Counts the number of lines in the specified file.
     *
     * @param fileToCount the file whose lines are to be counted
     * @return the number of lines in the file; if the file cannot be read, returns 0
     */
    private static int countLines(File fileToCount) {
        int count = 0;
        Scanner countIn = null;
        try {
            countIn = new Scanner(fileToCount);
            while (countIn.hasNext()) {
                countIn.nextLine();
                count++;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if (countIn != null) {
                countIn.close();
            }
        }
        return count;
    }
   

    /**
     * Reads a solar system file and returns a {@code SolarSystem} object representing the
     * celestial bodies in the file.
     * <p>
     * The file is expected to be in the following TAB-separated format:
     * <pre>
     * CB_NAME	CB_COLOUR	CB_RADIUS	UNIQUE_ATTRIBUTE	CB_PARENT_NAME
     * </pre>
     * where the {@code UNIQUE_ATTRIBUTE} field is:
     * <ul>
     *   <li>An integer (age) for a Star</li>
     *   <li>A float (habitability) for a Planet</li>
     *   <li>A lowercase string (radiation) for a Comet</li>
     *   <li>An enum value (IRON, NICKEL, or LEAD) for a Moon</li>
     * </ul>
     * <p>
     * If the file contains lines that do not match the expected format (e.g., wrong number
     * of tokens or invalid data), those lines are skipped.
     * </p>
     *
     * @param solarFile the name (and path) of the file to be read
     * @return a {@code SolarSystem} object populated with the celestial bodies from the file;
     *         if the file is empty or not found, an empty solar system (or one with no bodies) is returned
     */
    public static SolarSystem readSolarSystemFile(File solarFile) {
        SolarSystem solar = null;
      
        Scanner solarIn = null;
        try {
            // Count lines for efficiency (maximum number of celestial bodies).
            int maxBodies = countLines(solarFile);

            // Derive solar system name from file name (up to the first dot).
            String solarName = solarFile.getName();
            solarName = solarName.substring(0, solarName.indexOf('.'));
            // Create a new solar system with an estimated capacity.
            solar = new SolarSystem(solarName, maxBodies);

            // If the file is empty, return the empty solar system.
            if (maxBodies == 0) return solar;

            solarIn = new Scanner(solarFile);
            String line = "";



            while (solarIn.hasNext()) {
                line = solarIn.nextLine();
                StringTokenizer cbTokenizer = new StringTokenizer(line);

                // Validate line: must have exactly 5 tokens.
                if (!cbTokenizer.hasMoreTokens() || cbTokenizer.countTokens() != 5) {
                    continue;
                }

                String name = cbTokenizer.nextToken();
                String colour = cbTokenizer.nextToken();
                String radius = cbTokenizer.nextToken();
                String attribute = cbTokenizer.nextToken();
                CelestialBody parent = solar.getBodyFromName(cbTokenizer.nextToken());

                // Determine the type of celestial body based on the regex match and add it to the system.
                if (Star.validate(line)) {
                    int age = Integer.parseInt(attribute);
                    solar.addBody(new Star(name, Integer.parseInt(radius), EColour.valueOf(colour), parent, age));
                } else if (Planet.validate(line)) {
                    float habitable = Float.parseFloat(attribute);
                    solar.addBody(new Planet(name, Integer.parseInt(radius), EColour.valueOf(colour), parent, habitable));
                } else if (Comet.validate(line)) {
                    solar.addBody(new Comet(name, Integer.parseInt(radius), EColour.valueOf(colour), parent, attribute));
                } else if (Moon.validate(line)) {
                    MoonMetal metal = MoonMetal.valueOf(attribute);
                    solar.addBody(new Moon(name, Integer.parseInt(radius), EColour.valueOf(colour), parent, metal));
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if (solarIn != null) {
                solarIn.close();
            }
        }
        return solar;
    }
}
