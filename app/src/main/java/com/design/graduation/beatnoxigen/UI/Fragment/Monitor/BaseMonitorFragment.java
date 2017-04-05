package com.design.graduation.beatnoxigen.UI.Fragment.Monitor;


import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.design.graduation.beatnoxigen.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public abstract class BaseMonitorFragment extends Fragment {
    protected Spinner mModeSpinner;
    private ModeListener mModeListener;

    public BaseMonitorFragment() {
        // Required empty public constructor
    }

    public void setModeListener(ModeListener ml) {
        mModeListener = ml;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState, String[] modes, ModeListener ml) {
        // Inflate the layout for this fragment
        mModeListener = ml;
        View rootView = inflater.inflate(R.layout.fragment_base_monitor, container, false);
        mModeSpinner = (Spinner) rootView.findViewById(R.id.modeSpinner);
        mModeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                Fragment panel = mModeListener.getSelectedPanel(pos);
                FragmentTransaction trans = getFragmentManager().beginTransaction();
                trans.replace(R.id.monitorContent, panel);
                trans.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mModeSpinner.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, modes));
        return rootView;
    }

    public interface ModeListener {
        Fragment getSelectedPanel(int pos);
    }

}
