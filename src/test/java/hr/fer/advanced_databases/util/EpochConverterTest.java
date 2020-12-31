package hr.fer.advanced_databases.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class EpochConverterTest {

    @Test
    public void convertTest() {
        String time = EpochConverter.convertFromEpoch("1336780800");
        assertEquals("12/05/2012 02:00:00", time);
    }

}