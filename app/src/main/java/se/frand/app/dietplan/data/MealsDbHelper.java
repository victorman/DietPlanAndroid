package se.frand.app.dietplan.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class MealsDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 5;
    public static final String DATABASE_NAME = "Meals.db";

    public MealsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MEALS);
        db.execSQL(CREATE_TABLE_INGREDIENTS);
        db.execSQL(CREATE_TABLE_MEAL_ITEMS);

        SQLiteStatement statement = db.compileStatement(INSERT_MEALS);

        for(int i=0;i<meals.length;i++) {
            statement.clearBindings();
            statement.bindNull(1);
            statement.bindString(2,meals[i]);
            statement.execute();
        }
        //ingredients
        statement = db.compileStatement(INSERT_INGREDIENTS);
        for(int i=0;i<ingredients_meats.length;i++) {
            statement.clearBindings();
            statement.bindNull(1);
            statement.bindString(2,ingredients_meats[i]);
            statement.bindLong(3,CAT_ID_INGREDIENTS_MEATS);
            statement.execute();
        }
        for(int i=0;i<ingredients_dairy.length;i++) {
            statement.clearBindings();
            statement.bindNull(1);
            statement.bindString(2,ingredients_dairy[i]);
            statement.bindLong(3,CAT_ID_INGREDIENTS_DAIRY);
            statement.execute();
        }
        for(int i=0;i<ingredients_grains.length;i++) {
            statement.clearBindings();
            statement.bindNull(1);
            statement.bindString(2,ingredients_grains[i]);
            statement.bindLong(3,CAT_ID_INGREDIENTS_GRAINS);
            statement.execute();
        }
        for(int i=0;i< ingredients_vegetables.length;i++) {
            statement.clearBindings();
            statement.bindNull(1);
            statement.bindString(2,ingredients_vegetables[i]);
            statement.bindLong(3,CAT_ID_INGREDIENTS_VEGETABLES);
            statement.execute();
        }
        for(int i=0;i< ingredients_fruits.length;i++) {
            statement.clearBindings();
            statement.bindNull(1);
            statement.bindString(2,ingredients_fruits[i]);
            statement.bindLong(3,CAT_ID_INGREDIENTS_FRUITS);
            statement.execute();
        }
        for(int i=0;i< ingredients_sweets.length;i++) {
            statement.clearBindings();
            statement.bindNull(1);
            statement.bindString(2,ingredients_sweets[i]);
            statement.bindLong(3,CAT_ID_INGREDIENTS_SWEETS);
            statement.execute();
        }
        for(int i=0;i< ingredients_other.length;i++) {
            statement.clearBindings();
            statement.bindNull(1);
            statement.bindString(2,ingredients_other[i]);
            statement.bindNull(3);
            statement.execute();
        }

        statement = db.compileStatement(INSERT_MEAL_ITEM);
        //add whey protein to bfast1
        statement.clearBindings();
        statement.bindNull(1);
        statement.bindLong(2,71);
        statement.bindLong(3,0);
        statement.execute();
        statement.clearBindings();
        // add cantaloupe
        statement.bindNull(1);
        statement.bindLong(2,50);
        statement.bindLong(3,0);
        statement.execute();
        // add eggs to bfast 2
        statement.clearBindings();
        statement.bindNull(1);
        statement.bindLong(2,75);
        statement.bindLong(3,1);
        statement.execute();
        //add egg whites
        statement.clearBindings();
        statement.bindNull(1);
        statement.bindLong(2,76);
        statement.bindLong(3,1);
        statement.execute();
        // add olive oil
        statement.clearBindings();
        statement.bindNull(1);
        statement.bindLong(2,77);
        statement.bindLong(3,1);
        statement.execute();
        // cheese
        statement.clearBindings();
        statement.bindNull(1);
        statement.bindLong(2,20);
        statement.bindLong(3,1);
        statement.execute();
        //oatmeal
        statement.clearBindings();
        statement.bindNull(1);
        statement.bindLong(2,23);
        statement.bindLong(3,1);
        statement.execute();
        // cottage cheese to late morning
        statement.clearBindings();
        statement.bindNull(1);
        statement.bindLong(2,18);
        statement.bindLong(3,2);
        statement.execute();
        // pineapple
        statement.clearBindings();
        statement.bindNull(1);
        statement.bindLong(2,51);
        statement.bindLong(3,2);
        statement.execute();
        // cliff bar
        statement.clearBindings();
        statement.bindNull(1);
        statement.bindLong(2,74);
        statement.bindLong(3,2);
        statement.execute();
        // albacore to lunch
        statement.clearBindings();
        statement.bindNull(1);
        statement.bindLong(2,2);
        statement.bindLong(3,3);
        statement.execute();
        // wheat bread
        statement.clearBindings();
        statement.bindNull(1);
        statement.bindLong(2,24);
        statement.bindLong(3,3);
        statement.execute();
        // mayonaise
        statement.clearBindings();
        statement.bindNull(1);
        statement.bindLong(2,78);
        statement.bindLong(3,3);
        statement.execute();
        // fruit
        statement.clearBindings();
        statement.bindNull(1);
        statement.bindLong(2,52);
        statement.bindLong(3,3);
        statement.execute();
        // whey protein to afternoon
        statement.clearBindings();
        statement.bindNull(1);
        statement.bindLong(2,71);
        statement.bindLong(3,4);
        statement.execute();
        // peanut butter
        statement.clearBindings();
        statement.bindNull(1);
        statement.bindLong(2,73);
        statement.bindLong(3,4);
        statement.execute();
        // jam
        statement.clearBindings();
        statement.bindNull(1);
        statement.bindLong(2,79);
        statement.bindLong(3,4);
        statement.execute();
        // whole wheat bread
        statement.clearBindings();
        statement.bindNull(1);
        statement.bindLong(2,24);
        statement.bindLong(3,4);
        statement.execute();
        // salmon to dinner
        statement.clearBindings();
        statement.bindNull(1);
        statement.bindLong(2,1);
        statement.bindLong(3,5);
        statement.execute();
        // broccoli to dinner
        statement.clearBindings();
        statement.bindNull(1);
        statement.bindLong(2,39);
        statement.bindLong(3,5);
        statement.execute();
        // green salad to dinner
        statement.clearBindings();
        statement.bindNull(1);
        statement.bindLong(2,40);
        statement.bindLong(3,5);
        statement.execute();
        // casein to bed snack
        statement.clearBindings();
        statement.bindNull(1);
        statement.bindLong(2,72);
        statement.bindLong(3,6);
        statement.execute();
        // casein to bed snack
        statement.clearBindings();
        statement.bindNull(1);
        statement.bindLong(2,73);
        statement.bindLong(3,6);
        statement.execute();

    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(DELETE_MEALS);
        db.execSQL(DELETE_INGREDIENTS);
        db.execSQL(DELETE_MEAL_ITEMS);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INTEGER";
    private static final String COM = ",";
    private static final String NNULL = " NOT NULL";
    private static final String CREATE_TABLE_MEALS =
            "CREATE TABLE " + MealsContract.MealEntry.TABLE_NAME + " (" +
                    MealsContract.MealEntry._ID + INT_TYPE + " PRIMARY KEY AUTOINCREMENT" + COM +
                    MealsContract.MealEntry.COL_NAME_NAME + TEXT_TYPE + NNULL +
                    " )";
    private static final String CREATE_TABLE_INGREDIENTS =
            "CREATE TABLE " + IngredientsContract.IngredientsEntry.TABLE_NAME + " (" +
                    IngredientsContract.IngredientsEntry.COL_NAME_ID + INT_TYPE + " PRIMARY KEY AUTOINCREMENT" + COM +
                    IngredientsContract.IngredientsEntry.COL_NAME_NAME + TEXT_TYPE + NNULL + COM +
                    IngredientsContract.IngredientsEntry.COL_NAME_CAT_ID + INT_TYPE +
                    " )";
 private static final String CREATE_TABLE_MEAL_ITEMS =
            "CREATE TABLE " + MealItemsContract.MealItemEntry.TABLE_NAME + " (" +
                    MealItemsContract.MealItemEntry.COL_NAME_ID + INT_TYPE + " PRIMARY KEY AUTOINCREMENT" + COM +
                    MealItemsContract.MealItemEntry.COL_NAME_INGREDIENT_ID + INT_TYPE + NNULL + COM +
                    MealItemsContract.MealItemEntry.COL_NAME_MEAL_ID + INT_TYPE + NNULL +
                    " )";

    private static final String INSERT_MEALS =
            "INSERT INTO " + MealsContract.MealEntry.TABLE_NAME +
                    " VALUES (?,?);";

    private static final String INSERT_INGREDIENTS =
            "INSERT INTO " + IngredientsContract.IngredientsEntry.TABLE_NAME +
                    " VALUES (?,?,?);";

private static final String INSERT_MEAL_ITEM =
            "INSERT INTO " + MealItemsContract.MealItemEntry.TABLE_NAME +
                    " VALUES (?,?,?);";


    private static final String DELETE_MEALS =
            "DROP TABLE IF EXISTS " + MealsContract.MealEntry.TABLE_NAME;
    private static final String DELETE_INGREDIENTS =
            "DROP TABLE IF EXISTS " + IngredientsContract.IngredientsEntry.TABLE_NAME;
    private static final String DELETE_MEAL_ITEMS =
            "DROP TABLE IF EXISTS " + MealItemsContract.MealItemEntry.TABLE_NAME;

    private static String[] meals = {
            "Breakfast 1",
            "Breakfast 2",
            "Late Morning Snack",
            "Lunch",
            "Afternoon Snack",
            "Dinner",
            "Before Bed Snack"
    };

    public static final long CAT_ID_INGREDIENTS_MEATS = 0;
    private static String[] ingredients_meats = {
            // these id's start from one. what are we in fucking kindergarten?
            "Salmon", // 1
            "Albacore Tuna", // 1
            "Chicken Breast",
            "Chicken Thighs",
            "Turkey Breast",
            "Lean Ground Turkey",
            "Lean Ground Beef",
            "Tri-tip Steak",
            "Flank Steak",
            "Pork Tenderloin",
            "Bison",
            "Trout",
            "Tilapia",
            "Crab",
            "Lean Deli Turkey Breast",
            "Lean Deli Ham",
            "Lean Deli Roast Beef"
    };
    public static final long CAT_ID_INGREDIENTS_DAIRY = 1;
    private static  String[] ingredients_dairy = {
            "Cottage Cheese", // 17
            "Greek Yogurt",
            "Low-fat or Reduced fat Cheese", // 19
            "Plain low-fat Yogurt",
            "Low-fat Milk"
    };

    public static final long CAT_ID_INGREDIENTS_GRAINS = 2;
    private static String[] ingredients_grains = {
            "Oatmeal", // 23
            "Whole-wheat bread", // 24
            "Whole-wheat Crackers",
            "Brown Rice",
            "Whole-grain cold Cereal",
            "Whole-wheat Waffle",
            "Ezekiel bread",
            "Rye Bread",
            "Sourdough Bread",
            "Whole-wheat English Muffin",
            "Whole-wheat pita Bread",
            "Whole-wheat Bagel",
            "Whole-wheat Tortilla",
            "Whole-wheat Pasta",
            "Quinoa",
            "Sweet Potato or Yam"
    };

    public static final long CAT_ID_INGREDIENTS_VEGETABLES = 3;
    private static String[] ingredients_vegetables = {
            "Broccoli", // 37
            "Mixed Green Salad", // 38
            "Asparagus",
            "Green Beans",
            "Cauliflower",
            "Bell Peppers",
            "Brussels Sprouts",
            "Mixed Vegetables",
            "Zucchini or Squash",
            "Eggplant",
            "Bok Choy" // 49
    };

    public static final long CAT_ID_INGREDIENTS_FRUITS = 4;
    private static String[] ingredients_fruits = {
            "Cantaloupe", // 50
            "Sliced Pineapple", // 51
            "Apple", // 52
            "Orange",
            "Peach",
            "Banana",
            "Pear",
            "Strawberries",
            "Blueberries",
            "Raspberries",
            "Blackberries",
            "Cherries",
            "Grapes",
            "Kiwifruit"
    };

    public static final long CAT_ID_INGREDIENTS_SWEETS = 5;
    private static String[] ingredients_sweets = {
            "Gummy Bears", // 63
            "GENR8",
            "Wonka Pixy Stix",
            "Wonka Bottle Caps",
            "White Bread",
            "Angel Food Cake",
            "Sorbet"
    };

    private static String[] ingredients_other = {
            "Whey Protein", // 71
            "Casein Protein", // 72
            "Peanut Butter", // 73
            "Clif Bar", // 74
            "Eggs", // 75
            "Egg Whites", // 76
            "Olive Oil",
            "Light Mayonaise", // 78
            "Jam"
    };
}
