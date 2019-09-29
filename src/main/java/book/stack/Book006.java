package book.stack;

/**
 * 先简单实现下汉诺塔结构，后面的难度3星的再说。
 * <p>
 * TODO hannuota
 */
public class Book006 {

    public static void main(String[] args) {
        hannio(2,'a','b','c');
    }

    public static void hannio(int n, char A, char B, char C) {
        if (n == 1) {
            move(A, C);
            return;
        }else {
            hannio(n - 1, A, C, B);
            move(A, C);
            hannio(n - 1, B, A, C);
        }
    }

    public static void move(char A, char C) {
        System.out.println("把" + A + "移动到" + C);
    }
}
