package com.pipi.slide;

/**
 * Created by pipi- on 2018/3/4.
 */

public class Ball extends SlidingObject {
    public Ball(double m){
        super(false,m);
    }
    public void setMass(double mm){
        super.mass=mm;
    }
    public double getMass(){
        return(super.mass);
    }
    public boolean getHasFriction(){
        return (super.hasFriction);
    }
    public String getName(){return ("Ball");}
}
