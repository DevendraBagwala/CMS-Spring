package com.divergent.clinicmanagement.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
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
import com.divergent.clinicmanagement.dto.MakeAppointmentDto;

@Repository("MakeAppointmentDao")
public class MakeAppointmentDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	private static Logger logger = LoggerFactory.getLogger(MakeAppointmentDao.class);



	public void appointment(final MakeAppointmentDto mkdto) {

		final List<MakeAppointmentDto> appointList = jdbcTemplate.query("select * from patient ",
				new RowMapper<MakeAppointmentDto>() {

					@Override
					public MakeAppointmentDto mapRow(ResultSet rs, int rowNum) throws SQLException {
						mkdto.setPatientName(rs.getString("patientName"));
						mkdto.setDisease(rs.getString("Disease"));
						return mkdto;

					}
				});

		/*
		 * List<MakeAppointmentDto> appointList =
		 * jdbcTemplate.query("select * from doctor ", new
		 * RowMapper<MakeAppointmentDto>() {
		 * 
		 * @Override public MakeAppointmentDto mapRow(ResultSet rs, int rowNum) throws
		 * SQLException { mkdto.setDoctorName(rs.getString("doctorName"));
		 * mkdto.setSpecialization(rs.getString("specialization"));
		 * mkdto.setDoctorFee(rs.getInt("fee")); return mkdto; } });
		 */
		/*
		 * String query; query =
		 * " select patientName, Disease from patient where patientName='" +
		 * mkdto.getPatientName() + "'"; ResultSet rs = select.getData(query); try {
		 * while (rs.next()) {
		 * 
		 * mkdto.setPatientName(rs.getString("patientName"));
		 * mkdto.setDisease(rs.getString("Disease"));
		 * 
		 * } } catch (SQLException e) { logger.info(e.toString());
		 * 
		 * }
		 * 
		 * query =
		 * " select doctorName, specialization, fee from doctor where doctorName='" +
		 * mkdto.getDoctorName() + "'"; rs = select.getData(query); try { while
		 * (rs.next()) {
		 * 
		 * mkdto.setDoctorName(rs.getString("doctorName"));
		 * mkdto.setSpecialization(rs.getString("specialization"));
		 * mkdto.setDoctorFee(rs.getInt("fee"));
		 * 
		 * } } catch (SQLException e) {
		 * 
		 * logger.info(e.toString()); }
		 */
		String query;
		query = "insert into appointment values(appointId, '" + mkdto.getPatientName() + "', '" + mkdto.getDisease()
				+ "', '" + mkdto.getDoctorName() + "',  '" + mkdto.getSpecialization() + "', '" + mkdto.getDoctorFee()
				+ "', '" + mkdto.getDateOfAppointment() + "', '" + mkdto.getTimeOfAppointment() + "')";
		// insertUpdateDelete.setData(Query, "Appointment Booked");
		jdbcTemplate.execute(query);
	}

}
