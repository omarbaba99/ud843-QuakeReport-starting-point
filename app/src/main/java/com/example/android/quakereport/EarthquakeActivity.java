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
import android.content.UriPermission;
import android.content.UriMatcher;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import java.util.ArrayList;
import android.content.Intent;
import java.net.*;
import java.net.URI;
import android.net.*;

public class EarthquakeActivity extends Activity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        final ArrayList<Data> earthquakes = QueryUtils.extractEarthquakes();




        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        DataApdapter adapter = new DataApdapter(this,earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Data item = earthquakes.get(i);
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getUrl()));
                startActivity(webIntent);
            }
        });
    }}
