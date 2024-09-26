/**
 * HW06_20230808010
 */
public class HW06_20230808010 {
    public static void main(String[] args) {
        Paper not=new Paper();
        not.setNote("yazi yazalim");
        Box me=new Box();
        Mirror mm=new Mirror(10, 20);
        mm.reflect(me);
    }
    
}

interface Sellable{
    public String getName();
    public double getPrice();
}
interface Package<T>{
    public T extact();
    public boolean pack(T item);
    public boolean isEmpty();
}
interface Wrappable extends Sellable{

}
 
abstract class Product implements Sellable{
    private String name;
    private double price;

    Product(String name, double price){
        setName(name);
        setPrice(price);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        if(price>=0)
            this.price = price;
    }
    @Override
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName()+" ("+name+" "+ price+") ";
    }
}

class Mirror extends Product{
    private int width;
    private int height;
    
    Mirror(int width,int height) {
        super("mirror", 2);
        setHeight(height);
        setWidth(width);
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getArea(){
        return height*width;
    }
    @Override
    public double getPrice() {
        return 2*getArea();
    }
    public <T> T reflect(T item){
        System.out.println(item);
        return item;
    }
}

class Paper extends Product implements Wrappable{

    
    private String note;
    
    Paper(){
        super("Paper", 0.5);
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
}

class Matroschka<T extends Wrappable> extends Product implements Wrappable, Package<T> {
    private T item;

    Matroschka(T item) {
        super("Doll", 5.0+((Product)item).getPrice());
        pack(item);
    }

    @Override
    public T extact() {
        T insideItem=item;
        item=null;
        if(insideItem==null)
            return null;
        else 
            return insideItem;
    }

    @Override
    public boolean pack(T item) {
        if(item==null){
            this.item=item;
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean isEmpty() {
        if(item==null)
            return true;
        else
            return false;    
    }
    @Override
    public String toString() {
        return super.toString()+ "{"+item+"}";
    }
}

class Box <T extends Sellable> implements Package<T>{
    private T item;
    private boolean seal;

    Box(){
        this.item=null;
    }
    Box(T item){
        pack(item);
        this.seal=true;
    }
    @Override
    public T extact() {
        T insideItem=item;
        item=null;
        seal=false;
        if(insideItem==null)
            return null;
        else 
            return insideItem;
    }

    @Override
    public boolean pack(T item) {
        if(this.item==null){
            this.item=item;
            seal=true;
            return true;
        }
        else
            return false;
    }
    public boolean isSealBroken() {
        return seal;
    }

    @Override
    public boolean isEmpty() {
        if(item == null)
            return true;
        else
            return false;
    
        }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+" {"+item+"} Seal: "+seal;
    }
}