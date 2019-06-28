package com.example.mycarsettings;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FinalFragment.OnFinalFragmentIntListener} interface
 * to handle interaction events.
 */
public class FinalFragment extends Fragment {

    private OnFinalFragmentIntListener mListener;
    TextView tvFinalCarName;
    TextView tvFinalCarColor;
    private String myNameRetrieved;
    private String myColorRetrieved;

    public FinalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewFinalFragment = inflater.inflate(R.layout.fragment_final, container, false);
        tvFinalCarName = viewFinalFragment.findViewById(R.id.tvFinalCarName);
        tvFinalCarColor = viewFinalFragment.findViewById(R.id.tvFinalCarColor);

        tvFinalCarName.setText(myNameRetrieved);
        tvFinalCarColor.setText(myColorRetrieved);


        return viewFinalFragment;
    }

    public void sendData(String name, String color){
        myNameRetrieved = name;
        myColorRetrieved = color;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFinalFragmentIntListener) {
            mListener = (OnFinalFragmentIntListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFinalFragmentIntListener {
        void finalData();
    }
}
