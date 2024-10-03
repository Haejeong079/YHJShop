package inhatc.cse.yhjshope.interfaces;

public class HyundaiMaker implements CarMaker {
//    @Override
//    public Car sell(Money money) {
//        return null;
//    }

    @Override

    public Car sell(Money money ){
        System.out.println("현대 자동차(입금) : " + money.getAmountint());

        Car car = new Car("아이오닉 5");


        return car;
    }

}
