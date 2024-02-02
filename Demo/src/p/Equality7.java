package p;

class Equality7 {
    public static void main(String[] args)
{
        int[] a = { 1, 2, 3, 4 };
        int[] b = { 1, 2, 3, 4 };
        int[] c = b;
        System.out.println(" a and b equals is " + (a == b));
        System.out.println(" b and c equals is" + (b == c));
    }
}
