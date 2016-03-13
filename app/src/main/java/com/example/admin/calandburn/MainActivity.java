package com.example.admin.calandburn;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    //Explicit
    private UserTABLE objUserTABLE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create & Connected
        objUserTABLE = new UserTABLE(this);

        //Check userTABLE
        checkUserTABLE();

        //กำหนด Listener ให้กับปุ่ม "Information"
        ImageButton btnProfile = (ImageButton) findViewById(R.id.pro1);
        btnProfile.setOnClickListener(this);

    } //onCreate

    @Override
    protected void onRestart() {
        super.onRestart();

        checkUserTABLE();

    }

    private void checkUserTABLE() {

        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase(MyOpenHelper.DATABASE_NAME,
                MODE_PRIVATE, null);
        Cursor objCursor = objSqLiteDatabase.rawQuery("SELECT * FROM userTABLE", null);
        if (objCursor.getCount() <= 0) {

            Log.d("cal1", "objCursor = null");
            Intent objIntent = new Intent(MainActivity.this, InputProfile.class);
            startActivity(objIntent);

        } else {
            objCursor.close();
            Log.d("cal1", "objCursor = Have Data");
        }

    }   // checkUserTABLe


    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
    }   // ข้อมูลส่วนตัวผู้ใช้

    public void onInforClicked(View v) {
        Intent i = new Intent(getApplicationContext(), Information.class);
        startActivity(i);
    }   // ข้อมูลน่ารู้

    public void onCalClick(View v) {
        Intent c = new Intent(getApplicationContext(), CalActivity.class);
        startActivity(c);
    }   // อาการ

    public void onBurnClick(View v) {
        Intent b = new Intent(getApplicationContext(), BurnActivity.class);
        startActivity(b);
    }   // กิจกรรม

    public void onReportClick(View v) {

        if (checkSQLite()) {
            //Have Value
            Intent intent = new Intent(MainActivity.this, ReportActivity.class);
            startActivity(intent);
        } else {
            //Some Table Null
            MyAlertDialog myAlertDialog = new MyAlertDialog();
            myAlertDialog.myDialog(MainActivity.this,
                    "โปรดเพิ่มกิจกรรม และ อาหาร ", "โปรดเพิ่มกิจกรรม และ อาหาร ก่อนคะ" );
        }

    }   // รายงาน

    private boolean checkSQLite() {

        boolean bolStatus = true;
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.DATABASE_NAME,
                MODE_PRIVATE, null);
        Cursor burnCursor = sqLiteDatabase.rawQuery("SELECT * FROM " + MyManage.table_burn, null);
        burnCursor.moveToFirst();
        Cursor calaryCursor = sqLiteDatabase.rawQuery("SELECT * FROM " + MyManage.table_calary, null);
        calaryCursor.moveToFirst();

        if (burnCursor.getCount() == 0) {
            bolStatus = true;
        } else if (calaryCursor.getCount() == 0) {
            bolStatus = true;
        } else {
            bolStatus = false;
        }



        return bolStatus;
    }
} // MainClass
