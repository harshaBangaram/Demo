package p;

class Equality2{
public static void main(String args[]){
String str1 = new String("String1");
String str2 = new String("String1");
System.out.print(str1 == str2);
System.out.print(str1.equals(str2));
str1 = str2;
System.out.print(str1 == str2);
}
}

