/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.List;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int headIndex = bundle.getInt("headIndex");
        int bodyIndex = bundle.getInt("bodyIndex");
        int legsIndex = bundle.getInt("legsIndex");

        if (savedInstanceState == null){
            BodyPartFragment headFragment = new BodyPartFragment();
            setFragment(headFragment,AndroidImageAssets.getHeads(),R.id.head_container,headIndex);

            BodyPartFragment bodyFragment = new BodyPartFragment();
            setFragment(bodyFragment,AndroidImageAssets.getBodies(),R.id.body_container,bodyIndex);

            BodyPartFragment legsFragment = new BodyPartFragment();
            setFragment(legsFragment,AndroidImageAssets.getLegs(),R.id.legs_container,legsIndex);
        }
    }

    private void setFragment(BodyPartFragment fragment, List<Integer> bodyPart, int cointainerId, int listIndex){

        fragment.setmImageIds(bodyPart);
        fragment.setmListIndex(listIndex);

        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add(cointainerId,fragment)
                .commit();
    }
}
