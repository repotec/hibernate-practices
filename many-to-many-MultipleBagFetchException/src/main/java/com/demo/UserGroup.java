package com.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_groups")
public class UserGroup {

	@Id
	@Column(name = "user_id")
	private long userId;
	
	@Column(name = "group_name")
	private String groupName;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "UserGroup [userId=" + userId + ", groupName=" + groupName + "]";
	}
}
