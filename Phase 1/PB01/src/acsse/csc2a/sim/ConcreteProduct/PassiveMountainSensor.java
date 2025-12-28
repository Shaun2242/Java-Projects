package acsse.csc2a.sim.ConcreteProduct;

import acsse.csc2a.sim.AbstractProduct.IMountainSensor;
import acsse.csc2a.sim.util.ERegionType;
import acsse.csc2a.sim.util.ESensorType;

public class PassiveMountainSensor implements IMountainSensor{

	@Override
	public void deploy() {
		// TODO Auto-generated method stub
		System.out.println(ESensorType.PASSIVE + " " + ERegionType.MOUNTAIN + " Sensor is monitoring ambient conditions.");		
	}

}
