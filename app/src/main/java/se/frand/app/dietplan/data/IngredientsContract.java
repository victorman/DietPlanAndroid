package se.frand.app.dietplan.data;

import android.provider.BaseColumns;

public final class IngredientsContract {
    public IngredientsContract() {};

    public static abstract class IngredientsEntry implements BaseColumns {
        public static final String TABLE_NAME = "ingredients";
        public static final String COL_NAME_ID = "_id";
        public static final String COL_NAME_NAME = "name";
        public static final String COL_NAME_CAT_ID = "cat_id";
    }

}
