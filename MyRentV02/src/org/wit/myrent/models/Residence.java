package org.wit.myrent.models;

import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;

public class Residence
{
  public UUID id;

  public String  geolocation;
  public Date    date;
  public boolean rented;

  public Residence()
  {
    id = UUID.randomUUID();
    this.date = new Date();
  }
 
  public String getDateString()
  {
    return "Registered: " + DateFormat.getDateTimeInstance().format(date);
  }
}