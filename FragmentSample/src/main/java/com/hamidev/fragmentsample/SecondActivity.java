package com.hamidev.fragmentsample;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.EditText;

public class SecondActivity extends ActionBarActivity {

    public static final String NAME_FOR_EXTRA_DATA = "justSimpleName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        PlaceholderFragment.theIntent = getIntent();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment(), "secondPlaceHolderFragmentTag")
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void goBackAndCorrect(View view) {
        Intent intentForMainActivity = new Intent(this, MainActivity.class);
        intentForMainActivity.putExtra(SecondActivity.NAME_FOR_EXTRA_DATA, ((EditText) getSupportFragmentManager()
                .findFragmentByTag("secondPlaceHolderFragmentTag").getView().findViewById(R.id.editTextSecond)).getText().toString());

        startActivity(intentForMainActivity);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public static Intent theIntent;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_second, container, false);

            if (theIntent != null)
                ((EditText) rootView.findViewById(R.id.editTextSecond)).setText(theIntent.getStringExtra(MainActivity.NAME_FOR_EXTRA));

            return rootView;
        }
    }

}
