package org.cx.designpattern.builder.mybuilder;

/**
 * 建造模式是将复杂的内部创建封装在内部，对于外部调用的人来说，只需要传入建造者和建造工具，
 * 对于内部是如何建造成成品的，调用者无需关心。
 * 建造模式很象抽象工厂模式，细微的区别的大概只有在反复使用的方能体会。
 * @author caoxiao
 * @create date 2011-5-13
 */
public class TestBuilder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConcreteBuilder builder = new ConcreteBuilder(); //创建一个建造工具
		Director director = new Director( builder ); //创建（建造者）并把建造工具拿给建造者

		director.construct(); //建造者利用工具进行建造
		Product product = builder.getResult(); //取得产品
	}

}
