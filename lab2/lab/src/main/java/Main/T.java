package Main;

public class T {
    public static void main(String[] args) {
        System.out.println(Math.sin(Double.MAX_VALUE%(2*Math.PI)));
        System.out.println(Math.sin(Double.MAX_VALUE));
        System.out.println(Math.sin(100%(2*Math.PI)));
        System.out.println(Math.sin(100));
    }
}
