
import java.util.Scanner;

public class Ex0220230808010 {
    public static void main(String[] args) {
        //exercise 1
        System.out.println("Enter a number.");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        if (number <0) {System.out.println((-1)*((number % 100) - (number % 10))/10);}
        else System.out.println(((number % 100) - (number % 10))/10);

        //exercise 2
        System.out.println("Enter how many minutes customer has spent");
        int minutes = input.nextInt();
        if (minutes % 60 ==0) {System.out.println("Customer has to pay " + (minutes/60)*50 + " liras.");}
        else {System.out.println("Customer has to pay " + (minutes/60+1)*50 + " liras.");}
        System.out.println("Customer didn't use "+ (60 - (minutes % 60)) + " minutes of the paid time.");

        //exercise 3
        System.out.println("Enter how many trials dice will be rolled.");
        int trials = input.nextInt();
        double result= (Math.pow(1-1/6.0 , trials-1))/6; 
        System.out.println("The probability of rolling the first 4 on trial " + trials + " is " + result);

          input.close();
          }
        }

    

