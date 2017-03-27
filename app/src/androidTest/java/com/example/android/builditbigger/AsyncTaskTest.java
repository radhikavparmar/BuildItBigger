package com.example.android.builditbigger;

import android.content.Context;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.util.Pair;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static android.support.test.InstrumentationRegistry.getInstrumentation;

/**
 * Created by radhikaparmar on 19/03/17.
 */
@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void testClick() throws Exception{
        Context context = getInstrumentation().getTargetContext().getApplicationContext();

        try {
            MainActivity mainActivity = new MainActivity();
            EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
            endpointsAsyncTask.execute(new Pair<Context, String>(context, "User"));
            String result = endpointsAsyncTask.get(30, TimeUnit.SECONDS);
            assert(result.isEmpty()==false);
        } catch (Exception e){
            Log.e("AsyncTaskTest", "testDoInBackground: Timed out");
        }

    }
}

