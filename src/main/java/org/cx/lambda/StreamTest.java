package org.cx.lambda;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 数据流基本操作
 * 获取一个数据源（source）-> 数据转换 -> 执行操作获取想要的结果，每次转换原有 Stream 对象不改变，返回一个新的 Stream 对象（可以有多次转换）
 *
 *
 * 获取方式
 * 集合中获取	            {@link Collection#stream()}
 * 集合中获取	            {@link Collection#parallelStream()}
 * 数组中获取	            {@link Arrays#stream(Object[])}
 * 数组中获取	            {@link Stream#of(Object)}
 *
 * BufferedReader获取	{@link BufferedReader#lines()}
 *
 * 静态工厂		        {@link java.util.stream.IntStream#range(int, int)}
 *
 * Random		        {@link Random#ints()}
 *
 */
public class StreamTest {

    private static List<Mobile> mobileList = new ArrayList<Mobile>() {
        {add(new Mobile("aaa", 100));}

        {add(new Mobile("ccc", 800));}

        {add(new Mobile("bbb", 300));}
    };

    /**
     * 提取
     */
    public static void extract() {
        //提取对象中某个字段
        Set<String> set = mobileList.stream().map(Mobile::getMobileBrand).collect(Collectors.toSet());
        List<Integer> priceList = mobileList.stream().map(Mobile::getPrice).collect(Collectors.toCollection(ArrayList<Integer>::new));
        System.out.println(set);


        //split提取 重新拼接为上海,天津
        String cityName = Stream.of(StringUtils.split("2:上海;3:天津", ";"))
                .map(str -> StringUtils.split(str, ":")[1]).collect(Collectors.joining(","));
        System.out.println(cityName);


        //转换为大写
        List<String> list = Stream.of("a", "helllo", "c", "d", "999aaa").map(string -> string.toUpperCase()).collect(Collectors.toList());
        list.stream().forEach(System.out::println);

        //找出以数字开头的字符串
        List<String> withNumber = list.stream().filter(value -> Character.isDigit(value.charAt(0))).collect(Collectors.toList());
        withNumber.stream().forEach(str -> System.out.println("数字开头的:" + str));


        //前两个
        mobileList.stream().limit(2).forEach(System.out::println);
        //前两个之后的
        mobileList.stream().skip(2).forEach(System.out::println);
    }

    /**
     * 循环
     */
    public static void loop() {
        //转换为list set
        List<String> list = Stream.of("aaa", "bbb", "3ccc", "4ddd", "eee", "fff").collect(Collectors.toList());
        Set<String> set = Stream.of("aaa", "bbb", "3ccc", "4ddd", "eee", "fff").collect(Collectors.toSet());
        System.out.println(list.stream().count());
        set.forEach(System.out::println);

        mobileList.stream().forEach(mobile -> {
            System.out.println(mobile.toString());
        });
    }

    /**
     * 循环map
     */
    public static void loopMap() {
        Map<String, String> map = new TreeMap<String, String>();
        map.put("nickName", "babc");
        map.put("headImg", "aacb");
        map.put("uid", "qf4s");
        map.put("origin", "145");
        map.forEach((k, v) -> System.out.printf("key:%s --- value:%s %n", k, v));
    }

    /**
     * java8提供新的方法comparing，方便的实现一个比较器，这个方法接受一个函数并返回另一个函数
     */
    public static void compare() {
        //找出价钱最便宜的手机对象
        Mobile mobile = mobileList.stream().min(Comparator.comparing(mob -> mob.getPrice())).get();
        System.out.println("最便宜的:" + mobile.toString());

        //大于200的
        mobileList.stream().filter(m -> (m.getPrice() > 200)).forEach(m -> System.out.printf("大于200的mobile:%s %n", m));
    }

    /**
     * flatMap多个转换成一个   合并list
     */
    public static void mergeList() {
        List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4, 5)).flatMap(numbers -> numbers.stream()).collect(Collectors.toList());
        together.forEach(System.out::println);
    }

    /**
     * 排序
     */
    public static void sort() {
        Set<Integer> number = new HashSet<Integer>(Arrays.asList(4, 3, 5, 2, 1));
        List<Integer> sortNumber = number.stream().sorted().collect(Collectors.toList());
        sortNumber.stream().forEach(str -> System.out.println(str));


        //limit在sorted之前时，并不知道排序顺序
        mobileList.stream().sorted((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()))
                .limit(2).collect(Collectors.toList()).forEach(System.out::println);
    }

    /**
     * reduce 累加 拼接
     * 第一个参数identity 起始值存在时返回具体对象，不存在时返回{@link Optional}
     */
    public static void reduceTest() {
        //identity 起始值0
        int count = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);
        Integer sum = Stream.of(1, 2, 3).reduce(0, Integer::sum);
        System.out.println(count);

        // 字符串连接，concat = "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce(String::concat).get();
        System.out.println(concat);

        //等差数列  和generate相似，必须用limit限制大小
        Stream.iterate(0, n -> n + 3).limit(10).forEach(x -> System.out.print(x + " "));
    }

    /**
     * 单个判断 集合判断
     */
    public static void optional() {
        String text = "";
        //jdk8
        Integer status = Optional.ofNullable(text).map(String::length).orElse(-1);
        System.out.println(status);
        //pre jdk8
        int status1 = text != null ? text.length() : -1;


        //jdk8
        Optional.ofNullable(text).ifPresent(System.out::println);
        //pre jdk8
        if (text != null) {
            System.out.println(text);
        }


        boolean flag = mobileList.stream().allMatch(p -> p.getPrice() > 100);
        boolean flag2 = mobileList.stream().anyMatch(p -> p.getPrice() > 100);
        boolean flag3 = mobileList.stream().noneMatch(p -> p.getPrice() < 100);
        System.out.println(flag);
        System.out.println(flag2);
        System.out.println(flag3);
    }

    public static void newThread() {
        new Thread(() -> System.out.println("Hello world !")).start();
    }

    /**
     * 实现 {@link Supplier} 接口生成流
     * Supplier实例传递给 Stream.generate() 生成的 Stream，默认是串行（相对 parallel 而言）但无序的（相对 ordered 而言）。
     * 由于它是无限的，在管道中，必须利用 limit 之类的操作限制 Stream 大小。
     */
    public static void generate() {
        Random seed = new Random();
        Supplier<Integer> random = seed::nextInt;
        Stream.generate(random).limit(10).forEach(System.out::println);


        //生成10个mobile 输出
        Stream.generate(new MobileSupplier()).limit(10).
                forEach(p -> System.out.printf("%s, %s %n", p.getMobileBrand(), p.getPrice()));

    }

    /**
     * 分组
     */
    public static void groupby() {
        //生成10个mobile 根据mobileBrand分组
        Stream.generate(new MobileSupplier()).limit(10).collect(Collectors.groupingBy(Mobile::getMobileBrand))
                .entrySet().forEach(System.out::println);

        //根据条件分组 分别价格大于100和小于100的
        Map<Boolean, List<Mobile>> map = Stream.generate(new MobileSupplier()).limit(10)
                .collect(Collectors.partitioningBy(p -> p.getPrice() > 100));
        System.out.println("true-->" + map.get(true));
        System.out.println("false-->" + map.get(false));
    }

    public static void main(String[] args) {
//		extract();
//		loop();
//		loopMap();
//		mergeList();
//		sort();
//		compare();
//		reduceTest();
//		optional();
//        generate();
//        groupby();

    }


}
