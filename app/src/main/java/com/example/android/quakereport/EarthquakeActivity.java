/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        ArrayList<Data> earthquakes = new ArrayList<Data>();
        earthquakes.add(new Data(1.2,"Kano Sate","1 April, 2021"));
        earthquakes.add(new Data(2.3,"Kaduna State","2 May, 2022"));
        earthquakes.add(new Data(3.4,"Sokoto State","3 june, 2023"));
        earthquakes.add(new Data(4.5,"Katsina State","4 july, 2024"));
		earthquakes.add(new Data(5.6,"Gombe Sate","1 April, 2025"));
        earthquakes.add(new Data(2.3,"Jigawa State","2 May, 2022"));
        earthquakes.add(new Data(3.4,"Sokoto State","8 june, 2023"));
        earthquakes.add(new Data(4.5,"Kebbi State","4 july, 2024"));

		

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        DataApdapter adapter = new DataApdapter(this,earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
    }
}
