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

public class ronde3Speler1 extends Fragment {
    //Number
    TextView tvNumberInput;
    TextView tvNumberGoal;

    GameViewModel viewModel;

    Button btnBigNumber;
    Button btnSmallNumber;

    //Result
    EditText mEditTextR3S1;
    Button mButtonSend;

    public ronde3Speler1() {
        // Required empty public constructor
    }
    //Cijfer
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(GameViewModel.class);

        viewModel.getChar().observe(this, letter -> {
            tvNumberInput.append(letter.toString() + " ");
        });
    }
    //Result
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ronde3_speler1, container, false);
        mEditTextR3S1 = v.findViewById(R.id.AnswerR3S1);
        mButtonSend = v.findViewById(R.id.btn_SendR3S1);

        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mEditTextR3S1.getText().toString().length() == 0){
                    mEditTextR3S1.setText("");
                }
                //Send Result to Resultpage
                viewModel.string5 = mEditTextR3S1.getText().toString();
            }
        });
        //Cijfer
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

        tvNumberGoal.setText(String.valueOf(viewModel.pickGoalNumber(1000)));

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        viewModel.clearCounter();
    }
}