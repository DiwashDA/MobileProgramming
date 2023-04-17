package com.example.blankactivity;//package com.example.blankactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


public class MyActivity extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    TextView resultView;
    Button buttonSum;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("");
        setContentView(R.layout.layout);
        addListenerOnButton();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        System.out.println("_________________________________________");
        System.out.println("got activity result");
        System.out.println("_________________________________________");
        if (resultCode == 200) {
            String result = data.getStringExtra("result");
            resultView.setText(result);
        } else {
            resultView.setText(resultCode);
        }
    }


    public void openSomeActivityForResult() {
        Intent intent = new Intent(this, SecondActivity.class);
        someActivityResultLauncher.launch(intent);
    }

    // You can do the assignment inside onAttach or onCreate, i.e, before the activity is displayed
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        /// Do Operations
                    }
                }
            });


    public void addListenerOnButton() {
        buttonSum.setOnClickListener(view -> {
            int sum = Integer.parseInt(textView1.getText().toString()) + Integer.parseInt(textView2.getText().toString());
            Intent i = new Intent(MyActivity.this, SecondActivity.class);
            i.putExtra("value", sum);
            /// OLD WAY
            startActivityForResult(i, 1);

            /// NEW WAY
            openSomeActivityForResult();
//                registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
//                    @Override
//                    public void onActivityResult(ActivityResult result) {
//                        if (result.getResultCode() == Activity.RESULT_OK) {
//                            Intent data = result.getData();
//                        }
//                    }
//                }).launch(i);

        });
    }
}



//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.RadioButton;
//import android.widget.RadioGroup;
//import android.widget.Spinner;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//
//public class MyActivity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {
//    Button button;
//    Spinner spinner;
//    RadioButton genderradioButton;
//    RadioGroup radioGroup;
//    String [] aray = {"1","2","3","4"};
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
//        spinner = (Spinner) findViewById(R.id.spin);
//        spinner.setOnItemSelectedListener(this);
//
//        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,aray);
//        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(aa);
//    }
//
//    public void onclickbuttonMethod(View v) {
//        int selectedId = radioGroup.getCheckedRadioButtonId();
//        genderradioButton = (RadioButton) findViewById(selectedId);
//        if (selectedId == -1) {
//            Toast.makeText(MyActivity.this, "Nothing selected", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(MyActivity.this, genderradioButton.getText(), Toast.LENGTH_SHORT).show();
//        }
//
//    }
//
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(MyActivity.this, "Item selected", Toast.LENGTH_SHORT).show();
//
//
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }
//}