package com.gpengtao.test;

/**
 * Created by pengtao.geng on 2017/7/7.
 */
public class Food implements Eatable, Eatable2 {

    @Override
    public void canEat() {
        System.out.println("can");
    }

    public static void main(String[] args) {
        Food food = new Food();
        food.canEat();

        Eatable eatable = new Food();
        eatable.canEat();

        Eatable2 eatable2 = new Food();
        eatable2.canEat();
    }
}
