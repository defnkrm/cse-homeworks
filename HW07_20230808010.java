import java.util.ArrayList;

public class HW07_20230808010 {
    public static void main(String[] args) {
        Mirror m1=new Mirror(10,20);
        Mirror m2=new Mirror(5,4);
        Paper p1=new Paper();
        Container c1=new Container();
        Box<Mirror> b1=new Box<>(m1,2);
        Box<Mirror> b2=new Box<Mirror>(m2,12);
        System.out.println(b1.isSealBroken());
        c1.push(b1);
        Container c2=new Container();
        c2.push(b2);
        Mirror m3=new Mirror(100,20);
        Container c3=new Container();
        Box<Mirror> b3=new Box<Mirror>(m3,1);
        c3.push(b3);
//        System.out.println(c1.peek());
        CargoFleet f1=new CargoFleet();
        System.out.println(f1.enqueue(c1));
        System.out.println(f1.peek());
        System.out.println(f1.enqueue(c2));
        System.out.println(f1.peek());

    }
}
interface Common<T>{
    public boolean isEmpty();
    public T peek();
    public int size();
}
interface Node<T>{
     static final int DEFAULT_CAPACITY=2;
     public T getNext();
     public double getPriority();
     public void setNext(T item);
}
interface Package<T>{
    public T extract();
    public double getPriority();
    public  boolean isEmpty();
    public boolean pack(T item);
}
interface PriorityQueue<T> extends Common<T>{
    static final int FLEET_CAPACITY=3;
    public T dequeue();
    public boolean enqueue(T item);
}
interface Sellable{
    public String getName();
    public double getPrice();
}
interface Stack<T> extends Common<T>{
    public T pop();
    public boolean push(T item);
}
interface Wrappable extends Sellable{}
class Box <T extends Sellable>{
    private int distanceToAddress;
    private T item;
    private boolean seal;

    Box(){
        T item=null;
    }
    Box(T item, int distanceToAddress){
        setDistanceToAddress(distanceToAddress);
        pack(item);
    }

    public void setDistanceToAddress(int distanceToAddress) {
        if(distanceToAddress>=0)
            this.distanceToAddress = distanceToAddress;
        else
            throw new RuntimeException();
    }

    public int getDistanceToAddress() {
        return distanceToAddress;
    }
    public T getItem() {
        return item;
    }
    public T extract(){
        if(this.item==null){
            return null;
        }
        else{
            T toReturn=this.item;
            this.item=null;
            seal=false;
            return toReturn;
        }
    }
    public double getPriority(){
        return item.getPrice() +(1.0/distanceToAddress);
    }
    public boolean isEmpty(){
        if(this.item==null)
            return true;
        else
            return false;
    }
    protected boolean isSealBroken(){
        if (this.seal)
            return false;
        else
            return true;
    }
    public boolean pack(T item){
        if(this.item!=null)
            return false;
        else{
            this.item=item;
            seal=true;
            return true;
        }
    }

    @Override
    public String toString() {
        return "Box, item inside "+item;
    }
}
abstract class Product implements Sellable{
    private String name;
    private double price;
    Product(String name,double price){
        this.name=name;
        setPrice(price);
    }

    public void setPrice(double price) {
        if(price>=0){
            this.price = price;
        }
        else
            throw new RuntimeException("ERROR: price cannot be negative.");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name +": "+ price +" $";
    }
}
class Paper extends Product implements Sellable, Wrappable{
    private String note;
    Paper(){
        super("Paper",0.5);
        this.note="";
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
class Mirror extends Product implements Sellable{
    private int height;
    private  int width;
    Mirror(int height,int width){
        super("Mirror",height*width);
        setHeight(height);
        setWidth(width);
    }

    public void setHeight(int height) {
        if(height>0){
            this.height = height;
        }
        else
            throw new RuntimeException("ERROR: invalid value ");
    }

    public void setWidth(int width) {
        if(width>0){
            this.width = width;
        }
        else
            throw new RuntimeException("ERROR: invalid value ");
    }
    public <T> T reflect(T item){
        System.out.println(item);
        return item;
    }

    @Override
    public double getPrice() {
        return height*width;
    }
}
class Matroschka<T> extends Product implements Wrappable, Package<T>{
    private T item;
    Matroschka(T item){
        super("Doll", 5.0+((Product)item).getPrice());
        pack(item);
    }
    public T extract(){
        if(item!=null) {
            T temp = item;
            this.item=null;
            return temp;
        }
        else
            return null;
    }
    public double getPriority(){
        throw new UnsupportedOperationException();
    }
    public boolean isEmpty(){
        if (this.item==null)
            return true;
        else
            return false;
    }
    public boolean pack(T item){
        if(this.item==null && item instanceof Product){
            this.item=item;
            return true;
        }
        else
            return false;
    }

    @Override
    public String toString() {
        return "Matroschka: "+getPrice()+"\nItem inside: "+
                ((Product)item).getName()+": "+((Product)item).getPrice();
    }
}
class Container implements Stack<Box>, Node<Container>, Comparable<Container>{
    private Box<?>[] boxes;
    private Container next;
    private double priority;
    private int top;
    Container(){
        boxes=new Box[DEFAULT_CAPACITY];
        top=-1;
    }

    @Override
    public int compareTo(Container o) {
        if(this.getPriority() == o.getPriority())
            return 0;
        else if(this.getPriority() > o.getPriority())
            return 1;
        else
            return -1;
    }
    public Container getNext(){
        return next;
    }
    public double getPriority(){
        double priority=0;
        for (int i = 0; i < boxes.length; i++) {
            if(boxes[i]!=null)
            priority+=(boxes[i].getItem()).getPrice();
        }
        return priority;
    }

    @Override
    public void setNext(Container item) {
        this.next=item;
    }
    @Override
    public boolean isEmpty() {
        if(top<0)
            return true;
        else
            return false;
    }
    public Box<?> peek(){
        if(top>=0)
            return boxes[top];
        else
            throw new RuntimeException("The Container is empty");
    }
    public Box<?> pop(){
        if(top>=0) {
            Box<?> temp = boxes[top];
            boxes[top]=null;
            top--;
            return temp;
        }
        else
            throw new RuntimeException("Container is empty.");
    }
    @Override
    public boolean push(Box item){
        if(top==boxes.length-1) {
            Box<?>[] temp = new Box[boxes.length + 1];
            for (int i = 0; i < boxes.length; i++) {
                temp[i] = boxes[i];
            }
            boxes = temp;
            top++;
            return true;
        }
        else{
            top++;
            boxes[top]=item;
            return true;
        }
    }
    public int size(){
        return boxes.length;
    }

    @Override
    public String toString() {
        String result="Container with: ";
        for (int i = 0; i < boxes.length; i++) {
            if(boxes[i]!=null)
                result+=boxes[i]+" ";
        }
        return result;
    }
}
class CargoCompany{
    private Container stack;
    private CargoFleet queue;
    CargoCompany(){
        this.stack=new Container();
        this.queue=new CargoFleet();
    }

    public <T extends Box<?>>void add(T box){
        stack.push(box);
    }
    private <T extends Box<?>> Sellable deliver(T box){
        return box.extract();
    }
    private void empty(Container container){
        if(stack.size()!=0){
            for (int i = 0; i < stack.size(); i++) {
                deliver(stack.pop());
            }
        }
    }
    private void ship(CargoFleet fleet){
        if(fleet.size()!=0){
            for (int i = 0; i < fleet.size(); i++) {
                empty(fleet.dequeue());
            }
        }

    }
}
class CargoFleet implements PriorityQueue<Container>{
    private Container head;
    private int size;
    private ArrayList<Container> que=new ArrayList<>(0);
    CargoFleet(){
        this.size=0;
    }
    public Container dequeue(){
        Container temp=que.get(0);
        que.remove(0);
        head=que.get(0);
        return temp;
    }

    @Override
    public boolean enqueue(Container item) {
        if(que.size()==0){
            que.add(item);
            return true;
        }
        else{
            for (int i = 0; i < que.size(); i++) {
                if(item.compareTo(que.get(i))>=0){
                    que.add(i,item);
                    head=que.get(0);
                    break;
                }
                else
                    continue;
            }
            return true;
        }
    }

    @Override
    public boolean isEmpty() {
        if(size==0)
            return true;
        else
            return false;
    }

    @Override
    public Container peek() {
        return que.get(0);
    }

    @Override
    public int size() {
        return 0;
    }
}