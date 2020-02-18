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
        List<Object> elementList = arrayOrderMixer.getArrayInRandomOrder(dummyList);
        assertTrue(elementList.contains("1"));
        assertTrue(elementList.contains("2"));
        assertTrue(elementList.contains("3"));
        assertTrue(elementList.contains("4"));
        assertTrue(elementList.contains("5"));
        assertTrue(elementList.contains("6"));
        assertTrue(elementList.contains("7"));
        assertTrue(elementList.contains("8"));
        assertTrue(elementList.contains("9"));
        assertTrue(elementList.contains("10"));
        assertFalse(elementList.contains("-1"));
        assertFalse(elementList.contains("0"));
        assertEquals(10, elementList.size());
    }
}
