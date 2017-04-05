package com.design.graduation.beatnoxigen.UI.Fragment.Monitor;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.design.graduation.beatnoxigen.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HeartbeatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HeartbeatFragment extends BaseMonitorFragment implements BaseMonitorFragment.ModeListener {
    private String[] modes;
    private String[] hints;

    public HeartbeatFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment OxigenFragment.
     */
    public static HeartbeatFragment newInstance() {
        HeartbeatFragment fragment = new HeartbeatFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        modes = getResources().getStringArray(R.array.heartbeat_modes);
        hints = getResources().getStringArray(R.array.heartbeat_mode_hints);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState, modes, this);
    }

    @Override
    public Fragment getSelectedPanel(int pos) {
        Fragment panel = null;
        switch (pos) {
            case 0:
                panel = ValuePanelFragment.newInstance(modes[pos], hints[pos]);
                break;
            case 1:
                panel = LinePanelFragment.newInstance(modes[pos], hints[pos]);
                break;
            default:
                break;
        }
        return panel;
    }
}
