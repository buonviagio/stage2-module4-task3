package com.mjc.stage2.warehouse;


import com.mjc.stage2.entity.RectangleValues;
import java.util.HashMap;
import java.util.Map;

public class RectangleWarehouse {
    private static RectangleWarehouse instance;
    private Map<Integer, RectangleValues> valueMap;

    private RectangleWarehouse() {
        this.valueMap = new HashMap<>();
    }

    public static RectangleWarehouse getInstance() {
        if (instance == null) {
            instance = new RectangleWarehouse();
        }
        return instance;
    }

    public RectangleValues get(Integer rectangleId) {
        return valueMap.get(rectangleId);
    }

    public RectangleValues put(Integer rectangleId, RectangleValues rectangleValues) {
        return valueMap.put(rectangleId, rectangleValues);
    }

    public boolean remove(Integer rectangleId, RectangleValues rectangleValues) {
        return valueMap.remove(rectangleId, rectangleValues);
    }
}
