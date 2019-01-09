package com.nd.android.demo1;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.doubleClick;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasBackground;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;


/**
 * Created by Administrator on 2019/1/8.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class UIImageAdapterTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void AdapterViewTest() {
        onData(allOf(is(instanceOf(Image.class)), myImageMatcher())).inAdapterView(withId(R.id.rv_image));
        onView(ViewMatchers.withId(R.id.rv_image))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0,
                        doubleClick() ) );
        onView(withId(R.id.imageView2)).check(matches(isDisplayed()));
        onView(withId(R.id.imageView2)).perform(click()).check(doesNotExist());
    }

    private static Matcher<Object> myImageMatcher() {
        return new BoundedMatcher<Object,Image>(Image.class) {
            @Override
            protected boolean matchesSafely(Image item) {
                return true;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("with item content: ");
            }
        };
    }
}