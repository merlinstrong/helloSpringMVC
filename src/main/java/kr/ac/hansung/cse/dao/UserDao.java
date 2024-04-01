package kr.ac.hansung.cse.dao;

import kr.ac.hansung.cse.model.Offer;
import kr.ac.hansung.cse.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao {

    private JdbcTemplate jdbcTemplate;  // psa(portable service abstraction, sql(x) api

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    //query and return a single object
    public User getUser(String name) {

        String sqlStatement= "select * from user where name=?";

        return jdbcTemplate.queryForObject(sqlStatement, new Object[] {name},
                new RowMapper<User>() {

                    @Override
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

                        User user= new User();

                        user.setUsername(rs.getString("username"));
                        user.setPassword(rs.getString("password"));

                        return user;
                    }
                });
    }

    public List<User> getUsers() {

        String sqlStatement= "select * from user";
        return jdbcTemplate.query(sqlStatement, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {

                User user= new User();

                user.setUsername(rs.getString("email"));
                user.setPassword(rs.getString("password"));

                return user;
            }
        });
    }
}
