package com.divergent.clinicmanagement.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.divergent.clinicmanagement.database.InsertUpdateDelete;
import com.divergent.clinicmanagement.database.Select;
import com.divergent.clinicmanagement.dto.DoctorDto;
import com.divergent.clinicmanagement.dto.PatientDto;

@Repository("DoctorDao")
public class DoctorDao {
	

	@Autowired
	JdbcTemplate jdbcTemplate;

	private static Logger logger = LoggerFactory.getLogger(DoctorDao.class);


	public List<DoctorDto> patientList() {
		List<DoctorDto> patientsList = jdbcTemplate.query("select * from patient", new RowMapper<DoctorDto>() {
			public DoctorDto mapRow(ResultSet rs, int rowCol) throws SQLException {
				DoctorDto dto = new DoctorDto();
				dto.setDoctorId(rs.getInt(1));
				dto.setPatientName(rs.getString(2));
				dto.setAddress(rs.getString(3));
				dto.setDisease(rs.getString(4));
				dto.setAge(rs.getInt(5));
				dto.setContactNo(rs.getLong(6));
				return dto;
			}
		});
		return patientsList;

	}

	public void insertPrescription(final DoctorDto dto) {

		final List<DoctorDto> insertList = jdbcTemplate.query("select * from patient ", new RowMapper<DoctorDto>() {

			@Override
			public DoctorDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				dto.setDisease(rs.getString("Disease"));
				return dto;
			}
			
		});
	
		String query;
		query = " insert into doctorprescription values('" + dto.doctorId + "','" + dto.doctorName + "','"
				+ dto.getPatientName() + "','" + dto.getDisease() + "','" + dto.getPrescription() + "','"
				+ dto.getNotes() + "','" + dto.getDate() + "')";
		// insertUpdateDelete.setData(Query, "Prescription and Notes Added
		// Successfully");
		jdbcTemplate.execute(query);

	}

	public List<DoctorDto> appointList() {
		List<DoctorDto> appointedList = jdbcTemplate.query("select * from appointment ", new RowMapper<DoctorDto>() {
			public DoctorDto mapRow(ResultSet rs, int rowCol) throws SQLException {
				DoctorDto dto = new DoctorDto();
				dto.setPatientName(rs.getString("patientName"));
				dto.setPatientDisease(rs.getString("patientDisease"));
				dto.setDoctorName(rs.getString("doctorName"));
				dto.setDateOfAppointment(rs.getString("dateOfAppointment"));
				dto.setTimeOfAppointment(rs.getString("timeOfAppointment"));
				return dto;
			}
		});
		return appointedList;

	}

	public List<DoctorDto> patientHistroy() {
		List<DoctorDto> patientsHistroy = jdbcTemplate.query("select * from doctorprescription ",
				new RowMapper<DoctorDto>() {
					public DoctorDto mapRow(ResultSet rs, int rowCol) throws SQLException {
						DoctorDto dto = new DoctorDto();
						dto.setDoctorName(rs.getString(2));
						dto.setPatientName(rs.getString(3));
						dto.setPatientDisease(rs.getString(4));
						dto.setPrescription(rs.getString("prescription"));
						dto.setNotes(rs.getString("notes"));
						dto.setDate(rs.getString("prescriptionDate"));
						return dto;
					}
				});
		return patientsHistroy;

	}
}