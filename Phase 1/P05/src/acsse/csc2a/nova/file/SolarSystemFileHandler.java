package acsse.csc2a.nova.file;

import java.io.BufferedInputStream;
import java.io.DataInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import acsse.csc2a.nova.models.SolarSystem;


/**
 * 
 */


/**
 * 
 */
public class SolarSystemFileHandler {
		 
	
    public static SolarSystem readLayout(File file){    
    	SolarSystem solar = null;
    	try(FileInputStream input = new FileInputStream(file);
    		BufferedInputStream binput = new BufferedInputStream(input);
    		DataInputStream ois = new DataInputStream(binput);)
    	{
    		
    		//Read the name 
    		String solarName = ois.readUTF();
    		int numberofbodies = ois.readInt();
    		
    		//use the name in the 
    		File textFile = new File("data/" + solarName + ".txt");
    		solar = CelestialBodyFileReader.readSolarSystemFile(textFile);    		
    		
    		for(int i =0; i < numberofbodies; i++)
    		{
    			String cb_name = ois.readUTF();
    			double distance = ois.readDouble();
    			
    			solar.getBodyFromName(cb_name).setDistanceFromParent(distance);
    		}
    		
			/*
			 * while (true) { try { CelestialBody body = (CelestialBody) ois.readObject();
			 * (EOFException e) { break; } }
			 */
            return solar;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
		
		
	
}
