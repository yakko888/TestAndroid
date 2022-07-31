package co.personal.testandroid.activities.moviescreen

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import co.personal.testandroid.R
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MovieScreenTest{

    @get: Rule
    val movieRule = ActivityScenarioRule(MovieScreen::class.java)

    fun testListFragmentVisible_onAppLaunch(){
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
    }
    @Test
    fun hideBottonDetail(){
        onView(withId(R.id.rv_movies)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click()))
        pressBack()
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))

    }
}