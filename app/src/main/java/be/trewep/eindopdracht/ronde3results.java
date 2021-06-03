package be.trewep.eindopdracht;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import static android.content.ContentValues.TAG;

public class ronde3results extends Fragment {
    TextView mTextViewResultS1;
    TextView mTextViewResultS2;
    GameViewModel viewModel;

    public ronde3results() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ronde3results, container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(GameViewModel.class);
        mTextViewResultS1 = v.findViewById(R.id.tv_ResultR3S1);
        mTextViewResultS2 = v.findViewById(R.id.tv_ResultR3S2);

        //array.append(viewModel.string1.getValue());
        //viewModel.string1.setValue());
        mTextViewResultS1.setText(viewModel.int1.toString());
        mTextViewResultS2.setText(viewModel.int2.toString());
        return v;
    }

}