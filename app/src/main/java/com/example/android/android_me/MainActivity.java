package com.example.android.android_me;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.ui.AndroidMeActivity;
import com.example.android.android_me.ui.MasterListFragment;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListner {

    int headIndex;
    int bodyIndex;
    int legsIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onImageSelected(int position){

        int bodyPartNumber = position/12;
        int listIndex = position - 12*bodyPartNumber;

        switch (bodyPartNumber){
            case 0: headIndex = listIndex;
                break;
            case 1: bodyIndex = listIndex;
                break;
            case 2: legsIndex = listIndex;
                break;
        }

        Bundle bundle = new Bundle();
        bundle.putInt("headIndex",headIndex);
        bundle.putInt("bodyIndex",bodyIndex);
        bundle.putInt("legsIndex",legsIndex);

        final Intent intent = new Intent(this, AndroidMeActivity.class);
        intent.putExtras(bundle);

        Button nextBtn = (Button)findViewById(R.id.next_btn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(intent);
            }
        });

    }

}
