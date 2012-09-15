package com.develogical;

import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.StringContains.containsString;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutSpa() throws Exception {
        assertThat(queryProcessor.process("SPA2012"), containsString("conference"));
    }

    @Test
    public void knowsAboutWhatIs() throws Exception {
    	//System.out.print(queryProcessor.process("what is 10 plus 30"));
        assertThat(queryProcessor.process("what is 10 plus 30"), containsString("40"));
    }

    @Test
    public void knowsAboutLargest() throws Exception {
    	//System.out.print(queryProcessor.process("what is 10 plus 30"));
        assertThat(queryProcessor.process("which of the following numbers is the largest: 940, 186, 14, 69"), containsString("940"));
    }
}
