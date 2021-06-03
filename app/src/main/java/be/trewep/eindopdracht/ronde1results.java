package be.trewep.eindopdracht;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ronde1results extends Fragment {

    TextView mTextViewResultR1S1;
    TextView mTextViewResultR1S2;

    public ronde1results() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ronde1_speler2, container, false);
        // Inflate the layout for this fragment
        mTextViewResultR1S1 = v.findViewById(R.id.tv_ResultR1S1);

        //Words
        String word1 = ronde1Speler1.getWord1();
        String word2 = ronde1Speler2.getWord2();

        mTextViewResultR1S1.setText(word1);
        mTextViewResultR1S2.setText(word2);

        return v;
    }
}