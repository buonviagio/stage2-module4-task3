package com.mjc.stage2.impl;

import com.mjc.stage2.Observer;
import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.entity.RectangleValues;
import com.mjc.stage2.event.RectangleEvent;
import com.mjc.stage2.warehouse.RectangleWarehouse;

public class RectangleObserver implements Observer {
    @Override
    public void handleEvent(RectangleEvent event) {
        Rectangle rectangle = event.getSource();
        double sideA = rectangle.getSideA();
        double sideB = rectangle.getSideB();
        int id = rectangle.getId();
        RectangleWarehouse rectangleWarehouse = RectangleWarehouse.getInstance();
        if (rectangleWarehouse.get(id) == null) {
            rectangleWarehouse.put(id, new RectangleValues(sideA * sideB, 2 * (sideA * sideB)));
        } else {
            RectangleValues rectangleValues = rectangleWarehouse.get(id);
            rectangleValues.setSquare(sideA * sideB);
            rectangleValues.setPerimeter(2 * (sideA * sideB));
        }
    }
    // Write your code here!
}
