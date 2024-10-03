package inhatc.cse.yhjshope.basic;

public class OrderManager {

    private HyundaiMaker maker;

    public OrderManager(){
        this.maker = new HyundaiMaker();

    }

    public void order(int cost){
        Money money = new Money(cost);
        Car car  = maker.sell(money);
        System.out.println("판매상(인수) : " + car.getName());
    }
}
