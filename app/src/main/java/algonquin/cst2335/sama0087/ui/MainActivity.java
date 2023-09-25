package algonquin.cst2335.sama0087.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

import algonquin.cst2335.sama0087.data.MainViewModel;
import algonquin.cst2335.sama0087.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding variableBinding;

    MainViewModel vModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        vModel = new ViewModelProvider(this).get(MainViewModel.class);
        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(variableBinding.getRoot());

        TextView tv = variableBinding.thetextview;
        Button b = variableBinding.thebutton;
        EditText et = variableBinding.theeditText;
        ImageButton ib = variableBinding.theimagebtn;

        variableBinding.thecheckbox.setOnCheckedChangeListener(
                (btn, onOroff) -> {
                    vModel.onOroff.postValue(onOroff);
                });

        variableBinding.theswitch.setOnCheckedChangeListener((btn, onOroff)-> {
            vModel.onOroff.postValue(onOroff);
        });

        variableBinding.theradiobutton.setOnCheckedChangeListener((btn, onOroff)-> {
            vModel.onOroff.postValue(onOroff);
        });

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int width = ib.getWidth();
                int height = ib.getHeight();

                boolean checkboxState = variableBinding.thecheckbox.isChecked();
                boolean switchState = variableBinding.theswitch.isChecked();
                boolean radioButtonState = variableBinding.theradiobutton.isChecked();

                String toastMessage = "Width = " + width + ", Height = " + height +
                        "\nCheckbox State = " + checkboxState +
                        "\nSwitch State = " + switchState +
                        "\nRadio Button State = " + radioButtonState;
                Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT).show();
            }
        });

        vModel.onOroff.observe(this, newValue -> {
            variableBinding.thecheckbox.setChecked(newValue);
            variableBinding.theswitch.setChecked(newValue);
            variableBinding.theradiobutton.setChecked(newValue);
        });

        et.setText(vModel.userString.getValue());

        vModel.userString.observe(this, (s) -> {
            b.setText("Your text is now: " + s);
            tv.setText("Your text is now: " + s);
        });

        b.setOnClickListener(v -> {
            vModel.userString.postValue(et.getText().toString());
        });

        int i = 0;
    }
}

