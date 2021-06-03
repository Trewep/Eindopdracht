package be.trewep.eindopdracht;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class gameresults extends Fragment {
    GameViewModel viewModel;
    //Result
    TextView mTextViewResultR1S1;
    TextView mTextViewResultR1S2;
    TextView mTextViewResultR2S1;
    TextView mTextViewResultR2S2;
    TextView mTextViewResultR3S1;
    TextView mTextViewResultR3S2;

    public gameresults() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    //Result
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gameresults, container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(GameViewModel.class);

        mTextViewResultR1S1 = v.findViewById(R.id.tVAntwoordR1S1);
        mTextViewResultR1S2 = v.findViewById(R.id.tVAntwoordR1S2);
        mTextViewResultR2S1 = v.findViewById(R.id.tVAntwoordR2S1);
        mTextViewResultR2S2 = v.findViewById(R.id.tVAntwoordR2S2);
        mTextViewResultR3S1 = v.findViewById(R.id.tVAntwoordR3S1);
        mTextViewResultR3S2 = v.findViewById(R.id.tVAntwoordR3S2);

        mTextViewResultR1S1.setText(viewModel.string1);
        mTextViewResultR1S2.setText(viewModel.string2);
        mTextViewResultR2S1.setText(viewModel.string3);
        mTextViewResultR2S2.setText(viewModel.string4);
        mTextViewResultR3S1.setText(viewModel.int1.toString());
        mTextViewResultR3S2.setText(viewModel.int2.toString());
        return v;
    }
}