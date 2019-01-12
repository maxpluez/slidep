package com.pipi.slide;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class Presentation extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_presentation);

        Intent ii=getIntent();
        Result r;
        TextView t;
        String s;
        int n=1;

        if(!Stack.isEmpty()) {
            r=Stack.pop();
            t=(TextView)findViewById(R.id.t1);
            s=(""+n+". "+"Object: "+r.getSlidingObject().getName()+"; f coefficient: "+r.getSurface().getFC()+"; a="+r.getAcce()+"m/s"+"; angle="+(int)(r.getAngle()));
            t.setText(s);
            n++;
        }
        if(!Stack.isEmpty()) {
            r=Stack.pop();
            t=(TextView)findViewById(R.id.t2);
            s=(""+n+". "+"Object: "+r.getSlidingObject().getName()+"; f coefficient: "+r.getSurface().getFC()+"; a="+r.getAcce()+"m/s"+"; angle="+(int)(r.getAngle()));
            t.setText(s);
            n++;
        }
        if(!Stack.isEmpty()) {
            r=Stack.pop();
            t=(TextView)findViewById(R.id.t3);
            s=(""+n+". "+"Object: "+r.getSlidingObject().getName()+"; f coefficient: "+r.getSurface().getFC()+"; a="+r.getAcce()+"m/s"+"; angle="+(int)(r.getAngle()));
            t.setText(s);
            n++;
        }
        if(!Stack.isEmpty()) {
            r=Stack.pop();
            t=(TextView)findViewById(R.id.t4);
            s=(""+n+". "+"Object: "+r.getSlidingObject().getName()+"; f coefficient: "+r.getSurface().getFC()+"; a="+r.getAcce()+"m/s"+"; angle="+(int)(r.getAngle()));
            t.setText(s);
            n++;
        }
        if(!Stack.isEmpty()) {
            r=Stack.pop();
            t=(TextView)findViewById(R.id.t5);
            s=(""+n+". "+"Object: "+r.getSlidingObject().getName()+"; f coefficient: "+r.getSurface().getFC()+"; a="+r.getAcce()+"m/s"+"; angle="+(int)(r.getAngle()));
            t.setText(s);
            n++;
        }
        if(!Stack.isEmpty()) {
            r=Stack.pop();
            t=(TextView)findViewById(R.id.t6);
            s=(""+n+". "+"Object: "+r.getSlidingObject().getName()+"; f coefficient: "+r.getSurface().getFC()+"; a="+r.getAcce()+"m/s"+"; angle="+(int)(r.getAngle()));
            t.setText(s);
            n++;
        }
        if(!Stack.isEmpty()) {
            r=Stack.pop();
            t=(TextView)findViewById(R.id.t7);
            s=(""+n+". "+"Object: "+r.getSlidingObject().getName()+"; f coefficient: "+r.getSurface().getFC()+"; a="+r.getAcce()+"m/s"+"; angle="+(int)(r.getAngle()));
            t.setText(s);
            n++;
        }
        if(!Stack.isEmpty()) {
            r=Stack.pop();
            t=(TextView)findViewById(R.id.t8);
            s=(""+n+". "+"Object: "+r.getSlidingObject().getName()+"; f coefficient: "+r.getSurface().getFC()+"; a="+r.getAcce()+"m/s"+"; angle="+(int)(r.getAngle()));
            t.setText(s);
            n++;
        }
        if(!Stack.isEmpty()) {
            r=Stack.pop();
            t=(TextView)findViewById(R.id.t9);
            s=(""+n+". "+"Object: "+r.getSlidingObject().getName()+"; f coefficient: "+r.getSurface().getFC()+"; a="+r.getAcce()+"m/s"+"; angle="+(int)(r.getAngle()));
            t.setText(s);
            n++;
        }
        if(!Stack.isEmpty()) {
            r=Stack.pop();
            t=(TextView)findViewById(R.id.t10);
            s=(""+n+". "+"Object: "+r.getSlidingObject().getName()+"; f coefficient: "+r.getSurface().getFC()+"; a="+r.getAcce()+"m/s"+"; angle="+(int)(r.getAngle()));
            t.setText(s);
            n++;
        }
    }
}
