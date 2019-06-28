package com.example.mycarsettings;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SettingsFragment.OnSettingsFragmentIntListener} interface
 * to handle interaction events.
 */
public class SettingsFragment extends Fragment {

    private OnSettingsFragmentIntListener mListener;
    String carColor;

    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewSettingsFragment = inflater.inflate(R.layout.fragment_settings, container, false);
        Spinner spnColor = viewSettingsFragment.findViewById(R.id.spnColor);
        Button btnNext2 = viewSettingsFragment.findViewById(R.id.btnNext2);



        final String[] arrayColors = new String[]{"red", "green", "blue", "white", "black", "grey"};

        ArrayAdapter<String> adapterPotato = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, arrayColors);

        spnColor.setAdapter(adapterPotato);

        spnColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                carColor = arrayColors[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //nothing selected
            }
        });

        btnNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onNext2Click(carColor);
            }
        });

        return viewSettingsFragment;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onNext2Click(carColor);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSettingsFragmentIntListener) {
            mListener = (OnSettingsFragmentIntListener) context;
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
    public interface OnSettingsFragmentIntListener {
        // TODO: Update argument type and name
        void onNext2Click(String carColor);
    }
}
