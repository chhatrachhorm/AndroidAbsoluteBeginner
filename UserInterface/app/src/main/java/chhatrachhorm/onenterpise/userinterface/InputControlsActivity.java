package chhatrachhorm.onenterpise.userinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class InputControlsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_controls);

        // map with checkbox
        CheckBox mP1 = findViewById(R.id.personal_type_1);
        CheckBox mP2 = findViewById(R.id.personal_type_2);
        CheckBox mP3 = findViewById(R.id.personal_type_3);
        CheckBox mP4 = findViewById(R.id.personal_type_4);

        // map radio
        RadioButton mR1 = findViewById(R.id.radio_male);
        RadioButton mR2 = findViewById(R.id.radio_female);
        RadioButton mR3 = findViewById(R.id.radio_other_gender);

        // Toggle Button
        ToggleButton mToggleBtn = findViewById(R.id.toggleButton);

        Button mAcceptBtn = findViewById(R.id.AcceptBtn);
        mAcceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });





        // Optional : just show how to set on click listener
        RadioGroup radioGroup = findViewById(R.id.ipc_radiogroup);
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
    // Check Check boxes
    public void onCheckBoxChecked(){

    }




    }
