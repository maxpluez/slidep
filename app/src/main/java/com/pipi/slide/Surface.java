package com.pipi.slide;

/**
 * Created by pipi- on 2018/3/4.
 */

public abstract class Surface {
    protected double fricCoef;
    protected double distance;
    protected String name;
    public Surface(double a,double b){
        fricCoef=a;
        distance=b;
    }
    public abstract double getFC();
    public abstract double getDistance();
    public abstract void setDistance(double b);
    public abstract String getName();
}
