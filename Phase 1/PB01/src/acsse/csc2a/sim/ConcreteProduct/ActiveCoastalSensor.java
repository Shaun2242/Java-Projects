package acsse.csc2a.sim.ConcreteProduct;

import acsse.csc2a.sim.AbstractProduct.ICoastalSensor;
import acsse.csc2a.sim.util.ERegionType;
import acsse.csc2a.sim.util.ESensorType;

public class ActiveCoastalSensor implements ICoastalSensor{

	@Override
	public void deploy() {
		// TODO Auto-generated method stub
		System.out.println(ESensorType.ACTIVE + " " + ERegionType.COASTAL + " Sensor is measuring wave dynamics.");		
	}

}
