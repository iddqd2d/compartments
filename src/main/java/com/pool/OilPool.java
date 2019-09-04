package com.pool;

import lombok.Getter;

import java.util.Arrays;

@Getter
public class OilPool {
    private int capacityOil;
    private int[] wallsWithWater;


    public OilPool(int[] wallsWithWater) {
        this.wallsWithWater = wallsWithWater;
        calculateOilCapacity(wallsWithWater, capacityOil);
    }

    private int calculateOilCapacity(int[] wallsWithWater, int capacity) {
        int[] wallsAfterShake = removeEmptinessOutThePoolBorder(wallsWithWater);
        if (wallsAfterShake.length > 1) {
            return calculateOilCapacity(cutLineFromPool(wallsAfterShake), capacity + calculateOilCapacityInLine(wallsAfterShake));
        }
        this.capacityOil = capacity;
        return capacity;
    }

    private int calculateOilCapacityInLine(int[] walls) {
        int capacity = 0;
        for (int wall : walls) {
            if (wall == 0) {
                capacity++;
            }
        }
        return capacity;
    }

    private int[] removeEmptinessOutThePoolBorder(int[] walls) {
        int borderStart = 0;
        int borderFinish = 0;

        for (int i = 0; i < walls.length; i++) {
            if (walls[i] > 0) {
                borderStart = i;
                break;
            }
        }
        for (int i = walls.length - 1; i > 0; i--) {
            if (walls[i] > 0) {
                borderFinish = i;
                break;
            }
        }
        return Arrays.copyOfRange(walls, borderStart, borderFinish + 1);
    }

    private int[] cutLineFromPool(int[] walls) {
        int[] temp = new int[walls.length];
        for (int i = 0; i < walls.length; i++) {
            if (walls[i] != 0) {
                temp[i] = walls[i] - 1;
            }
        }
        return temp;
    }
}
