package se.frand.app.dietplan.data;

import android.provider.BaseColumns;

public final class MealItemsContract {
    public MealItemsContract() {};

    public static abstract class MealItemEntry implements BaseColumns {
        public static final String TABLE_NAME = "mealitems";
        public static final String COL_NAME_ID = "_id";
        public static final String COL_NAME_INGREDIENT_ID = "ingredient_id";
        public static final String COL_NAME_MEAL_ID = "meal_id";

    }

}