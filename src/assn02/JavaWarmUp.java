package assn02;
import java.util.*;
public class JavaWarmUp {
    public static void main(String args[]){
        System.out.println("Please enter the info:");
//        System.out.println(Arrays.toString(getData()));
        System.out.println(Arrays.toString(getTime(getData())));


    }
    public static String[] getData(){
        Scanner myScanner = new Scanner(System.in);
        int size = Integer.parseInt(myScanner.nextLine());
        String[] infoList = new String[size];
        for (int i = 0; i < size; i++){
            String batch = myScanner.nextLine();
            infoList[i] = batch;
        }
        return infoList;

    }
    public int getMaxUnitPriceIndex(String[] strL){
        return 0;
    }
    public static String[] getTime(String[] rawDataList){
        int size = rawDataList.length;
        String[] TimeList = new String[size];
        for (int i = 0; i < rawDataList.length; i++) TimeList[i] = rawDataList[i].substring(0, 13).strip();
        return TimeList;
    }
}
