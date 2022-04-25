package com.tlc.crm.crud.action;

import com.tlc.commons.json.Json;
import com.tlc.commons.json.JsonArray;
import com.tlc.commons.json.JsonObject;

import com.tlc.crm.common.action.secure.CrmConfigAction;
import com.tlc.crm.common.config.ConfigManager;
import com.tlc.crm.crud.api.CrudManager;
import com.tlc.crm.crud.model.Student;
import com.tlc.crm.crud.validation.HibernateValidation;

import com.tlc.validator.type.Group.Create;
import com.tlc.validator.type.Group.Update;
import com.tlc.web.WebAction;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Data from API is implemented.
 *
 * @author EswariNivethaVU
 */
@WebAction(path = "/student/mgmt")
public class StudentManagement extends CrmConfigAction<Student> {

    @Override
    public ConfigManager getConfigManager() {
        return CrudManager.getInstance();
    }

    /**
     * Converts JsonObject to Student Object
     *
     * @param jsonObject
     * @return Student
     */
    @Override
    public Student construct(final JsonObject jsonObject) {
        final Long id = jsonObject.optLong("id", 0);
        final String name = jsonObject.optString("name", null);
        final Integer rollNo = jsonObject.optInt("rollNo", 0);
        final String department = jsonObject.optString("department", null);

        final Student student = new Student(id, name, rollNo, department);
        final String type = jsonObject.getString("type");

        if (type.equals("create") || type.equals("update")) {
            HibernateValidation.validator(student, getGroups(type));
        }
        return student;
    }

    /**
     * Passing Collection of json object and converted to student list
     *
     * @param data
     * @return studentList
     */
    public Collection<Student> constructArray(final JsonObject data) {
        final Collection<Student> studentList = new ArrayList<>();
        final JsonArray dataJsonArray = data.getJsonArray("data");
        final String type = data.getString("type");

        for (int i = 0; i < dataJsonArray.size(); i++) {
            final JsonObject jsonObject = dataJsonArray.getJsonObject(i);
            final Long id = jsonObject.optLong("id", 0);
            final String name = jsonObject.optString("name", null);
            final Integer rollNo = jsonObject.optInt("rollNo", 0);
            final String department = jsonObject.optString("department", null);
            final Student student = new Student(id, name, rollNo, department);

            if (type.equals("create") || type.equals("update")) {

                try {
                    HibernateValidation.validator(student, getGroups(type));
                    studentList.add(student);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }
        return studentList;
    }

    /**
     * Converts Student object to json object
     *
     * @param student
     * @return json object
     */
    public JsonObject construct(final Student student) {
        final JsonObject jsonObject = Json.object();

        jsonObject.put("id", student.getId());
        jsonObject.put("name", student.getName());
        jsonObject.put("rollNo", student.getRollNo());
        jsonObject.put("department", student.getDepartment());

        return jsonObject;
    }

    /**
     * Gets group.
     *
     * @param type
     */
    private Class getGroups(final String type) {

        if (type.equals("create")) {
            return Create.class;
        }
        return Update.class;
    }
}