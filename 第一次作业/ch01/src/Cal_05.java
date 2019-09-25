public class Cal_05 {
    //package ch02;
    //静态变量，用于存储运行结果
    public static class Calculator {
        private int result = 0;
        public void add(int n) {
            result = result + n;
        }
        public void substract(int n) {
            result = result - n;
        }
        public void multiply(int n) {
            result = result * n;
        }
        public void divide(int n) {
            result = result / n;
         }
        public void square() {
            result = result * result;
        }
        public void power(int n) {
            result = (int) Math.pow(result, n);
        }
        public void clear() {
            result = 0;
        }
        public int getResult() {
            return result;
        }
    }
    public static void main(String[] args) {
        Calculator Cal_05 = new Calculator();
        System.out.print("初始值：");
        System.out.print(Cal_05.getResult()+"\n");
        Cal_05.add(5);
        System.out.print("加5后：");
        System.out.print(Cal_05.getResult()+"\n");
        Cal_05.multiply(7);
        System.out.print("乘7后：");
        System.out.print(Cal_05.getResult()+"\n");
        Cal_05.square();
        System.out.print("平方后：");
        System.out.print(Cal_05.getResult()+"\n");
        Cal_05.substract(1220);
        System.out.print("减1220后：");
        System.out.print(Cal_05.getResult()+"\n");
        Cal_05.power(3);
        System.out.print("三次方后：");
        System.out.print(Cal_05.getResult()+"\n");
        Cal_05.clear();
        System.out.print("清零后：");
        System.out.print(Cal_05.getResult()+"\n");
    }
}
