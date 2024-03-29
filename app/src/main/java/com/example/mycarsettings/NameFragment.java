package com.example.mycarsettings;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NameFragment.OnNameFragmentIntListener} interface
 * to handle interaction events.
 */
public class NameFragment extends Fragment {

    private OnNameFragmentIntListener mListener;

    public NameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewNameFragment = inflater.inflate(R.layout.fragment_name, container, false);
        final EditText etCarName = viewNameFragment.findViewById(R.id.etCarName);
        Button btnNext = viewNameFragment.findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String carName = etCarName.getText().toString();
                mListener.btnNextClick(carName);
            }
        });
        return viewNameFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (OnNameFragmentIntListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnNameFragmentIntListener {
        void btnNextClick(String carName);
    }
}
