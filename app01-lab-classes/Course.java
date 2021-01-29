
/**
 * Write a description of class Course here.
 *
 * @author Evan Castro  
 * @version 13/01/2021
 */
public class Course
{
    private String codeNumber;
    private String title;
    
    /**
     * Constructor for objects of class Course
     */
    public Course(String codeNumber, String title)
    {
       this.codeNumber = codeNumber;
       this.title = title;
    }

    /**
     *This method prints out the course details
     */
    public void print()
    {
        System.out.println("Code:" + codeNumber);
        System.out.println("Title:" + title);
    }
}
