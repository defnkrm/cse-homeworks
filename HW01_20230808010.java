public class HW01_20230808010 {
    public static void main(String[] args) {
    }
}
class Stock{
   private String symbol; 
   private String name;
   private double previousClosingPrice;
   private double currentPrice;


   public double getCurrentPrice() {
       return currentPrice;
   }
   public String getName() {
       return name;
   }
   public double getPreviousClosingPrice() {
       return previousClosingPrice;
   }
   public String getSymbol() {
       return symbol;
   }
   
   public void setPreviousClosingPrice(double previousClosingPrice) {
       this.previousClosingPrice = previousClosingPrice;
   }

   public double setCurrentPrice(double newPrice){
    if(newPrice<0){
        System.out.println("ERROR : you have entered an invalid value.");
    }
    else{
        previousClosingPrice=currentPrice;
        currentPrice=newPrice;
    }
    return currentPrice;
   }

   public double getChangePercent(){
    double percent=(currentPrice-previousClosingPrice)/previousClosingPrice;
    return percent*100;
   }

   Stock(){

   }

   Stock(String givenSymbol,String givenName){
    symbol=givenSymbol.toUpperCase();
    String[] names=givenName.split(" ");
    name=" ";
    for (int i = 0; i < names.length; i++) {
        name+=names[i].substring(0,1).toUpperCase()+names[i].substring(1).toLowerCase()+" ";
    }
    name=name.trim();
   }

   //@Override
   public String toString() {
       return String.format("[%s] - [%s]: [%f]",symbol,name,currentPrice);
   }
}

class Fan{
    private final int SLOW=1;
    private final int MEDIUM=2;
    private final int FAST=3;
    private int speed;
    private boolean on;
    private double radius; 
    private String color;

    Fan(){
        this(5,"Blue");
        this.speed=SLOW;
        this.on=false;
    }
    Fan(int radius, String color){
        this.radius=radius;
        this.color=color;
    }

    public String getColor() {
        return color;
    }
    public double getRadius() {
        return radius;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int newSpeed){
        if(on){
            if(newSpeed==1||newSpeed==2||newSpeed==3)
                speed=newSpeed;
            else
                System.out.println("ERROR: You have entered an invalid speed.");
        }
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public void setColor(String color) {
        this.color = color;
    }
    

    public boolean isOn(){
        if(on)
            return true;
        else 
            return false;
    }
    public void change(){
        if(on)
            on=false;
        else
            on=true;
    }

    //@Override
    public String toString() {
        if(on){
            return String.format("Speed: %d,Radius %.2f, Color: %s",speed,radius,color);
        }
        else{
            return String.format("Fan is off");
        }        
        
    }
}