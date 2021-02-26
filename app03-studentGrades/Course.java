
/**
 * This class stores information about a course
 * that enrolled students may want to complete
 *
 * @author Evan Castro
 * @version 19/02/2021
 */
public class Course
{

    private String codeNo;
    private String title;

    private Module module1;
    private Module module2;
    private Module module3;
    private Module module4;

    private boolean isCompleted;
    /**
     * Constructor for objects of class Course
     */
    public Course(String codeNo, String title)
    {
        // initialise instance variables
        this.codeNo = codeNo;
        this.title = title;
        isCompleted = false;

    }

    /**
     * Prints out the details modules in the course
     * Prints out final grade
     */
    public void print()
    {
        // put your code here
        System.out.println("Course: " + codeNo + " - " + title);
        System.out.println("Module 1: " + module1.getModuleTitle() + " (" + module1.getModuleCode() + ") Mark: " + module1.getmoduleMark());
        System.out.println("Module 2: " + module2.getModuleTitle() + " (" + module2.getModuleCode() + ") Mark: " + module2.getmoduleMark());
        System.out.println("Module 3: " + module3.getModuleTitle() + " (" + module3.getModuleCode() + ") Mark: " + module3.getmoduleMark());
        System.out.println("Module 4: " + module4.getModuleTitle() + " (" + module4.getModuleCode() + ") Mark: " + module4.getmoduleMark());
        System.out.println("Final Grade: " + getFinalGrade());
    }

    /**
     * 
     * Add a module to the Course
     */
    public void addModule (Module module, int moduleNumber)
    {
        if(moduleNumber == 1)
        {
            this.module1 = module;
        }
        else if(moduleNumber == 2)
        {
            this.module2 = module;
        }
        else if(moduleNumber == 3)
        {
            this.module3 = module;
        }
        else if(moduleNumber == 4)
        {
            this.module4 = module;
        }
    }

    /**
     * checks completion of the modules
     */
    public void checkCompletion()
    {
        if(module1.getCompletionStatus() == true 
        && module2.getCompletionStatus() == true 
        && module3.getCompletionStatus() == true 
        && module4.getCompletionStatus() == true)
        {
            isCompleted = true;
            System.out.println("You have completed all of the Modules");

        }
        else
        {
            isCompleted = false;
            System.out.println("Please complete all of the modules");
        }
    }

    /**
     * Calculates the final grade for the entire course
     *
     */

    public String getFinalGrade()
    {
        {
            int totalMark = (module1.getmoduleMark() + module2.getmoduleMark() + 
                    module3.getmoduleMark() + module4.getmoduleMark()) / 4;

            if(totalMark <= 39)
            { 
                return "F";
            }
            else if(totalMark <= 49)
            {
                return "D";
            }
            else if(totalMark <= 59)
            {
                return "C";
            }
            else if(totalMark <= 69)
            {
                return "B";
            }
            else
            {
                return "A";
            }

        }
    }

}

