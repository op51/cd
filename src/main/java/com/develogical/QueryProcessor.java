package com.develogical;

import java.util.regex.*;


public class QueryProcessor {

    public String process(String query) {
    	
    	System.out.println("###| INCOMING |###");
    	System.out.println(query);
    	System.out.println("###| -------- |###");
    	
        if (query.contains("SPA2012")) {
            return "SPA is a conference";
        }
        if (query.contains("Dragos") || query.contains("Ovidiu")) {
        	return "I'm just a drop flop:" + query;
        }
        if (query.contains("what is")) {
        	return whatIs(query);
        }
        if (query.contains("which of the following numbers is the largest")) {
        	return largestAll(query);
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
    /* Largest */
   
    
    public String largestAll(String query) {
    	final String REGEXP= "([\\d]+)";
    	Pattern pattern= Pattern.compile(REGEXP);
        Matcher matcher = pattern.matcher(query);
        
        double max =Double.MIN_VALUE;
        while (matcher.find()){
        	double value = new Double(matcher.group()).doubleValue();
        	if (value>max) {
        		max=value;
        	}
        }
    	return new Double(max).toString();
    }
    
    
}
