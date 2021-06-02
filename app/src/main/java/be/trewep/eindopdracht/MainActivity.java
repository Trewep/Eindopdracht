package be.trewep.eindopdracht;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Fragment currentLayout; //holds the currents fragment that's been showed on this moment
    final ronde1Speler1 ronde1Speler1 = new ronde1Speler1();
    final ronde1Speler2 ronde1Speler2 = new ronde1Speler2();
    final ronde1results ronde1results = new ronde1results();

    final ronde2Speler1 ronde2Speler1 = new ronde2Speler1();
    final ronde2Speler2 ronde2Speler2 = new ronde2Speler2();
    final ronde2results ronde2results = new ronde2results();

    final ronde3Speler1 ronde3Speler1 = new ronde3Speler1();
    final ronde3Speler2 ronde3Speler2 = new ronde3Speler2();
    final ronde3results ronde3results = new ronde3results();

    final gameresults gameresults = new gameresults();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentLayout = ronde1Speler1; //Starting Layout

        Button btnChange = findViewById(R.id.btn_switch); //button to change between fragments

        FragmentManager fm = getSupportFragmentManager(); //initialize fragment manager
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentSpot, currentLayout); //replace starting fragment with ronde1Speler1Fragment
        ft.commit();

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("currentLayout", String.valueOf(currentLayout));
                Log.d("r1s1", String.valueOf(ronde1Speler1));
                Log.d("r1s2", String.valueOf(ronde1Speler2));
                if (currentLayout == ronde1Speler1) {
                    currentLayout = ronde1Speler2;
                }else if (currentLayout == ronde1Speler2){
                    currentLayout = ronde1results;
                }else if (currentLayout == ronde1results){
                 currentLayout = ronde2Speler1 ;
                }else if (currentLayout == ronde2Speler1){
                    currentLayout = ronde2Speler2 ;
                }else if (currentLayout == ronde2Speler2){
                    currentLayout = ronde2results;
                }else if (currentLayout == ronde2results){
                    currentLayout = ronde3Speler1 ;
                }else if (currentLayout == ronde3Speler1){
                    currentLayout = ronde3Speler2 ;
                }else if (currentLayout == ronde3Speler2){
                    currentLayout = ronde3results;
                }else if (currentLayout == ronde3results){
                    currentLayout = gameresults ;
                }else {
                    currentLayout = ronde1Speler1;
                }

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragmentSpot, currentLayout);
                ft.commit();
            }
        });
    }
}