package be.trewep.eindopdracht;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ronde1results extends Fragment {
    TextView mTextViewResultS1;
    TextView mTextViewResultS2;
    GameViewModel viewModel;

    public ronde1results() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ronde1results, container, false);
        mTextViewResultS1 = v.findViewById(R.id.tv_ResultR1S1);
        mTextViewResultS2 = v.findViewById(R.id.tv_ResultR1S2);

/*
        mTextViewResultS1.setText(viewModel.word1);
        mTextViewResultS2.setText(viewModel.word2);

 */
        return v;
    }

}