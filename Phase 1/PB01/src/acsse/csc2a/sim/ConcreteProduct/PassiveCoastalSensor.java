package acsse.csc2a.sim.ConcreteProduct;

import acsse.csc2a.sim.AbstractProduct.ICoastalSensor;
import acsse.csc2a.sim.util.ERegionType;
import acsse.csc2a.sim.util.ESensorType;

public class PassiveCoastalSensor implements ICoastalSensor {

	@Override
	public void deploy() {
		// TODO Auto-generated method stub
		System.out.println(ESensorType.PASSIVE + " " + ERegionType.COASTAL + " Sensor is monitoring ambient conditions.");
		
	}

}
