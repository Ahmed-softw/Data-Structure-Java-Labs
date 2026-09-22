package datast;
abstract class Employee {
protected String name;
protected double payRate;
public Employee(String empName, double empRate) {
name = empName;
payRate = empRate;
}
public String getName() {
return name;
}
public void setPayRate(double newRate) {
payRate = newRate;
}
abstract public double pay(); // no definition ?
public void print() {
System.out.println("Name: " + name);
System.out.println("Pay Rate: "+payRate);
}
}
///////////////////////////////////
class HourlyEmployee extends Employee {
private int hours;
public HourlyEmployee(String hName, double hRate) {
super(hName, hRate);
hours = 0;
}
public void addHours(int moreHours) {
hours += moreHours;
}
public double pay() {
return payRate * hours;
}
public void print() {
super.print();
System.out.println("Current hours: " + hours);
}
}
/////////////////////////////////
class MonthlyEmployee extends Employee {
public MonthlyEmployee(String empName, double empRate) {
super(empName, empRate);
}
public double pay() {
return payRate;
}
}
/////////////////////////////////
class Executive extends MonthlyEmployee {
private double bonus;
public Executive(String exName, double exRate) {
super(exName, exRate);
bonus = 0;
}
public void awardBonus(double amount) {
bonus = amount;
}
public double pay() {
double paycheck = super.pay() + bonus;
bonus = 0;
return paycheck;
}
public void print() {
super.print();
System.out.println("Current bonus: " + bonus);
}
}
/////////////////////////////////
public class lap1 {
public static void main(String[] args) {
Employee[] list = new Employee[3];
list[0] = new Executive("Jarallah Al-Ghamdi (E)", 50000);
list[1] = new HourlyEmployee("Azmat Ansari (H)", 120);
list[2] = new MonthlyEmployee("Sahalu Junaidu (M)", 9000);
((Executive)list[0]).awardBonus(11000);
for(int i = 0; i < list.length; i++)
if(list[i] instanceof HourlyEmployee)
((HourlyEmployee)list[i]).addHours(60);
for(int i = 0; i < list.length; i++) {
list[i].print();
System.out.println("Paid: " + list[i].pay());
System.out.println("*************************");
}
}
}
/////////////////////////////////