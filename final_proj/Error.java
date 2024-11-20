//Error.java
package final_proj;

import java.io.Serializable;

public class Error implements Serializable
{
  private String message;
  private String type;
  
  public String getMessage()
  {
    return message;
  }
  public String getType()
  {
    return type;
  }
  
  public void setMessage(String message)
  {
    this.message = message;
  }
  public void setType(String type)
  {
    this.type = type;
  }
  
  public Error(String message, String type)
  {
    setMessage(message);
    setType(type);
  }
}
