package algonquin.cst2335.sama0087.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

import algonquin.cst2335.sama0087.R;
import algonquin.cst2335.sama0087.data.MainViewModel;
import algonquin.cst2335.sama0087.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private Button loginButton;
    private SharedPreferences prefs;
    ActivityMainBinding variableBinding;

    ImageView imgView;
    Switch sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        //imgView = findViewById(R.id.imageView);
       // sw = findViewById(R.id.spin_switch);

        emailEditText = findViewById(R.id.emailEditText);
        loginButton = findViewById(R.id.loginButton);

        // Initialize SharedPreferences
        prefs = getSharedPreferences("MyData", MODE_PRIVATE);

        // Load the saved email address and set it in the EditText
        String emailAddress = prefs.getString("LoginName", "");
        emailEditText.setText(emailAddress);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Save the email address entered by the user
                String enteredEmail = emailEditText.getText().toString();
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("LoginName", enteredEmail);
                editor.apply();

                // Start the SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
@Override
    protected void onStart() {
        super.onStart();
        Log.w( "MainActivity", "In onStart() - Loading Widgets" );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w( "MainActivity", "In onPause() - Loading Widgets" );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w( "MainActivity", "In onResume() - Loading Widgets" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w( "MainActivity", "In onDestroy() - Loading Widgets" );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w( "MainActivity", "In onStop() - Loading Widgets" );
    }
}

