import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.lang.Math.*;

/**
 * Javadoc me
 */
public class BaseConverter {

    private final String DIGITS = "0123456789ABCDEF";
    /**
     * Convert a String num in fromBase to base-10 int.
     * @param num the original number
     * @param fromBase the original from base
     * @return a base-10` int of num base fromBase
     */
    public int strToInt(String num, String fromBase)    {
        // "FF" "16"
        int value = 0, exp=0;
        for(int i=num.length()-1; i>=0; i--, exp++){
            value+=DIGITS.indexOf(num.charAt(i))*Math.pow(Integer.parseInt(fromBase), exp);
            exp++;
        }
        return value;
    }

    /**
     * Javadoc converts an Integer to a String
     * @param num
     * @param toBase
     * @return returns a Base 10 String
     */
    public String intToStr(int num, int toBase) {
        String toNum = new String();

        int index=-1;
        while(num>0){
            index=num%toBase;
            toNum = DIGITS.charAt(num % toBase)+ toNum;
            num/=toBase;
        }

        return (toNum.equals("")) ? "0" : toNum;
    }

    /**
     * Reads in the contents of a datafile and calls the strToInt and intToStr methods to convert the base.
     */
    public void inputConvertPrintWrite()    {
        Scanner in=null;
        PrintWriter out=null;
        try{
            in =new Scanner(new File("datafiles/values30.dat"));
            out=new PrintWriter(new File("datafiles/converted.dat"));
            String [] line;
            String output;
            while(in.hasNext()){
                //out.println(in.nextLine());
                line=in.nextLine().split("\t");

                if(Integer.parseInt(line[1])<2 || Integer.parseInt(line[1])>16){
                    System.out.println("Invalid input base "+ line[1]);
                }

                else if(Integer.parseInt(line[2])<2 || Integer.parseInt(line[2])>16){
                    System.out.println("Invalid input base "+ line[2]);
                }

                else{
                    output=intToStr(strToInt(line[0], line[1]), Integer.parseInt(line[2])) + "\t"+line[2];
                    out.println(line[0] +"\t"+line[1]+"\t"+output);
                    System.out.println(line[0]+" base "+line[1]+" = "+output+" base "+line[2]);
                }
            }

            if(out != null){
                out.close();
            }
            if(in != null){
                in.close();
                System.out.println("The revolution will not be televised");
            }

        }catch (Exception e) {
            System.out.println("Something bad happened. Details here: "+ e.toString());
        }
    }

    /**
     * Javadoc me
     * @param args
     */
    public static void main(String[] args) {
        BaseConverter bc = new BaseConverter();
        bc.inputConvertPrintWrite();

    }
}
