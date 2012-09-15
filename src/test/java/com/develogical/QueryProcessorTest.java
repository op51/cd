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
    public void knowsAboutWhatIsPlus() throws Exception {
    	//System.out.print(queryProcessor.process("what is 10 plus 30"));
        assertThat(queryProcessor.process("76EDA090: what is 10 plus 30"), containsString("40"));
    }
    @Test
    public void knowsAboutWhatIsMinus() throws Exception {
    	//System.out.print(queryProcessor.process("what is 10 plus 30"));
        assertThat(queryProcessor.process("76EDA090: what is 30 minus 10"), containsString("20"));
    }

    @Test
    public void knowsAboutLargest4() throws Exception {
    	//System.out.print(queryProcessor.process("what is 10 plus 30"));
        assertThat(queryProcessor.process("76EDA090: which of the following numbers is the largest: 940, 186, 14, 69"), containsString("940"));
    }
    @Test
    public void knowsAboutLargest2() throws Exception {
    	//System.out.print(queryProcessor.process("what is 10 plus 30"));
        assertThat(queryProcessor.process("76EDA090: which of the following numbers is the largest: 12, 186"), containsString("186"));
    }
}
