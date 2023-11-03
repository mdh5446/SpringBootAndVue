package com.example.mdh_test.repository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class CommonRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CommonRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public <T> T executeProcedure(String procedureName, Map<String, Object> parameters, Class<T> returnType) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName(procedureName)
                .returningResultSet("result", new BeanPropertyRowMapper<>(returnType));

        MapSqlParameterSource in = new MapSqlParameterSource(parameters);
        Map<String, Object> out = jdbcCall.execute(in);

        @SuppressWarnings("unchecked")
		List<T> result = (List<T>) out.get("result");
        return result.isEmpty() ? null : result.get(0);
    }
}