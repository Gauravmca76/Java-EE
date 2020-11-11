package com.javapoint;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	private JdbcTemplate jdbcTemplate;
    // JdbcTemplate setter
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	@Override
	public void saveEmployee(Employee employee) {
		String sql = "insert into employee values(?,?,?,?)";

        jdbcTemplate.update(sql, new Object[]
        { employee.getId(), employee.getName(), employee.getDept(), employee.getSal()  });
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		String sql = "select * from employee where id=?";
        Employee employee = (Employee) jdbcTemplate.queryForObject(sql, new Object[]
        { id }, new RowMapper()
        {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                Employee employee = new Employee();
                employee.setId(rs.getInt(1));
                employee.setName(rs.getString(2));
                employee.setDept(rs.getString(3));
                employee.setSal(rs.getInt(4));
                return employee;
            }
        });
        return employee;
	}

	@Override
	public void updateEmployee(Employee employee) {
		 String sql = "update employee set salary=?, dept=?,name=? where id=?";
	        jdbcTemplate.update(sql, new Object[]
	        { employee.getSal(), employee.getDept(), employee.getName(), employee.getId() });
		
	}

	@Override
	public void deleteEmployee(int id) {
		String sql = "delete from employee where id=?";
        jdbcTemplate.update(sql, new Object[]
        { id });
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		String sql = "select * from employee";

        List<Employee> employeeList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Employee>>()
        {
            @Override
            public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException
            {
                List<Employee> list = new ArrayList<Employee>();
                while (rs.next())
                {
                    Employee employee = new Employee();
                    employee.setId(rs.getInt(1));
                    employee.setName(rs.getString(2));
                    employee.setDept(rs.getString(3));
                    employee.setSal(rs.getInt(4));
                    list.add(employee);
                }
                return list;
            }

        });
        return employeeList;
	}

}
