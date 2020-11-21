package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * create By zb on 2020/11/5.
 */
public class West2FriedChickenRestaurant implements FriedChickenRestaurant {
    private double accountMoney=10000;//开局10000元，发家致富
    private LinkedList<Beer> beers=new LinkedList<Beer>();
    private LinkedList<Juice> juices=new LinkedList<Juice>();
    public static ArrayList<SetMeal> meals=new ArrayList<>();
    //ArrayList底层实现是数组，按下标查找快，但插入和删除慢
    //LinkedList底层实现是链表，插入和删除快，但查找慢
    //本题删除和插入操作比较多，故用LinkedList
    static {
        meals.add(new SetMeal(1,"套餐一","香辣鸡块",new Beer(" QingDaoBeer", LocalDate.of(2020,11,6),0.11f)));
        meals.add(new SetMeal(2,"套餐二","香辣鸡块",new Beer(" XueHuaBeer ", LocalDate.of(2020,11,6),0.15f)));
        meals.add(new SetMeal(3,"套餐三","香辣鸡块",new Juice(" OrangeJuice", LocalDate.of(2020,11,6))));
        meals.add(new SetMeal(4,"套餐四","香辣鸡块",new Juice(" AppleJuice ", LocalDate.of(2020,11,6))));
    }

    boolean use(Drinks drinks){
        if(drinks instanceof Juice){
            //System.out.println("Juice"+juices.size());
            for(int i=0;i<juices.size();i++){
                if(juices.get(i).isOutOfDate()){
                    juices.remove(i);i--;continue;
                }
                if(juices.get(i).name==drinks.name){
                    juices.remove(i);return true;
                }
            }
            return false;
        }else if(drinks instanceof Beer){
            //System.out.println("beer"+beers.size());
//            System.out.println(drinks.name+"###");
//            for(int i=0;i<beers.size();i++){
//                System.out.println(beers.get(i).name);
//            }
            for(int i=0;i<beers.size();i++){
                //System.out.println("beer1 "+beers.size());
                if(beers.get(i).isOutOfDate()){
                    beers.remove(i);continue;
                }
                //System.out.println("beer2 "+beers.size());
                if(beers.get(i).name==drinks.name){
                    beers.remove(i);return true;
                }
            }
            return false;
        }else{
            return false;
        }
    }
    @Override

    public double sale(ArrayList<SetMeal> foods) {
        double cost=0;
        for(int i=0;i<foods.size();i++){
            if(beers.size()<=0||juices.size()<=0) {
                throw new IngredientSortOutException(foods.get(i));
            }
            if(foods.get(i).getDrink() instanceof Beer){
                if(!use((Beer)(foods.get(i).getDrink()))) {
                    throw new IngredientSortOutException(foods.get(i));
                }else{
                    cost+=foods.get(i).getSetPrice();
                }
            }else if(foods.get(i).getDrink() instanceof Juice){
                if(!use((Juice) (foods.get(i).getDrink()))) {
                    throw new IngredientSortOutException(foods.get(i));
                }else{
                    cost+=foods.get(i).getSetPrice();
                }
            }
        }
        return cost;
    }

    @Override
    public void purchase(int num_beer,int num_juice) {
        double cost=num_beer*Beer.beer_Purchase_Price+num_juice*Juice.juice_Purchase_Price;
        if(cost<=accountMoney){
            addToBeer(num_beer/2,num_beer-num_beer/2);
            addToJuice(num_juice/2,num_juice-num_juice/2);
        }else{
            throw new OverdraftBalanceException(cost-accountMoney);
        }
    }
    void addToBeer(int numOfQingdaoBeer,int numOfXueHuaBeer){
        for(int i=0;i<numOfQingdaoBeer;i++){
            beers.add(new Beer(" QingDaoBeer",LocalDate.of(2020,11,18),0.11f));
        }
        for(int i=0;i<numOfXueHuaBeer;i++){
            beers.add(new Beer(" XueHuaBeer ",LocalDate.of(2020,11,18),0.15f));
        }
    }
    void addToJuice(int numOfOrange,int numOfApple){
        for(int i=0;i<numOfOrange;i++){
            juices.add(new Juice(" OrangeJuice",LocalDate.of(2020,11,6)));
        }
        for(int i=0;i<numOfApple;i++){
            juices.add(new Juice(" AppleJuice ",LocalDate.of(2020,11,6)));
        }
    }
    public void showSellInformation(){
        System.out.println("欢迎光临西二炸鸡店：");
        System.out.println("本店套餐如下：");
        System.out.println("----------------------------------------------------------------");
        System.out.println("|套餐名|    炸鸡名称"+"    |    "+"   饮料名   "+"    |    "+"价格|");
        for(int i=0;i<meals.size();i++){
            System.out.println("|套餐"+(i+1)+" |    "+meals.get(i).getChickenName()+"    |    "+meals.get(i).getDrink().name+"    |    "+meals.get(i).getSetPrice()+"|");
        }
        System.out.println("----------------------------------------------------------------");
        System.out.println("请选择你所需要的套餐：\n1.套餐1 \n2.套餐2 \n3.套餐3 \n4.套餐4 \n");
        System.out.println("0表示确认订单并提交，-1表示取消订单");
    }
}
