package org.cx.designpattern.builder.mybuilder;

public interface Builder {
	
	// 创建部件A　　比如创建汽车车轮
	void buildPartA();

	// 创建部件B 比如创建汽车方向盘
	void buildPartB();

	// 创建部件C 比如创建汽车发动机
	void buildPartC();

	Product getResult(); // 返回这个产品

}
