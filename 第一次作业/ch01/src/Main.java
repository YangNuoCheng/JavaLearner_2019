//This application can slove two dimensiol system of equations
import java.awt.desktop.SystemEventListener
import java.text.DecimalFormat;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Here we have equations:");
        System.out.println("ax+by=e and cx+dy=f");
        System.out.print("Please input a:");
        Float a = scan.nextFloat();
        System.out.print("Please input b:");
        Float b = scan.nextFloat();
        System.out.print("Please input c:");
        Float c = scan.nextFloat();
        System.out.print("Please input d:");
        Float d = scan.nextFloat();
        System.out.print("Please input e:");
        Float e = scan.nextFloat();
        System.out.print("Please input f:");
        Float f = scan.nextFloat();
        System.out.println("Your equations are:");
        System.out.println(a+"x+"+b+"y="+e);
        System.out.println(c+"x+"+d+"y="+f);
        DecimalFormat df=new DecimalFormat("0.00");//设置保留位数
        //df.format((float)a/b);
        String ansx =df.format((Float)((e*d-b*f)/(a*d-b*c)));
        String ansy =df.format((Float)((a*f-e*c)/(a*d-b*c)));
        System.out.println("The answer is : x="+ansx+" y= "+ansy);
    }
}
