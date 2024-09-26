import java.util.Scanner;

public class Ex04_20230808010 {

    public static void main(String[] args) {
        //exercise 1
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Center point x and y. ");
        double x1=input.nextDouble();
        double y1=input.nextDouble();
        System.out.println("Enter Edge point x and y. ");
        double x2= input.nextDouble();
        double y2= input.nextDouble();
        double result= Math.pow((y2-y1), 2) + Math.pow((x2-x1), 2);
        double radius= Math.sqrt(result);
        double area = Math.PI*radius*radius;
        double circumference = 2*Math.PI*radius;
        System.out.println("Circle's area is " +area);
        System.out.println("Circle's circumference is " + circumference);
        //exercise 2
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter your name.");
        String fullName = reader.nextLine();
        int blank= fullName.indexOf(" ");
        String firstName= fullName.substring(0, blank+1);
        String lastName= fullName.substring(blank+1);
        System.out.println(lastName+ ", " + firstName);
        //exercise 3
        System.out.println("Enter a day in the week as a number(1-7)");
        int day = input.nextInt();
         switch (day) {
          case 1: System.out.println("Monday"); break;
          case 2: System.out.println("Tuesday"); break;
          case 3: System.out.println("Wednesday"); break;
          case 4: System.out.println("Thursday");  break;
          case 5: System.out.println("Friday"); break;
          case 6: System.out.println("Saturday"); break;
          case 7: System.out.println("Sunday"); break; 
          default: System.out.println("Enter a valid integer.");}
        //exercise 4 
        System.out.println("Enter the first city");
        String city1= reader.nextLine();
        System.out.println("Enter the second city");
        String city2 = reader.nextLine();
        System.out.println("Enter the last city");
        String city3 = reader.nextLine();
        if (city1.compareTo(city2) < 0 && city2.compareTo(city3) < 0) {
            System.out.println(city1 + "\n" + city2 + "\n" + city3); }
        else if (city1.compareTo(city2) < 0 && city3.compareTo(city2) < 0) {
            System.out.println(city1 + "\n" + city3 + "\n" + city2); }
        else if (city2.compareTo(city1) < 0 && city1.compareTo(city3) < 0) {
            System.out.println(city2 + "\n" + city1 + "\n" + city3); }
        else if (city2.compareTo(city1) < 0 && city3.compareTo(city1) < 0) {
            System.out.println(city2 + "\n" + city3 + "\n" + city1); }
        else if (city3.compareTo(city1) < 0 && city1.compareTo(city2) < 0) {
             System.out.println(city3 + "\n" + city1 + "\n" + city2);}
        else {System.out.println(city3 + "\n" + city2 + "\n" + city1);}
        //exercise 5
        System.out.println("Enter the height of the triangle.");
        double height = input.nextDouble();
        System.out.println("Enter base of the triangle.");
        double base = input.nextDouble();
        double triangleArea = height*base/2;
        System.out.printf("Triangle's approximate area is %.3f %n", triangleArea);

        input.close();
        reader.close();       
    }
}