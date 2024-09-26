import java.util.ArrayList;
import java.util.Collections;

public class HW05_20230808010 {
    public static void main(String[] args) {
       
    }
}
interface Damageable{
    void takeDamage(int damage);
    void takeHealing(int healing);
    boolean isAlive();

    int compareTo(Character o);
}
interface Caster{
    void castSpell(Damageable target);
    void learnSpell(Spell spell);
}
interface Combat extends Damageable{
    void attack(Damageable target);
    void lootWeapon(Weapon weapon);
}
interface Useable{
    int use();
}
class Spell implements Useable{
    private int minHeal;
    private int maxHeal;
    private String name;
    Spell(String name,int minHeal,int maxHeal){
        setName(name);
        this.maxHeal=maxHeal;
        this.minHeal=minHeal;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int heal(){
    return (int)(Math.random()*(maxHeal-minHeal))+(minHeal);
    }
    @Override
    public int use() {
        return heal();
    }
}
class Weapon implements Useable{
    private String name;
    private int minDamage;
    private int maxDamage;

    Weapon(String name,int minDamage,int maxDamage){
    setName(name);
    this.maxDamage=maxDamage;
    this.minDamage=minDamage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    private int attack(){
        return (int)(Math.random()*(maxDamage-minDamage))+(minDamage);
    }
    @Override
    public int use() {
        return attack();
    }
}

class Attributes{
    private int strength;
    private int intelligence;

    Attributes(){
    strength=3;
    intelligence=3;
    }
    Attributes(int strength,int intelligence) {
        this.strength = strength;
        this.intelligence = intelligence;
    }
    public int getIntelligence() {
        return intelligence;
    }
    public int getStrength() {
        return strength;
    }
    public void increaseStrength(int amount){
        if (amount>=0)
            strength+=amount;
        else
            System.out.println("Error: invalid amount entered.");
    }
    public void increaseIntelligence(int amount){
        if (amount>=0)
            intelligence+=amount;
        else
            System.out.println("Error: invalid amount entered.");
    }

    @Override
    public String toString() {
        return "Attributes [Strength= " + strength+ ", intelligence= "+ intelligence+"]";
    }
}
abstract class Character implements Damageable, Comparable<Character>{
    private String name;
    protected int level;
    protected Attributes attributes;
    protected int health;

    Character(String name,Attributes attributes){
        this.name=name;
        this.attributes=attributes;
    }
    abstract public void levelUp();
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public boolean isAlive() {
        if (health>0)
            return true;
        else
            return false;
    }

    @Override
    public void takeDamage(int damage) {
        health-=damage;
    }
    @Override
    public void takeHealing(int healing) {
        health+=healing;
    }

    @Override
    public int compareTo(Character o) {
        if(this.getLevel()>o.getLevel())
            return 1;
        else if (this.getLevel()==o.getLevel())
            return 0;

        else
            return -1;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+" LvL: "+level+" - "+attributes ;
    }
}
abstract class PlayableCharacter extends Character{
    private boolean inParty;
    private Party party;

    PlayableCharacter(String name, Attributes attributes) {
        super(name, attributes);
    }

    public boolean isInParty() {
        if(inParty==true)
            return true;
        else
            return false;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    @Override
    public void levelUp() {
        level+=1;
    }
    public void joinParty(Party party)throws AlreadyInPartyException,PartyLimitReachedException{
    if(this.party==party)
        throw new AlreadyInPartyException("Error: This character is already in party.");
    else{
        party.addCharacter(this);
        inParty=true;
        this.party=party;
    }
    }
    public void quitParty(Party party)throws CharacterIsNotInPartyException{
        if(inParty==true) {
            party.removeCharacter(this);
            this.party = null;
            inParty = false;
        }
        else
            throw new CharacterIsNotInPartyException("Error: This character is not in a party.");
    }
}
abstract class NonPlayableCharacter extends Character{

    NonPlayableCharacter(String name,Attributes attributes){
        super(name, attributes);
    }
}
class Merchant extends NonPlayableCharacter{
    private ArrayList<Useable> items;
    Merchant(String name) {
        super(name,new Attributes(0,0));
        items=new ArrayList<>();
    }

    @Override
    public void takeDamage(int damage) {
        health-=damage;
    }
    @Override
    public void takeHealing(int healing) {
        health+=healing;
    }
    @Override
    public boolean isAlive() {
        if (health>0)
            return true;
        else
            return false;
    }
    @Override
    public void levelUp() {

    }
    public void display(){
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
        }
    }
    //interesting
    public Useable buy(int itemNumber)throws ItemNotFoundException{
        try {
            return items.get(itemNumber);
        }catch (IndexOutOfBoundsException e){
            throw new ItemNotFoundException("Error: Item not found at given index.");
        }
    }
    public void sell(Useable item){
        items.add(item);
    }
}
class Skeleton extends NonPlayableCharacter implements Combat{

    Skeleton(String name, Attributes attributes) {
        super(name, attributes);
    }
    @Override
    public void takeDamage(int damage) {
        health-=damage;
    }
    @Override
    public void takeHealing(int healing) {
        takeDamage(healing);
    }
    @Override
    public boolean isAlive() {
        if (health>0)
            return true;
        else
            return false;
    }

    @Override
    public void attack(Damageable target) {
        target.takeDamage(attributes.getStrength()+attributes.getIntelligence());
    }
    @Override
    public void lootWeapon(Weapon weapon) {

    }

    @Override
    public void levelUp() {

    }
}
class Warrior extends PlayableCharacter implements Combat{
    private Useable weapon;
    Warrior(String name){
        super(name,new Attributes(4,2));
        health=35;
    }

    @Override
    public void levelUp() {
        level+=1;
        this.attributes.increaseStrength(2);
        this.attributes.increaseIntelligence(1);
    }

    @Override
    public void attack(Damageable target) {
        target.takeDamage(this.attributes.getStrength()+weapon.use());
    }

    @Override
    public void lootWeapon(Weapon weapon) {
        this.weapon=weapon;
    }
}
class Cleric extends PlayableCharacter implements Caster{
    private Useable spell;
    Cleric(String name){
        super(name,new Attributes(2,4));
        health=25;
    }

    @Override
    public void levelUp() {
        level+=1;
        this.attributes.increaseStrength(1);
        this.attributes.increaseIntelligence(2);
    }

    @Override
    public void castSpell(Damageable target) {
        target.takeHealing(this.attributes.getIntelligence()+((Useable)spell).use());
    }

    @Override
    public void learnSpell(Spell spell) {
        this.spell=spell;
    }
}

class Paladin extends PlayableCharacter implements Caster,Combat{
    private Useable weapon;
    private Useable spell;

    Paladin(String name) {
        super(name, new Attributes());
        health=30;
    }
    @Override
    public void castSpell(Damageable target) {
        target.takeHealing(this.attributes.getIntelligence()+((Useable)spell).use());
    }
    @Override
    public void learnSpell(Spell spell) {
        this.spell=spell;
    }
    @Override
    public void attack(Damageable target) {
        target.takeDamage(this.attributes.getStrength()+weapon.use());
    }
    @Override
    public void lootWeapon(Weapon weapon) {
        this.weapon=weapon;
    }

    @Override
    public void levelUp() {
        level+=1;
        if(level%2==0){
            this.attributes.increaseStrength(2);
            this.attributes.increaseIntelligence(1);
        }
        else{
            this.attributes.increaseStrength(1);
            this.attributes.increaseIntelligence(2);
        }
    }
}


class Party{
    private final int partyLimit=8;
    private ArrayList<Combat> fighters= new ArrayList<Combat>();
    private ArrayList<Caster> healers= new ArrayList<Caster>();
    private int mixedCount;

    Party(){}
    public void addCharacter(PlayableCharacter character)throws PartyLimitReachedException {
        if (character.getParty() == this)
            System.out.println("character is already in the party");
        else {
            if (fighters.size() + healers.size() - mixedCount == 8)
                throw new PartyLimitReachedException("Error: Party is already full.");
            else {
                character.setParty(this);
                if (character instanceof Combat && character instanceof Caster) {
                    mixedCount++;
                    healers.add((Caster) character);
                    fighters.add((Combat) character);
                } else if (character instanceof Caster)
                    healers.add((Caster) character);
                else
                    fighters.add((Combat) character);
            }
        }
    }
    public void removeCharacter(PlayableCharacter character)throws CharacterIsNotInPartyException{
        if(fighters.contains(character) || healers.contains(character)){
            if(character instanceof Caster && character instanceof Combat)
                mixedCount--;
            if(character instanceof Caster)
                healers.remove(character);
            if(character instanceof Combat)
                fighters.remove(character);
        }
        else
            throw new CharacterIsNotInPartyException("Error: This character is not in this party.");
    }
    public void partyLevelUp(){
        for (int i = 0; i < fighters.size(); i++) {
            ((PlayableCharacter)fighters.get(i)).levelUp();
        }
        for (int i = 0; i < healers.size(); i++) {
            if(healers.get(i) instanceof Combat){
                continue;
            }
            ((PlayableCharacter)healers.get(i)).levelUp();
        }
    }
}


//EXCEPTIONS
class PartyLimitReachedException extends Exception{
    PartyLimitReachedException(String wrongVal){
        super(wrongVal);
    }
}
class AlreadyInPartyException extends Exception{
    AlreadyInPartyException(String wrongVal){
        super(wrongVal);
    }
}
class CharacterIsNotInPartyException extends Exception{
    CharacterIsNotInPartyException(String wrongVal){
        super(wrongVal);
    }
}
class ItemNotFoundException extends Exception{
    ItemNotFoundException(String wrongVal){
        super(wrongVal);
    }
}