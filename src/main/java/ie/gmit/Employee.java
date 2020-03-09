/*
Jack Madden
G00338579@gmit.ie

Creates Employee objects which have a title, age, name, PPS number, phone number, employment type, and age.

Employee objects will only be created under the following conditions:
-Title must be Mr, Mrs, or Ms
-Name can have a minimum of 3 characters and a maximum of 25 characters
-PPS number must be 8 characters in length
-Phone number must have 9 digits
-Employment type must be Full-time, Part-time, or Contract
-Age must be over 16

Failure to meet any of of these requirements will result in an exception being thrown and the Employee not being created.
 */
package ie.gmit;

public class Employee {
    private String title;
    private String name;
    private String pps;
    private String phoneNo;
    private String employmentType;
    private int age;

    public Employee(String title, String name, String pps, String phoneNo, String employmentType, int age) {
        if(title.equals("Mr") || title.equals("Mrs") || title.equals("Ms"))
            this.title = title;
        else
            throw new IllegalArgumentException("Title must be Mr, Mrs, or Ms");

        if(name.length() >= 3 && name.length() <= 25)
            this.name = name;
        else
            throw new IllegalArgumentException("Name must be 3–25 characters");

        if(pps.length() == 8)
            this.pps = pps;
        else
            throw new IllegalArgumentException("PPS number must have 8 characters");

        if(phoneNo.length() == 9)
            this.phoneNo = phoneNo;
        else
            throw new IllegalArgumentException("Phone number must have 9 digits");

        if(employmentType.equals("Full-time") || employmentType.equals("Part-time") || employmentType.equals("Contract"))
            this.employmentType = employmentType;
        else
            throw new IllegalArgumentException("Employment type must be Full-time, Part-time, or Contract");

        if(age > 16)
            this.age = age;
        else
            throw new IllegalArgumentException("Employee must be over 16");
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getPps() {
        return pps;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public int getAge() {
        return age;
    }
}
