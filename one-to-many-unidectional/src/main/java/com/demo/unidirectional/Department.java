package com.demo.unidirectional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department  {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "department_id")
    private List<Employee> employees;

    public void addEmployee(Employee employee) {
        if(employees == null){
            this.employees = new ArrayList<>();
        }else {
            this.employees.add(employee);
        }
    }
}
