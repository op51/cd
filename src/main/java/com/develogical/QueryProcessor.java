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
        if (query.contains("which of the following numbers is the largest")) {
        	return largest(query);
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
   
    
    public String largest(String query) {
    	final String REGEXP= "([^\\d]+)([\\d]+),\\s([\\d]+),\\s([\\d]+),\\s([\\d]+)";
    	Pattern pattern= Pattern.compile(REGEXP);
        Matcher matcher = pattern.matcher(query);
        
        if (matcher.matches()){
        	double one = new Double(matcher.group(2)).doubleValue();
            double two= new Double(matcher.group(3)).doubleValue(); 
        	double three= new Double(matcher.group(4)).doubleValue(); 
        	double four= new Double(matcher.group(5)).doubleValue();
        	double[] list = {one, two, three, four};
        	return maxValue(list);
        }
        return "";
    }
    
    

    public String maxValue(double[] list) {
    	double max=Double.MIN_VALUE;
    	for(int i=0;i<list.length;i++){
    		if (list[i]>max) {
    			max=list[i];
    		}
    	}
    	return new Double(max).toString();
    }
    
    
}
