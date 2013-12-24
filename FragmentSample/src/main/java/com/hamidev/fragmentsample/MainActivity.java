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

public class MainActivity extends ActionBarActivity {

    public final static String NAME_FOR_EXTRA = "simpleName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PlaceholderFragment.intent = getIntent();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment(), "mainPlaceHolderFragmentTag")
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    public String getInputData()
    {
        return ((EditText) getSupportFragmentManager()
                .findFragmentByTag("mainPlaceHolderFragmentTag")
                .getView().findViewById(R.id.editText))
                .getText().toString();
    }

    public void showAlertDialog(View view) {
        AlertDialogFragment myDialog = new AlertDialogFragment("Hamid Behnam", getInputData()
                );

        myDialog.show(getSupportFragmentManager(), "AlertDialogFragmentTag");
    }

    public void openAnotherActivity(View view) {
        Intent theIntent = new Intent(this, SecondActivity.class);
        theIntent.putExtra(MainActivity.NAME_FOR_EXTRA, getInputData());
        startActivity(theIntent);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        public static Intent intent;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            if (intent != null) {
                ((EditText) rootView.findViewById(R.id.editText)).setText(intent.getStringExtra(SecondActivity.NAME_FOR_EXTRA_DATA));
            }

            return rootView;
        }
    }

}
