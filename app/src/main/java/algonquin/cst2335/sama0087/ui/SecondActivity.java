package algonquin.cst2335.sama0087.ui;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import algonquin.cst2335.sama0087.R;
import algonquin.cst2335.sama0087.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> cameraResult;
    private Button buttonPic;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySecondBinding binding = ActivitySecondBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        Intent newPage = getIntent();
        String userInput = newPage.getStringExtra("EmailAddress");
        TextView textViewWelcome = findViewById(R.id.textView3);
        if (userInput != null) {
            textViewWelcome.setText("Welcome back " + userInput);
        }

        TextView phoneNumberEditText = findViewById(R.id.editTextPhone);
        Button callButton = findViewById(R.id.buttonCall);

        // Set a click listener for the Call Number button
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the phone number from the EditText
                String phoneNumber = phoneNumberEditText.getText().toString();

                // Create an Intent to initiate a phone call
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + phoneNumber));

                // Start the phone call activity
                startActivity(callIntent);
            }
        });

        buttonPic = findViewById(R.id.buttonPic);
        imageView = findViewById(R.id.imageView);

        // Initialize the cameraResult launcher
        cameraResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            // Image capture was successful, set the image to the ImageView
                            Bundle extras = result.getData().getExtras();
                            if (extras != null) {
                                Bitmap imageBitmap = (Bitmap) extras.get("data");
                                imageView.setImageBitmap(imageBitmap);
                                FileOutputStream fOut = null;
                                try { fOut = openFileOutput("Picture.png", Context.MODE_PRIVATE);
                                    imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                    fOut.flush();
                                    fOut.close();
                                }
                                catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }
                                catch (IOException e){
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                });

        // Set a click listener for the buttonPic
        buttonPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to open the camera app
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                cameraResult.launch(takePictureIntent);
            }
        });
    }
}