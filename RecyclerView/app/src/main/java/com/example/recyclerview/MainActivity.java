package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    int images[]={R.drawable.alpha,R.drawable.beta,R.drawable.cupcake,R.drawable.donut,R.drawable.eclair,R.drawable.froyo,R.drawable.gingerbread,R.drawable.honeycomb,R.drawable.icecreamsandwich,
            R.drawable.jellybean,R.drawable.kitkat,R.drawable.lollipop,R.drawable.marshmallow,R.drawable.nougat,R.drawable.oreo,R.drawable.pie};
    String [] versions ={"Alpha","Beta","Cupcake","Donut","Eclair",
            "Froyo","GingerBread","HoneyComb","IcecreamSandwich","JellyBean",
            "Kitkat","Lollipop","Marshmallow","Nougat","Oreo","Pie"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.recycler);
        rv.setAdapter(new MyDataAdapter(this,images,versions));
        rv.setLayoutManager(new LinearLayoutManager(this));
        //rv.setLayoutManager(new StaggeredLayoutManager(2,1));
        //rv.setLayoutManager(new GridLayoutManager(this,2));
    }
}

