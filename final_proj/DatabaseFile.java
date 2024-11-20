//DatabaseFile.java
package final_proj;

import java.io.*;
import java.util.HashMap;
import java.util.Map.Entry;

public class DatabaseFile
{
  FileInputStream fis;
  FileOutputStream fos;

  HashMap<String, String> database;
  
  public boolean verifyAccount(String username, String password)
  {
    readFile();
    
    if (database.get(username) == null)
      return false;
    
    if (database.get(username).equals(password))
      return true;
    else
      return false;
  }
  
  public boolean createNewAccount(String username, String password)
  {
    readFile();
    
    if (database.get(username) != null)
      return false;
    
    database.put(username, password);
    
    writeFile();
    return true;
  }
  
  public synchronized void readFile()
  {
    database = new HashMap<String, String>();
    
    try
    {
      fis = new FileInputStream("database.txt");
      BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
      
      String line = reader.readLine();
      while(line != null)
      {
        String[] data = line.split("\\|");
        
        if (data.length == 2)
          database.put(data[0], data[1]);
        
        line = reader.readLine();
      }
      
      fis.close();
    }
    
    catch (Exception exception)
    {
      return;
    }
  }
  
  public synchronized void writeFile()
  {
    String output = "";
    for (Entry<String, String> entry : database.entrySet())
    {
      output += entry.getKey() + "|" + entry.getValue() + "\n";
    }
    
    try
    {
      fos = new FileOutputStream("database.txt");
      BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
      
      writer.write(output);
      writer.flush();
      
      fos.close();
    }
    
    catch (Exception exception)
    {
      return;
    }
  }
}
