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

public class ronde2Speler2 extends Fragment {
    //Letter
    TextView tvLetter;
    GameViewModel viewModel;
    Button btnVowel;
    Button btnConsonant;
    //Result
    EditText mEditTextR1S2;
    Button mButtonSend;

    public ronde2Speler2() {
        // Required empty public constructor
    }
    //Letter
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(GameViewModel.class);

        viewModel.getChar().observe(this, letter -> {
            tvLetter.append(letter.toString() + " ");
        });
    }
    //Result
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ronde2_speler2, container, false);

        mEditTextR1S2 = v.findViewById(R.id.AnswerR2S2);
        mButtonSend = v.findViewById(R.id.btn_SendR2S2);

        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mEditTextR1S2.getText().toString().length() == 0){
                    mEditTextR1S2.setText("");
                }
                //Send Result to Resultpage
                viewModel.string4 = mEditTextR1S2.getText().toString();
            }
        });
        //Letter
        tvLetter = v.findViewById(R.id.tv_letter);

        btnVowel = v.findViewById(R.id.btn_vowel);
        btnConsonant = v.findViewById(R.id.btn_consonant);

        btnVowel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewModel.pickVowel();
            }
        });

        btnConsonant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewModel.pickConsonant();
            }
        });

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        viewModel.clearCounter();
    }

}