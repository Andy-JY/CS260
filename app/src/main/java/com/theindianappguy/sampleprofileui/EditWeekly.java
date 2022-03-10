package com.theindianappguy.sampleprofileui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditWeekly extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_main_edit_weekly_goal);

        final SharedPreferences prefs = getSharedPreferences(
                "com.theindianappguy.sampleprofileui", Context.MODE_PRIVATE);
        TextView save_weekly_button = (TextView) findViewById(R.id.save_weekly);
        ImageView back_to_profile = (ImageView) findViewById(R.id.backtoprofile);

        save_weekly_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText calorie_edit = (EditText)findViewById(R.id.calorie_edit);
                EditText time_edit = (EditText)findViewById(R.id.time_edit);
                EditText distance_edit = (EditText)findViewById(R.id.distance_edit);

                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("calorie", calorie_edit.getText().toString());
                editor.putString("time", time_edit.getText().toString());
                editor.putString("distance", distance_edit.getText().toString());
                editor.commit();

                Toast.makeText(getBaseContext(), "Save!", Toast.LENGTH_SHORT).show();
            }
        });
        back_to_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(EditWeekly.this, ProfileActivity.class);
                EditWeekly.this.startActivity(myIntent);
            }
        });

    }
}

