package com.studentmanagement.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studentmanagement.model.Student;

public class StudentDao extends DataAccessObject<Student> {

    private static final String INSERT = "INSERT INTO students (id,fore_names, last_name, email, birth_date, degree_id) VALUES (?, ?, ?, ?, ?, ?) ";
    private final static String GET_ONE = "SELECT fore_names, last_name, email, birth_date, degree_id FROM students WHERE id = ?";
    private final static String GET_ALL = "SELECT id,fore_names, last_name, email, birth_date, degree_id FROM students";
    private final static String UPDATE = "UPDATE (id,fore_names, last_name, email, birth_date, degree_id) FROM students";
    private final static String DELETE = "";

    public StudentDao(Connection connection) {
        super(connection);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Student create(Student dao) {
        try (PreparedStatement statement = this.connection.prepareStatement(INSERT);) {
            statement.setLong(1, dao.getId());
            statement.setString(2, dao.getForeNames());
            statement.setString(3, dao.getLastName());
            statement.setString(4, dao.getEmail());
            statement.setDate(5, Date.valueOf(dao.getBirthDate()));
            statement.setLong(6, dao.getDegree().getId());
            statement.execute();

            return null;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    @Override
    public void delete(long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(GET_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getLong("id"));
                student.setForeNames(resultSet.getString("fore_names"));
                student.setLastName(resultSet.getString("last_name"));
                student.setEmail("email");
                Date date = resultSet.getDate("birth_date");
                student.setBirthDate(date.toLocalDate());
                student.setDegree(new DegreeDao(connection).findById(resultSet.getLong("degree_id")));
                students.add(student);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public Student findById(long id) {
        Student student = new Student();
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(GET_ONE)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                student.setId(id);
                student.setForeNames(resultSet.getString(1));
                student.setLastName(resultSet.getString(2));
                student.setEmail(resultSet.getString(3));
                Date date = resultSet.getDate(4);
                student.setBirthDate(date.toLocalDate());
                student.setDegree(new DegreeDao(connection).findById(resultSet.getLong(5)));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public Student update(Student dao) {
        try (PreparedStatement statement = this.connection.prepareStatement(INSERT);) {
            statement.setLong(1, dao.getId());
            statement.setString(2, dao.getForeNames());
            statement.setString(3, dao.getLastName());
            statement.setString(4, dao.getEmail());
            statement.setDate(5, Date.valueOf(dao.getBirthDate()));
            statement.setLong(6, dao.getDegree().getId());
            statement.execute();

            return null;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

}
