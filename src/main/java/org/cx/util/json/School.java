package org.cx.util.json;

import java.util.List;

public class School {
	private Integer id;
	private String schoolName;
	private List<Student> stuList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public List<Student> getStuList() {
		return stuList;
	}

	public void setStuList(List<Student> stuList) {
		this.stuList = stuList;
	}

	@Override
	public String toString() {
		return "School [id=" + id + ", schoolName=" + schoolName + ", stuList=" + stuList + "]";
	}
}
