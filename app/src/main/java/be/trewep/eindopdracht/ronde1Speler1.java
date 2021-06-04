package be.trewep.eindopdracht;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ronde1Speler1 extends Fragment {
    //Letter
    TextView tvLetter;
    GameViewModel viewModel;
    Button btnVowel;
    Button btnConsonant;
    //Result
    EditText mEditTextR1S1;
    Button mButtonSend;

    public ronde1Speler1() {
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
        View v = inflater.inflate(R.layout.fragment_ronde1_speler1, container, false);

        mEditTextR1S1 = v.findViewById(R.id.AnswerR1S1);
        mButtonSend = v.findViewById(R.id.btn_SendR1S1);

        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mEditTextR1S1.getText().toString().length() == 0){
                    mEditTextR1S1.setText("");
                }
                //Send Result to Resultpage
                viewModel.string1 = mEditTextR1S1.getText().toString();
            }
        });
        //Letter Code
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