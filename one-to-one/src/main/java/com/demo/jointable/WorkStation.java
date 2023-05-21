package com.demo.jointable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "workstation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkStation {
	@Id
    @Column(name = "id")
    private Long id;
	
    @Column(name = "floor")
    private Integer floor;
	
	@OneToOne(mappedBy = "workStation")
    private Employee employee;
}
