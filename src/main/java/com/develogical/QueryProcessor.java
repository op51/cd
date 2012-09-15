package com.develogical;

import java.util.regex.*;

public class QueryProcessor {

    public String process(String query) {
    	
        if (query.contains("SPA2012")) {
            return "SPA is a conference";
        }
        if (query.contains("Dragos") || query.contains("Ovidiu")) {
        	return "I'm just a drop flop:" + query;
        }
        if (query.contains("what is")) {
        	return whatIs(query);
        }
        if (query.contains("what is")) {
        	return whatIs(query);
        }
        return "";
    }
    
    /* What Is */
    public String whatIs(String query) {
    	final String REGEXP= "([^\\d]+)([\\d]+)([^\\d]+)([\\d]+)";
    	Pattern pattern= Pattern.compile(REGEXP);
        Matcher matcher = pattern.matcher(query);
        
        if (matcher.matches()){
        	double sum = new Double(matcher.group(2)).doubleValue() + new Double(matcher.group(4)).doubleValue(); 
        	return new Double(sum).toString();
        }
        return "";
    }
}
