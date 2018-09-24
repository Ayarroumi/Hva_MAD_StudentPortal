package com.example.anass.studentportal;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    public List<PortalObject> mPortalObjects = new ArrayList<>();
    private PortalObject portalObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getIntent();
        getIntent().getStringExtra("portalObject");

        mPortalObjects.add(new PortalObject("VLO","http://www.google.com"));

        RecyclerView mPortalRecyclerView = findViewById(R.id.RecylcerViewPortals);
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL);



        mPortalRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
                System.out.println("wooehooee");
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });


        mPortalRecyclerView.setLayoutManager(mLayoutManager);
        PortalObjectAdapter mAdapter = new PortalObjectAdapter(this,mPortalObjects);
        mPortalRecyclerView.setAdapter(mAdapter);

        fab = (FloatingActionButton) findViewById(R.id.addPortalButton);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddPortalActivity.class);
                startActivityForResult(intent,1234);
            }
    });
}

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == 1234){
                Bundle bundle = data.getExtras();
                PortalObject intentPortalObject = (PortalObject) bundle.getSerializable("portalObject");
                mPortalObjects.add(intentPortalObject);
            }
        }
    }

}
