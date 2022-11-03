package org.springframework.samples.petclinic.recoveryroom;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class RecoveryRoomTypeFormatter implements Formatter<RecoveryRoomType>{

	@Autowired
	private RecoveryRoomService service;
	
    @Override
    public String print(RecoveryRoomType object, Locale locale) {
        return object.getName();
    }

    @Override
    public RecoveryRoomType parse(String text, Locale locale) throws ParseException {
        
    	RecoveryRoomType rrt= service.getRecoveryRoomType(text);
    	if(rrt!=null) {
    		return rrt;
    	}else {
    		throw new ParseException("It cannot be null", 0);
    	}
    }
    
}
