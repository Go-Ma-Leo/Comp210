package assn02;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.io.File;
public class JavaWarmUp {
    static int ENTRY_DATA_SIZE = 7; // number of fields each line.
    static int DATE_INDEX = 0;
    static int HM_INDEX = 1;
    static int TYPE_INDEX = 2;
    static int FEE_INDEX = 3;
    static int QUANTITY_INDEX = 4;
    static int TIME_INDEX = 5;
    static int COST_INDEX = 6;

    public static void main(String[] args){
        String[][] data_2d_array = getData();
        String[] feeL = get(data_2d_array, FEE_INDEX);
        String[] dateL = get(data_2d_array, DATE_INDEX);
        String[] hmL = get(data_2d_array, HM_INDEX);
        String[] typeL = get(data_2d_array, TYPE_INDEX);
        String[] quantityL = get(data_2d_array, QUANTITY_INDEX);
        String[] timeL = get(data_2d_array, TIME_INDEX);
        String[] costL = get(data_2d_array, COST_INDEX);
        String phone = "phone";
        String laptop = "laptop";
        String smart_watch = "smart_watch";

        int highest_fee_index = getMaxIndex(feeL);
        int lowest_fee_index = getMinIndex(feeL);

        String highest = "Highest per unit assembling fee:\n" +
                "\tWhen: " + dateL[highest_fee_index] + " " + hmL[highest_fee_index] + "\n" +
                "\tCategory: " + typeL[highest_fee_index] + "\n" +
                "\tPrice: " + feeL[highest_fee_index];
        String lowest = "Lowest per unit assembling fee:\n" +
                "\tWhen: " + dateL[lowest_fee_index] + " " + hmL[lowest_fee_index] + "\n" +
                "\tCategory: " + typeL[lowest_fee_index] + "\n" +
                "\tPrice: " + feeL[lowest_fee_index];


        String phoneStat = "Statistic of phone\n" +
                "\tQuantity: " + getStat(data_2d_array,phone)[0] + "\n" +
                "\tAverage Assembling fee: " + getStat(data_2d_array,phone)[1] + "\n" +
                "\tAverage Net Profit: " + getStat(data_2d_array,phone)[2];
        String laptopStat = "Statistic of laptop\n" +
                "\tQuantity: " + getStat(data_2d_array,laptop)[0] + "\n" +
                "\tAverage Assembling fee: " + getStat(data_2d_array,laptop)[1] + "\n" +
                "\tAverage Net Profit: " + getStat(data_2d_array,laptop)[2];
        String smart_phoneStat = "Statistic of smart_watch\n" +
                "\tQuantity: " + getStat(data_2d_array,smart_watch)[0] + "\n" +
                "\tAverage Assembling fee: " + getStat(data_2d_array,smart_watch)[1] + "\n" +
                "\tAverage Net Profit: " + getStat(data_2d_array,smart_watch)[2];
        System.out.println(highest);
        System.out.println(lowest);
        System.out.println(phoneStat);
        System.out.println(laptopStat);
        System.out.println(smart_phoneStat);
    }
    public static String[][] getData(){
        // Return a 2d array of the input data(lines).
        Scanner myScanner = new Scanner(System.in);
        int size = Integer.parseInt(myScanner.nextLine());
        String[][] infoList = new String[size][ENTRY_DATA_SIZE];
        for (int i = 0; i < size; i++){
            String entry = myScanner.nextLine();
            infoList[i] = entry.split("\\s+");
        };
        return infoList;

    }
    public static String[] get(String[][] info_data, int index){
        // Given 2d data array and data type index return an array of that kind of data.
        int size = info_data.length;
        String[] TypeList = new String[size];
        for (int i = 0; i < info_data.length; i++) {
            TypeList[i] = info_data[i][index];
        }
        return TypeList;
    }
    public static int getMaxIndex(String[] strL){
        // Given a list of strings of numbers, return the index of max.
        Double[] numbers = new Double[strL.length];
        for(int i = 0; i < strL.length; i++) numbers[i] = Double.parseDouble(strL[i]);
        if ( numbers == null || numbers.length == 0 ) return -1; // null or empty

        int index = 0;
        for ( int i = 1; i < numbers.length; i++ )
        {
            if ( numbers[i] >= numbers[index] ) index = i;
        }
        return index;
    }
    public static int getMinIndex(String[] strL){
        // Given a list of strings of numbers, return the index of min.
        Double[] numbers = new Double[strL.length];
        for(int i = 0; i < strL.length; i++) numbers[i] = Double.parseDouble(strL[i]);
        if ( numbers == null || numbers.length == 0 ) return -1; // null or empty

        int index = 0;
        for ( int i = 1; i < numbers.length; i++ )
        {
            if ( numbers[i] <= numbers[index] ) index = i;
        }
        return index;
    }


    public static String[] getStat(String[][] data, String type){
        int quantity = 0;
        double totalFee = 0;
        String[] stat = new String[3];
        double totalCost = 0;
        for (int i = 0; i < data.length; i++){
            if (data[i][TYPE_INDEX].equals(type)){
                quantity += Integer.parseInt(data[i][QUANTITY_INDEX]);
                totalFee += Double.parseDouble(data[i][FEE_INDEX]) * Double.parseDouble(data[i][QUANTITY_INDEX]);
                totalCost += Double.parseDouble(data[i][COST_INDEX]) + 16 * Double.parseDouble(data[i][TIME_INDEX]);
            }
        }
        double avgFee = totalFee/quantity;
        double avgNetProfit = (totalFee-totalCost)/quantity;
        stat[0] = String.valueOf(quantity);
        stat[1] = String.format("%.2f",avgFee);
        stat[2] = String.format("%.2f",avgNetProfit);
        return stat;
    }
    }



