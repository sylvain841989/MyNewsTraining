package conraud.sylvain.mynewstraining.ui.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.ListUpdateCallback;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.Serializable;
import java.util.Calendar;

import conraud.sylvain.mynewstraining.R;
import conraud.sylvain.mynewstraining.data.RootArticle;
import conraud.sylvain.mynewstraining.utils.CallBack;
import conraud.sylvain.mynewstraining.utils.call.CallNewYorkTimes;

public class SearchActivity extends AppCompatActivity implements CallNewYorkTimes.CallBackSearch {

    private DatePickerDialog.OnDateSetListener mDataSetListener;
    private DatePickerDialog dialog;
    private Button buttonSearch;
    private EditText editTextSearch;
    private CheckBox checkBoxArts, checkBoxBusiness, checkBoxEntrepreneur, checkBoxPolitic, checkBoxSport, checkBoxTravel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        buttonSearch = findViewById(R.id.button_search);
        editTextSearch = findViewById(R.id.edit_text_search);
        configureToolBar();
        configureSpinnerDate();
        configureCheckBox();
        configureButtonSearch();

    }

    void configureToolBar(){
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }
    void configureSpinnerDate(){
        final Spinner spinner =findViewById(R.id.spinner_begin_date);
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        mDataSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            }
        };

        spinner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                dialog = new DatePickerDialog(SearchActivity.this, AlertDialog.THEME_HOLO_DARK,mDataSetListener,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                return false;
            }
        });
    }

    void configureCheckBox(){

        checkBoxArts = findViewById(R.id.checkbox_arts);
        checkBoxBusiness = findViewById(R.id.checkbox_business);
        checkBoxEntrepreneur = findViewById(R.id.checkbox_entrepreneurs);
        checkBoxPolitic = findViewById(R.id.checkbox_politic);
        checkBoxSport = findViewById(R.id.checkbox_sport);
        checkBoxTravel = findViewById(R.id.checkbox_travel);
        getCheckBox();
    }

    void callSearch(){
        String search = editTextSearch.getText().toString();
        String filter = getCheckBox();
        CallNewYorkTimes.callSearch(this, search , filter );
    }

    String getCheckBox(){
        StringBuilder stringBuilder = new StringBuilder();
        if(checkBoxTravel.isChecked())
            stringBuilder.append("\"travel\"");
        if(checkBoxSport.isChecked())
            stringBuilder.append("\"sport\"");
        if(checkBoxPolitic.isChecked())
            stringBuilder.append("\"politic\"");
        if(checkBoxEntrepreneur.isChecked())
            stringBuilder.append("\"entrepreneur\"");
        if(checkBoxBusiness.isChecked())
            stringBuilder.append("\"business\"");
        if(checkBoxArts.isChecked())
            stringBuilder.append("\"arts\"");

        return stringBuilder.toString();

    }

    void configureButtonSearch(){
        buttonSearch = findViewById(R.id.button_search);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callSearch();
            }
        });
    }

    @Override
    public void onResponse(RootArticle rootArticle) {
            displayResults(rootArticle);
    }

    @Override
    public void onFailure() {

    }

    void displayResults(RootArticle rootArticle){
        Intent intent = new Intent(this, ResultSearchActivity.class);
        intent.putExtra("rootArticle",rootArticle);
        startActivity(intent);
    }
}
