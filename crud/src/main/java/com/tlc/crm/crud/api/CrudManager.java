package com.tlc.crm.crud.api;

import com.tlc.commons.code.ErrorCode;
import com.tlc.crm.common.config.AuditEntry;
import com.tlc.crm.common.config.ConfigManager;

import com.tlc.crm.crud.model.Student;
import com.tlc.crm.crud.status.StudentErrorCodes;

import com.tlc.sql.SQLAccess;
import com.tlc.sql.api.DataContainer;
import com.tlc.sql.api.Row;
import com.tlc.sql.api.dml.*;
import com.tlc.sql.api.ds.OrgDataStore;

import java.util.*;

/**
 * Implements crud operation.
 *
 * @author EswariNivethaVU
 */
public class CrudManager implements ConfigManager<Student> {

    private static final Table TABLE = new Table("Student", "studentdata");
    private static final OrgDataStore ORG_DATA_STORE = getOrgDataStore();

    /**
     * Creates instance
     */
    private static class Instance {
        private static final CrudManager INSTANCE = new CrudManager();
    }

    private CrudManager() {
    }

    /**
     * Gets the instance
     */
    public static CrudManager getInstance() {
        return Instance.INSTANCE;
    }

    /**
     * Gets the value of OrgDatastore
     */
    private static final OrgDataStore getOrgDataStore() {
        return SQLAccess.get().getOrgDataStore(Long.valueOf(1));
    }


    /**
     * Inserts data into database
     *
     * @param student
     */
    @Override
    public void create(final Student student) {
        final Row row = new Row(TABLE);
        final DataContainer dataContainer = DataContainer.create();

        row.set("NAME", student.getName());
        row.set("ROLLNUMBER", student.getRollNo());
        row.set("DEPARTMENT", student.getDepartment());
        dataContainer.addNewRow(row);
        ORG_DATA_STORE.commitChanges(dataContainer);
    }

    /**
     * Inserts Collection of data into database
     *
     * @param models
     */
    public void create(final Collection<Student> models) {
        final DataContainer dataContainer = DataContainer.create();

        for (Student student : models) {
            final Row row = new Row(TABLE);

            row.set("NAME", student.getName());
            row.set("ROLLNUMBER", student.getRollNo());
            row.set("DEPARTMENT", student.getDepartment());
            dataContainer.addNewRow(row);
            ORG_DATA_STORE.commitChanges(dataContainer);
        }
    }

    /**
     * Updates the student data into database
     *
     * @param student
     */
    @Override
    public void update(final Student student) {

        if (exists(student)) {
            final Row row = new Row(TABLE, student.id());
            final DataContainer dataContainer = DataContainer.create();

            row.set("NAME", student.getName());
            row.set("ROLLNUMBER", student.getRollNo());
            row.set("DEPARTMENT", student.getDepartment());
            dataContainer.updateRow(row);
            ORG_DATA_STORE.commitChanges(dataContainer);
        } else {
            throw ErrorCode.get(StudentErrorCodes.ID_NOT_FOUND);
        }
    }

    /**
     * Deletes the student data from database
     *
     * @param student
     */
    @Override
    public void delete(final Student student) {

        if (exists(student)) {
            delete(List.of(student));
        } else {
            throw ErrorCode.get(StudentErrorCodes.ID_NOT_FOUND);
        }
    }

    /**
     * Checks the existence of student data.
     *
     * @param student
     */
    @Override
    public boolean exists(final Student student) {
        return (ORG_DATA_STORE.get(TABLE, student.id()) != null) ? true : false;
    }

    /**
     * Deletes the student data from database
     *
     * @param students
     */
    @Override
    public void delete(final Collection<Student> students) {
        final Collection<Long> id = new HashSet<>();

        students.forEach(model -> id.add(model.id()));
        ORG_DATA_STORE.delete(TABLE, id);
    }

    /**
     * Gets data from database
     *
     * @param id
     */
    @Override
    public Student partialGet(final Long id) {
        final Student student = new Student();

        student.setId(id);
        return student;
    }

    /**
     * Gets the data from database by using id
     *
     * @param id
     */
    @Override
    public Student get(final Long id) {
        final Student student = new Student();
        final Row row = ORG_DATA_STORE.get(TABLE, id);

        student.setId(row.get("ID"));
        student.setName(row.get("NAME"));
        student.setRollNo(row.get("ROLLNUMBER"));
        student.setDepartment(row.get("DEPARTMENT"));

        return student;
    }

    @Override
    public Collection<Student> get(final Collection<Long> id) {
        return null;
    }

    @Override
    public AuditEntry auditEntry(final Student student) {
        return null;
    }
}