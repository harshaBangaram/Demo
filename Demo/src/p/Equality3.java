package p;
class Equality3{
public static void main(String args[]){
String str1 = "String1";
String str2 = "String1";
System.out.print(str1 == str2);
System.out.print(str1.equals(str2));
str1 = str2;
System.out.print(str1 == str2);
}
}
