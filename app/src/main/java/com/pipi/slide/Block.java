package com.pipi.slide;

/**
 * Created by pipi- on 2018/3/4.
 */

public class Block extends SlidingObject {
    public Block(double m){
        super(true,m);
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
    public String getName(){return ("Block");}
}
