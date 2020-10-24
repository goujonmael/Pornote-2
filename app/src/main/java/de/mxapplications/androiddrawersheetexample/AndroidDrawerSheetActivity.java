package de.mxapplications.androiddrawersheetexample;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import de.mxapplications.androiddrawersheet.AndroidDrawerSheet;

public class AndroidDrawerSheetActivity extends AppCompatActivity {
    private final static String LOG_TAG="Example Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_drawer_sheet);



        ImageButton rightButton = (ImageButton)findViewById(R.id.right_image_button);

        final AndroidDrawerSheet rightDrawerSheet = (AndroidDrawerSheet)findViewById(R.id.right_drawer);

        Button rightDrawerCloseButton = (Button)findViewById(R.id.right_drawer_close_button);



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
