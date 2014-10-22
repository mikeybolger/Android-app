package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Members extends Controller
{
  public static void index()
  {
    User user = Accounts.getLoggedInUser();
    List<User> users = User.findAll();
    users.remove(user);
    render(user, users);
  }
}