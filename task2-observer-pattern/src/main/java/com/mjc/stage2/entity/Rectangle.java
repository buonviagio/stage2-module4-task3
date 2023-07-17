package com.mjc.stage2.entity;

import com.mjc.stage2.Observable;
import com.mjc.stage2.Observer;
import com.mjc.stage2.event.RectangleEvent;

import java.util.ArrayList;
import java.util.List;

public class Rectangle implements Observable {
    private int id;
    private double sideA;
    private double sideB;

    // Write your code here!
    List<Observer> observes = new ArrayList<>();
    public Rectangle(int id, double sideA, double sideB) {
        this.id = id;
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
        // Write your code here!
        notifyObserver();
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
        // Write your code here!
        notifyObserver();
    }

    @Override
    public void addObserver(Observer o) {
        observes.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observes.remove(o);
    }

    @Override
    public void notifyObserver() {
        RectangleEvent rectangleEvent = new RectangleEvent(this);
        observes.forEach(observer -> observer.handleEvent(rectangleEvent));
    }
// Write your code here!
}
