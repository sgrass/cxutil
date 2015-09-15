package org.cx.jobtask;

import java.util.List;
import java.util.TimerTask;

public class Job extends TimerTask {

	private List taskList;

	public Job(List list) {
		this.taskList = list;
	}

	public void doTask() {
		if (taskList != null) {
			for (int i = 0; i < taskList.size()-1; i++) {
				Task task = (Task) taskList.get(i);
				task.doTask();
			}
		}
	}

	public void run() {
		doTask();
	}
}
