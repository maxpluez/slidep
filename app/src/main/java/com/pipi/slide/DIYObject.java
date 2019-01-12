package com.pipi.slide;

/**
 * Created by pipi- on 2018/3/22.
 */

public class DIYObject extends SlidingObject {
    private String name;
    public DIYObject(double m, String a, boolean b){
        super(b,m);
        name=a;
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
    public String getName(){return (name);}
    public void setName(String n){name=n;}
}
