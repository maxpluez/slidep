package com.pipi.slide;

/**
 * Created by pipi- on 2018/3/4.
 */

public class Iron extends Surface {
    public Iron(double a){
        super(1.0,a);
        super.name="iron";
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
