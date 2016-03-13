package com.example.admin.calandburn;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    // Explicit
    private TextView nameTextView, sexTextView, ageTextView,
            heightTextView, weightTextView, actTextView, bmiTextView,
            weightStdTextView, bmrTextView;
    private String nameString, sexString, ageString, heightString, weightString,
            actString, bmiString, weightStdString, bmrString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Bind Widget
        bindWidget();

        // Show View
        showView();

    } // Main Methon

    public void clickMainMenu(View view) {
        startActivity(new Intent(ProfileActivity.this, MainActivity.class));
        finish();
    }

    private void showView() {

        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase(MyOpenHelper.DATABASE_NAME,
                MODE_PRIVATE, null);
        Cursor objCursor = objSqLiteDatabase.rawQuery("SELECT * FROM " + UserTABLE.TABLE_USER, null);
        objCursor.moveToFirst();
        nameString = objCursor.getString(objCursor.getColumnIndex(UserTABLE.COLUMN_name));
        sexString = objCursor.getString(objCursor.getColumnIndex(UserTABLE.COLUMN_sex));
        ageString = objCursor.getString(objCursor.getColumnIndex(UserTABLE.COLUMN_age));
        heightString = objCursor.getString(objCursor.getColumnIndex(UserTABLE.COLUMN_height));
        weightString = objCursor.getString(objCursor.getColumnIndex(UserTABLE.COLUMN_weight));
        actString = objCursor.getString(objCursor.getColumnIndex(UserTABLE.COLUMN_myact));
        bmiString = objCursor.getString(objCursor.getColumnIndex(UserTABLE.COLUMN_bmiuser));
        weightStdString = null;
        bmrString = objCursor.getString(objCursor.getColumnIndex(UserTABLE.COLUMN_bmruser));

        objCursor.close();

        nameTextView.setText(nameString);
        sexTextView.setText(sexString);
        ageTextView.setText(ageString);
        heightTextView.setText(heightString + " cm.");
        weightTextView.setText(weightString + " kg.");
        actTextView.setText(actString);
        bmiTextView.setText(bmiString);
        weightStdTextView.setText(weightStdString);
        bmrTextView.setText(bmrString);

    } // Show View

    private void bindWidget() {

        nameTextView = (TextView) findViewById(R.id.textView2);
        sexTextView = (TextView) findViewById(R.id.textView4);
        ageTextView = (TextView) findViewById(R.id.textView6);
        heightTextView = (TextView) findViewById(R.id.textView8);
        weightTextView = (TextView) findViewById(R.id.textView10);
        actTextView = (TextView) findViewById(R.id.textView12);
        bmiTextView = (TextView) findViewById(R.id.textView14);
        weightStdTextView = (TextView) findViewById(R.id.textView16);
        bmrTextView = (TextView) findViewById(R.id.textView18);

    } // Main Method


} // Main Class
