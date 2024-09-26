import java.util.ArrayList;
import java.util.Arrays;

public class HW04_20230808010 {
    public static void main(String[] args)throws ComputationException,InterruptedException {
        CPU cp=new CPU("abc",12);
        RAM ra=new RAM("zart",12);
        Computer asus=new Computer(cp,ra);
        Laptop benim=new Laptop(cp,ra,100);
        System.out.println(benim);
        System.out.println(ra.getValue(2,6));
        System.out.println(benim.batteryPercentage());
        System.out.println(cp.compute(-1,1));
    }    
}
@SuppressWarnings("ALL")
class Computer{
    protected CPU cpu;
    protected RAM ram;
    Computer(CPU cpu,RAM ram){
    this.cpu=cpu;
    this.ram=ram;
    }
    public void run() throws MemoryException, ComputationException, InterruptedException {
        try{
        int allValues=0;
            for (int i = 0; i < ram.getCapacity(); i++) {
                allValues+=cpu.compute(allValues, ram.getValue(i,i));
            }
            ram.setValue(0,0,allValues);
        }catch(MemoryException e){
            e.printStackTrace();
        }catch (ComputationException e){
            int allValues=0;
            for (int i = 0; i < ram.getCapacity(); i++) {
                allValues+=e.fixComputation(allValues,ram.getValue(i,i));
            }
            ram.setValue(0,0,allValues);
        }
    }

    @Override
    public String toString() {
        return "Computer: "+cpu+" "+ram;
    }
}

class Laptop extends Computer{
    private int milliAmp;
    private int battery;

    Laptop(CPU cpu, RAM ram,int milliAmp) {
        super(cpu, ram);
        this.milliAmp=milliAmp;
        battery=(milliAmp*30)/100;
    }
    public int batteryPercentage(){
        return battery;
    }
    public void charge(){
        while(battery<=(milliAmp*90)/100){
            battery+=(milliAmp*2)/100;
        }
    }

    @Override
    public void run() throws MemoryException, ComputationException, InterruptedException {
        if(battery>(milliAmp*5)/100){
            super.run();
            battery-=(milliAmp*3)/100;
        }
        else
            charge();
    }

    @Override
    public String toString() {
        return super.toString()+" "+ battery;
    }
}
class Desktop extends Computer{
    private ArrayList<String> peripherals=new ArrayList<>();
    
    Desktop(CPU cpu, RAM ram, String[] varargs) {
        super(cpu, ram);
        ArrayList<String> varargs1=new ArrayList<>(Arrays.asList(varargs));
        peripherals.addAll(varargs1);
    }
    public void plugIn(String peripheral){
        peripherals.add(peripheral);
    }
    public String plugOut(){
        String result=peripherals.getLast();
        peripherals.removeLast();
        return result;
    }
    public String plugOut(int index){
        String result=peripherals.get(index);
        peripherals.remove(index);
        return result;
    }

    @Override
    public void run() throws MemoryException, ComputationException, InterruptedException {
        super.run();
    }

    @Override
    public String toString(){
        StringBuilder result= new StringBuilder(" ");
        for (String peripheral : peripherals) {
            result.append(peripheral).append(" ");
        }
        return super.toString()+result;
    }
}
class CPU{
    private String name;
    private double clock;

    CPU(String name, double clock){
        this.clock=clock;
        this.name=name;
    }
    public int compute(int a,int b)throws ComputationException,InterruptedException{
        try {
            int sum=a+b;
            Thread.sleep((long)(5/clock* 1000));
            if(a+b<0){
                throw new ComputationException(this,a,b);
            }
            return sum;
        } catch (InterruptedException e) {
            throw new InterruptedException("Exception occurred due to internal clock speed: "+clock);
        }

    }

    @Override
    public String toString() {
        return String.format("CPU: %s %f Ghz", name,clock);
    }
}

class RAM{
    private String type;
    private int capacity;
    private int[][] memory;

    RAM(String type, int capacity){
        this.type=type;
        this.capacity=capacity;
        initMemory();
    }

    public int getCapacity() {
        return capacity;
    }
    public int[][] getMemory() {
        return memory;
    }

    public String getType() {
        return type;
    }
    private void initMemory(){
        memory=new int[capacity][capacity];
        for (int i = 0; i < capacity; i++) {
            for (int j = 0; j < capacity; j++) {
                memory[i][j]=(int)(Math.random()*10);
            }
        }
    }
    private boolean check(int i,int j)throws MemoryException{
        if(i<capacity && j<capacity)
            return true;
        else
            throw new MemoryException(this,i,j);
    }
    public int getValue(int i, int j)throws MemoryException{
        if(check(i, j))
            return memory[i][j];
        else
            throw new MemoryException(this,i,j);

    }
    public void setValue(int i,int j,int value)throws MemoryException{
        if(check(i, j))
            memory[i][j]=value;

        else
            throw new MemoryException(this,i,j);

    }


    @Override
    public String toString() {
        return String.format("RAM: %s %dGB", type,capacity);
    }
}

class MemoryException extends RuntimeException{
    private RAM ram;
    private int address1;
    private int address2;
    MemoryException(RAM ram,int address1,int address2){
        super("Memory out of range! With addresses #["+address1+","+address2+"]");
        this.address1=address1;
        this.address2=address2;
        this.ram=ram;
    }

    public int getAddress1() {
        return address1;
    }

    public int getAddress2() {
        return address2;
    }

    public RAM getRam() {
        return ram;
    }
}
class ComputationException extends Exception{
    private CPU cpu;
    private int value1;
    private int value2;

    ComputationException(CPU cpu,int value1,int value2){
        super("Computation exception occurred on "+ cpu + " with values: ("+value1+", "+value2+")");
        this.cpu=cpu;
        this.value1=value1;
        this.value2=value2;
    }
    ComputationException(ComputationException e){
        super("Unhandled exception occurred at "+e.cpu+" with values "+e.value1+" and "+e.value2+":\n\t"+e.getMessage());
    }

    public int fixComputation(int value1,int value2)throws ComputationException{
        value1=Math.abs(value1);
        value2=Math.abs(value2);
        try {
            return cpu.compute(value1, value2);
        } catch (InterruptedException e) {
            e.printStackTrace();
            
        } catch (ComputationException ee){
            throw ee;
        }
        return value1+value2;
    }
}