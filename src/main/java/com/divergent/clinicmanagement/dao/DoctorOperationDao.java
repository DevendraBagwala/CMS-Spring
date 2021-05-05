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
import com.divergent.clinicmanagement.dto.DoctorOperationDto;
import com.divergent.clinicmanagement.dto.PatientDto;

@Repository("DoctorOperationDao")
public class DoctorOperationDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	private static Logger logger = LoggerFactory.getLogger(DoctorOperationDao.class);


	public void insert(DoctorOperationDto dodto) {

		try {

			String query;
			query = "insert into doctor values(doctorId,'" + dodto.getDoctorName() + "', '" + dodto.getEmail() + "', '"
					+ dodto.getDegree() + "', '" + dodto.getSpecialization() + "', '" + dodto.getFee() + "','"
					+ dodto.getAddress() + "', '" + dodto.getContactNo() + "')";
			// insertUpdateDelete.setData(Query, "Doctor data added succefully");
			jdbcTemplate.execute(query);
		} catch (Exception e) {

			// logger.log(Level.FINE, e.getMessage());
			logger.info(e.toString());
		}
	}

	public void update(DoctorOperationDto dodto) {

		try {

			String query;
			query = "update doctor set doctorName='" + dodto.getDoctorName() + "', email='" + dodto.getEmail()
					+ "', degree='" + dodto.getDegree() + "', specialization='" + dodto.getSpecialization() + "', fee='"
					+ dodto.getFee() + "', address='" + dodto.getAddress() + "', contactNo='" + dodto.getContactNo()
					+ "' where doctorId='" + dodto.getDoctorId() + "' ";
			// insertUpdateDelete.setData(Query, "Doctor data updated succefully");
			jdbcTemplate.execute(query);
		} catch (Exception e) {

			// logger.log(Level.FINE, e.getMessage());
			logger.info(e.toString());
		}

	}

	public List<DoctorOperationDto> list() {
		List<DoctorOperationDto> DoctorList = jdbcTemplate.query("select * from doctor",
				new RowMapper<DoctorOperationDto>() {

					public DoctorOperationDto mapRow(ResultSet rs, int rowCol) throws SQLException {
						DoctorOperationDto dodto = new DoctorOperationDto();
						dodto.setDoctorId(rs.getInt(1));
						dodto.setDoctorName(rs.getString("doctorName"));
						dodto.setEmail(rs.getString("email"));
						dodto.setDegree(rs.getString("degree"));
						dodto.setSpecialization(rs.getString("specialization"));
						dodto.setFee(rs.getInt("fee"));
						dodto.setAddress(rs.getString("address"));
						dodto.setContactNo(rs.getLong("contactNo"));

						return dodto;
					}
				});
		return DoctorList;

	}

	public void delete(DoctorOperationDto dodto) {

		try {

			String query;
			query = "delete from doctor where doctorId = '" + dodto.getDoctorId() + "'";
			// insertUpdateDelete.setData(Query, "Doctor data deleted");
			jdbcTemplate.execute(query);
		} catch (Exception e) {

			// logger.log(Level.FINE, e.getMessage());
			logger.info(e.toString());
		}

	}

}
