import java.util.List;

import play.*;
import play.jobs.*;
import play.test.*;
import models.*;
 
@OnApplicationStart
public class Bootstrap extends Job 
{ 
  public void doJob()
  {
    if (User.count() == 0)
    {
      Fixtures.deleteDatabase(); 
      Fixtures.loadModels("data.yml");
    }
  }
}