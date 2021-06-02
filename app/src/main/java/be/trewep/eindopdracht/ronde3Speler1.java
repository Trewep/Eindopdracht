package be.trewep.eindopdracht;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class ronde3Speler1 extends Fragment {
    TextView tvNumberInput;
    TextView tvNumberGoal;

    GameViewModel viewModel;

    Button btnBigNumber;
    Button btnSmallNumber;

    public ronde3Speler1() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ronde3_speler1, container, false);

        tvNumberInput = v.findViewById(R.id.tv_numberInput);
        tvNumberGoal = v.findViewById(R.id.tv_numberGoal);
        btnBigNumber = v.findViewById(R.id.btn_BigNumber);
        btnSmallNumber = v.findViewById(R.id.btn_SmallNumber);

        btnBigNumber.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewModel.pickBigNumber();
            }
        });

        btnSmallNumber.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewModel.pickSmallNumber();
            }
        });

        tvNumberGoal.setText(String.valueOf(viewModel.pickGoalNumber(50)));

        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(GameViewModel.class);

        viewModel.getChar().observe(this, letter -> {
            tvNumberInput.append(letter.toString() + " ");
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        viewModel.clearCounter();
    }
}