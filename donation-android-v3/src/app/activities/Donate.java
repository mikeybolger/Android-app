package app.activities;

import app.donation.R;
import app.main.DonationApp;
import app.models.Donation;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Donate extends Activity
{
  private RadioGroup   paymentMethod;
  private ProgressBar  progressBar;
  private NumberPicker amountPicker;
  private TextView     amountText;
  private TextView     amountTotal;
  private DonationApp app;
  
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_donate);
    
    app = (DonationApp) getApplication();
    
    paymentMethod = (RadioGroup)   findViewById(R.id.paymentMethod);
    progressBar   = (ProgressBar)  findViewById(R.id.progressBar);
    amountPicker  = (NumberPicker) findViewById(R.id.amountPicker);
    amountText    = (TextView)     findViewById(R.id.amountText);
    amountTotal   = (TextView)     findViewById(R.id.amountTotal);
    
    amountPicker.setMinValue(0);
    amountPicker.setMaxValue(1000);
    progressBar.setMax(app.target);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu)
  {
    getMenuInflater().inflate(R.menu.donate, menu);
    return true;
  }
  
  @Override
  public boolean onOptionsItemSelected(MenuItem item)
  {
    switch (item.getItemId())
    {
      case R.id.menuReport : startActivity (new Intent(this, Report.class));
                             break;
      case R.id.menuLogout : startActivity (new Intent(this, Welcome.class));
                             break;                             
    }
    return true;
  }
  
  public void donateButtonPressed (View view) 
  {
    String method = paymentMethod.getCheckedRadioButtonId() == R.id.PayPal ? "PayPal" : "Direct";
    int donatedAmount =  amountPicker.getValue();
    if (donatedAmount == 0)
    {
      String text = amountText.getText().toString();
      if (!text.equals(""))
        donatedAmount = Integer.parseInt(text);
    }
    if (donatedAmount > 0)
    {
      app.newDonation(new Donation(donatedAmount, method));
      progressBar.setProgress(app.totalDonated);
      String totalDonatedStr = "$" + app.totalDonated;
      amountTotal.setText(totalDonatedStr);
    }
    amountText.setText("");
    amountPicker.setValue(0);
   }
}
