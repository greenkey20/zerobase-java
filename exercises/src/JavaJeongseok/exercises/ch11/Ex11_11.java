package exercises.src.JavaJeongseok.exercises.ch11;
import java.util.*;

// 2022.8.29(월) 23h50
class SutdaCard {
    int num;
    boolean isKwang;

    SutdaCard() {
        this(1, true);
    }

    SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    public boolean equals(Object obj) {
        if (obj instanceof SutdaCard) {
            SutdaCard c = (SutdaCard) obj;
                    return num == c.num && isKwang == c.isKwang;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return num + (isKwang ? "K" : "");
    }

    @Override
    public int hashCode() {
//        return super.hashCode(); // 'generate override methods' 메뉴로 자동 생성한 메소드 내용
        return toString().hashCode();
    }
}

public class Ex11_11 {
    public static void main(String[] args) {
        SutdaCard c1 = new SutdaCard(3, true);
        SutdaCard c2 = new SutdaCard(3, true);
        SutdaCard c3 = new SutdaCard();

        HashSet set = new HashSet();
        set.add(c1);
        set.add(c2);
        set.add(c3);

        System.out.println(set);
    }
}
