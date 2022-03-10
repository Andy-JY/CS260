package com.theindianappguy.sampleprofileui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditInfo extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_main_edit_info);


        final SharedPreferences prefs = getSharedPreferences(
                "com.theindianappguy.sampleprofileui", Context.MODE_PRIVATE);
        ImageView back_to_profile = (ImageView) findViewById(R.id.backtoprofile);

        TextView save_info = (TextView) findViewById(R.id.save_info);

        save_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText birthday_edit = (EditText)findViewById(R.id.birthday);
                EditText sex_edit = (EditText)findViewById(R.id.sex);
                EditText age_edit = (EditText)findViewById(R.id.age);
                EditText bloodtype_edit = (EditText)findViewById(R.id.bloodtype);
                EditText weight_edit = (EditText)findViewById(R.id.weight);
                EditText height_edit = (EditText)findViewById(R.id.height);
                EditText bodyfat_edit = (EditText)findViewById(R.id.bodyfat);

                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("birthday", birthday_edit.getText().toString());
                editor.putString("sex", sex_edit.getText().toString());
                editor.putString("age", age_edit.getText().toString());
                editor.putString("bloodtype", bloodtype_edit.getText().toString());
                editor.putString("weight", weight_edit.getText().toString());
                editor.putString("height", height_edit.getText().toString());
                editor.putString("bodyfat", bodyfat_edit.getText().toString());
                editor.commit();

                Toast.makeText(getBaseContext(), "Save!", Toast.LENGTH_SHORT).show();
            }
        });

        back_to_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(EditInfo.this, ProfileActivity.class);
                EditInfo.this.startActivity(myIntent);
            }
        });


    }
}
