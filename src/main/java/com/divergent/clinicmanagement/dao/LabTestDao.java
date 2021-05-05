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
import com.divergent.clinicmanagement.dto.LabTestDto;
import com.divergent.clinicmanagement.dto.PatientDto;

@Repository("LabTestDao")
public class LabTestDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	private static Logger logger = LoggerFactory.getLogger(LabTestDao.class);

	public void insert(LabTestDto ldto) {

		try {

			String query;
			query = "insert into labtest values(testId, '" + ldto.getTestName() + "', '" + ldto.getTestRate() + "')";
			// insertUpdateDelete.setData(Query, "Lab Test Data added successfully");
			jdbcTemplate.execute(query);
		} catch (Exception e) {

			// logger.log(Level.FINE, e.getMessage());
			logger.info(e.toString());
		}

	}

	public void update(LabTestDto ldto) {

		try {

			String query;
			query = "update labtest set testName='" + ldto.getTestName() + "', testRate='" + ldto.getTestRate()
					+ "' where testId='" + ldto.getTestId() + "'";
			// insertUpdateDelete.setData(Query, "Test data updated successfully");
			jdbcTemplate.execute(query);
		} catch (Exception e) {

			// logger.log(Level.FINE, e.getMessage());
			logger.info(e.toString());
		}

	}

	public List<LabTestDto> labTestlist() {
		List<LabTestDto> labTestList = jdbcTemplate.query("select * from labtest", new RowMapper<LabTestDto>() {

			public LabTestDto mapRow(ResultSet rs, int rowCol) throws SQLException {
				LabTestDto ldto = new LabTestDto();
				ldto.setTestId(rs.getInt(1));
				ldto.setTestName(rs.getString(2));
				ldto.setTestRate(rs.getInt(3));
				return ldto;
			}
		});
		return labTestList;

	}

	public void delete(LabTestDto ldto) {

		try {

			String query;
			query = "delete from labtest where testId = '" + ldto.getTestId() + "'";
			// insertUpdateDelete.setData(Query, "Test data deleted");
			jdbcTemplate.execute(query);
		} catch (Exception e) {

			// logger.log(Level.FINE, e.getMessage());
			logger.info(e.toString());
		}

	}

}
