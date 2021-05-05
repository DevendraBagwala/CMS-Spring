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
import com.divergent.clinicmanagement.dto.DrugsDto;
import com.divergent.clinicmanagement.dto.PatientDto;

@Repository("DrugssDao")
public class DrugsDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	private static Logger logger = LoggerFactory.getLogger(DrugsDao.class);

	public void insert(DrugsDto ddto) {

		try {

			String query;
			query = "insert into drug values(drugId,'" + ddto.getDrugName() + "', '" + ddto.getDrugWeight() + "', '"
					+ ddto.getDrugContent() + "', '" + ddto.getExpiryDate() + "', '" + ddto.getBrandName() + "','"
					+ ddto.getDrugMRP() + "')";
			// insertUpdateDelete.setData(Query, "Drug data added succefully");
			jdbcTemplate.execute(query);
		} catch (Exception e) {

			// logger.log(Level.FINE, e.getMessage());
			logger.info(e.toString());
		}

	}

	public void update(DrugsDto ddto) {

		try {

			String query;
			query = "update drug set drugName='" + ddto.getDrugName() + "', drugWeight='" + ddto.getDrugWeight()
					+ "', drugContent='" + ddto.getDrugContent() + "', expiryDate='" + ddto.getExpiryDate()
					+ "', brandName='" + ddto.getBrandName() + "', drugMRP='" + ddto.getDrugMRP() + "' where drugId='"
					+ ddto.getDrugId() + "' ";
			// insertUpdateDelete.setData(Query, "Drug data Updated succefully");
			jdbcTemplate.execute(query);
		} catch (Exception e) {

			// logger.log(Level.FINE, e.getMessage());
			logger.info(e.toString());
		}
	}

	public List<DrugsDto> list() {
		List<DrugsDto> DrugsList = jdbcTemplate.query("select * from drug ", new RowMapper<DrugsDto>() {

			public DrugsDto mapRow(ResultSet rs, int rowCol) throws SQLException {
				DrugsDto ddto = new DrugsDto();
				ddto.setDrugId(rs.getInt(1));
				ddto.setDrugName(rs.getString("drugName"));
				ddto.setDrugWeight(rs.getString("drugWeight"));
				ddto.setDrugContent(rs.getString("drugContent"));
				ddto.setExpiryDate(rs.getString("expiryDate"));
				ddto.setBrandName(rs.getString(6));
				ddto.setDrugMRP(rs.getInt(7));
				return ddto;
			}
		});
		return DrugsList;

	}

	public void delete(DrugsDto ddto) {

		try {

			String query;
			query = "delete from drug where drugId = '" + ddto.getDrugId() + "'";
			// insertUpdateDelete.setData(Query, "Drug data deleted");
			jdbcTemplate.execute(query);
		} catch (Exception e) {

			// logger.log(Level.FINE, e.getMessage());
			logger.info(e.toString());
		}

	}
}
