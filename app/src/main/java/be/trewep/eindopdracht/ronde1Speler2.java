package be.trewep.eindopdracht;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class ronde1Speler2 extends Fragment {
    TextView tvLetter;
    GameViewModel viewModel;
    Button btnVowel;
    Button btnConsonant;

    public ronde1Speler2() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ronde1_speler2, container, false);

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