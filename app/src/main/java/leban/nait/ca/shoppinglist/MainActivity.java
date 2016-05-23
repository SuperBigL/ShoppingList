package leban.nait.ca.shoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import leban.nait.ca.shoppinglist.Foods.Food;
import leban.nait.ca.shoppinglist.Foods.ShoppingList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button addButton, updateButton, deleteButton, clearButton;
    Spinner foodSpinner;
    EditText foodText;
    ArrayList foods = new ArrayList();
    ShoppingList list;
    int foodCount = 0;
    NumberPicker quantityPicker;
    Food food;
    ListView shoppingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        foodText = (EditText)findViewById(R.id.textfood);
        addButton = (Button)findViewById(R.id.addButton);
        updateButton = (Button)findViewById(R.id.updateButton);
        deleteButton = (Button)findViewById(R.id.deleteButton);
        clearButton = (Button)findViewById(R.id.clearbutton);
        foodSpinner = (Spinner)findViewById(R.id.foodspinner);
        quantityPicker = (NumberPicker) findViewById(R.id.quantitypicker);
        shoppingList = (ListView) findViewById(R.id.shoppinglist);

        addButton.setOnClickListener(this);
        updateButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
        updateButton.setEnabled(false);
        deleteButton.setEnabled(false);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.addButton:
            {


                if(foodCount == 0) {
                    try {
                        //Adds the food item to the list.
                        food = list.addFood(foodCount, foodText.getText().toString(), quantityPicker.getValue());
                        Toast.makeText(this, "You've added a food into the list.", Toast.LENGTH_LONG).show();

                        String foodInfo = food.getFoodName() + "(s) " + food.getFoodQuantity() ;
                        //Adds food to the ListView
                        ArrayAdapter<String> foodsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, foods);
                        shoppingList.setAdapter(foodsAdapter);
                        foods.add(foodInfo);
                        foodCount++;



                    } catch (Exception e) {
                        e.printStackTrace();
                    };
                }


               break;
            }

            case R.id.updateButton:
            {

                food.setFoodName(foodText.getText().toString());
                food.setFoodQuantity(quantityPicker.getValue());

                String foodInfo = list.getFoodName(foodSpinner.getSelectedItemPosition()) + list.getFoodQuantity(foodSpinner.getSelectedItemPosition());
                ArrayAdapter<String> foodsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, foods);
                shoppingList.setAdapter(foodsAdapter);
                foodCount = list.getFoodList();
                Toast.makeText(this, "Updated food", Toast.LENGTH_LONG).show();

                break;
            }

            case R.id.deleteButton:
            {
                foods.remove(foodSpinner.getSelectedItemPosition());

                break;
            }

            case R.id.clearbutton:
            {
                foods.clear();

                ArrayAdapter<String> foodsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, foods);
                foodsAdapter.clear();
                shoppingList.setAdapter(foodsAdapter);
                foodCount = 0;
                Toast.makeText(this, "Cleared all items", Toast.LENGTH_LONG).show();


            }
        }

    }
}
