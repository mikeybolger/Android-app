package org.wit.myrent.activities;


import java.util.UUID;

import org.wit.myrent.R;
import org.wit.myrent.app.MyRentApp;
import org.wit.myrent.models.Portfolio;
import org.wit.myrent.models.Residence;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class ResidenceActivity extends Activity implements TextWatcher, OnCheckedChangeListener
{
  private EditText geolocation;
  private CheckBox rented;
  private Button   dateButton;

  private Residence residence;
  private Portfolio portfolio; 

  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_residence);

    geolocation = (EditText) findViewById(R.id.geolocation);
    dateButton  = (Button)   findViewById(R.id.registration_date);
    rented      = (CheckBox) findViewById(R.id.isrented);

    residence = new Residence();

    geolocation.addTextChangedListener(this);
    geolocation.setText(residence.geolocation);
    dateButton .setEnabled(false);
    rented     .setChecked(residence.rented);
    rented     .setOnCheckedChangeListener(this);
    
    MyRentApp app = (MyRentApp) getApplication();
    portfolio = app.portfolio;
    
    UUID resId = (UUID) getIntent().getExtras().getSerializable("RESIDENCE_ID");
    residence = portfolio.getResidence(resId);
    if (residence != null)
    {
      updateControls(residence);
    }
  }

  public void updateControls(Residence residence)
  {
    geolocation.setText(residence.geolocation);
    rented.setChecked(residence.rented);
    dateButton.setText(residence.getDateString());
  }

  @Override
  public void onCheckedChanged(CompoundButton arg0, boolean isChecked)
  {
    Log.i(this.getClass().getSimpleName(), "rented Checked");
    residence.rented = isChecked;
  }

  @Override
  public void afterTextChanged(Editable c)
  {
    Log.i(this.getClass().getSimpleName(), "geolocation " + c.toString());
    residence.geolocation = c.toString();
  }

  @Override
  public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3)
  {
  }

  @Override
  public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3)
  {
  }
}
