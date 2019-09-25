//This application can calculate number of days.
import java.util.Scanner;
import java.lang.Long;
public class Year_Day_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入分钟数：");
        long a = scan.nextInt();
        long Bet = a / 1440;
        long Year = Bet / 365;
        long Days = Bet % 365;
        System.out.println("The "+a+" minutes equal to "+Year+" Years and "+Days+"days." );
    }
}
