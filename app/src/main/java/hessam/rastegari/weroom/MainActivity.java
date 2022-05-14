package hessam.rastegari.weroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv,catRV, currentHorizontalRv;
    ArrayList<String> dataSource, catDataSource, currentDatSource;
    ArrayList<Integer> imgDataSource, catImgDataSource;
    LinearLayoutManager linearLayoutManager,catLinearLayoutManager,currentLinearLayoutManager;
    ActiveweroomRVAdapter activeweroomRVAdapter;
    CategoriesRVAdapter categoriesRVAdapter;
    CurrentRVAdapter currentRVAdapter;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.horizontalRv);
        catRV = findViewById(R.id.catHorizontalRv);
        currentHorizontalRv = findViewById(R.id.currentHorizontalRv);

        dataSource = new ArrayList<>();
        imgDataSource = new ArrayList<>();
        catDataSource = new ArrayList<>();
        catImgDataSource = new ArrayList<>();
        currentDatSource = new ArrayList<>();

        dataSource.add("Digital Marketing Design");
        dataSource.add("Natural Matters");
        dataSource.add("Educational");
        dataSource.add("Partnership");
        dataSource.add("Just For Fun");
        dataSource.add("Feeling Sad");
        dataSource.add("*****");

        imgDataSource.add(R.drawable.avatar1);
        imgDataSource.add(R.drawable.avatar2);
        imgDataSource.add(R.drawable.avatar3);
        imgDataSource.add(R.drawable.avatar4);
        imgDataSource.add(R.drawable.avatar5);
        imgDataSource.add(R.drawable.avatar6);
        imgDataSource.add(R.drawable.avatar7);



        catDataSource.add("Arcade");
        catDataSource.add("For Fun");
        catDataSource.add("Pet");
        catDataSource.add("Feeling Sad");
        catDataSource.add("Business");
        catDataSource.add("Hot");
        catDataSource.add("PRIDE");

        catImgDataSource.add(R.drawable.ic_baseline_card_travel_24);
        catImgDataSource.add(R.drawable.ic_baseline_child_care_24);
        catImgDataSource.add(R.drawable.ic_baseline_card_travel_24);
        catImgDataSource.add(R.drawable.ic_baseline_child_care_24);
        catImgDataSource.add(R.drawable.ic_baseline_card_travel_24);
        catImgDataSource.add(R.drawable.ic_baseline_child_care_24);
        catImgDataSource.add(R.drawable.ic_baseline_card_travel_24);


        currentDatSource.add("Arcade");
        currentDatSource.add("For Fun");
        currentDatSource.add("Pet");
        currentDatSource.add("Feeling Sad");
        currentDatSource.add("Business");
        currentDatSource.add("Hot");
        currentDatSource.add("PRIDE");


        linearLayoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        activeweroomRVAdapter = new ActiveweroomRVAdapter(dataSource, imgDataSource, MainActivity.this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(activeweroomRVAdapter);


        catLinearLayoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        categoriesRVAdapter = new CategoriesRVAdapter(catDataSource, catImgDataSource, MainActivity.this);
        catRV.setLayoutManager(catLinearLayoutManager);
        catRV.setAdapter(categoriesRVAdapter);


        currentLinearLayoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        currentRVAdapter = new CurrentRVAdapter(currentDatSource, MainActivity.this);
        currentHorizontalRv.setLayoutManager(currentLinearLayoutManager);
        currentHorizontalRv.setAdapter(currentRVAdapter);
    }
}