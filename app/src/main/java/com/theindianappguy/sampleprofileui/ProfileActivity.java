package com.theindianappguy.sampleprofileui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {

    LinearLayout personalinfo;
    TextView personalinfobtn, weeklybtn;
    ImageView back_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_main);
        back_button = findViewById(R.id.back);
        personalinfo = findViewById(R.id.personalinfo);
        personalinfobtn = findViewById(R.id.editinfo);
        weeklybtn = findViewById(R.id.editweekly);

        TextView birthday = findViewById(R.id.p_birthday);
        TextView age = findViewById(R.id.p_age);
        TextView bloodtype = findViewById(R.id.p_bloodtype);
        TextView sex = findViewById(R.id.p_sex);
        TextView weight = findViewById(R.id.p_weight);
        TextView height = findViewById(R.id.p_height);
        TextView bodyfat = findViewById(R.id.p_bodyfat);
        TextView calories = findViewById(R.id.p_calories);
        TextView time = findViewById(R.id.p_time);
        TextView distance = findViewById(R.id.p_distance);

        SharedPreferences sharedPrefs = this.getSharedPreferences(
                "com.theindianappguy.sampleprofileui", Context.MODE_PRIVATE);

        String birthday_val = sharedPrefs.getString("birthday", "");
        String sex_val = sharedPrefs.getString("sex", "");
        String age_val = sharedPrefs.getString("age", "");
        String bloodtype_val = sharedPrefs.getString("bloodtype", "");
        String weight_val = sharedPrefs.getString("weight", "");
        String height_val = sharedPrefs.getString("height", "");
        String bodyfat_val = sharedPrefs.getString("bodyfat", "");
        String calorie_val = sharedPrefs.getString("calorie", "");
        String time_val = sharedPrefs.getString("time", "");
        String distance_val = sharedPrefs.getString("distance", "");


        if (birthday_val != "") birthday.setText(birthday_val);
        if (sex_val != "") sex.setText(sex_val);
        if (age_val != "") age.setText(age_val);
        if (bloodtype_val != "") bloodtype.setText(bloodtype_val);
        if (weight_val != "") weight.setText(weight_val);
        if (height_val != "") height.setText(height_val);
        if (bodyfat_val != "") bodyfat.setText(bodyfat_val);
        if (calorie_val != "") calories.setText(calorie_val);
        if (time_val != "") time.setText(time_val);
        if (distance_val != "") distance.setText(distance_val);


        personalinfobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ProfileActivity.this, EditInfo.class);
                ProfileActivity.this.startActivity(myIntent);
            }
        });

        weeklybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ProfileActivity.this, EditWeekly.class);
                ProfileActivity.this.startActivity(myIntent);
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ProfileActivity.this, MainActivity.class);
                ProfileActivity.this.startActivity(myIntent);
            }
        });


    }
}
