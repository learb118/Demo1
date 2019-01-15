package com.nd.android.demo1;

import android.app.Dialog;
import android.support.constraint.ConstraintLayout;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasBackground;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withResourceName;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

/**
 * Created by Administrator on 2019/1/8.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class UiMainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void InitStateTest()throws Exception{
        onView(withId(R.id.linearLayout)).check(matches(hasBackground(R.drawable.white_container)));
        onView(withId(R.id.layout_all)).check(matches(hasBackground(R.drawable.background)));
        onView(withId(R.id.constraintLayout)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));//小框可见
        onView(withId(R.id.btn_close)).check(matches(isEnabled()));//关闭小框按钮可点
    }


    @Test
    public void ButtonTest()throws Exception{
        onView(withId(R.id.constraintLayout)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));//小框可见
        Thread.sleep(2000);
        onView(withId(R.id.btn_close)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_close)).perform(click());//点击关闭小框按钮
        onView(withId(R.id.btn_activecase)).check(matches(isEnabled()));//打开小框按钮可点
        onView(withId(R.id.constraintLayout)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));//小框不可见

        onView(withId(R.id.btn_activecase)).perform(click());//点击打开小框按钮
        onView(withId(R.id.btn_activecase)).check(matches(not(isEnabled())));//打开小框按钮不可点
        onView(withId(R.id.constraintLayout)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));//小框可见

    }

}