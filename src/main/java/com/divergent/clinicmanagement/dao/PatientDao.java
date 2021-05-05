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
import com.divergent.clinicmanagement.dto.PatientDto;

@Repository("PatientDao")
public class PatientDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private static Logger logger = LoggerFactory.getLogger(PatientDao.class);

	public void insert(PatientDto pdto) {

		try {
			String query;
			query = "insert into patient values(id, '" + pdto.getPatientName() + "', '" + pdto.getAddress() + "', '"
					+ pdto.getDisease() + "', '" + pdto.getAge() + "', '" + pdto.getContactNo() + "')";
			// insertUpdateDelete.setData(Query, "Patient data inserted succefully");
			jdbcTemplate.execute(query);
		} catch (Exception e) {

			// logger.log(Level.FINE, e.getMessage());
			logger.info(e.toString());

		}

	}

	public void update(PatientDto pdto) {

		try {
			String query;
			query = "update patient set patientName='" + pdto.getPatientName() + "', address='" + pdto.getAddress()
					+ "', Disease='" + pdto.getDisease() + "', age='" + pdto.getAge() + "', contactNo='"
					+ pdto.getContactNo() + "' where id='" + pdto.getId() + "'";
			// insertUpdateDelete.setData(Query, "Patient data updated succefully");
			jdbcTemplate.execute(query);
		} catch (Exception e) {

			// logger.log(Level.FINE, e.getMessage());
			logger.info(e.toString());

		}

	}

	public List<PatientDto> list() {
		List<PatientDto> patientsList = jdbcTemplate.query("select * from patient", new RowMapper<PatientDto>() {

			public PatientDto mapRow(ResultSet rs, int rowCol) throws SQLException {
				PatientDto pdto = new PatientDto();
				pdto.setId(rs.getInt("id"));
				pdto.setPatientName(rs.getString("patientName"));
				pdto.setAddress(rs.getString("address"));
				pdto.setDisease(rs.getString("Disease"));
				pdto.setAge(rs.getInt(5));
				pdto.setContactNo(rs.getLong("contactNo"));
				return pdto;
			}
		});
		return patientsList;
	}

	public void delete(PatientDto pdto) {

		try {

			String query;
			query = "delete from patient where id = '" + pdto.getId() + "'";
			// insertUpdateDelete.setData(Query, "Patient data deleted");
			jdbcTemplate.execute(query);
		} catch (Exception e) {

			// logger.log(Level.FINE, e.getMessage());
			logger.info(e.toString());

		}

	}

}
