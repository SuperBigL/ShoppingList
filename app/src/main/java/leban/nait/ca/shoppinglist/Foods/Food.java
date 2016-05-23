package leban.nait.ca.shoppinglist.Foods;

/**
 * Created by Owner on 2016-05-20.
 */
public class Food
{
    private int foodnumber;
    private String foodName;
    private int foodQuantity;
    boolean bought;


    public Food(int FoodNumber, String FoodName, int FoodQuantity)
    {
        foodnumber = FoodNumber;
        foodName = FoodName;
        foodQuantity = FoodQuantity;
        //bought = Bought;
    }

    public int getFoodnumber() {
        return foodnumber;
    }

    public void setFoodnumber(int foodnumber) {
        this.foodnumber = foodnumber;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }


    /*public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }*/
}
