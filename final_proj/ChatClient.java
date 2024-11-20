//ChatClient.java
package final_proj;

import ocsf.client.AbstractClient;

public class ChatClient extends AbstractClient
{
  private LoginControl loginControl;
  private CreateAccountControl createAccountControl;

  public void setLoginControl(LoginControl loginControl)
  {
    this.loginControl = loginControl;
  }
  public void setCreateAccountControl(CreateAccountControl createAccountControl)
  {
    this.createAccountControl = createAccountControl;
  }

  public ChatClient()
  {
    super("localhost", 8300);
  }
  
  public void handleMessageFromServer(Object arg0)
  {
    if (arg0 instanceof String)
    {
      String message = (String)arg0;
      
      if (message.equals("LoginSuccessful"))
      {
        loginControl.loginSuccess();
      }
      
      else if (message.equals("CreateAccountSuccessful"))
      {
        createAccountControl.createAccountSuccess();
      }
    }
    
    else if (arg0 instanceof Error)
    {
      Error error = (Error)arg0;
      
      if (error.getType().equals("Login"))
      {
        loginControl.displayError(error.getMessage());
      }
      
      else if (error.getType().equals("CreateAccount"))
      {
        createAccountControl.displayError(error.getMessage());
      }
    }
  }  
}
