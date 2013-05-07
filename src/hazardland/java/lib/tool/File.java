package hazardland.java.lib.tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File
{
	public static boolean write (String name, String content)
	{
        //FileOutputStream stream = null;
        BufferedWriter file;
		try 
		{
			file = new BufferedWriter(new FileWriter(name), 32768);
		} 
		catch (IOException e) 
		{
			return false;
		}
        //OutputStreamWriter file = new OutputStreamWriter (stream); 
		try
		{
			file.write (content);
		}
		catch (IOException exception)
		{
			return false;
		}
		try
		{
			file.flush();
		}
		catch (IOException exception)
		{
			return false;
		}
        try
		{
			file.close();
		}
		catch (IOException exception)
		{
			return false;
		}
	    return true;
	}
	
	public static String read (String name)
	{
        BufferedReader file;
		try 
		{
			file = new BufferedReader(new FileReader(name));
		} 
		catch (FileNotFoundException e) 
		{
			return "";
		}
        StringBuilder result = new StringBuilder();
        String line;
        try
		{
			while ((line = file.readLine()) != null) 
			{
			    result.append(line);
			}
		}
		catch (IOException exception)
		{
			return "";
		}

		return result.toString ();		
	}
	
	public static boolean delete (String name)
	{
		//return context.deleteFile (name);
		return false;
	}
	
	public static boolean rename (String from, String to)
	{
		java.io.File file = new java.io.File (from);
		return file.renameTo (new java.io.File (to));
	}
	
	public static String[] list (String path)
	{
		java.io.File file = new java.io.File (path);
		return file.list ();
	}
}
