import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindGuitarTester{
    public static void main(String[] args) {
        Inventory inventory=new Inventory();

        GuitarSpec whatErinLikes=new GuitarSpec(Builder.FENDER,
                 Type.ELECTRIC,"Stratocastor", Wood.ALDER, Wood.ALDER);

        inventory.addGuitar("V12345",1549.99,whatErinLikes);
        List matchingGuitars=inventory.search(whatErinLikes);
        if(!matchingGuitars.isEmpty()){
            System.out.println("Erin, you might like these guitars:");
            for (Iterator i = matchingGuitars.iterator(); i.hasNext();){
                Guitar guitar=(Guitar)i.next();
                GuitarSpec guitarSpec=guitar.getSpec();
                System.out.println("We have "+ guitarSpec.getBuilder()
                +" "+guitarSpec.getModel()+" "+ guitarSpec.getType()+" guitar:\n"+
                guitarSpec.getBackWood()+" back and sides,\n"+guitarSpec.getTopWood()+" top.\n"+
                "You can have it for only $"+ guitar.getPrice());
            }
        }
        else
            System.out.println("Sorry Erin, we have nothing for you.");
    }
}

class GuitarSpec{
    private Builder builder;
    private Type type;
    private Wood topWood;
    private Wood backWood;
    private String model;
    GuitarSpec(Builder builder, Type type, String model, Wood top, Wood back){
    this.builder=builder;
    this.type=type;
    this.topWood=top;
    this.backWood=back;
    this.model=model;
    }
    public Wood getBackWood() {
        return backWood;
    }

    public Builder getBuilder() {
        return builder;
    }

    public Type getType() {
        return type;
    }

    public Wood getTopWood() {
        return topWood;
    }

    public String getModel() {
        return model;
    }
}

class Guitar {
    private String serialNumber;
    private double price;

    private GuitarSpec spec;

    Guitar(String serialNo, GuitarSpec spec, double price){
        this.price=price;
        this.serialNumber=serialNo;
        this.spec=spec;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public GuitarSpec getSpec() {
        return spec;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

}
class Inventory{
    List<Guitar> guitars=new LinkedList<>();
    public void addGuitar(String no, double price, GuitarSpec spec){
        guitars.add(new Guitar(no,spec,price));
    }

    public List search(GuitarSpec searchSpec){
        List matchingGuitars=new LinkedList();
        for (Iterator i = guitars.iterator(); i.hasNext();){
            Guitar guitar=(Guitar) i.next();
            GuitarSpec guitarSpec=guitar.getSpec();
            if(searchSpec.getBuilder() != guitarSpec.getBuilder())
                continue;
            String model=searchSpec.getModel();
            if((model!=null) && (!model.equals("") && (!model.equals(guitarSpec.getModel()))))
                continue;
            if(searchSpec.getType() != guitarSpec.getType())
                continue;
            if(searchSpec.getBackWood() !=guitarSpec.getBackWood())
                continue;
            if (searchSpec.getTopWood() != guitarSpec.getTopWood())
                continue;
            matchingGuitars.add(guitar);
        }
            return matchingGuitars;
    }
    public Guitar getGuitar(String serialNo){
        for(Iterator i= guitars.iterator(); i.hasNext();){
            Guitar guitar=(Guitar) i.next();
            if (guitar.getSerialNumber().equals(serialNo))
                return guitar;
        }
        return null;
    }
}
enum Type{
    ACOUSTIC, ELECTRIC;

    @Override
    public String toString() {
        switch (this) {
            case ACOUSTIC:
                return "acoustic";
            case ELECTRIC:
                return "electric";
            default: return "unspecified";
        }
    }
}
enum Builder{
    FENDER, MARTIN, GIBSON, COLLINGS, OLSON, RYAN, PRS, ANY;

    @Override
    public String toString() {
        switch (this){
            case FENDER: return "Fender";
            case MARTIN: return "Martin";
            case GIBSON: return "Gibson";
            case COLLINGS: return "Collings";
            case OLSON: return "Olson";
            case RYAN: return "Ryan";
            case PRS: return "Prs";
            case ANY:return "Any";
            default: return "unspecified";
        }
        }
    }
enum Wood{
    INDIAN_ROSEWOOD, BRAZILIAN_ROSEWOOD, MAHOGANY, MAPLE, COCOBOLLO
    , CEDAR, ADIRONDACK, ALDER, SITKA;

    @Override
    public String toString() {
        switch (this){
            case INDIAN_ROSEWOOD: return "Indian Rosewood";
            case BRAZILIAN_ROSEWOOD: return "Brazilian Rosewood";
            case MAHOGANY: return "Mahogany";
            case MAPLE: return "Maple";
            case CEDAR: return "Cedar";
            case COCOBOLLO: return "Cocobollo";
            case ADIRONDACK: return "Adirondack";
            case ALDER: return "Alder";
            case SITKA: return "Sitka";
            default: return "unspecified";
        }
    }
}
