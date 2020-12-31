package hr.fer.advanced_databases.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class EpochConverterTest {

    @Test
    public void convertTest() {
        String time = EpochConverter.convertFromEpoch("1336780800");
        assertEquals("2012-05-12T02:00:00", time);
    }

}