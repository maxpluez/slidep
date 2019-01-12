package com.pipi.slide;

/**
 * Created by pipi- on 2018/3/4.
 */

public class DIYSurface extends Surface {

    public DIYSurface(double a,double b,String c){
        super(a,b);
        super.name=c;
    }
    public double getFC(){
        return super.fricCoef;
    };
    public double getDistance(){
        return super.distance;
    }
    public void setDistance(double b){
        super.distance=b;
    }
    public void setFC(double a){
        super.fricCoef=a;
    }
    public String getName(){return super.name;}
}
