import java.util.ArrayList;
import java.util.regex.Pattern;

/**Defne Demir 
 * started on 25.03.2024
 * Assignment02 20230808010
 */
public class Assignment02_20230808010 {
    public static void main(String[] args) {
        Department cse=new Department("CSE","compsci");
        Department ziraat=new Department("ZRT", "ziraatmuh");
        Teacher memet=new Teacher("memed", "asfa@domain.com", 12345L, ziraat, 3);
        Student mustafa=new Student("must", "dasd@domain.com", 6425342, ziraat);
        Course istatistik=new Course(ziraat, 100, "bogazicili", "ozel ders", 4, memet);
        mustafa.addCourse(istatistik, 56);
        System.out.println(mustafa);
        System.out.println(memet);
        System.out.println(mustafa.courseResult(istatistik));
        System.out.println();
        Teacher jos=new Teacher("joseph", "j@gm.com", 34265, cse,1);
        jos.promote();
        System.out.println(jos.getTitle());
        jos.demote();
        System.out.println(jos.getTitle());
        Student defne=new Student("defne", "abc@gm.com", 324, cse);
        GradStudent sd=new GradStudent("fasd", "dasd@domain.com", 123, ziraat, 1, "fasf");
        Course programming=new Course(cse, 101, "abc", "intro", 4,jos);
        System.out.println(programming);
        defne.addCourse(programming, 100);
        defne.addCourse(istatistik, 0);
        System.out.println(defne.getGPA());
       
    }
}
//classes
class Department{
    private Teacher chair;
    private String code;
    private String name;
    
    Department(String code,String name){
        setCode(code);
        setName(name);
    }
    public void setChair(Teacher chair) {
        if(chair==null){
            this.chair=chair;
        }
        else{
            if(this.equals(chair.getDepartment())){
                this.chair=chair;
            }
            else{
                throw new DepartmentMismatchException(this, chair);
            }
        }
    }
    public void setCode(String code) {
        
        if(code.length()==3 || code.length()==4)
            this.code = code;
        else
            throw new InvalidValueException("Department","code",code,"Code must be 3 or 4 characters long");
    }

    public void setName(String name) {
        this.name = name;
    }
    public Teacher getChair() {
        return chair;
    }
    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
}

class Course{
    private Teacher teacher;
    private Department department;
    private int courseNumber;
    private String title;
    private String description;
    private int akts;

    Course(Department department,int courseNumber,String title, String description,int akts,Teacher teacher){
        setDepartment(department);
        setCourseNumber(courseNumber);
        setTitle(title);
        setDescription(description);
        setAkts(akts);
        setTeacher(teacher);
    }

    public void setAkts(int akts) {
        if(akts<=0){
            throw new InvalidValueException("Course", "akts", akts, "Value must be bigger than 0");
        }
        else{
            this.akts=akts;
        }
    }

    public void setCourseNumber(int courseNumber) {
        if((courseNumber>99 && courseNumber<1000) || (courseNumber>4999 && courseNumber<6000)
        ||(courseNumber>6999 && courseNumber<8000)){
            this.courseNumber = courseNumber;
        }
        else 
            throw new InvalidValueException("Course", "courseNumber", courseNumber,
             "Course number must be between 100 - 1000 , 5000 - 6000 or 7000 - 8000");
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setTeacher(Teacher teacher) {
        if(teacher.getDepartment()==this.getDepartment()){
            this.teacher = teacher;
        }
        else   
            throw new DepartmentMismatchException(this, teacher);
        
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getAkts() {
        return akts;
    }
    public int getCourseNumber() {
        return courseNumber;
    }
    public Department getDepartment() {
        return department;
    }
    public String getDescription() {
        return description;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public String getTitle() {
        return title;
    }
    public String courseCode(){
        return department.getCode()+ Integer.toString(courseNumber);
    }
    @Override
    public String toString() {
        return courseCode()+" - "+ title + "("+ akts+")";
    }
}

abstract class Person{
    private Department department;
    private String name;
    private String email;
    private long ID;
    private String departmentCode;
    

    Person(String name, String email, long ID, Department department){
        this.name=name;
        this.email=email;
        if(!patternMatches(email)){
            throw new IllegalArgumentException("Error: invalid email adress");
        }
        this.ID=ID;
        this.department=department;

    }

    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public long getId() {
        return ID;
    }
    public void setId(long id) {
        this.ID = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s (%d) - %s", name,ID,email);
    }
    public static boolean patternMatches(String emailAddress) {
        return Pattern.compile("^(.+)@(\\S+)$")
          .matcher(emailAddress)
          .matches();
    }
}

class Teacher extends Person{
    private int rank;
 
    Teacher(String name, String email, long id, Department department,int rank) {
        super(name, email, id, department);
        this.rank=rank;
    }
    @Override
    public void setDepartment(Department department) {
        if(this==this.getDepartment().getChair()){
            this.getDepartment().setChair(null);
        }
        super.setDepartment(department);
    }
    public void promote(){
        if(rank==5){
            throw new InvalidRankException(6);
        }
        else{
            rank++;
        }
    }
    public void demote(){
        if(rank==1){
            throw new InvalidRankException(0);

        }
        else {
            rank--;
        }
    }
    public String getTitle(){
        switch(rank){
            case 1:
                return "Teaching Assistant";
            case 2:
                return  "Lecturer";
            case 3:
                return "Assistant Professor";
            case 4:
                return "Associate Professor";
            case 5:
                return "Professor";
            default:
                return "";
        }
    }
}

class Student extends Person{
    protected ArrayList<Course> courses;
    protected ArrayList<Double> grades;

    Student(String name, String email, long ID, Department department) {
        super(name, email, ID, department);
        courses = new ArrayList<>();
        grades = new ArrayList<>();
    }
    public int getAKTS() {
       int result=0;
       for (int i = 0; i < courses.size(); i++) {
            if(grades.get(i)>59.4)
            result+=courses.get(i).getAkts();    
       }
        return result;
    }   
    
    public int getAttemptedAKTS(){
        int result=0;
       for (int i = 0; i < courses.size(); i++) {
        result+=courses.get(i).getAkts();    
       }
        return result;
    }

    public void addCourse(Course course,double grade){
        if(grade<0 || grade>100){
            throw new InvalidGradeException(grade);
        }
        else{
            if(courses.contains(course)){
                int index=courses.indexOf(course);
                grades.set(index,grade);
            }
            else{
                courses.add(course);
                grades.add(grade);
            }
        }
    }
    public double courseGPAPoints(Course course){
        if(courses.contains(course)){
            int index=courses.indexOf(course);
            double grade=grades.get(index);
            if(grade>87.4){
                return 4.0;
            }
            else if(grade>80.4){
                return 3.5;
            }
            else if(grade>73.4){
                return 3.0;
            }
            else if(grade>66.4){
                return 2.5;
            }
            else if(grade>59.4){
                return 2.0;
            }
            else if(grade>52.4){
                return 1.5;
            }
            else if(grade>45.4){
                return 1.0;
            }
            else if(grade>34.4){
                return 0.5;
            }
            else{
                return 0.0;
            }
        }
        else{
            throw new CourseNotFoundException(this, course);
        }
    }
    public String courseGradeLetter(Course course){
        if(courses.contains(course)){
            int index=courses.indexOf(course);
            double grade=grades.get(index);
            if(grade>87.4){
                return "AA";
            }
            else if(grade>80.4){
                return "BA";
            }
            else if(grade>73.4){
                return "BB";
            }
            else if(grade>66.4){
                return "CB";
            }
            else if(grade>59.4){
                return "CC";
            }
            else if(grade>52.4){
                return "DC";
            }
            else if(grade>45.4){
                return "DD";
            }
            else if(grade>34.4){
                return "FD";
            }
            else{
                return "FF";
            }
        }
        else{
            throw new CourseNotFoundException(this, course);
        }
    }
    public String courseResult(Course course){
        if(courses.contains(course)){
            int index=courses.indexOf(course);
            double grade=grades.get(index);
            if(grade>59.4){
                return "passed";
            }
            else if(grade>45.4){
                return "conditionally passed";
            }
            else{
                return "failed";
            }
        }
        else{
            throw new CourseNotFoundException(this, course);
        }
    }
    public double getGPA(){
        double result=0;
        for (int i = 0; i < courses.size(); i++) {
            if(grades.get(i)>59.4)
                result+=courseGPAPoints(courses.get(i));
            else
                continue;
        }
        int passedCourseSize=0;
        for (int i = 0; i < courses.size(); i++) {
            if (grades.get(i)>59.4)
                passedCourseSize++;
        }
        return (result/passedCourseSize);
    }
    @Override
    public String toString() {
        
        return super.toString()+ " -GPA: "+getGPA();
    } 

}
class GradStudent extends Student{
    private int rank;
    private String thesisTopic;

    GradStudent(String name, String email, long id, Department department, int rank, String thesis) {
        super(name, email, id, department);
        setRank(rank);
        this.thesisTopic=thesis;
    }
    public void setRank(int rank) {
        if(rank>0 && rank<4)
            this.rank = rank;
        else
            throw new InvalidRankException(rank);
    }
    public String getLevel(){
        if(rank==1)
            return "Master's Student";
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
    @Override
    public String courseGradeLetter(Course course) {
        if(courses.contains(course)){
            int index=courses.indexOf(course);
            double grade=grades.get(index);
            if(grade>89.4){
                return "AA";
            }
            else if(grade>84.4){
                return "BA";
            }
            else if(grade>79.4){
                return "BB";
            }
            else if(grade>74.4){
                return "CB";
            }
            else if(grade>69.4){
                return "CC";
            }
            else{
                return "FF";
            }
        }
        else{
            throw new CourseNotFoundException(this, course);
        }
    }
    @Override
    public double courseGPAPoints(Course course) {
        if(courses.contains(course)){
            int index=courses.indexOf(course);
            double grade=grades.get(index);
            if(grade>89.4){
                return 4.0;
            }
            else if(grade>84.4){
                return 3.5;
            }
            else if(grade>79.4){
                return 3.0;
            }
            else if(grade>74.4){
                return 2.5;
            }
            else if(grade>69.4){
                return 2.0;
            }
            else{
                return 0.0;
            }
        }
        else{
            throw new CourseNotFoundException(this, course);
        }

    }
    @Override
    public String courseResult(Course course) {
        if(courses.contains(course)){
            int index=courses.indexOf(course);
            double grade=grades.get(index);
            if(grade>69.4){
                return "Passed";
            }
            else{
                return "Failed";
            }
        }
        else{
            throw new CourseNotFoundException(this, course);
        }
    }
}
//exceptions
class CourseNotFoundException extends RuntimeException{
    private Student student;
    private Course course;

    CourseNotFoundException(Student student,Course course){
        this.course=course;
        this.student=student;
    }

    @Override
    public String toString() {
        return "CourseNotFoundException: " + student.getId() + " has not yet taken " + course.courseCode();
    }
}
class DepartmentMismatchException extends RuntimeException{
    private Department department;
    private Teacher person;
    private Course course;

    DepartmentMismatchException(Course course,Teacher person){
        department=null;
        this.course=course;
        this.person=person;
    }
    DepartmentMismatchException(Department department,Teacher person){
        course=null;
        this.person=person;
        this.department=department;
    }
    @Override
    public String toString() {
        if(course==null){
            return "DepartmentMismatchException: "+person.getName()+ "("+person.getId()+") cannot be chair of "+
            department.getCode()+" because he/she is currently assigned to "+person.getDepartment().getCode();
        }
        else{
            return "DepartmentMismatchException: "+person.getName()+ "("+person.getId()+") cannot teach "+
            course.courseCode()+" because he/she is currently assigned to "+ person.getDepartment().getCode();
        }
    }
}
class InvalidGradeException extends RuntimeException{
    private double grade;
    InvalidGradeException(double grade){
        this.grade=grade;
    }
    @Override
    public String toString() {
        return "InvalidGradeException: "+ grade;
    }

}
class InvalidRankException extends RuntimeException{
    private int rank;
    InvalidRankException(int rank){
        this.rank=rank;
    }
    @Override
    public String toString() {
        return "InvalidRankException: "+ rank;
    }
}
class InvalidValueException extends RuntimeException{
    private String className;
    private String varName;
    private int wrongVal;
    private String wrongString;
    private int caseNo;
    private String validNos;

    InvalidValueException(String className,String varName, int wrongVal,String validNos){
        this.varName=varName;
        this.className=className;
        this.wrongVal=wrongVal;
        this.validNos=validNos;
        caseNo=1;
    }
    InvalidValueException(String className,String varName, String wrongString,String validNos){
        this.varName=varName;
        this.className=className;
        this.wrongString=wrongString;
        this.validNos=validNos;
        caseNo=2;
    }
    //////////////////////REVISE VALIDNO STRINGGGGGGGGGGGGGGGGGGGG
   @Override
   public String toString() {
    switch(caseNo){
        case 1:
        return "InvalidValueException: "+className+" "+varName+" "
        +wrongVal+" "+validNos;
        case 2:
        return "InvalidValueException: "+className+" "+varName+" "
        +wrongString+" "+validNos;
        default:
        return "InvalidValueException";
    }
   }
}