import java.util.regex.Pattern;

/**Defne Demir
 * Assignment01 20230808010
 */

public class Assignment01_20230808010 {
    public static void main(String[] args) {
        Course cse101=new Course("CSE", 101, "Computer prog", "introduction to oop ",8);
        System.out.println(cse101);
        System.out.println(cse101.courseCode()+" "+ cse101.getTitle());

        System.out.println("----------");

        Teacher josephhoca=new Teacher("joseph", "jj@domain.com", 143, "CSE", -1);
        System.out.println(josephhoca.getId());
        System.out.println(josephhoca.getRank());
        System.out.println(josephhoca);

        Student defne=new Student("defne demir", "dfndmr@domain.com", 2020133208, "CSE");
        System.out.println(defne);
        System.out.println("defne akts: "+defne.getAkts());
        System.out.println("---Defne passes CSE course ---");
       
        defne.passCourse(cse101);
        System.out.println("Defne akts: "+ defne.getAkts());
        
        GradStudent baskaBiri=new GradStudent("ogrenci soyisim", "ogrenci@domain.com", 2020839402, "HIST", 2, "abcs");
        System.out.println(baskaBiri +" "+ baskaBiri.getThesisTopic());

    }

    
}

class Course{
    private String departmentCode;
    private int courseNumber;
    private String title;
    private String description;
    private int akts;

    Course(String departmentCode, int courseNumber, String title, String description, int akts){
        this.akts=akts;
        if(akts<=0){
            throw new IllegalArgumentException("ERROR: akts must be positive.");
        }
       

        this.courseNumber=courseNumber;
        if((courseNumber>99 && courseNumber<1000) || (courseNumber>4999 && courseNumber<6000)
        ||(courseNumber>6999 && courseNumber<8000)){}

        else{
            throw new IllegalArgumentException("ERROR: invalid course number");
        }

        this.departmentCode=departmentCode;
        if(this.departmentCode.length()>4 || this.departmentCode.length()<3){
         throw new IllegalArgumentException("ERROR: invalid department code.");
        }
        
        this.title=title;
        this.description=description;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }
    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
    public int getAkts() {
        return akts;
    }
    public void setAkts(int akts) {
        this.akts = akts;
    }
    public int getCourseNumber() {
        return courseNumber;
    }
    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String courseCode(){
        return departmentCode+ Integer.toString(courseNumber);
    }

    @Override
    public String toString() {
        return String.format("%s%d - %s (%d)", departmentCode,courseNumber,title,akts);
    }
}

class Person{ 
    private String name;
    private String email;
    private long id;
    private String departmentCode;
    

    Person(String name, String email, long id, String departmentCode){
        this.name=name;
        this.email=email;
        if(!patternMatches(email)){
            throw new IllegalArgumentException("Error: invalid email adress");
        }
        this.id=id;
        this.departmentCode=departmentCode;
        if(departmentCode.length()>4 || departmentCode.length()<3){
            throw new IllegalArgumentException("ERROR: invalid department code.");
        }
    }

    public String getDepartmentCode() {
        return departmentCode;
    }
    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s (%d) - %s", name,id,email);
    }

    
    public static boolean patternMatches(String emailAddress) {
        return Pattern.compile("^(.+)@(\\S+)$")
          .matcher(emailAddress)
          .matches();
    }
}

class Student extends Person{
    private int akts;

    Student(String name, String email, long id, String departmentCode) {
        super(name, email, id, departmentCode);
        this.akts=0;
    }

    public int getAkts() {
        return akts;
    }
    public void passCourse(Course course){
        akts+=course.getAkts();
    }
    
}

class Teacher extends Person{
    private int rank;

    Teacher(String name, String email, long id, String departmentCode, int rank) {
        super(name, email, id, departmentCode);
        this.rank=rank;
    }
    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    public String toString() {
        return String.format("%s(%d) - %s", getName(),getId(),getEmail());
    }

    
}

class GradStudent extends Student{
    private int rank;
    private String thesisTopic;

    GradStudent(String name, String email, long id, String departmentCode,int rank,String thesisTopic) {
        super(name, email, id, departmentCode);
        this.rank=rank;
        this.thesisTopic=thesisTopic;
    }
    public void setRank(int rank) {
        if(rank>0 && rank<4)
            this.rank = rank;
        else
            throw new IllegalArgumentException("ERROR: invalid rank number.");
    }

    public String getLevel(){
        if(rank==1)
            return "Master’s Student";
        else if(rank==2)
            return "Doctoral Student";
        else
            return "Doctoral Candidate"; 
    }
    public String getThesisTopic() {
        return thesisTopic;
    }
    public void setThesisTopic(String thesisTopic) {
        this.thesisTopic = thesisTopic;
    }

}