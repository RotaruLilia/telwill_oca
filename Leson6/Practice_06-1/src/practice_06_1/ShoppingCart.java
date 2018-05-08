package practice_06_1;

import practice_06_1.Item;

public class ShoppingCart {
    public static void main (String []args){
        Item item1= new Item();
        Item item2= new Item();
        item1.description = "Description 1";
        item2.description = "Description 2";
        System.out.println(item1.description);
        System.out.println(item2.description);

    }


}
