package inhatc.cse.yhjshope.interfaces;

public class KiaMaker implements CarMaker {

    @Override
    public Car sell(Money money){
        System.out.println("현대 자동차(입금) : " + money.getAmountint());

        Car car = new Car(" K5");


        return car;
    }

}
