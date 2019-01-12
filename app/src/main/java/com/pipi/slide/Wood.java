package com.pipi.slide;

/**
 * Created by pipi- on 2018/3/4.
 */

public class Wood extends Surface {
    public Wood(double a){
        super(0.4,a);
        super.name="wood";
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
