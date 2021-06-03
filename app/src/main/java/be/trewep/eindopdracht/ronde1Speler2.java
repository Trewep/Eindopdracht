package be.trewep.eindopdracht;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import static android.content.ContentValues.TAG;

public class ronde1Speler2 extends Fragment {
    TextView tvLetter;
    GameViewModel viewModel;
    Button btnVowel;
    Button btnConsonant;
    //To save text
    EditText mEditTextR1S2;
    TextView mTextViewResult;
    Button mButtonSend;

    public ronde1Speler2() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ronde1_speler2, container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(GameViewModel.class);
        mEditTextR1S2 = v.findViewById(R.id.AnswerR1S2);
        mTextViewResult = v.findViewById(R.id.tv_AnswerR1S2);
        mButtonSend = v.findViewById(R.id.btn_SendR1S2);
        Log.d(TAG, "ViewModel Speler 2:"+ viewModel.string1.getValue());

        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mEditTextR1S2.getText().toString().length() == 0){
                    mEditTextR1S2.setText("Answer");
                }


                //viewModel.word2 = mEditTextR1S2.getText().toString();
               // mTextViewResult.setText(word2);

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