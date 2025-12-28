package acsse.csc2a.sim.ConcreteProduct;

import acsse.csc2a.sim.AbstractProduct.IDesertSensor;
import acsse.csc2a.sim.util.ERegionType;
import acsse.csc2a.sim.util.ESensorType;

public class ActiveDesertSensor implements IDesertSensor{

	@Override
	public void deploy() {
		// TODO Auto-generated method stub
		System.out.println(ESensorType.ACTIVE + " " + ERegionType.DESERT + " Sensor is probing sand composition.");
		
	}

}
