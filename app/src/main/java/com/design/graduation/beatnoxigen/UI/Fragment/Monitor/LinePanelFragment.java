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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LinePanelFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LinePanelFragment extends Fragment {

    private String mTitle;
    private String mHint;

    public LinePanelFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param title Parameter 1.
     * @param hint  Parameter 2.
     * @return A new instance of fragment LinePanelFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LinePanelFragment newInstance(String title, String hint) {
        LinePanelFragment fragment = new LinePanelFragment();
        Bundle args = new Bundle();
        args.putString("TITLE", title);
        args.putString("HINT", hint);
        fragment.setArguments(args);
        return fragment;
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
        View rootView = inflater.inflate(R.layout.fragment_line_panel, container, false);
        ((TextView) rootView.findViewById(R.id.textTitle)).setText(mTitle);
        ((TextView) rootView.findViewById(R.id.textHint)).setText(mHint);
        return rootView;
    }
}
