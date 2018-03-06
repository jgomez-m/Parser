package com.ef.processor;

import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;

public class ItemRecordProcessor implements ItemProcessor<Map<String, Object>, Map<String, Object>> {

    @Value("${ip}")
    String ip_filter;
    
    @Override
    public Map<String, Object> process(Map<String, Object> item) throws Exception {
        if(item.containsKey("column2") && item.get("column2") != null){
            String ip = (String)item.get("column2");
            if(ip_filter.equals(ip.trim())){
                return item;
            }
        }
        return null;
    }

}
