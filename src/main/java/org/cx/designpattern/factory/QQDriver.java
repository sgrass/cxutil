package org.cx.designpattern.factory;

public class QQDriver implements Driver{  
	
  public Car driveCar() {  
      return new QQCar();  
  }  
} 
