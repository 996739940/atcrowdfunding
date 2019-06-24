package com.atguigu.ssm.beans;

import java.util.List;

public class Department {

	private Integer id;
	private String deptName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + "]";
	}

	public Department(Integer id, String deptName) {
		super();
		this.id = id;
		this.deptName = deptName;
	}

	public Department() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deptName == null) ? 0 : deptName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (deptName == null) {
			if (other.deptName != null)
				return false;
		} else if (!deptName.equals(other.deptName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
