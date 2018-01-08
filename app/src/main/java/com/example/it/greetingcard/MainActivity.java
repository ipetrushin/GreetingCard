package com.example.it.greetingcard;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    PostcardView postcardView;
    boolean startSnow = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postcardView = (PostcardView) findViewById(R.id.postcard);

    }
    public void onStep (View v) {
        MyTask myTask = new MyTask();
        myTask.execute();
    }

    // AsyncTask
    class MyTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            while (startSnow) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            for (int i = 0; i < postcardView.snow_x.length; i++) {

                postcardView.snow_y[i] += 0.02;
                if (postcardView.snow_y[i] > 1) {
                    postcardView.snow_y[i] = 0;
                }
            }
            postcardView.invalidate();
        }
    } ;

}
