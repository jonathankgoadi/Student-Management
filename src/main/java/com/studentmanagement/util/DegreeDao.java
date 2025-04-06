package com.studentmanagement.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studentmanagement.model.Degree;

public class DegreeDao extends DataAccessObject<Degree> {
    private static final String INSERT = "INSERT INTO students (id,fore_names, last_name, email, birth_date, degree_id) VALUES (?, ?, ?, ?, ?, ?) ";
    private final static String GET_ONE = "SELECT degree_name, duration, lecture_id FROM degrees WHERE id = ?";
    private final static String GET_ALL = "SELECT id, degree_name, duration, lecture_id FROM degrees";
    private final static String UPDATE = "UPDATE students SET  fore_names =?, last_name=?, email=?, birth_date=?, degree_id=? WHERE id=? ";
    private final static String DELETE = "DELETE FROM student WHERE id=?";

    public DegreeDao(Connection connection) {
        super(connection);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Degree findById(long id) {
        // INSERT INTO degrees (id, degree_name, duration, lecture_id) VALUES
        // (100,'Computer Science', 36, 100);
        Degree degree = new Degree();
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(GET_ONE)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            degree.setId(id);
            degree.setName(resultSet.getString(1));
            degree.setDuration(resultSet.getInt(2));
            degree.setLecture(new LectureDao(connection).findById(resultSet.getLong(3)));

        } catch (Exception e) {
            // TODO: handle exception
        }
        return degree;
    }

    @Override
    public List<Degree> findAll() {

        List<Degree> degrees = new ArrayList<>();
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(GET_ONE)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            Degree degree = new Degree();
            while (resultSet.next()) {
                degree.setId(resultSet.getLong(1));
                degree.setName(resultSet.getString(2));
                degree.setDuration(resultSet.getInt(3));
                degree.setLecture(new LectureDao(connection).findById(resultSet.getLong(4)));
                degrees.add(degree);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return degrees;

    }

    @Override
    public Degree update(Degree dao) {

        Degree degree = new Degree();
        try (
                PreparedStatement preparedStatement = this.connection.prepareStatement(UPDATE)) {

        } catch (Exception e) {
            // TODO: handle exception
        }
        return degree;
    }

    @Override
    public Degree create(Degree dao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public void delete(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
