package com.example.barclaysinterviewproject.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.barclaysinterviewproject.R;
import com.example.barclaysinterviewproject.fragments.DetailsFragment;
import com.example.barclaysinterviewproject.fragments.DisplayResultsFragment;
import com.example.barclaysinterviewproject.fragments.SearchFragment;
import com.example.barclaysinterviewproject.parser.ResultItem;

public class MainActivity extends AppCompatActivity implements SearchFragment.OnSearchFragmentInteractionListener,
        DisplayResultsFragment.OnListFragmentInteractionListener {

    private ResultItem mResultItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Attach Search fragment
        replaceFragment(SearchFragment.newInstance(), false);
    }

    /**
     * Callback from SearchFragment
     * @param resultItem Main object from server for search after parsing
     */
    @Override
    public void onDataArrived(ResultItem resultItem) {
        if(resultItem != null && resultItem.getResults().size() > 0) {
            mResultItem = resultItem;

            replaceFragment(DisplayResultsFragment.newInstance(resultItem), true);
        }
        else{ //Error occured
            Snackbar.make(findViewById(android.R.id.content), getString(R.string.error_message), Snackbar.LENGTH_LONG)
                    .setActionTextColor(Color.RED)
                    .show();
        }
    }

    /**
     * Callback from DisplayResultsFragment
     * @param position clicked position on the RecyclerView list
     */
    @Override
    public void onListFragmentInteraction(int position) {
        replaceFragment(DetailsFragment.newInstance(mResultItem.getResults().get(position)), true);
    }

    /**
     * Utility method to replace current fragment with a new one
     * @param fragment Fragment to replace with
     * @param addToBackStack Whether to add the new fragment to the backstack
     */
    private void replaceFragment(Fragment fragment, boolean addToBackStack){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, fragment);
        if(addToBackStack)
            fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
