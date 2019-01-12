package com.pipi.slide;

/**
 * Created by pipi- on 2018/3/4.
 */

public abstract class SlidingObject {
    protected boolean hasFriction;
    protected double mass;
    public SlidingObject(boolean hf, double m){
        hasFriction=hf;
        mass=m;
    }
    public abstract void setMass(double mm);
    public abstract double getMass();
    public abstract boolean getHasFriction();
    public abstract String getName();
}
