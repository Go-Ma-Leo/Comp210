package assn02;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.util.*;
import java.io.File;
public class JavaWarmUp {
    static int ENTRY_DATA_SIZE = 7; // number of fields each line.
    static int DATE_INDEX = 0;
    static int TIME_INDEX = 1;
    public static void main(String[] args){
        String[][] data_2d_array = getData();
        getTime(data_2d_array);
//        System.out.println(Arrays.toString(getTime(getData())));


    }
    public static String[][] getData(){
        // Return a 2d array of the input data(lines).
        File text_file = new File("C:\\Users\\Mosken\\Documents\\UNC\23 Spring\\Comp 210\\A2-text.txt");
        Scanner myScanner = null;
        try {
            myScanner = new Scanner(text_file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found! Please manually enter the info:");
            myScanner = new Scanner(System.in);
        }

        int size = Integer.parseInt(myScanner.nextLine());
        String[][] infoList = new String[size][ENTRY_DATA_SIZE];
        for (int i = 0; i < size; i++){
            String entry = myScanner.nextLine();
            infoList[i] = entry.split("\\s+");
        }
        System.out.println(Arrays.deepToString(infoList));
        return infoList;

    }
    public int getMaxUnitPriceIndex(String[] strL){
        return 0;
    }
    public static String[] getTime(String[][] info_data){
        int size = info_data.length;
        String[] TimeList = new String[size];
        for (int i = 0; i < info_data.length; i++) {
            TimeList[i] = info_data[i][DATE_INDEX] + " " + info_data[i][TIME_INDEX];
        }
        System.out.println(Arrays.toString(TimeList));
        return TimeList;
    }
}
