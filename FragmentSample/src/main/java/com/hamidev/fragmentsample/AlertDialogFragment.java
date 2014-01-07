package com.hamidev.fragmentsample;



import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 *
 */
public class AlertDialogFragment extends DialogFragment {

    public static final String KEY_FOR_TITLE = "keyForTitle";
    public static final String KEY_FOR_MESSAGE = "keyForMessage";

    private String title = "Default Title";
    private String message = "Default Message";

    public AlertDialogFragment() {
        // Required empty public constructor
    }

    public AlertDialogFragment(String title, String message) {
        this.title = title;
        this.message = message;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(AlertDialogFragment.KEY_FOR_TITLE, this.title);
        outState.putString(AlertDialogFragment.KEY_FOR_MESSAGE, this.message);

        super.onSaveInstanceState(outState);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if(savedInstanceState != null)
        {
            this.title = savedInstanceState.getString(AlertDialogFragment.KEY_FOR_TITLE);
            this.message = savedInstanceState.getString(AlertDialogFragment.KEY_FOR_MESSAGE);
        }

        AlertDialog.Builder theBuilder = new AlertDialog.Builder(getActivity());
        theBuilder.setTitle(this.title).setMessage(this.message);

        return theBuilder.create();
    }
}
