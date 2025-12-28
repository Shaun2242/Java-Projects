package acsse.csc2a.nova.file;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import acsse.csc2a.nova.models.CelestialBody;
import acsse.csc2a.nova.models.SolarSystem;

public class SolarSystemFileHandler {

	
	public static SolarSystem readLayout(File solarSystemBinFile) {
		
		SolarSystem solarSystem = null;
		String solarSystemTextFileName = "";
		int numBodies = 0;
		String bodyName = "";
		double parentDistance = 0;
		CelestialBody cb = null;
		try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(solarSystemBinFile)))){
			solarSystemTextFileName = dis.readUTF();
			
			//you need to reposition the path to include the data folder
			solarSystem = CelestialBodyFileReader.readSolarSystemFile(new File(String.format("data/%s.txt", solarSystemTextFileName)));
			
			//now that you have your SolarSystem populated, loop through the rest of the file
			numBodies = dis.readInt();
			for(int i=0; i< numBodies; i++) {
				//read the body name
				bodyName = dis.readUTF();
				//parent distance
				parentDistance = dis.readDouble();
				
				cb = solarSystem.getBodyFromName(bodyName);
				if(cb != null) {
					cb.setDistanceFromParent(parentDistance);
				}
				
			}
		}catch(IOException ex) {
			System.err.println(ex);
		}
		
		return solarSystem;
		
	}

}
