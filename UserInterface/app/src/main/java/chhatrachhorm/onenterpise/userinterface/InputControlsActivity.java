package chhatrachhorm.onenterpise.userinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputControlsActivity extends AppCompatActivity {

    private List<CheckBox> personalities;
    private List<String> mPersonality;
    private List<RadioButton> genders;
    private String sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_controls);

        personalities = new ArrayList<>();
        mPersonality = new ArrayList<>();
        genders = new ArrayList<>();
        final Map<String, Object> agreements;

        // map with checkbox
        final CheckBox mP1 = findViewById(R.id.personal_type_1);
        final CheckBox mP2 = findViewById(R.id.personal_type_2);
        final CheckBox mP3 = findViewById(R.id.personal_type_3);
        final CheckBox mP4 = findViewById(R.id.personal_type_4);
        personalities.addAll(Arrays.asList(mP1, mP2, mP3, mP4));

        // Optional : just show how to set on click listener
        final RadioGroup radioGroup = findViewById(R.id.ipc_radiogroup);

        // instantiate map
        agreements = new HashMap<>();

        // map radio
        RadioButton mR1 = findViewById(R.id.radio_male);
        RadioButton mR2 = findViewById(R.id.radio_female);
        RadioButton mR3 = findViewById(R.id.radio_other_gender);
        genders.addAll(Arrays.asList(mR1, mR2, mR3));

        // Toggle Button
        final ToggleButton mToggleBtn = findViewById(R.id.send_notification_btn);

        // rating bar
        final RatingBar mRatingBar = findViewById(R.id.cia_rating_bar);
        mRatingBar.setNumStars(5);
        mRatingBar.setRating(1.5f);
        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float value, boolean b) {
                String s = value + " " + b;
                Toast.makeText(InputControlsActivity.this, s, Toast.LENGTH_SHORT).show();
                Log.d("RatingListener", s);
            }
        });

        final Button mAcceptBtn = findViewById(R.id.AcceptBtn);
        mAcceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get value for personality
                for(CheckBox i : personalities){
                    if(i.isChecked())
                        mPersonality.add(i.getText().toString());
                }

                // get value for radio
                for(RadioButton r: genders){
                    if(r.isChecked())
                        sex = r.getText().toString();
                }
                if(mToggleBtn.isChecked())
                    agreements.put("notified", true);
                else agreements.put("notified", false);
                agreements.put("personality", mPersonality);
                agreements.put("sex", sex);
                agreements.put("likability", mRatingBar.getRating());
                Toast.makeText(InputControlsActivity.this, agreements.toString(), Toast.LENGTH_LONG).show();
                mPersonality.clear();
                agreements.clear();

            }
        });




        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int position) {
                switch (position){
                    case R.id.radio_male:
                        Toast.makeText(InputControlsActivity.this, "male", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.radio_female:
                        Toast.makeText(InputControlsActivity.this, "female", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radio_other_gender:
                        Toast.makeText(InputControlsActivity.this, "other", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    }
