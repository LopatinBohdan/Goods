package com.example.goods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Good> goods=new ArrayList<>();
    ListView goodsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInitialData();

        goodsList=findViewById(R.id.goodsList);

        GoodAdapter goodAdapter=new GoodAdapter(this,R.layout.list_item, goods);

        goodsList.setAdapter(goodAdapter);

        AdapterView.OnItemClickListener itemListener= (parent, view, position, l) -> {
            Good selectedGood=(Good)parent.getItemAtPosition(position);
//            Toast.makeText(getApplicationContext(),"selected" + selectedGood.getTitle(),
//                    Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(view.getContext(), InfoActivity.class);
            intent.putExtra("title", selectedGood.getTitle());
            intent.putExtra("info", selectedGood.getInfo());
            intent.putExtra("img", selectedGood.getImgResource());
            startActivity(intent);
        };

        goodsList.setOnItemClickListener(itemListener);


    }

    private void setInitialData(){
        goods.add(new Good("good1", "info1", R.drawable.images));
        goods.add(new Good("good2", "info2",R.drawable.images));

    }
}