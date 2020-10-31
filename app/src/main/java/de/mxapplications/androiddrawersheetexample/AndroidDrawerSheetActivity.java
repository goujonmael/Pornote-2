package de.mxapplications.androiddrawersheetexample;

import android.annotation.SuppressLint;
import android.media.Image;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import de.mxapplications.androiddrawersheet.AndroidDrawerSheet;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class AndroidDrawerSheetActivity extends AppCompatActivity {

    Button changeTextButton;
    TextView message;
    Button mButton;
    TextInputLayout mEdit;
    TextView mText;





    private final static String LOG_TAG="Example Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_drawer_sheet);


//FARADAY
        message= (TextView)findViewById(R.id.ChangeClasse);
        changeTextButton = (Button)findViewById(R.id.bChangeText);
        changeTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message.setText("(TFARADAY)");
            }
        });
//CUIVRE
        message= (TextView)findViewById(R.id.ChangeClasse);
        changeTextButton = (Button)findViewById(R.id.bChangeText2);
        changeTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message.setText("(TCUIVRE)");
            }
        });

//SET BUTTON
        mButton = (Button)findViewById(R.id.button1);

        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mText = (TextView)findViewById(R.id.textView1);
                TextInputLayout textInputLayout = findViewById(R.id.editText1);
                Editable text = textInputLayout.getEditText().getText();
                message.setText("("+text+")");

            }
        });




        TextView textView=findViewById(R.id.date);
        SimpleDateFormat sdf = new SimpleDateFormat("EEE dd.MMM 'à' HH'h'mm");
        String currentDateandTime = sdf.format(new Date());
        textView.setText(currentDateandTime);

//Dates des prochains devoirs

        TextView datefor=findViewById(R.id.datefor);
        SimpleDateFormat prochains = new SimpleDateFormat("EEEE dd MMM.");
        String next = prochains.format(new Date());
        next=next.toLowerCase();
        datefor.setText(next);



        ImageButton rightButton = (ImageButton)findViewById(R.id.right_image_button);

        final AndroidDrawerSheet rightDrawerSheet = (AndroidDrawerSheet)findViewById(R.id.right_drawer);

        ImageButton rightDrawerCloseButton = (ImageButton)findViewById(R.id.right_drawer_close_button);


        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rightDrawerSheet.toggleDrawer();
            }
        });

        rightDrawerCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rightDrawerSheet.closeDrawer();
            }
        });



        rightDrawerSheet.addOnInteractionListener(new AndroidDrawerSheet.OnInteractionListener() {

            @Override
            public void beforeDrawerClosed() {
                Log.i(LOG_TAG, "Before right drawer is closed");
            }

            @Override
            public void beforeDrawerOpened() {
                Log.i(LOG_TAG, "Before right drawer is opened");
            }

            @Override
            public void afterDrawerClosed() {
                Log.i(LOG_TAG, "After right drawer is closed");
            }

            @Override
            public void afterDrawerOpened() {
                Log.i(LOG_TAG, "After right drawer is opened");
            }
        });



        rightDrawerSheet.addOnResizeListener(new AndroidDrawerSheet.OnResizeListener() {
            @Override
            public void drawerResized(int size) {
                Log.i(LOG_TAG, "right drawer resized: "+size);
            }
        });

    }




}

