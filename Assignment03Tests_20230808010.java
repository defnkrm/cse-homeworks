/**
 * src.Assignment03Tests_20230808010
 * Defne Demir 20230808010
 * started @ 03.05.2024
 */
import org.junit.*;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
public class Assignment03Tests_20230808010 {

    @Before
    public void setUp()throws Exception{}
    @Test
    public void departmentThrowsDepartmentMismatchException(){
        try{
            Department ziraat=new Department("ZRT", "ziraat");
            Department cse=new Department("CSE","compsci");
            Teacher jos=new Teacher("joseph", "j@gm.com", 34265, cse,1);
            ziraat.setChair(jos);
            Assert.assertEquals(false,true );
        }catch (DepartmentMismatchException e){
            Assert.assertTrue(true);
        }
    }
    @Test
    public void departmentShouldSetChair(){
        Department cse=new Department("CSE","compsci");
        Teacher jos=new Teacher("joseph", "j@gm.com", 34265, cse,1);
        cse.setChair(jos);
        Assert.assertEquals(jos, cse.getChair());
    }
    @Test
    public void departmentThrowsInvalidValueException(){
        try {
            Department cse=new Department("CSE","compsci");
            cse.setCode("ABCDE");
            Assert.assertTrue("Code must be 3 or 4 characters",false);
        }catch (Exception e){
            Assert.assertTrue(true);
        }
    }
    @Test
    public void departmentShouldGetChair(){
        Department cse=new Department("CSE","compsci");
        Teacher jos=new Teacher("joseph", "jdf@gailm.com", 34265, cse,1);
        cse.setChair(jos);
        Assert.assertEquals(jos, cse.getChair());
    }
    @Test
    public void departmentShouldGetName(){
        Department cse=new Department("CSE","ceng");
        Assert.assertEquals("ceng", cse.getName());
    }
    @Test
    public void departmentShouldGetCode(){
        Department cse=new Department("CSE","ceng");
        Assert.assertEquals("CSE", cse.getCode());
    }
    @Test
    public void departmentShouldSetCode(){
        Department cse=new Department("CSE","ceng");
        cse.setCode("ABC");
        Assert.assertEquals("ABC", cse.getCode());
    }
    @Test
    public void courseThrowsInvalidValueException(){
        try {
            Department cse = new Department("CSE", "compsci");
            Teacher jos = new Teacher("joseph", "j@gm.com", 34265, cse, 1);
            Course programming = new Course(cse, 101, "abc", "intro", 4, jos);
            programming.setAkts(-1);
            Assert.assertEquals(false,true );
        }catch (Exception e){
            Assert.assertTrue(true);
        }
    }
    @Test
    public void courseShouldSetAKTS(){
        Department cse = new Department("CSE", "compsci");
        Teacher jos = new Teacher("joseph", "j@gm.com", 34265, cse, 1);
        Course programming = new Course(cse, 101, "abc", "intro", 4, jos);
        programming.setAkts(1);
        Assert.assertEquals(1, programming.getAkts());
    }
    @Test
    public void courseShouldSetCourseNumber(){
        Department cse = new Department("CSE", "compsci");
        Teacher jos = new Teacher("joseph", "j@gm.com", 34265, cse, 1);
        Course programming = new Course(cse, 101, "abc", "intro", 4, jos);
        programming.setCourseNumber(102);
        Assert.assertEquals(102, programming.getCourseNumber());
    }
    @Test
    public void courseShouldNotSetCourseNumber(){
        try{
            Department cse = new Department("CSE", "compsci");
            Teacher jos = new Teacher("joseph", "j@gm.com", 34265, cse, 1);
            Course programming = new Course(cse, 101, "abc", "intro", 4, jos);
            programming.setCourseNumber(102323);
            Assert.assertEquals(false,true );
        }catch (Exception e){
            Assert.assertTrue(true);
        }
    }
    @Test
    public void courseShouldSetDepartment(){
        Department cse = new Department("CSE", "compsci");
        Teacher jos = new Teacher("joseph", "j@gm.com", 34265, cse, 1);
        Course programming = new Course(cse, 101, "abc", "intro", 4, jos);
        Assert.assertEquals(cse, programming.getDepartment());
    }
    @Test
    public void courseShouldSetDescription() {
        Department cse = new Department("CSE", "compsci");
        Teacher jos = new Teacher("joseph", "j@gm.com", 34265, cse, 1);
        Course programming = new Course(cse, 101, "abc", "intro", 4, jos);
        programming.setDescription("a");
        Assert.assertEquals("a", programming.getDescription());
    }
    @Test
    public void courseShouldSetTeacher() {
        Department cse = new Department("CSE", "compsci");
        Teacher jos = new Teacher("joseph", "j@gm.com", 34265, cse, 1);
        Course programming = new Course(cse, 101, "abc", "intro", 4, jos);
        Teacher hoca=new Teacher("hoca","das@fsd.com",1223,cse,1);
        programming.setDescription("a");
        Assert.assertEquals("a", programming.getDescription());
    }
    @Test
    public void courseShouldNotSetTeacher(){
        try{
            Department cse = new Department("CSE", "compsci");
            Teacher jos = new Teacher("joseph", "j@gm.com", 34265, cse, 1);
            Course programming = new Course(cse, 101, "abc", "intro", 4, jos);
            Department ziraat=new Department("ZRT", "ziraatmuh");
            Teacher memet=new Teacher("memed", "asfa@g.c", 12345L, ziraat, 3);
            programming.setTeacher(memet);
            Assert.assertEquals(false,true );
        }catch (DepartmentMismatchException e){
            Assert.assertTrue(true);
        }
    }
    @Test
    public void courseShouldSetTitle(){
        Department cse = new Department("CSE", "compsci");
        Teacher jos = new Teacher("joseph", "j@gm.com", 34265, cse, 1);
        Course programming = new Course(cse, 101, "abc", "intro", 4, jos);
        programming.setTitle("abc");
        Assert.assertEquals("abc", programming.getTitle());
    }
    @Test
    public void courseShouldGetCourseCode() {
        Department cse = new Department("CSE", "compsci");
        Teacher jos = new Teacher("joseph", "j@gm.com", 34265, cse, 1);
        Course programming = new Course(cse, 101, "abc", "intro", 4, jos);
        Assert.assertEquals("CSE101", programming.courseCode());
    }
    @Test
    public void courseToString(){
        Department cse = new Department("CSE", "compsci");
        Teacher jos = new Teacher("joseph", "j@gm.com", 34265, cse, 1);
        Course programming = new Course(cse, 101, "abc", "intro", 4, jos);
        if((programming.toString()).contains("CSE101") &&(programming.toString()).contains("abc")
                &&(programming.toString()).contains("(4)"))
            Assert.assertTrue(true);
        else
            Assert.assertEquals(false,true );
    }
    @Test
    public void teacherShouldGetName(){
        Department cse = new Department("CSE", "compsci");
        Person me=new Teacher("a","ab@domain.com",12345,cse,1);
        Assert.assertEquals("a",me.getName());
    }
    @Test
    public void teacherShouldGetId() {
        Department cse = new Department("CSE", "compsci");
        Person me = new Teacher("a", "ab@domain.com", 12345, cse, 1);
        Assert.assertEquals(12345, me.getId());
    }
    @Test
    public void teacherShouldGetDepartment() {
        Department cse = new Department("CSE", "compsci");
        Person me = new Teacher("a", "ab@domain.com", 12345, cse, 1);
        Assert.assertEquals(cse, me.getDepartment());
    }
    @Test
    public void teacherShouldGetEmail() {
        Department cse = new Department("CSE", "compsci");
        Person me = new Teacher("a", "user@gmail.com", 12345, cse, 1);
        Assert.assertEquals("user@gmail.com", me.getEmail().trim());
    }
    @Test
    public void teacherShouldSetEmail() {
        Department cse = new Department("CSE", "compsci");
        Person me = new Teacher("a", "a@domain.com", 12345, cse, 1);
        me.setEmail("b@domain.com");
        Assert.assertEquals("b@domain.com", me.getEmail().trim());
    }
    @Test
    public void teacherShouldSetDepartment() {
        Department cse = new Department("CSE", "compsci");
        Department ziraat=new Department("ZRT", "ziraatmuh");
        Person me = new Teacher("a", "afds@bfsdf.com", 12345, cse, 1);
        me.setDepartment(ziraat);
        Assert.assertEquals(ziraat, me.getDepartment());
    }
    @Test
    public void teacherShouldSetName(){
        Department cse = new Department("CSE", "compsci");
        Person me=new Teacher("a","afds@bdfs.com",12345,cse,1);
        me.setName("newName");
        Assert.assertEquals("newName",me.getName());
    }
    @Test
    public void teacherShouldSetId() {
        Department cse = new Department("CSE", "compsci");
        Person me = new Teacher("a", "asd@bgfd.com", 12345, cse, 1);
        me.setId(1);
        Assert.assertEquals(1, me.getId());
    }
    @Test
    public void chairShouldBeNull() {
        Department cse = new Department("CSE", "compsci");
        Department ziraat=new Department("ZRT", "ziraatmuh");
        Teacher me = new Teacher("a", "adfs@bfdg.com", 12345, cse, 1);
        cse.setChair(me);
        me.setDepartment(ziraat);
        Assert.assertEquals(null, cse.getChair());
    }
    @Test
    public void teacherShouldPromoteTo2() {
        Department cse = new Department("CSE", "compsci");
        Department ziraat=new Department("ZRT", "ziraatmuh");
        Teacher me = new Teacher("a", "asdf@bfsdf.com", 12345, cse, 1);
        me.promote();
        Assert.assertEquals("Lecturer", me.getTitle().trim());
    }
    @Test
    public void teacherShouldPromoteTo3() {
        Department cse = new Department("CSE", "compsci");
        Department ziraat=new Department("ZRT", "ziraatmuh");
        Teacher me = new Teacher("a", "faf@bfsd.comö", 12345, cse, 2);
        me.promote();
        Assert.assertEquals("Assistant Professor", me.getTitle().trim());
    }
    @Test
    public void teacherShouldPromoteTo4() {
        Department cse = new Department("CSE", "compsci");
        Department ziraat=new Department("ZRT", "ziraatmuh");
        Teacher me = new Teacher("a", "afsdf@bfds.com", 12345, cse, 3);
        me.promote();
        Assert.assertEquals("Associate Professor", me.getTitle().trim());
    }
    @Test
    public void teacherShouldNotPromoteTo6() {
        try{
            Department cse = new Department("CSE", "compsci");
            Department ziraat=new Department("ZRT", "ziraatmuh");
            Teacher me = new Teacher("a", "fsdf@bfds.com", 12345, cse, 5);
            me.promote();
            Assert.assertEquals(false,true);
        }catch (InvalidRankException e){
            Assert.assertEquals(true,true);
        }
    }
    @Test
    public void teacherThrowsInvalidRankException() {
        try{
            Department cse = new Department("CSE", "compsci");
            Department ziraat=new Department("ZRT", "ziraatmuh");
            Teacher me = new Teacher("a", "fsdf@bfds.com", 12345, cse, 1);
            me.demote();
            Assert.assertEquals(false,true);
        }catch (InvalidRankException e){
            Assert.assertEquals(true,true);
        }
    }
    @Test
    public void studentExtendsPerson(){
        Department cse = new Department("CSE", "compsci");
        Student defne=new Student("defne", "abc@gm.com", 324, cse);
        Assert.assertEquals("defne",defne.getName().trim());
    }
    @Test
    public void studentGetsAKTS(){
        Department cse = new Department("CSE", "compsci");
        Student defne=new Student("defne", "abc@gm.com", 324, cse);
        Teacher me = new Teacher("a", "fsdf@bfds.com", 12345, cse, 1);
        Course programming=new Course(cse, 101, "abc", "intro", 4,me);
        Course istatistik=new Course(cse, 101, "bogazicili", "ozel ders", 4, me);
        defne.addCourse(programming,90);
        defne.addCourse(istatistik,20);
        Assert.assertEquals(4,defne.getAKTS());
    }
    @Test
    public void studentGetsAttemptedAKTS(){
        Department cse = new Department("CSE", "compsci");
        Student defne=new Student("defne", "abc@gm.com", 324, cse);
        Teacher me = new Teacher("a", "ads@bds.com", 12345, cse, 1);
        Course programming=new Course(cse, 101, "abc", "intro", 4,me);
        Course istatistik=new Course(cse, 101, "bogazicili", "ozel ders", 4, me);
        defne.addCourse(programming,90);
        defne.addCourse(istatistik,20);
        Assert.assertEquals(8,defne.getAttemptedAKTS());
    }
    @Test
    public void studentThrowsInvalidGradeException(){
        try{
            Department cse = new Department("CSE", "compsci");
            Department ziraat=new Department("ZRT", "ziraatmuh");
            Teacher me = new Teacher("a", "ads@bds.com", 12345, cse, 1);
            Course istatistik=new Course(cse, 101, "bogazicili", "ozel ders", 4, me);
            Student defne=new Student("defne", "abc@gm.com", 324, cse);
            defne.addCourse(istatistik,-1);
            Assert.assertEquals(false,true);
        }catch (InvalidGradeException e){
            Assert.assertEquals(true,true);
        }
    }
    @Test
    public void studentThrowsCourseNotFoundException(){
        try{
            Department cse = new Department("CSE", "compsci");
            Teacher me = new Teacher("a", "ads@bds.com", 12345, cse, 1);
            Course istatistik=new Course(cse, 101, "bogazicili", "ozel ders", 4, me);
            Student defne=new Student("defne", "abc@gm.com", 324, cse);
            defne.courseGPAPoints(istatistik);
            Assert.assertEquals(false,true);
        }catch (Exception e){
            Assert.assertTrue(true);
        }
    }
    @Test
    public void studentGetsCourseGPA4_0(){
        Department cse = new Department("CSE", "compsci");
        Teacher me = new Teacher("a", "ads@bds.com", 12345, cse, 1);
        Course istatistik=new Course(cse, 101, "bogazicili", "ozel ders", 4, me);
        Student defne=new Student("defne", "abc@gm.com", 324, cse);
        defne.addCourse(istatistik,90);
        Assert.assertEquals(4.0,defne.courseGPAPoints(istatistik),0.005);
    }
    @Test
    public void studentGetsCourseGPA3_5(){
        Department cse = new Department("CSE", "compsci");
        Teacher me = new Teacher("a", "ads@bds.com", 12345, cse, 1);
        Course istatistik=new Course(cse, 101, "bogazicili", "ozel ders", 4, me);
        Student defne=new Student("defne", "abc@gm.com", 324, cse);
        defne.addCourse(istatistik,85);
        Assert.assertEquals(3.5,defne.courseGPAPoints(istatistik),0.005);
    }
    @Test
    public void studentGetsCourseGPA3_0(){
        Department cse = new Department("CSE", "compsci");
        Teacher me = new Teacher("a", "ads@bds.com", 12345, cse, 1);
        Course istatistik=new Course(cse, 101, "bogazicili", "ozel ders", 4, me);
        Student defne=new Student("defne", "abc@gm.com", 324, cse);
        defne.addCourse(istatistik,80);
        Assert.assertEquals(3.0,defne.courseGPAPoints(istatistik),0.005);
    }
    @Test
    public void studentGetsCourseGPA2_5(){
        Department cse = new Department("CSE", "compsci");
        Teacher me = new Teacher("a", "ads@bds.com", 12345, cse, 1);
        Course istatistik=new Course(cse, 101, "bogazicili", "ozel ders", 4, me);
        Student defne=new Student("defne", "abc@gm.com", 324, cse);
        defne.addCourse(istatistik,67);
        Assert.assertEquals(2.5,defne.courseGPAPoints(istatistik),0.005);
    }
    @Test
    public void studentGetsCourseGPA2_0(){
        Department cse = new Department("CSE", "compsci");
        Teacher me = new Teacher("a", "ads@bds.com", 12345, cse, 1);
        Course istatistik=new Course(cse, 101, "bogazicili", "ozel ders", 4, me);
        Student defne=new Student("defne", "abc@gm.com", 324, cse);
        defne.addCourse(istatistik,60);
        Assert.assertEquals(2.0,defne.courseGPAPoints(istatistik),0.005);
    }
    @Test
    public void studentGetsCourseGPA1_5(){
        Department cse = new Department("CSE", "compsci");
        Teacher me = new Teacher("a", "ads@bds.com", 12345, cse, 1);
        Course istatistik=new Course(cse, 101, "bogazicili", "ozel ders", 4, me);
        Student defne=new Student("defne", "abc@gm.com", 324, cse);
        defne.addCourse(istatistik,53);
        Assert.assertEquals(1.5,defne.courseGPAPoints(istatistik),0.005);
    }
    @Test
    public void studentGetsCourseGPA1_0(){
        Department cse = new Department("CSE", "compsci");
        Teacher me = new Teacher("a", "ads@bds.com", 12345, cse, 1);
        Course istatistik=new Course(cse, 101, "bogazicili", "ozel ders", 4, me);
        Student defne=new Student("defne", "abc@gm.com", 324, cse);
        defne.addCourse(istatistik,46);
        Assert.assertEquals(1.0,defne.courseGPAPoints(istatistik),0.005);
    }
    @Test
    public void studentGetsCourseGPA0_5(){
        Department cse = new Department("CSE", "compsci");
        Teacher me = new Teacher("a", "afsd@bdas.com", 12345, cse, 1);
        Course istatistik=new Course(cse, 101, "bogazicili", "ozel ders", 4, me);
        Student defne=new Student("defne", "abc@gm.com", 324, cse);
        defne.addCourse(istatistik,35);
        Assert.assertEquals(0.5,defne.courseGPAPoints(istatistik),0.005);
    }
    @Test
    public void studentGetsCourseGPA0_0(){
        Department cse = new Department("CSE", "compsci");
        Teacher me = new Teacher("a", "afsd@bdas.com", 12345, cse, 1);
        Course istatistik=new Course(cse, 101, "bogazicili", "ozel ders", 4, me);
        Student defne=new Student("defne", "abc@gm.com", 324, cse);
        defne.addCourse(istatistik,10);
        Assert.assertEquals(0.0,defne.courseGPAPoints(istatistik),0.005);
    }
    @Test
    public void studentGetsCourseGradeLetterAA(){
        Department cse = new Department("CSE", "compsci");
        Teacher me = new Teacher("a", "afsd@bdas.com", 12345, cse, 1);
        Course istatistik=new Course(cse, 101, "bogazicili", "ozel ders", 4, me);
        Student defne=new Student("defne", "abc@gm.com", 324, cse);
        defne.addCourse(istatistik,90);
        Assert.assertEquals("AA",defne.courseGradeLetter(istatistik).trim());
    }
    @Test
    public void studentGetsCourseResultPassed(){
        Department cse = new Department("CSE", "compsci");
        Teacher me = new Teacher("a", "afsd@bdas.com", 12345, cse, 1);
        Course istatistik=new Course(cse, 101, "bogazicili", "ozel ders", 4, me);
        Student defne=new Student("defne", "abc@gm.com", 324, cse);
        defne.addCourse(istatistik,90);
        Assert.assertEquals("passed",defne.courseResult(istatistik).trim());
    }
    @Test
    public void studentGetsCourseResultConditionallyPassed(){
        Department cse = new Department("CSE", "compsci");
        Teacher me = new Teacher("a", "afsd@bdas.com", 12345, cse, 1);
        Course istatistik=new Course(cse, 101, "bogazicili", "ozel ders", 4, me);
        Student defne=new Student("defne", "abc@gm.com", 324, cse);
        defne.addCourse(istatistik,50);
        Assert.assertEquals("conditionally passed",defne.courseResult(istatistik).trim());
    }
    @Test
    public void studentGetsCourseResultFailed(){
        Department cse = new Department("CSE", "compsci");
        Teacher me = new Teacher("a", "afsd@bdas.com", 12345, cse, 1);
        Course istatistik=new Course(cse, 101, "bogazicili", "ozel ders", 4, me);
        Student defne=new Student("defne", "abc@gm.com", 324, cse);
        defne.addCourse(istatistik,10);
        Assert.assertEquals("failed",defne.courseResult(istatistik).trim());
    }
    @Test
    public void studentGetsGPA(){
        Department cse = new Department("CSE", "compsci");
        Teacher me = new Teacher("a", "afsd@bdas.com", 12345, cse, 1);
        Course istatistik=new Course(cse, 101, "bogazicili", "ozel ders", 4, me);
        Course programming=new Course(cse, 101, "abc", "intro", 4,me);
        Student defne=new Student("defne", "abc@gm.com", 324, cse);
        defne.addCourse(istatistik,90 );
        defne.addCourse(programming,10);
        Assert.assertEquals(4.0,defne.getGPA(),0.005);
    }
    //in my assignment 2 homework, I should have divided the passed grade sum to
    //number of passed courses. I did a logic error because of diving to number of courses taken.

    @Test
    public void studentToStringFormatCheck(){
        Department cse = new Department("CSE", "compsci");
        Teacher me = new Teacher("a", "afsd@bdas.com", 12345, cse, 1);
        Student defne=new Student("defne", "abc@gm.com", 324, cse);
        Course istatistik=new Course(cse, 101, "bogazicili", "ozel ders", 4, me);
        defne.addCourse(istatistik,90 );
        if(defne.toString().contains("defne")&& defne.toString().contains("324") &&
                defne.toString().contains("abc@gm.com") && defne.toString().contains("4.0"))
            Assert.assertEquals(true,true);
        else
            Assert.assertEquals(false,true);
    }
    @Test
    public void GradStudentShouldSetRank(){
        Department cse = new Department("CSE", "compsci");
        GradStudent a=new GradStudent("a","afsd@bdas.com",12,cse,1,"q");
        a.setRank(2);
        Assert.assertEquals("Doctoral Student",a.getLevel());
    }
    @Test
    public void GradStudentShouldNotSetRank(){
        try{
            Department cse = new Department("CSE", "compsci");
            GradStudent a=new GradStudent("a","afsd@bdas.com",12,cse,1,"q");
            a.setRank(8);
            Assert.assertEquals(false,true);
        }catch (InvalidRankException e){
            Assert.assertEquals(true,true);
        }
    }
    @Test
    public void GradStudentSetsTopic(){
        Department cse = new Department("CSE", "compsci");
        GradStudent a=new GradStudent("a","afsd@bdas.com",12,cse,1,"q");
        a.setThesisTopic("z");
        Assert.assertEquals("z",a.getThesisTopic());
    }
    @Test
    public void GradStudentShouldPass(){
        Department cse = new Department("CSE", "compsci");
        Teacher me = new Teacher("a", "afsd@bdas.com", 12345, cse, 1);
        GradStudent a=new GradStudent("a","afsd@bdas.com",12,cse,1,"q");
        Course istatistik=new Course(cse, 101, "bogazicili", "ozel ders", 4, me);
        a.addCourse(istatistik,90);
        Assert.assertEquals("passed",a.courseResult(istatistik).trim().toLowerCase());
    }
    @Test
    public void GradStudentShouldFail(){
        Department cse = new Department("CSE", "compsci");
        Teacher me = new Teacher("a", "afsd@bdas.com", 12345, cse, 1);
        GradStudent a=new GradStudent("a","afsd@bdas.com",12,cse,1,"q");
        Course istatistik=new Course(cse, 101, "bogazicili", "ozel ders", 4, me);
        a.addCourse(istatistik,50);
        Assert.assertEquals("failed",a.courseResult(istatistik).trim().toLowerCase());
    }
    @Test
    public void GradStudentGradeLetterAA(){
        Department cse = new Department("CSE", "compsci");
        Teacher me = new Teacher("a", "afsd@bdas.com", 12345, cse, 1);
        GradStudent a=new GradStudent("a","afsd@bdas.com",12,cse,1,"q");
        Course istatistik=new Course(cse, 101, "bogazicili", "ozel ders", 4, me);
        a.addCourse(istatistik,90);
        Assert.assertEquals("AA",a.courseGradeLetter(istatistik));
    }
    @Test
    public void ShouldNotCreateGradStudent(){
        try {
            Department cse = new Department("CSE", "compsci");
            Teacher me = new Teacher("a", "afsd@bdas.com", 12345, cse, 1);
            GradStudent a = new GradStudent("a", "a@domain.com", 12, cse, -1, "q");
            Assert.assertEquals(false,true);
        }catch (Exception e){
            Assert.assertEquals(true,true);
        }
    }
    @Test
    public void GradStudentCourseGPAPoints(){
        Department cse = new Department("CSE", "compsci");
        Teacher me = new Teacher("a", "afsd@bdas.com", 12345, cse, 1);
        GradStudent a=new GradStudent("a","afsd@bdas.com",12,cse,1,"q");
        Course istatistik=new Course(cse, 101, "bogazicili", "ozel ders", 4, me);
        a.addCourse(istatistik,78);
        Assert.assertEquals(2.5,a.courseGPAPoints(istatistik),0.003);
    }
}