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
import android.os.AsyncTask;
import java.util.List;
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
import javax.xml.transform.*;

public class EarthquakeActivity extends Activity {
    private static final String USGS_REQUEST_URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2016-01-01&endtime=2016-05-02&minfelt=50&minmagnitude=5";
    private DataApdapter mAdapter;

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        EarthquakeAsyncTask task = new EarthquakeAsyncTask();
        task.execute(USGS_REQUEST_URL);




        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        mAdapter = new DataApdapter(this, new ArrayList<Data>());

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(mAdapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Data item = mAdapter.getItem(i);
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getUrl()));
                startActivity(webIntent);
            }
        });}
    private class EarthquakeAsyncTask extends AsyncTask<String, Void, List> {

        /**
         * This method is invoked (or called) on a background thread, so we can perform
         * long-running operations like making a network request.
         *
         * It is NOT okay to update the UI from a background thread, so we just return an
         * {@link Data} object as the result.
         */
        protected List <Data> doInBackground(String... urls) {
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }
            List<Data> result =  QueryUtils.fetchEarthquakeData(urls[0]);

            return result;
        }

        /**
         * This method is invoked on the main UI thread after the background work has been
         * completed.
         *
         * It IS okay to modify the UI within this method. We take the {@link Data} object
         * (which was returned from the doInBackground() method) and update the views on the screen.
         */
        protected void onPostExecute(List<Data> data) {
            mAdapter.clear();
            if (data != null && !data.isEmpty()) {
                mAdapter.addAll(data);
            }

        }
    }
}
