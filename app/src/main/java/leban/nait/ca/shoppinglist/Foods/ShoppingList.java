package leban.nait.ca.shoppinglist.Foods;

import android.widget.Toast;

/**
 * Created by Owner on 2016-05-20.
 */
public class ShoppingList
{
    public static int MAX_FOODS = 200;
    public Food[] foodList = new Food[MAX_FOODS];
    public int listSize = 0;
    public Food food;

    public int getFoodList() {
        return listSize;
    }

    public String getFoodName(int number)
    {
        String name;
        name = foodList[number].getFoodName();
        return name;

    }

    public  int getFoodQuantity(int number)
    {
        int quantity;
        quantity = foodList[number].getFoodQuantity();
        return quantity;
    }


    public Food addFood(int number, String name, int quantity) throws Exception
    {
        Food food;



        if(name.isEmpty())
        {
            throw new Exception("You don't have a name for that food, try again.");
        }

        else if(quantity == 0)
        {
            throw new Exception("Try not to put food you don't intend on buying.");
        }

        else if(listSize > MAX_FOODS)
        {
            throw new Exception( "Your list is full. Try deleting stuff you've already bought");
        }

        else
        {


            food = new Food( listSize ,name, quantity);
            foodList[listSize] = food;
            listSize++;
        }

        return food;

    }

    public void updateFood(int number, String name, int quantity) throws Exception
    {





        if(name.isEmpty())
        {
            throw  new Exception("You don't have a food to update");
        }

        else if(quantity <= 0)
        {
            throw  new Exception("If you don't want this food item anymore, delete it from your list.");

        }

        else
        {
            foodList[number].setFoodName(name);
            foodList[number].setFoodQuantity(quantity);

        }

    }

    public void deleteFood(int number) throws Exception
    {
        if(number <= 0)
        {
           throw new Exception("You need a positive number for this to work.");
        }


        else
        {

            foodList[number].getFoodnumber();
            listSize--;


        }

    }



}
