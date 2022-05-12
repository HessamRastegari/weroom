package hessam.rastegari.weroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    ArrayList<String> dataSource;
    LinearLayoutManager linearLayoutManager;
    MyRvAdapter myRvAdapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.horizontalRv);
        dataSource = new ArrayList<>();
        dataSource.add("Digital Marketing Design");
        dataSource.add("Natural Matters");
        dataSource.add("Educational");
        dataSource.add("Partnership");
        dataSource.add("Just For Fun");
        dataSource.add("Feeling Sad");
        dataSource.add("*****");


        linearLayoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        myRvAdapter = new MyRvAdapter(dataSource,MainActivity.this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(myRvAdapter);
    }
}