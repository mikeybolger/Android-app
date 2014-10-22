package app.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import app.donation.R;
import app.main.DonationApp;
import app.models.User;

public class Signup extends Activity
{

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_signup);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu)
  {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.signup, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item)
  {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    if (id == R.id.action_settings)
    {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
  
  public void registerPressed (View view) 
  {
    TextView firstName = (TextView)  findViewById(R.id.firstName);
    TextView lastName  = (TextView)  findViewById(R.id.lastName);
    TextView email     = (TextView)  findViewById(R.id.Email);
    TextView password  = (TextView)  findViewById(R.id.Password);

    User user = new User (firstName.getText().toString(), lastName.getText().toString(), email.getText().toString(), password.getText().toString());

    DonationApp app = (DonationApp) getApplication();
    app.newUser(user);

    startActivity (new Intent(this, Donate.class));
  }
}
