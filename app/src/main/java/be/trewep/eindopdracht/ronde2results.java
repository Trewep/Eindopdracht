package be.trewep.eindopdracht;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ronde2results#newInstance} factory method to
 * create an instance of this fragment.
 * Nick Bevers09:32
 * LetterSolver letSolver = new LetterSolver();
 * Nick Bevers09:34
 * letSolver.loadDictionary(requireActivity(), R.raw.dictionary);
 * Nick Bevers09:49
 * NumberSolver numSolver = new NumberSolver();
 * Nick Bevers09:51
 * numberViewModel.results.observe(getViewLifecycleOwner(), strings -> strings.forEach(string-> resultString += tv_results.getText() + "\n" + string));
 */
public class ronde2results extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ronde2results() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ronde1results.
     */
    // TODO: Rename and change types and number of parameters
    public static ronde2results newInstance(String param1, String param2) {
        ronde2results fragment = new ronde2results();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ronde1results, container, false);
    }
}