package Annotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;
@Inherited
@Documented

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Course{
String cid() default "C-111";
String cname() default "CoreJava";
int cost() default 5000;
}
class Student
{
String sid;
String sname;
String saddress;
Student(String sid,String sname,String saddress){
this.sid = sid;
this.sname = sname;
this.saddress = saddress;
}
@Course(cid="C-222",cname="Frameworks")
public void getStudentDetails(){
System.out.println("****Student Details****");
System.out.println("SID :: "+sid);
System.out.println("SNAME :: "+sname);
System.out.println("SADDR :: "+saddress);
}
}
public class CustomAnnotation2
{
public static void main(String[] args)throws Exception
{
Student student = new Student("S-111","sachin","MI");
student.getStudentDetails();
System.out.println();
System.out.println("****CourseDetails****");
Class c = student.getClass();
Method method = c.getMethod("getStudentDetails");
Course course =(Course)method.getAnnotation(Course.class);
System.out.println("CID :: "+course.cid());
System.out.println("CNAME :: "+course.cname());
System.out.println("COST :: "+course.cost());
}
}