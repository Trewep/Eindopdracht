package be.trewep.eindopdracht;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ronde1Speler1 extends Fragment {
    TextView tvLetter;
    GameViewModel viewModel;
    Button btnVowel;
    Button btnConsonant;
    //To save text
    EditText mEditTextR1S1;
    TextView mTextViewResult;
    Button mButtonSend;;



    public ronde1Speler1() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ronde1_speler1, container, false);

        mEditTextR1S1 = v.findViewById(R.id.AnswerR1S1);
        mTextViewResult = v.findViewById(R.id.tv_AnswerR1S1);
        mButtonSend = v.findViewById(R.id.btn_SendR1S1);

        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mEditTextR1S1.getText().toString().length() == 0){
                    mEditTextR1S1.setText("Answer");
                }
                String word1 = mEditTextR1S1.getText().toString();

                mTextViewResult.setText(word1);

            }
        });

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(GameViewModel.class);

        viewModel.getChar().observe(this, letter -> {
            tvLetter.append(letter.toString() + " ");
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        viewModel.clearCounter();
    }
}