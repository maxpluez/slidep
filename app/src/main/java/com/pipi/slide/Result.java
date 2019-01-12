package com.pipi.slide;

/**
 * Created by pipi- on 2018/3/4.
 */

public class Result {
    private Surface s;
    private SlidingObject so;
    private double angle;
    private double acceleration;
    public Result(Surface a,SlidingObject b,double c){
        s=a;
        so=b;
        angle=c;
    }

    public void calculateAcceleration(){
        double rad=angle/180*Math.PI;
        double result=(9.8*(double)(Math.sin(rad))-s.getFC()*9.8*(double)(Math.cos(rad)));
        acceleration=result;
    }

    public double calculateTime(){
        double dism=s.distance/100;
        calculateAcceleration();
        return (Math.pow(2*dism/(acceleration),0.5));
    }
    public Surface getSurface(){
        return s;
    }
    public SlidingObject getSlidingObject(){
        return so;
    }
    public double getAcce(){
        return acceleration;
    }
    public double getAngle(){
        return angle;
    }
}
