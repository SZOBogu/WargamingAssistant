package testCommon;

import common.ArrayOrderMixer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class testArrayOrderMixer {
    List<Object> dummyList = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    ArrayOrderMixer arrayOrderMixer = new ArrayOrderMixer();

    @Test
    void testGetArrayInRandomOrder(){
        List<Object> resultList = arrayOrderMixer.getArrayInRandomOrder(dummyList);
        assertTrue(resultList.contains("1"));
        assertTrue(resultList.contains("2"));
        assertTrue(resultList.contains("3"));
        assertTrue(resultList.contains("4"));
        assertTrue(resultList.contains("5"));
        assertTrue(resultList.contains("6"));
        assertTrue(resultList.contains("7"));
        assertTrue(resultList.contains("8"));
        assertTrue(resultList.contains("9"));
        assertTrue(resultList.contains("10"));
        assertFalse(resultList.contains(""));
        assertEquals(10, resultList.size());
    }
}
