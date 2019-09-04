package com.pool;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import static org.junit.Assert.assertSame;

@Log4j
public class OilPoolTest {

    @Test
    public void calculateOilCapacityInEmptyPool() {
        int[] pool = new int[0];
        OilPool oilPool = new OilPool(pool);
        assertSame(oilPool.getCapacityOil(), 0);
    }

    @Test
    public void calculateOilCapacityInPoolWithCleanFloor() {
        int[] pool = new int[]{3,0,0,3};
        OilPool oilPool = new OilPool(pool);
        assertSame(oilPool.getCapacityOil(), 6);
    }

    @Test
    public void calculateOilCapacityInPoolWithDirtyFloor() {
        int[] pool = new int[]{3,2,1,2,3};
        OilPool oilPool = new OilPool(pool);
        assertSame(oilPool.getCapacityOil(), 4);
    }

    @Test
    public void calculateOilCapacityInPoolWithOneWall() {
        int[] pool = new int[]{5};
        OilPool oilPool = new OilPool(pool);
        assertSame(oilPool.getCapacityOil(), 0);
    }

    @Test
    public void calculateOilCapacityInPoolWithEmptinessOutTheBorder() {
        int[] pool = new int[]{0,0,5,0,2,0,0};
        OilPool oilPool = new OilPool(pool);
        assertSame(oilPool.getCapacityOil(), 2);
    }

    @Test(expected = NullPointerException.class)
    public void calculateOilCapacityInPoolWithoutPool() {
        int[] pool = null;
        OilPool oilPool = new OilPool(pool);
    }
}
