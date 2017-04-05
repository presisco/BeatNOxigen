package com.design.graduation.beatnoxigen.UI.Fragment.Monitor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.design.graduation.beatnoxigen.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ValuePanelFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ValuePanelFragment extends Fragment {

    private String mTitle;
    private String mHint;
    private TextView mValue;

    public ValuePanelFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param title Panel Title.
     * @param hint  Panel Hint.
     * @return A new instance of fragment ValuePanelFragment.
     */
    public static ValuePanelFragment newInstance(String title, String hint) {
        ValuePanelFragment fragment = new ValuePanelFragment();
        Bundle args = new Bundle();
        args.putString("TITLE", title);
        args.putString("HINT", hint);
        fragment.setArguments(args);
        return fragment;
    }

    public void updateValue(String value) {
        mValue.setText(value);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = getArguments().getString("TITLE");
            mHint = getArguments().getString("HINT");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_value_panel, container, false);
        ((TextView) rootView.findViewById(R.id.textTitle)).setText(mTitle);
        ((TextView) rootView.findViewById(R.id.textHint)).setText(mHint);
        mValue = (TextView) rootView.findViewById(R.id.textValue);
        return rootView;
    }

}
