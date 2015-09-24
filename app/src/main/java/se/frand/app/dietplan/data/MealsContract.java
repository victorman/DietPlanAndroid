package se.frand.app.dietplan.data;

import android.provider.BaseColumns;

public final class MealsContract {
    public MealsContract() {};

    public static abstract class MealEntry implements BaseColumns {
        public static final String TABLE_NAME = "meals";
        public static final String COL_NAME_ID = "_id";
        public static final String COL_NAME_NAME = "name";
    }

}