package com.pyongjjeom.test.controllers;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class CreateTable {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void doExecute() {
		String sql = "create table mytable(id integer, name varchar(100))";
		this.jdbcTemplate.execute(sql);
	}

	public void doInsert() {
		// String sql = "insert into mytable(id, name) values (?, ?)",1, "Ankit";
		this.jdbcTemplate.update("insert into mytable(id, name) values (?, ?)", 1,
				"Ankit");
	}
}
