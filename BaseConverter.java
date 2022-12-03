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
        int value = 0, decimalBase;
        // Do i need a try here?
        decimalBase = Integer.parseInt(fromBase);

        return value;
    }

    /**
     * Javadoc me
     * @param num
     * @param toBase
     * @return
     */
    public String intToStr(int num, int toBase) {
        String toNum = new String();

        return toNum;
    }

    /**
     * Javadoc me
     */
    public void inputConvertPrintWrite()    {
        Scanner in=null;
        PrintWriter out=null;
        try{
            in =new Scanner(new File("datafiles/values20.dat"));
            out=new PrintWriter(new File("datafiles/hello.txt"));
            while(in.hasNext()){
                out.println(in.nextLine());
            }


            out.println("Does this work?");
            out.println("Is AP Comp Sci truly the BEST class at DA?");
            if(out==null){
                out.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
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
