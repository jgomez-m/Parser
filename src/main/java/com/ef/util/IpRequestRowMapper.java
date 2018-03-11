package com.ef.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ef.dto.IpRequestDTO;

public class IpRequestRowMapper implements RowMapper<IpRequestDTO>{

	@Override
	public IpRequestDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		IpRequestDTO dto = new IpRequestDTO();
		//dto.setDate(rs.getString("date"));
		dto.setIpAddress(rs.getString("ip_address"));
		dto.setNumberOfRequests(rs.getInt("quantity"));
		//dto.setRequest(rs.getString("request"));
		//dto.setStatus(rs.getString("status"));
		//dto.setUserAgent(rs.getString("user_agent"));
		return dto;
	}

}
