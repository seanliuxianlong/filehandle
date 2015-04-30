package filehandle;

import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException;


/*
 * The class is to read file and operate the float number in the file, get total summary for those data and 
 * @author SeanLiu
 * @date  April 25, 2015
 */
public class FileProcess {
	
    
     /*
      * The method is to convert String[] to float and also calculate the summary of all. 
      *
      * @parameter String[] arrays  The String array for those floats  
	  * @return float the summation of all floats.
      * 
      */
    public static float Sum(String[] arrays) throws NumberFormatException,Exception {
        float subTotal=0;
    	try{
            for(int i=0;i<arrays.length; i++){
            	System.out.println("original next number is"+arrays[i]);
                subTotal +=Float.parseFloat(arrays[i]);
                if(subTotal>java.lang.Float.MAX_VALUE||subTotal<java.lang.Float.MIN_VALUE){
                    throw new Exception("Float summation is overflow");
                }
                else{
                	System.out.println("subtotal of numbers is"+subTotal);	
                }
            }
    	}
        catch(NumberFormatException e){
        	throw e;
        }
        return subTotal;
     }
    /*
     * handler the file which is specified. 
     * @parameter String path The path of the file which is specified.
     * @retur String total number and sum of total nubmer
     */
    public static String handlerFile(String path){
    	 
    	try {
            // read file content from file
    		File file = new File(path);   
    		BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));   
    		BufferedReader reader = new BufferedReader(new InputStreamReader(fis,"utf-8"),5*1024*1024);//use 5M buffer to read  
            String str = null;
            int count = 0;
            float total = 0;
            while((str = reader.readLine()) != null) {
       	    //read one line and remove more space and convert them to String array
            String [] stringArrays = str.split(" +");
            //calculate total summary of the stringArrays
            total += Sum(stringArrays);
            //calculate total number count of stringArrays
            count +=stringArrays.length;
            }
            String result ="Total count of those floats is"+count+"Total summary of those floats is"+total; 
            
            System.out.println(result);
            fis.close();
            reader.close();
            return result;
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
            return "-1";
        }
        catch(IOException e) {
            e.printStackTrace();
            return "-1";
        }
        catch(NumberFormatException e) {
            e.printStackTrace();
            System.out.println("-1");
            return "-1";
        }
    	catch(Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }

    
	public static void main(String[] args) {
        if (args.length==0){
            System.out.println("Please input your file name with full path");
        }
         
        else{
        	//test cases1, it is a normal case
        	handlerFile(args[0]);
        	//test cases2, include abnormal float. e.g. append English character, long float  
        	//handlerFile(args[0]);
        	//test cases3, include an empty file without any data
        	//test cases4, a big file with so many float
        }         
    }
}