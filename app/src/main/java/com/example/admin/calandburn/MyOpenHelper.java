package com.example.admin.calandburn;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Admin on 10/11/2558.
 */
public class MyOpenHelper extends SQLiteOpenHelper{

    //Explicit
    public static final String DATABASE_NAME = "my_calandburn.db";
    private static final int DATABASE_VERSION = 1;
    private static final String USER_TABLE = "create table userTABLE (_id integer primary key, " +
            "date text, " +
            "name text, " +
            "sex text, " +
            "age text, " +
            "height double, " +
            "weight double, " +
            "myact text, " +
            "factor text, " +
            "bmiuser double, " +
            "bmruser double);";

    private static final String FOOD_TABLE = "create table foodTABLE (_id integer primary key, " +
            "namefood text, " +
            "calfood text, " +
            "aboutfood text);";

    // join table food
    //private static final String TypeFOOD_TABLE = "create table typeFoodTable (_idTypeFood integer primary key,";

    private static final String ACTIVITY_TABLE = "create table activityTABLE (_id integer primary key, " +
            "nameact text, " +
            "burnact text, " +
            "aboutact text);";

    private static final String calary_table = "create table calary_table (" +
            "_id integer primary key, " +
            "Date text, " +
            "Food text, " +
            "Amount text," +
            "CalFood text);";

    private static final String burn_table = "create table burn_table (" +
            "_id integer primary key, " +
            "Date text, " +
            "Exercise text, " +
            "Hour text, " +
            "CalBurn text);";

    public MyOpenHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    } //Construstor

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(calary_table);
        db.execSQL(burn_table);
        db.execSQL(USER_TABLE);
        db.execSQL(FOOD_TABLE);
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('กระเพาะปลา 1 ชาม', 150.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('กล้วยบวชชี 1 ถ้วย', 230.00, 'ของหวาน');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('กุ้งอบวุ้นเส้น 1 จาน', 300.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ขนมจีนน้ำยา 1 จาน', 375.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ข้าวขาหมู 1 จาน', 690.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ข้าวคลุกกะปิ 1 จาน', 410.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ข้าวผัดกระเพรากุ้ง 1 จาน', 540.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ข้าวผัดกระเพราหมู 1 จาน', 580.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ข้าวมันไก่ 1 จาน', 585.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ข้าวมันไก่ทอด 1 จาน', 695.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ข้าวสวย 3 ทัพพี', 240.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ชาร้อน 1 แก้ว', 55.00, 'เครื่องดื่ม');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ชามะนาว 1 แก้ว', 100.00, 'เครื่องดื่ม');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('น้ำอัดลม (หวาน) 1 แก้ว', 75.00, 'เครื่องดื่ม');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('น้ำแอปเปิ้ลแดง 100%(200 ml) 1 กล่อง', 120.00, 'เครื่องดื่ม');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('เค้กช็อคโกแลต 1 ชิ้น', 275.00, 'ของหวาน');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('เบียร์ไทย 1 แก้ว', 148.00, 'เครื่องดื่ม');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ไข่ดาว 1 ฟอง', 165.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ไข่เจียว 1 ฟอง', 200.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ไอศกรีมชอกโกแล็ต 1 ก้อน', 110.00, 'ของหวาน');");

        db.execSQL(ACTIVITY_TABLE);
        db.execSQL("INSERT INTO activityTABLE( nameact, burnact, aboutact) VALUES ('กระโดดเชือก', 780.00, ' ออกกำลังกาย');");
        db.execSQL("INSERT INTO activityTABLE( nameact, burnact, aboutact) VALUES ('กวาดพื้น', 225.00, ' กิจกรรม');");
        db.execSQL("INSERT INTO activityTABLE( nameact, burnact, aboutact) VALUES ('ขี่จักรยาน', 450.00, ' ออกกำลังกาย');");
        db.execSQL("INSERT INTO activityTABLE( nameact, burnact, aboutact) VALUES ('มวยไทย', 800.00, ' ออกกำลังกาย');");
        db.execSQL("INSERT INTO activityTABLE( nameact, burnact, aboutact) VALUES ('วิ่งบนทางราบด้วยความเร็ว 12.8กม./ชม.', 825.00, ' ออกกำลังกาย');");
        db.execSQL("INSERT INTO activityTABLE( nameact, burnact, aboutact) VALUES ('วิ่งบนทางราบด้วยความเร็ว 18.2กม./ชม.', 1390.00, ' ออกกำลังกาย');");
        db.execSQL("INSERT INTO activityTABLE( nameact, burnact, aboutact) VALUES ('เดินช้า', 150.00, ' ออกกำลังกาย');");
        db.execSQL("INSERT INTO activityTABLE( nameact, burnact, aboutact) VALUES ('เดินธรรมดา', 300.00, ' ออกกำลังกาย');");
        db.execSQL("INSERT INTO activityTABLE( nameact, burnact, aboutact) VALUES ('เลื่อยไม้', 515.00, ' กิจกรรม');");
        db.execSQL("INSERT INTO activityTABLE( nameact, burnact, aboutact) VALUES ('เล่นวอลเล่ย์บอล', 300.00, ' ออกกำลังกาย');");
        db.execSQL("INSERT INTO activityTABLE( nameact, burnact, aboutact) VALUES ('เล่นฮูล่าฮูป', 430.00, ' ออกกำลังกาย');");
        db.execSQL("INSERT INTO activityTABLE( nameact, burnact, aboutact) VALUES ('เล่นเทนนิสคู่', 780.00, ' ออกกำลังกาย');");
        db.execSQL("INSERT INTO activityTABLE( nameact, burnact, aboutact) VALUES ('เล่นเทนนิสเดี่ยว', 780.00, ' ออกกำลังกาย');");
        db.execSQL("INSERT INTO activityTABLE( nameact, burnact, aboutact) VALUES ('เล่นแบดมินตัน', 780.00, ' ออกกำลังกาย');");
        db.execSQL("INSERT INTO activityTABLE( nameact, burnact, aboutact) VALUES ('แอโรบิค', 780.00, ' ออกกำลังกาย');");


    } //onCreate สร้างฐานข้อมูล

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        onCreate(db);
    } //onUpgrade อัพเกรดฐานข้อมูล
} //main class