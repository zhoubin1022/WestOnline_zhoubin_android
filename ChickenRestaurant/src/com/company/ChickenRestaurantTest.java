package com.company;


import java.util.ArrayList;
import java.util.Scanner;


public class ChickenRestaurantTest {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        West2FriedChickenRestaurant restaurant=new West2FriedChickenRestaurant();
        restaurant.purchase(6,6);
        restaurant.showSellInformation();

        ArrayList<SetMeal> setMeals=new ArrayList<>();
        while(true){
            System.out.println("输入你接下来的操作：（sell卖炸鸡，purchase进货，bye关门，其他重新输入）");
            String work=input.next();
            if(work.compareTo("bye")==0){
                System.out.println("小店打烊了！！");break;
            }else if(work.compareTo("sell")==0){
                while(true){
                    int type=input.nextInt();//
                    if(type==-1){
                        setMeals.clear();
                        System.out.println("取消点餐！");break;
                    }else if(type==0){
                        double cost=restaurant.sale(setMeals);
                        System.out.println("已下单！共"+cost+"元");break;
                    }else{
                        setMeals.add(restaurant.meals.get(type-1));
                    }
                }
            }else if(work.compareTo("purchase")==0){
                System.out.println("请输入采购啤酒数量：");
                int beer=input.nextInt();
                System.out.println("请输入采购果汁数量：");
                int juice=input.nextInt();
                restaurant.purchase(beer,juice);
                System.out.println("采购完毕！！");
            }else{
                System.out.println("输入错误！！请重新输入");continue;
            }
        }

    }
}
