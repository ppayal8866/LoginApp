package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import soup.neumorphism.NeumorphButton;
import soup.neumorphism.NeumorphTextView;

public class Home extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    TextView usernam;
    NeumorphTextView textView;
    NeumorphButton logout;
    SharedPreferences preferences, logged, remember;
    String name;
    Spinner spin;

    String[] countries = {"India", "Sri Lanka", "Bangladesh", "England", "Australia", "US", "South Africa", "China", "Pakistan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textView = findViewById(R.id.textView);
        logout = findViewById(R.id.logout);
        usernam = findViewById(R.id.usernam);

        preferences = getSharedPreferences("Userinfo", MODE_PRIVATE);
        logged = getSharedPreferences("loggedIn", MODE_PRIVATE);
        remember = getSharedPreferences("check", MODE_PRIVATE);

        name = preferences.getString("name", "");

        String top = "Welcome " + name + "!";
        usernam.setText(top);
        spin = findViewById(R.id.spin);

        spin.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countries);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(ad);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = spin.getSelectedItem().toString();
                switch (text) {
                    case "India": {
                        String info1 = "India is second largest country in population and seventh largest country by land area. It is also the most populous democracy in the world, bounded by the Indian Ocean on the south, the Arabian Sea on the southwest, and the Bay of Bengal on the southeast.";
                        textView.setText(info1);
                        break;
                    }
                    case "Sri Lanka": {
                        String info2 = "Sri Lanka, formerly known as Ceylon, is an island country in South Asia. It is situated on the Indian Ocean, southwest of the Bay of Bengal, and southeast of the Arabian Sea; while being separated from the Indian subcontinent by the Gulf of Mannar and the Palk Strait. Sri Jayawardenepura Kotte is its legislative capital, and Colombo is its largest city and financial centre.";
                        textView.setText(info2);
                        break;
                    }
                    case "Bangladesh": {
                        String info3 = "Bangladesh (officially called People's Republic of Bangladesh) is a country in South Asia. It is next to the North-east Indian provincial regions of India, which converges with Southeast Asia to the east. Its full name is The People's Republic of Bangladesh. The capital and the largest city is Dhaka (formerly \"Dacca\").";
                        textView.setText(info3);
                        break;
                    }
                    case "England": {
                        String info4 = "England is a country in Europe. It is a country with over sixty cities in it. It is in a union with Scotland, Wales and Northern Ireland. All four countries are in the British Isles and are part of the United Kingdom (UK).";
                        textView.setText(info4);
                        break;
                    }
                    case "Australia": {
                        String info5 = "Australia, formally the Commonwealth of Australia, is a country and sovereign state in the southern hemisphere, located in Oceania. Its capital city is Canberra, and its largest city is Sydney. Australia is the sixth biggest country in the world by land area, and is part of the Oceanic and Australasian regions.";
                        textView.setText(info5);
                        break;
                    }
                    case "US": {
                        String info6 = "The United States of America (U.S.A. or USA), commonly known as the United States (U.S. or US) or America, is a country primarily located in North America. It consists of 50 states, a federal district, five major unincorporated territories, 326 Indian reservations, and some minor possessions.";
                        textView.setText(info6);
                        break;
                    }
                    case "South Africa": {
                        String info7 = "South Africa, the southernmost country on the African continent, renowned for its varied topography, great natural beauty, and cultural diversity, all of which have made the country a favoured destination for travelers since the legal ending of apartheid (Afrikaans: “apartness,” or racial separation) in 1994.";
                        textView.setText(info7);
                        break;
                    }
                    case "China": {
                        String info8 = "China, officially the People's Republic of China, is a country in East Asia. It is the world's most populous country, with a population of more than 1.4 billion. It borders 14 countries, the second most of any country in the world, after Russia. Covering an area of approximately 9.6 million square kilometers (3.7 million mi2), it is the world's third or fourth-largest country.";
                        textView.setText(info8);
                        break;
                    }
                    case "Pakistan": {
                        String info9 = "Pakistan is a country in southern Asia. It is next to India, Iran, Afghanistan, and China. It is officially called the Islamic Republic of Pakistan. It has a long coastline along the Arabian Sea in the south. Pakistan has the fifth largest population (207.77 million) in the world.";
                        textView.setText(info9);
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        logout.setOnClickListener(v -> {

            logged.edit().putBoolean("Inlogged", false).apply();
            Intent intent = new Intent(Home.this, MainActivity.class);
            startActivity(intent);

        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}