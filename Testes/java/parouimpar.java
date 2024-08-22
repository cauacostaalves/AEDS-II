
public class parouimpar {
    public static void main(String[] args) {
        
        int num = 0;
        num = MyIO.readInt();
        while (num != 0) {
            if (num % 2 == 0) {
                MyIO.println("P");
            } else {
                MyIO.println("I");
            }
            num = MyIO.readInt();
        }
       
    }
}
