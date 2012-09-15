package com.develogical;

import java.util.regex.*;


public class QueryProcessor {

    public String process(String query) {
    	
    	System.out.println("###| INCOMING |###");
    	System.out.println(query);
    	System.out.println("###| -------- |###");
    	
    	String sub=query;
    	
    	if (query.length()>9) {
    		sub=query.substring(9);
    	}
    	
        if (query.contains("SPA2012")) {
            return "SPA is a conference";
        }
        if (query.contains("Dragos") || query.contains("Ovidiu")) {
        	return "I'm just a drop flop:" + query;
        }
        if (query.contains("plus")) {
        	return whatIsPlus(sub);
        }
        if (query.contains("minus")) {
        	return whatIsMinus(sub);
        }
        if (query.contains("which of the following numbers is the largest")) {
        	return largestAll(sub);
        }
        if (query.contains("Fibonacci")) {
        	return fibonacci(sub);
        }
        return "";
    }
    
    /* What Is PLUS*/
    public String whatIsPlus(String query) {
    	final String REGEXP= "([^\\d]+)([\\d]+)([^\\d]+)([\\d]+)";
    	Pattern pattern= Pattern.compile(REGEXP);
        Matcher matcher = pattern.matcher(query);
        
        if (matcher.matches()){
        	double sum = new Double(matcher.group(2)).doubleValue() + new Double(matcher.group(4)).doubleValue(); 
        	return new Double(sum).toString();
        }
        return "";
    }
    /* What Is MINUS*/
    public String whatIsMinus(String query) {
    	final String REGEXP= "([^\\d]+)([\\d]+)([^\\d]+)([\\d]+)";
    	Pattern pattern= Pattern.compile(REGEXP);
        Matcher matcher = pattern.matcher(query);
        
        if (matcher.matches()){
        	double diff= new Double(matcher.group(2)).doubleValue() - new Double(matcher.group(4)).doubleValue(); 
        	return new Double(diff).toString();
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
    
    
    /* What Is MINUS*/
    public String fibonacci(String query) {
    	
    	final String REGEXP= "([\\d]+)";
    	Pattern pattern= Pattern.compile(REGEXP);
        Matcher matcher = pattern.matcher(query);
        
        String r = "";
        
        if (matcher.find()){
        	r = new Integer(fib(new Integer(matcher.group()).intValue())).toString();
        }
        
        return r;
    }
    private static int fib(int n) {
    	 if (n <= 1) return n;
    	 else return fib(n-1) + fib(n-2);
    }
}
