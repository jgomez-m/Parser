package com.ef.util;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.ef.dto.IpRequestDTO;

public class StdoutWriter<T> implements ItemWriter<IpRequestDTO> {

	@Override
	public void write(List<? extends IpRequestDTO> items) throws Exception {
		for(IpRequestDTO record : items){
			System.out.println("IP Address: "+record.getIpAddress());
			System.out.println("Number of requests: "+record.getNumberOfRequests());
		}
		
	}


}
