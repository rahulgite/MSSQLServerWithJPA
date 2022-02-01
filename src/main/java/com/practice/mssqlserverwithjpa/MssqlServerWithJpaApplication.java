package com.practice.mssqlserverwithjpa;

import com.practice.mssqlserverwithjpa.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class MssqlServerWithJpaApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public static void main(String[] args) {
        SpringApplication.run(MssqlServerWithJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String sql="select * from USERS";
        List<Users> user=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Users.class));
        user.forEach(System.out::println);
    }
}
