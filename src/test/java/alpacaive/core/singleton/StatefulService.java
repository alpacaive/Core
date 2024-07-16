package alpacaive.core.singleton;

// 상태를 유지할 경우 발생하는 문제점: 실무에서도 굉장히 많이 발생하는 부
public class StatefulService {

    private int price; // 상태를 유지하는 필드 10000 -> 20000

    public void order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        this.price = price; // 여기가 문제
    }

    public int getPrice() {
        return price;
    }
}
