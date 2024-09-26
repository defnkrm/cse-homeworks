
public class Ex01_20230808010 {
    public static void main(String[] args) {
        //exercise 1
        int number = 1;
        System.out.println("a a^2 a^3");
        System.out.println(number + " " + number*number + " " + number*number*number++);
        System.out.println(number + " " + number*number + " " + number*number*number++);
        System.out.println(number + " " + number*number + " " + number*number*number++);
        System.out.println(number + " " + number*number + " " + number*number*number++);
        System.out.println();

        //exercise 2
        System.out.println(((9.5*4.5)-(2.5*3))/(45.5-3.5));
        System.out.println();

        //exercise 3
        double num = 3.0;
        System.out.print("Pi equals to ");
        System.out.println(4.0*(1.0 - (1.0/num) + (1.0/(num + 2.0)) - (1.0/(num + 4.0)) + (1.0/(num + 6.0)) - (1.0/(num + 8.0))) );
        System.out.print("Pi equals to ");
        System.out.println(4.0*(1.0 - (1.0/num) + (1.0/(num + 2.0)) - (1.0/(num + 4.0)) + (1.0/(num + 6.0)) - (1.0/(num + 8.0)) + (1.0/(num + 10.0))));
        double pi = 4.0*(1.0 - (1.0/num) + (1.0/(num + 2.0)) - (1.0/(num + 4.0)) + (1.0/(num + 6.0)) - (1.0/(num + 8.0)) + (1.0/(num + 10.0)));
        System.out.println();

        //exercise 4
        double rad = 5.5;
        System.out.print("If radius is 5.5 area of a circle is ");
        System.out.println(pi*rad*rad);
        System.out.println("If radius is 5.5 perimeter of a circle is ");
        System.out.println(2*pi*rad); 
        System.out.println();

        //exercise 5
        double a = 3.4;
        double b = 50.2;
        double c = 2.1;
        double d = .55;
        double e = 44.5;
        double f = 5.9;
        System.out.println("x equals to " + (e*d - b*f)/(a*d - b*c));
        System.out.println("y equals to " + (a*f - e*c)/(a*d - b*c));
        double x = (e*d - b*f)/(a*d - b*c);
        double y = (a*f - e*c)/(a*d - b*c);
        System.out.println("e equals to " + (a*x + b*y));
        System.out.println("f equals to " + (c*x + d*y));

        







        
        
    }

    
}