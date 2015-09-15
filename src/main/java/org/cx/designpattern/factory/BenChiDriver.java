package org.cx.designpattern.factory;

public class BenChiDriver implements Driver{  
	
  public Car driveCar() {  
      return new BenChiCar();  
  }  
}  