package com.example.LabExam;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

    public class StudentRepo {
        private JdbcTemplate jdbcTemplate;

        public void createDBAndTable() {
            DataSource dataSource = new EmbeddedDatabaseBuilder()
                    .setType(EmbeddedDatabaseType.H2)
                    .addScript("classpath:schema.sql")
                    .build();

            this.jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY, name VARCHAR(255), email VARCHAR(255))");
        }
        public void insertIntoTable(Student student) {
            jdbcTemplate.update("INSERT INTO students (id, name, email) VALUES (?, ?, ?)", student.getId(), student.getName(), student.getEmail());
        }
    }
