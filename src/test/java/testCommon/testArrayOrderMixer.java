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
        List<Integer> indexList = arrayOrderMixer.getArrayIndexesInRandomOrder(dummyList);
        assertTrue(indexList.contains(0));
        assertTrue(indexList.contains(1));
        assertTrue(indexList.contains(2));
        assertTrue(indexList.contains(3));
        assertTrue(indexList.contains(4));
        assertTrue(indexList.contains(5));
        assertTrue(indexList.contains(6));
        assertTrue(indexList.contains(7));
        assertTrue(indexList.contains(8));
        assertTrue(indexList.contains(9));
        assertFalse(indexList.contains(-1));
        assertFalse(indexList.contains(10));
        assertEquals(10, indexList.size());
    }
}
