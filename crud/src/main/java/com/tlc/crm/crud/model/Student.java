package com.tlc.crm.crud.model;

import com.tlc.crm.crud.validation.Department;
import com.tlc.crm.crud.validation.Name;
import com.tlc.validator.TlcModel;
import com.tlc.validator.type.Group.Update;
import com.tlc.validator.type.Group.Create;
import jakarta.validation.constraints.NotNull;

/**
 * Student model to get and set data.
 *
 * @author EswariNivethaVU
 */
public class Student implements TlcModel {

    private Long id;

    @Name(groups = {Create.class, Update.class})
    private String name;

    @NotNull(groups = {Create.class, Update.class})
    private Integer rollNo;

    @Department(groups = {Create.class, Update.class})
    private String department;

    public Student(Long id, String name, Integer rollNo, String department) {
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.department = department;
    }

    public Student() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public Long id() {
        return id;
    }

    @Override
    public Long orgId() {
        return null;
    }

    @Override
    public Object identity() {
        return null;
    }
}
