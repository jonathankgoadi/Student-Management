package com.studentmanagement.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.studentmanagement.model.Lecture;

public class LectureDao extends DataAccessObject<Lecture> {

    private static final String INSERT = "INSERT INTO students (id,fore_names, last_name, email, birth_date, degree_id) VALUES (?, ?, ?, ?, ?, ?) ";
    private final static String GET_ONE = "SELECT fore_names, last_name, email, birth_date FROM lectures WHERE id = ?;";
    private final static String GET_ALL = "SELECT (id,fore_names, last_name, email, birth_date, degree_id) FROM students";
    private final static String UPDATE = "UPDATE (id,fore_names, last_name, email, birth_date, degree_id) FROM students";
    private final static String DELETE = "";

    public LectureDao(Connection connection) {
        super(connection);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Lecture findById(long id) {
        Lecture lecture = new Lecture();
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(GET_ONE)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                lecture.setId(id);
                lecture.setForeNames(resultSet.getString("fore_names"));
                lecture.setLastName(resultSet.getString("last_name"));
                lecture.setEmail(resultSet.getString("email"));
                Date date = resultSet.getDate("birth_date");
                lecture.setBirthDate(date.toLocalDate());

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return lecture;
    }

    @Override
    public List<Lecture> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Lecture update(Lecture dao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Lecture create(Lecture dao) {
        try (PreparedStatement statement = this.connection.prepareStatement(INSERT);) {
            statement.setLong(1, dao.getId());
            statement.setString(2, dao.getForeNames());
            statement.setString(3, dao.getLastName());
            statement.setString(4, dao.getEmail());
            statement.setDate(5, Date.valueOf(dao.getBirthDate()));

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
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
