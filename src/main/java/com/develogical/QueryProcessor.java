package com.develogical;

public class QueryProcessor {

    public String process(String query) {
    	
        if (query.contains("SPA2012")) {
            return "SPA is a conference";
        }
        if (query.contains("Dragos") || query.contains("Ovidiu")) {
        	return "I'm just a drop flop:" + query;
        }
        if (query.contains("what is")) {
        	final String REGEXP= "([^\\d]+)([\\d]+)([^\\d]+)([\\d]+)";

        	String[] r = query.split(REGEXP);

        	double sum = new Double(r[1]).doubleValue() + new Double(r[3]).doubleValue();
            return new Double(sum).toString();
        }
        return "";
    }
}
