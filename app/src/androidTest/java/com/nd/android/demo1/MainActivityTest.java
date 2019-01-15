package com.nd.android.demo1;

import android.content.Intent;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.doubleClick;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by Administrator on 2019/1/8.
 */
public class MainActivityTest {
    private final ActivityTestRule<MainActivity> rule =
            new ActivityTestRule<>(MainActivity.class, false, false);

    private MainActivity mainActivity;

    @Before
    public void setUp() throws InterruptedException {
        rule.launchActivity(new Intent());
        mainActivity = rule.getActivity();
    }

    @Test
    public void dialogShowTest() throws Exception {
        mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Image image = new Image(R.drawable.apple_pic);
                mainActivity.dialogShow(image);
                assertEquals(mainActivity.dialog.isShowing(), true);
            }
        });
    }

    @Test
    public void ClickImageCallbackTest() throws Exception {
        mainActivity.getAdapter().setCallback(null);
        onView(ViewMatchers.withId(R.id.rv_image))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0,
                        doubleClick() ) );
        onView(withId(R.id.imageView2)).check(doesNotExist());
    }
}