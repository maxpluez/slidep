package com.pipi.slide;

/**
 * Created by pipi- on 2018/3/4.
 */

public class Glass extends Surface {
    public Glass(double a){
        super(0.7,a);
        super.name="glass";
    }
    public double getFC(){
        return super.fricCoef;
    };
    public double getDistance(){
        return super.distance;
    };
    public void setDistance(double b){
        super.distance=b;
    }
    public String getName(){return super.name;}
}
