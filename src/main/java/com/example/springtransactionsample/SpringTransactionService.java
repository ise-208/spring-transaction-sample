package com.example.springtransactionsample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service
public class SpringTransactionService {
    private final Logger log = LoggerFactory.getLogger(SpringTransactionService.class);
    private final JdbcTemplate jdbcTemplate;

    public SpringTransactionService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public int updateEmp(SpringTransactionEmp emp) {
        return jdbcTemplate.update("UPDATE emp SET name = (?)", emp.name);
    }

    public List<Map<String, Object>> findByEmp() {
        return jdbcTemplate.queryForList("SELECT * FROM emp ; ");
    }

}
