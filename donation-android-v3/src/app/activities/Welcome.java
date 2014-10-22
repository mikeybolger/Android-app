package app.activities;

import app.donation.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Welcome extends Activity
{
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_welcome);
  }
  
  public void loginPressed (View view) 
  {
    startActivity (new Intent(this, Login.class));
  }

  public void signupPressed (View view) 
  {
    startActivity (new Intent(this, Signup.class));
  }
}
