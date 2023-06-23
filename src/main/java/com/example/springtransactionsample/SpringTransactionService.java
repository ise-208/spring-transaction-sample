package com.example.springtransactionsample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;


@Service
public class SpringTransactionService {
    private final Logger log = LoggerFactory.getLogger(SpringTransactionService.class);
    private final JdbcTemplate jdbcTemplate;

    public SpringTransactionService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void updateEmp(SpringTransactionEmp emp) {
        jdbcTemplate.update("INSERT INTO emp (id, name) VALUES (? , ?) ", emp.id, emp.name);
        Random random = new Random();

        if (random.nextBoolean()){
            jdbcTemplate.update("UPDATE emp SET name = (?)", emp.name);
        } else {
            throw  new RuntimeException();
        }
        System.out.println(jdbcTemplate.queryForList("SELECT * FROM emp ; "));
    }

    public List<Map<String, Object>> findByEmp() {
        return jdbcTemplate.queryForList("SELECT * FROM emp ; ");
    }

}
