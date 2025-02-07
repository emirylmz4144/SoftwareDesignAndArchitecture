package DAO;

import Entity.Admin;
import Entity.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface PersonDAO {
    public Person findByLogin(String email, String password);
    public Person match(ResultSet result) throws SQLException;
}
