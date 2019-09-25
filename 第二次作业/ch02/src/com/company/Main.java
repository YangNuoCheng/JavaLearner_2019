package com.company;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.text.DecimalFormat;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.setProperty("webdriver.chrome.driver","/Users/yangnuocheng/Desktop/JavaExercise/第二次作业/JavaJsoup_Ecode/JavaSelenium/Googledrive/chromedriver");
        //chromedriver地址，必须先初始化后调用
        WebDriver driver = new ChromeDriver();
        driver.get("https://finance.sina.com.cn/money/forex/hq/USDCNY.shtml");
        //新浪财经，外汇板块，中美汇率页面
        String USDCNY_Xpath="/html/body/div[@class='wrap']/div[@class='part_01 clearfix']/div[@class='p_middle']/div[@id='quoteWrap']/div[@class='price_bar up']/div[@class='price']/h5";
        String USDCNY_Exchange = driver.findElement(By.xpath(USDCNY_Xpath)).getText();
        String USDCNY_Current=driver.findElement(By.xpath(USDCNY_Xpath)).getText();
        //通过页面信息中的xpath查找汇率具体值
        System.out.println("Current exchange rate is :"+driver.findElement(By.xpath(USDCNY_Xpath)).getText()+".");
        //driver.close();
        int quit=0;
        DecimalFormat df=new DecimalFormat("0.00");//设置保留位数
        while(quit==0) {
            System.out.print("Enter the exchange rate from dollars to RMB or you can enter 0.0 to use current exchange rate:");
            double USDCNY_MyExchange = input.nextDouble();
            System.out.print("Enter 0 to convert dollars to RMB and 1 vice versa:");
            double Number = input.nextInt();
            if (Number == 0) System.out.print("Enter the dollar amount:");
            else if (Number == 1) System.out.print("Enter the RMB amount:");
            else {
                System.out.print("Input Wrong,please try again.");
                continue;
            }
            double amountOfMoney = input.nextDouble();
            double aim = 0.0;
            if (USDCNY_MyExchange == 0)
                USDCNY_MyExchange = Double.parseDouble(USDCNY_Current);
            if (Number == 0) {
                //dollars 2 RMB
                aim = amountOfMoney * USDCNY_MyExchange;
            }
            else {
                aim = amountOfMoney / USDCNY_MyExchange;
            }
            String output = df.format(aim);
            if (Number == 0) {
                System.out.println(amountOfMoney+" dollars is ￥"+output);
            }
            else {
                System.out.println(amountOfMoney+"RMB is $"+output);
            }
        }
    }
}
