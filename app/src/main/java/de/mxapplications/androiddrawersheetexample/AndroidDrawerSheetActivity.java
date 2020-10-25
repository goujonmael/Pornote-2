package de.mxapplications.androiddrawersheetexample;

import android.annotation.SuppressLint;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

public class AndroidDrawerSheetActivity extends AppCompatActivity {

    Button changeTextButton;
    TextView message;




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


        TextView textView=findViewById(R.id.date);
        SimpleDateFormat sdf = new SimpleDateFormat("EEE dd.MMM 'à' HH'h'mm");
        String currentDateandTime = sdf.format(new Date());
        textView.setText(currentDateandTime);


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

