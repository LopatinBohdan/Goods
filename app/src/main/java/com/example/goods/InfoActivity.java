package com.example.goods;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        ImageView img=findViewById(R.id.goodImg);
        TextView title=findViewById(R.id.goodTitle);
        TextView info=findViewById(R.id.goodInfo);

        Bundle arguments=getIntent().getExtras();

        String goodTitle="";
        String goodInfo="";
        int goodImg=0;
        if(arguments!=null){
            goodImg=(int)arguments.get("img");
            goodTitle=arguments.get("title").toString();
            goodInfo=arguments.get("info").toString();
        }

        title.setText(goodTitle);
        info.setText(goodInfo);
        img.setImageResource(goodImg);
    }
}
