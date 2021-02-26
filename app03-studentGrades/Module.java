
/**
 * This class represents the different modules that the student can partake in.
 * It holds the title, module code and the percentage mark to assign grades.
 * @author Evan Castro  
 * @version 19/02/2021
 */
public class Module
{
    private String title;
    private String code;

    private int moduleMark;
    private boolean isCompleted;

    /**
     * Constructor for objects of class Module
     */
    public Module(String title, String code)
    {
        this.title = title;
        this.code = code;
        this.moduleMark = 0;
        isCompleted = false;
    }

    /**
     * This method allows to designate a mark for the module
     */
    public void setMark(int moduleMark)
    {
        if(moduleMark >= 0 && moduleMark <= 100)
        {
            this.moduleMark = moduleMark;
            checkCompletion();
        }
        else 
        {
            System.out.println("Please input a mark between 0 and 100");
        }

    }

    /**
     * This method checks the complettion status of the module
     * 
     *
     */
    public void checkCompletion()
    {
        if(moduleMark >= 40)
        {
            isCompleted = true;
        }
    }

    /**
     * checks the completion status of the module
     * Returns the value of true or false
     *
     */
    public boolean getCompletionStatus()
    {
        return isCompleted;
    }

    /**
     * Returns the mark from the modules
     *
     */
    public int getmoduleMark()
    {
        return moduleMark;
    }

    /**
     * Returns the module code
     *
     */
    public String getModuleCode()
    {
        return code;

    }

    /**
     * Returns the module title
     *
     */
    public String getModuleTitle()
    {
        return title;
    }

    /**
     * This method prints out the module information
     * It prints module code,title and mark.
     */

    public void print()
    {
        System.out.println ("\nModule code: " + code);
        System.out.println ("Module title: " + title);
        System.out.println ("Module mark: " + moduleMark + "%");
        System.out.println ("Module completion: " + isCompleted);
    }

}