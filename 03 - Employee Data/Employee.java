package chapter3;
/*Written by Carlos Vazquez
Chapter 3 
Programming Challenge 1
Date: 27 August 2018

Write a class named Employee that has the following fields:

- name. The name field is a String object that holds the employee’s name.

- idNumber. The idNumber is an int variable that holds the employee’s ID number.

- department. The department field is a String object that holds the name of the department where the employee works.

- position. The position field is a String object that holds the employee’s job title.

Write appropriate mutator methods that store values in these fields, 
and accessor methods that return the values in these fields. 
Once you have written the class, write a separate program that creates 
three Employee objects to hold the following data:
Name            ID Number     Department            Position
Susan Meyers    47899         Accounting            Vice President
Mark Jones      39119         IT                    Programmer
Joy Rogers      81774         Manufacturing         Engineer
*/

public class Employee 
{

        private String name; // holds the employee's name.
        private int idNumber; // holds the employee's ID number.
        private String department; // holds the name of the department where the employee works.
        private String position; // holds the employee's job title.
        
        //Mutators.
        /* The method setName takes one string argument
         * to hold the employee's name.
         */
        public void setName(String n)
        {
            name = n;
        }
        
        /* The method setIdNumber takes one integer argument
         * to hold the employee's id number.
         */
        public void setIdNumber(int idNum)
        {
            idNumber = idNum;
        }
        
        /* The method setDepartment takes one string argument
         * to hold the employee's department area.
         */
        public void setDepartment(String dept)
        {
            department = dept;
        }
         
        /* The method setPosition takes one string argument
         * to hold the employee's position.
         */
        public void setPosition(String pos)
        {
            position = pos;
        }
        
        //Accessors.
        /* The method getName returns the
         * string name value in the name field.
         */
        public String getName()
        {
            return name;
        }
        
        /* The method getIdNumber returns the
         * integer id number value in the idNumber field.
         */
        public int getIdNumber()
        {
            return idNumber;
        }
        
        /* The method getDepartment returns the
         * string department value in the department field.
         */
        public String getDepartment()
        {
            return department;
        }
        
        /* The method getPosition returns the
         * string position value in the position field.
         */
        public String getPosition()
        {
            return position;
        }
    
}
