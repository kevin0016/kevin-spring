package com.itkevin.factory.test.factory;

import com.itkevin.factory.test.Car;

public class DefaultFactory extends AbstractFactory {

	private AudiFactory defaultFactory = new AudiFactory();
	
	public Car getCar() {
		return defaultFactory.getCar();
	}

}
