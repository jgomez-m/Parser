/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ef.util;

import java.util.HashMap;
import java.util.Map;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 *
 * @author Julian Gomez
 */
public class MapFieldSetMapper implements FieldSetMapper<Map<String, String>>{

    @Override
    public Map<String, String> mapFieldSet(FieldSet fs) throws BindException {
        int numberOfColumns = fs.getFieldCount();
        Map<String, String> data = new HashMap<>();
        
        for (int i = 0; i < numberOfColumns; i++) {
            data.put(fs.getNames()[i], fs.getValues()[i]);
        }
        
        return data;
    }
}
