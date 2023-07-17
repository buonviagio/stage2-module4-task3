package com.mjc.stage2.impl;

import com.mjc.stage2.Observer;
import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.entity.RectangleValues;
import com.mjc.stage2.event.RectangleEvent;

public class RectangleObserver  implements Observer {
    @Override
    public void handleEvent(RectangleEvent event) {
        Rectangle rectangle = event.getSource();
        double sideA = rectangle.getSideA();
        double sideB = rectangle.getSideB();
        RectangleValues rectangleValues = new RectangleValues(sideA * sideB, 2 * (sideA * sideB));
    }
    // Write your code here!
}
