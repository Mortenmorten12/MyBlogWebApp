package com.example.myblog.Repositories;

import com.example.myblog.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("UserRepositoryImpl")
public class UserRepositoryImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<User> fetchAllUsers() {

        return jdbcTemplate.query(
                "select * from users",
                (resultSet, rowNum) ->
                        new User(
                                resultSet.getInt("id"),
                                resultSet.getString("username"),
                                resultSet.getString("password"),
                                resultSet.getString("usertype")
                                )
        );
    }
}