package acsse.csc2a.sim.ConcreteProduct;

import acsse.csc2a.sim.AbstractProduct.IMountainSensor;
import acsse.csc2a.sim.util.ERegionType;
import acsse.csc2a.sim.util.ESensorType;

public class ActiveMountainSensor implements IMountainSensor {

	@Override
	public void deploy() {
		// TODO Auto-generated method stub
		System.out.println(ESensorType.ACTIVE + " " + ERegionType.MOUNTAIN + " Sensor is deploying seismic pulses.");
		
	}

}
