package org.cx.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
	
	/**
	 * 统计两个时间段内工作日总数
	 * @throws ParseException
	 */
	public void totalWorkDays() throws ParseException {
    int workdays = 0; //工作天数
    int holiday = 0;  //假期
    
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //开始日期
    Date dateBefore = dateFormat.parse("2007-02-01");
    //结束日期
    Date dateAfter = dateFormat.parse("2007-03-01");
    
    //测试此日期是否在指定日期之前
		while(dateBefore.before(dateAfter)){
			Calendar cal = Calendar.getInstance();
			cal.setTime(dateBefore);
			//进行比较 计算出标准工作日
			if((cal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY)
			        &&(cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)){
			    workdays++;
			} else {
				holiday++;
			}
			//日期加1
		  cal.add(Calendar.DAY_OF_MONTH,1);
		  dateBefore = cal.getTime();
		  cal=null;
		}
	  System.out.println("工作天数是:" + workdays);
	  System.out.println("休息天数是:" + holiday);
	}

	public static void main(String[] args) {
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		//本月第一天
		calendar.setTime(new Date());
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    System.out.println(sdf.format(calendar.getTime()));
    /**********************************/
    
    //本月最后一天
    calendar.setTime(new Date());
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    calendar.add(Calendar.MONTH, 1);
    calendar.add(Calendar.DATE, -1);
    System.out.println(sdf.format(calendar.getTime()));
    /**********************************/
    
    //今天2点0分0秒
    calendar.set(Calendar.HOUR_OF_DAY, 02);
		calendar.set(Calendar.MINUTE, 00);
		calendar.set(Calendar.SECOND, 00);
		Date time = calendar.getTime();
		System.out.println(sdf.format(time));
		/**********************************/
		
		//获取加3后的日期
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_WEEK, 3);
		//转换timestamp
		Timestamp ts = new Timestamp(calendar.getTimeInMillis());
		System.out.println(sdf.format(calendar.getTime())); 
		System.out.println(ts);
		/**********************************/
		
		calendar.setTime(new Date());
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//今天的日期 
		calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+1);//让日期加1   
		System.out.println(sdf.format(calendar.getTime()));//加1之后的日期Top
		/**********************************/
		
		Date d=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");   
		System.out.println("今天的日期："+df.format(d));   
		System.out.println("两天前的日期：" + df.format(new Date(d.getTime() - 2 * 24 * 60 * 60 * 1000)));   
		System.out.println("三天后的日期：" + df.format(new Date(d.getTime() + 3 * 24 * 60 * 60 * 1000)));
	}

}
