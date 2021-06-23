package com.example.relationaldataaccess.DAO;

import com.example.relationaldataaccess.tableclass.Testtable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TesttableDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Testtable> list(){
        String sql = "SELECT * FROM TESTTABLE";
        List<Testtable> listTest = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Testtable.class));
        return listTest;
    }

    public void save(Testtable testtable){
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("TESTTABLE").usingColumns("first_Name","last_Name");
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(testtable);
        jdbcInsert.execute(parameterSource);
    }
    public void update(Testtable testtable){
        String sql = "UPDATE TESTTABLE SET FIRST_NAME ='"+testtable.getFirstName()+"', LAST_NAME ='"+testtable.getLastName()+"' where PERSON_ID ="+testtable.getPersonId();

        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(testtable);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,parameterSource);
    }

    public void delete(int personID){
        String sql = "DELETE FROM TESTTABLE WHERE PERSON_ID = " + personID;
        jdbcTemplate.update(sql);
    }

    public void getOneRow(){}
}
