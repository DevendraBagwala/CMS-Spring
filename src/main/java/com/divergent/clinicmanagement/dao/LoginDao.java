package com.divergent.clinicmanagement.dao;

import java.sql.ResultSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.divergent.clinicmanagement.crud.Doctor;
import com.divergent.clinicmanagement.database.InsertUpdateDelete;
import com.divergent.clinicmanagement.database.Select;
import com.divergent.clinicmanagement.dto.LoginDto;

@Repository("LoginDao")
public class LoginDao {
	@Autowired
	Doctor doctor;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}


	private static Logger logger = LoggerFactory.getLogger(LoginDao.class);

	public void loginDoctor(LoginDto loginDto) {

		int check = 0;

		List<LoginDto> loggerList = jdbcTemplate.query("select * from doctor", new RowMapper<LoginDto>() {
			public LoginDto mapRow(ResultSet rs, int rowCol) {
				LoginDto loginDto = new LoginDto();
				try {
					loginDto.setDoctorId(rs.getInt(1));
					loginDto.setDoctorName(rs.getString(2));
					loginDto.setEmail(rs.getString(3));

				} catch (Exception e) {

					logger.error(e.toString());

				}
				return loginDto;
			}
		});

		for (LoginDto loginDto1 : loggerList) {

			if (loginDto.getUserName().equals(loginDto1.getDoctorName())
					&& loginDto.getPassword().equals(loginDto1.getEmail())) {

				check = 1;
				doctor.doctorOperations(loginDto.getDoctorId(), loginDto.getDoctorName());

			}
		}

		if (check == 0) {
			logger.info("Invalid username or passsword\nPlease Enter Valid username and password:");
		}

	}

}
