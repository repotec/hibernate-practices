package com.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "groups")
public class Group {
	@Id
	@Column(name = "group_id")
	private Long groupId;
	
	@Column(name = "group_name")
	private String groupName;

	public Long getGroupId() {
		return groupId;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
	        name = "USER_GROUPS",
	        joinColumns = @JoinColumn(name = "GROUP_ID"),
	        inverseJoinColumns = @JoinColumn(name = "USER_ID")
	)
	private List<User> users = new ArrayList<>();
	
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", groupName=" + groupName + "]";
	}
}
