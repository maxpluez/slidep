package com.pipi.slide;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SlideActivity extends AppCompatActivity implements SensorEventListener {

    protected SensorManager sm;
    protected Sensor aSensor;
    protected Sensor mSensor;

    float[] accelerometerValues =new float[3];
    float[] magneticFieldValues=new float[3];//values returned by sensers that are used to calculate rotational matrix

    private TextView xx;
    private TextView yy;
    private TextView zz;
    private ImageView im1;//596dp
    private ImageView im2;
    private TextView a;
    private TextView dist1;
    private TextView tv;//layout components

    private double width;
    private String dis;
    private double angle;
    private Surface s=null;
    private SlidingObject so=null;
    private double d;
    private double diyFC=0;
    private String boardMat;
    private String slideMat;
    private String diyName;//inputs

    private Result re=null;

    private int wid;//width of the screen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_slide);

        Intent intent=getIntent();
        Bundle b=intent.getExtras();
        boardMat=b.getString("boardMaterial");
        slideMat=b.getString("slideMaterial");
        diyName=b.getString("name");

        d=b.getDouble("distance");
        double mass=b.getDouble("mass");
        diyFC=b.getDouble("DIYFC");//retrieving input

        if (slideMat.equals("ball")){
            so=new Ball(mass);
        }
        else if(slideMat.equals("block")){
            so=new Block(mass);
        }
        //s=new Wood(d);
        if(boardMat.equals("glass")){
            s=new Glass(d);
        }
        else if(boardMat.equals("iron")){
            s=new Iron(d);
        }
        else if(boardMat.equals("wood")){
            s=new Wood(d);
        }
        else if(boardMat.equals("DIYSurface")){
            //double coeff=b.getDouble("DIYFC");
            s=new DIYSurface(diyFC,d,diyName);
        }//creating so and s objects

        tv=(TextView) findViewById(R.id.textView);

        TextView board1=(TextView) findViewById(R.id.board);
        TextView slidee1=(TextView) findViewById(R.id.slidee);
        dist1=(TextView) findViewById(R.id.dist);
        if(boardMat.equals("DIYSurface")){board1.setText(s.getName());}
        else{board1.setText(boardMat);}
        slidee1.setText(slideMat);
        dist1.setText("d="+d);

        xx=(TextView) findViewById(R.id.xv);
        yy=(TextView) findViewById(R.id.yv);
        zz=(TextView) findViewById(R.id.zv);
        a=(TextView) findViewById(R.id.acceleration);

        sm=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        aSensor=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensor=sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        im1=(ImageView) findViewById(R.id.item);
        if(slideMat.equals("ball")){im1.setImageResource(R.drawable.ball);}

        WindowManager wm=(WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm=new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        wid=dm.widthPixels;

        ViewGroup.LayoutParams lp=im1.getLayoutParams();
        double dd=wid*5/(d+5);
        width=dd;
        lp.width=(int)dd;
        im1.setLayoutParams(lp);

        im2=(ImageView) findViewById(R.id.item2);
        ViewGroup.LayoutParams lp1=im2.getLayoutParams();
        lp1.width=wid;
        lp1.height=20;
        im2.setLayoutParams(lp1);
        im2.setTop(im1.getBottom());//setting layouts and sensors
    }
    @Override
    public void onPause(){
        sm.unregisterListener(this);
        sm.unregisterListener(this);
        super.onPause();
    }
    @Override
    public void onResume(){
        sm.registerListener(this,aSensor,SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(this,mSensor,SensorManager.SENSOR_DELAY_NORMAL);
        super.onResume();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if (sensorEvent.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)
            magneticFieldValues = sensorEvent.values;
        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
            accelerometerValues = sensorEvent.values;
        calculateOrientation();}

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

    protected float calculateOrientation() {
        float[] values = new float[3];
        float[] R = new float[9];
        sm.getRotationMatrix(R, null, accelerometerValues, magneticFieldValues);
        sm.getOrientation(R, values);

        values[0] = (float) Math.toDegrees(values[0]);
        values[1] = (float) Math.toDegrees(values[1]);
        values[2] = (float) Math.toDegrees(values[2]);

        yy.setText(String.valueOf(values[1]));
        return values[1];
    }

    public void onStartTrial(View view){
        float startV=wid-(int)width;
        ValueAnimator animate =ValueAnimator.ofFloat(startV,0f);
        if(calculateAccelerationPixel()>0){
        animate.setTarget(im1);
        animate.setDuration(calculateTimePixel());
        animate.setInterpolator(new AccelerateInterpolator());
        animate.start();
        animate.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                im1.setX((Float)animation.getAnimatedValue());
            }
        });}

        a.setText(String.valueOf(calculateAccelerationPixel()));
    }

    public float calculateAccelerationPixel(){
        double degree=(double) calculateOrientation();
        zz.setText(String.valueOf(degree));
        Result re=new Result(s,so,degree);
        re.calculateAcceleration();
        return (float)(re.getAcce());
    }

    public int calculateTimePixel(){
        double degree=(double) calculateOrientation();
        Result re=new Result(s,so,degree);
        float times=(float)re.calculateTime();
        Stack.push(re);
        return (int)(times*1000);
    }

    public void onGo(View view){
        Intent ii=new Intent(this,Presentation.class);
        startActivity(ii);
    }

    public float[] getOrientation(float[] R, float values[]) {
        values[0] = (float)Math.atan2(R[1], R[4]);
        values[1] = (float)Math.asin(-R[7]);
        values[2] = (float)Math.atan2(-R[6], R[8]);
        return values;
    }
}
