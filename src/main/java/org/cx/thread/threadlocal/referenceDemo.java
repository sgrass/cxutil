package org.cx.thread.threadlocal;

import org.apache.xpath.operations.String;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 强软弱虚引用
 * @author grass
 * @date 2017/10/28
 */
public class referenceDemo {
    public static void main(String[] args) {
        //强引用 只要有引用指向 就算内存不足时 报出out of memory也不会释放资源
        String str = new String();


        /**
         * sofReference引用 内存不足时才会考虑被回收，不容易造成内存溢出
         * 软引用可以和一个引用队列（ReferenceQueue）联合使用，如果软引用所引用的对象被垃圾回收，
         * Java虚拟机就会把这个软引用加入到与之关联的引用队列中。
         */
        List<String> list = new ArrayList<String>();
        SoftReference<List<String>> softReference= new SoftReference<List<String>>(new ArrayList<String>());
        list = softReference.get();

        //弱引用 每次gc就会回收
        WeakReference<String> weakReference = new WeakReference<String>(str);
        String st1 = weakReference.get(); //获取弱引用数据


        /**
         * PhantomReference虚引用
         * 如果一个对象仅持有 虚引用，那就和没有任何引用一样，在任何时候都可能被垃圾回收器回收。
         * 不会影响对象的生命周期的引用，回收后会加入引用队列，用在标识对象回收后应该触发什么动作
         * 虚引用主要用来跟踪对象被垃圾回收器回收的活动。虚引用必须和引用队列（ReferenceQueue）联合使用。
         */
        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference pr = new PhantomReference(new String(), queue);
    }
}
