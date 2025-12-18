
package com.tf8.quizapp.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class ClassementRepository {

    private final JdbcTemplate jdbcTemplate;

    public ClassementRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SqlRowSet getClassementRaw(Long quizId) {

        String sql = "CALL GetFinalRanking(?)";

        return jdbcTemplate.queryForRowSet(sql, quizId);
    }
}
