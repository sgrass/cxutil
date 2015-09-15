package org.cx.jobtask;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.servlet.http.HttpServlet;

public class JobServlet extends HttpServlet {
	private Timer timer;

	/**
	 * void cancel() 终止此计时器，丢弃所有当前已安排的任务。 
	 * void schedule(TimerTask task, Date time) 安排在指定的时间执行指定的任务。
	 * void schedule(TimerTask task, Date firstTime, long period) 安排指定的任务在指定的时间开始进行重复的固定延迟执行。 
	 * void schedule(TimerTask task, long delay) 安排在指定延迟后执行指定的任务。 
	 * void schedule(TimerTask task, long delay, long period) 安排指定的任务从指定的延迟后开始进行重复的固定延迟执行。 
	 * void scheduleAtFixedRate(TimerTask task, Date firstTime, long period) 安排指定的任务在指定的时间开始进行重复的固定速率执行。 
	 * void scheduleAtFixedRate(TimerTask task, long delay, long period) 安排指定的任务在指定的延迟后开始进行重复的固定速率执行。
	 */
	
	
	/**
	 * 初始化是设置每天的某个时间开始执行getJob
	 */
	public void init() {
		timer = new Timer();
		
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(Calendar.HOUR_OF_DAY, 11);
//		calendar.set(Calendar.MINUTE, 35);
//		calendar.set(Calendar.SECOND, 0);
//		Date time = calendar.getTime();
		
//		timer.schedule(getJob(), time);
		
		timer.schedule(getJob(), 0,50000);
	}

	public void destroy() {
		if (timer != null) {
			timer.cancel();
		}
	}

	private Job getJob() {
		List list = new ArrayList();
		list.add(new Test());
		Job job = new Job(list);
		return job;
	}
}
