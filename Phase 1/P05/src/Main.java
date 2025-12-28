import java.io.File;



import acsse.csc2a.nova.file.SolarSystemFileHandler;
import acsse.csc2a.nova.models.SolarSystem;


/**
 * Represents the interaction with the classes
 * @author Mr. Orfao
 * @version P04
 */
public class Main {
    public static void main(String[] args) {
        // Reading the binary file
        File binaryFile = new File("data/layout1.dat");
        SolarSystem sol = SolarSystemFileHandler.readLayout(binaryFile);
        // Display the Solar System
        System.out.println(sol);
        //Invoke the Tester.test method
        Tester.test();
    }
}

