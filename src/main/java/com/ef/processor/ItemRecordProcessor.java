package com.ef.processor;

import java.util.Map;

import org.springframework.batch.item.ItemProcessor;

public class ItemRecordProcessor implements ItemProcessor<Map<String, Object>, Map<String, Object>> {

    @Override
    public Map<String, Object> process(Map<String, Object> item) throws Exception {
        if(item.containsKey("column2") && item.get("column2") != null){
            String ip = (String)item.get("column2");
            if("192.168.234.82".equals(ip.trim())){
                return item;
            }
        }
        return null;
    }

}
