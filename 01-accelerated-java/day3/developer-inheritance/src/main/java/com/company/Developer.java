package com.company;

public class Developer  extends StaffMember{
    public Developer(String name, int hireYear, String preferredProgrammingLanguage) {
        this.name = name;
        this.hireYear = hireYear;
        this.preferredProgrammingLanguage = preferredProgrammingLanguage;
    }

    public Developer() {}

    protected String name;
    private int hireYear;
    private String preferredProgrammingLanguage;

    public void submitTimeCard() {
        System.out.println(this.name = " says: PAY ME!");
    }

    public int estimateStoryPoints() {
        System.out.println(this.name + " says: Hmmm.... I think we should do 3 story points");
        return 3;
    }

    public void checkInCode() {
        System.out.println(this.name + " types: git add -A; git commit -m; git push");
    }

//    public String getName() {
//        return name;
//    }

    public int getHireYear() {
        return hireYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHireYear(int hireYear) {
        this.hireYear = hireYear;
    }

    public void setPreferredProgrammingLanguage(String preferredProgrammingLanguage) {
        this.preferredProgrammingLanguage = preferredProgrammingLanguage;
    }

    public String getPreferredProgrammingLanguage() {
        return preferredProgrammingLanguage;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", hireYear=" + hireYear +
                ", preferredProgrammingLanguage='" + preferredProgrammingLanguage + '\'' +
                '}';
    }
}
