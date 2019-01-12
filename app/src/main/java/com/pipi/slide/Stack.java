package com.pipi.slide;


/**
 * Created by pipi- on 2018/3/5.
 */

public class Stack {
    protected static Result[] result=new Result[10];
    protected static int flag=-1;
    public static boolean isFull(){
        if(flag==9){return true;}
        else return false;
    }
    public static boolean isEmpty(){
        if(flag==-1){return true;}
        else return false;
    }
    public static void push(Result r){
        if(!isFull()) {
            flag++;
            result[flag] = r;
        }
        else{
            for(int i=0;i<9;i++){
                result[i]=result[i+1];
            }
            result[9]=r;
        }
    }
    public static Result pop(){
        if(!isEmpty()){
            Result r=result[flag];
            flag--;
            return r;
        }
        return null;
    }
}
