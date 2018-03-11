package com.ef.processor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

public class ItemRecordProcessor implements ItemProcessor<Map<String, String>, Map<String, String>> {

    @Value("${duration}")
    private String duration;
    
    @Value("${startDate}")
    private String startDate;
    
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd.HH:mm:ss");
    private static final DateFormat dateFileFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
    public Map<String, String> process(Map<String, String> item) throws Exception {
        if(StringUtils.hasLength(duration)){
        	Date date = dateFormat.parse(startDate);
        	Date endDate;
        	Calendar c = Calendar.getInstance();
        	c.setTimeInMillis(date.getTime());
        	
        	if("hourly".equalsIgnoreCase(duration)){
        		c.add(Calendar.HOUR, 1);
        	} else if("daily".equalsIgnoreCase(duration)){
        		c.add(Calendar.DAY_OF_MONTH, 1);
        	}
        	endDate = c.getTime();
        	//Filter Records
        	if(StringUtils.hasLength(item.get("column1"))){
        		String itemDateStr = item.get("column1");
        		Date itemDate = dateFileFormat.parse(itemDateStr);
        		if(itemDate.after(date) && itemDate.before(endDate)){
        			return item;
        		}
        	}
        }
        return null;
    }

}
