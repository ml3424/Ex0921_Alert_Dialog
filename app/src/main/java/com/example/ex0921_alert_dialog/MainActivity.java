package com.example.ex0921_alert_dialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

/**
 * @author	Maya Leibovich mayaLeibovich3@gmail.com
 * @version	 1.2
 * @since	26/1/2024
 * Alert dialog practice
 */


public class MainActivity extends AppCompatActivity {
    AlertDialog.Builder adb;
    Button btnMsg, btnMsgImg, btnMsgImg1, btnMsgImg2, btnMsgImg3;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMsg = findViewById(R.id.btnMsg);
        btnMsgImg = findViewById(R.id.btnMsgImg);
        btnMsgImg1 = findViewById(R.id.btnMsgImg1);
        btnMsgImg2 = findViewById(R.id.btnMsgImg2);
        btnMsgImg3 = findViewById(R.id.btnMsgImg3);

        adb = new AlertDialog.Builder(this);
    }

    /**
     * first btn onclick
     * @param	View view
     * @return	none
     */
    public void clickMsg(View view) {
        adb.setTitle("Only text");
        adb.setMessage("Still only text");
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * second btn onclick
     * @param	View view
     * @return	none
     */
    public void clickMsgImg(View view) {
        adb.setTitle("Text and image");
        adb.setMessage("text and image");
        adb.setIcon(R.drawable.icon);
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * third btn onclick
     * @param	View view
     * @return	none
     */
    public void clickMsgImg1(View view) {
        adb.setTitle("Text and image");
        adb.setMessage("and a button!");
        adb.setIcon(R.drawable.icon);

        adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * forth btn onclick
     * @param	View view
     * @return	none
     */
    public void clickMsgImg2(View view) {
        adb.setTitle("Text and image");
        adb.setMessage("and 2 buttons!");
        adb.setIcon(R.drawable.icon);

        adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setNeutralButton("Change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                View view = findViewById(android.R.id.content);
                int randomColor = generateRandomColor();
                view.setBackgroundColor(randomColor); // set background color

                dialog.cancel();
            }
        });

        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * fifth btn onclick
     * @param	View view
     * @return	none
     */
    public void clickMsgImg3(View view) {
        adb.setTitle("Text and image");
        adb.setMessage("and 3 buttons!");
        adb.setIcon(R.drawable.icon);

        adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setNeutralButton("Change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                View view = findViewById(android.R.id.content);
                int randomColor = generateRandomColor();
                view.setBackgroundColor(randomColor); // set background color

                dialog.cancel();
            }
        });
        adb.setNegativeButton("White", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                View view = findViewById(android.R.id.content);
                int randomColor = generateRandomColor();
                view.setBackgroundColor(Color.rgb(255, 255, 255)); // set background color to white

                dialog.cancel();
            }
        });

        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * generate color
     * @return	int which is a color
     */
    private int generateRandomColor() {
        Random random = new Random(); //random obj
        int red = random.nextInt(256); // 0-255 range
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return Color.rgb(red, green, blue); // create the color(int)
    }


    /**
     * create an option menu
     * @return	boolean
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    /**
     * create the options in an option menu
     * @return	boolean
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        String st = item.getTitle().toString();
        if(st.equals("Credits"))
        {
            intent = new Intent(this, CreditsActivity.class);
            startActivity(intent);
        }
        else if(st.equals("Main"))
        {
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}