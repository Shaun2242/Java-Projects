package acsse.csc2a.sim.ConcreteFactory;

import acsse.csc2a.sim.AbstractFactory.ISensorFactory;
import acsse.csc2a.sim.AbstractProduct.ICoastalSensor;
import acsse.csc2a.sim.AbstractProduct.IDesertSensor;
import acsse.csc2a.sim.AbstractProduct.IMountainSensor;
import acsse.csc2a.sim.ConcreteProduct.ActiveCoastalSensor;
import acsse.csc2a.sim.ConcreteProduct.ActiveDesertSensor;
import acsse.csc2a.sim.ConcreteProduct.ActiveMountainSensor;

public class ActiveSensorFactory implements ISensorFactory{

	@Override
	public ICoastalSensor createCoastalSensor() {
		// TODO Auto-generated method stub
		return new ActiveCoastalSensor();
	}

	@Override
	public IDesertSensor createDesertSensor() {
		// TODO Auto-generated method stub
		return new ActiveDesertSensor();
	}

	@Override
	public IMountainSensor createMountainSensor() {
		// TODO Auto-generated method stub
		return new ActiveMountainSensor();
	}
}
