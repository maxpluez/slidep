package com.pipi.slide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Spinner;

public class GatherInfo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_gather_info);
    }
    protected void onGo(View view){
        Intent intent =new Intent(this, SlideActivity.class);
        Spinner boardType=(Spinner) findViewById(R.id.spinner);
        String boardMat=String.valueOf(boardType.getSelectedItem());
        Spinner slideType=(Spinner) findViewById(R.id.spinner2);
        String slideMat=String.valueOf(slideType.getSelectedItem());
        EditText dis=(EditText) findViewById(R.id.distance);
        Double dist=Double.parseDouble(dis.getText().toString());
        EditText fc=(EditText) findViewById(R.id.editText2);
        double fco=0;
        if (!fc.getText().toString().equals("")) {fco=Double.parseDouble(fc.getText().toString());}
        EditText ms=(EditText) findViewById(R.id.editText);
        double mass=Double.parseDouble(ms.getText().toString());
        EditText namediy=(EditText) findViewById(R.id.editText3);
        String name=null;
        if(!namediy.getText().toString().equals("")){name=namediy.getText().toString();}
        Bundle bundle=new Bundle();
        bundle.putString("boardMaterial",boardMat);
        bundle.putString("slideMaterial",slideMat);
        bundle.putDouble("distance",dist);
        bundle.putDouble("mass",mass);
        bundle.putString("name",name);
        if(boardMat.equals("DIYSurface")){bundle.putDouble("DIYFC",fco);}
        else{bundle.putDouble("DIYFC",0);}
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
