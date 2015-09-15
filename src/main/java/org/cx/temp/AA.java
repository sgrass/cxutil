package org.cx.temp;


class Demo{
	private String name = "HELLO WORLD!!!" ;
	public void fun(final int temp){
		class Inner{
			public void print(){
				System.out.println("temp = " + temp) ;
				System.out.println("name = " + name) ;
			}
		}
		new Inner().print() ;
	}
};


public class AA {
	public static void main(String[] args) {
//		new Demo().fun(30) ;
		int arr[] = {49,4,12,16,69};
		for (int i=0; i<arr.length; i++) {
			for (int j=arr.length-1; j>i; j--) {
				if (arr[j] < arr[j-1]) {
					int tmp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = tmp;
				}
			}
		}
		
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
