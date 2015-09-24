package se.frand.app.dietplan;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import se.frand.app.dietplan.data.IngredientsContract;
import se.frand.app.dietplan.data.MealItemsContract;
import se.frand.app.dietplan.data.MealsDbHelper;

/**
 * Created by victorfrandsen on 9/24/15.
 */
public class IngredientsActivity extends ListActivity {
    private static final String LOG_TAG = IngredientsActivity.class.getSimpleName();

    long[] ids;
    SimpleCursorAdapter adapter;
    Cursor cursor;
    String query = "SELECT *" +
            " FROM " + IngredientsContract.IngredientsEntry.TABLE_NAME + " AS I" +
            " INNER JOIN " + MealItemsContract.MealItemEntry.TABLE_NAME + " AS M" +
            " ON I." + IngredientsContract.IngredientsEntry._ID +
            "=M." + MealItemsContract.MealItemEntry.COL_NAME_INGREDIENT_ID +
            " WHERE M." + MealItemsContract.MealItemEntry.COL_NAME_MEAL_ID + "=?";
    String meal_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meal_items_layout);

        SQLiteDatabase db = openOrCreateDatabase(MealsDbHelper.DATABASE_NAME,0,null);

        String[] from = {
                IngredientsContract.IngredientsEntry.COL_NAME_NAME,
                IngredientsContract.IngredientsEntry.COL_NAME_CAT_ID,
                MealItemsContract.MealItemEntry.COL_NAME_ID
        };
        int[] to = {R.id.ingredient_label,R.id.category,R.id.meal_item_id};


        meal_id = "" +getIntent().getExtras().getInt(MealItemsContract.MealItemEntry.COL_NAME_MEAL_ID);


        cursor = db.rawQuery(query, new String[]{meal_id});
        adapter = new SimpleCursorAdapter(this,R.layout.meal_item_item,cursor,from,to,0);
        setListAdapter(adapter);

        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, final View view, int position, long id) {

                //open the list dialog

                RelativeLayout layout = (RelativeLayout) view;
                TextView v = (TextView) layout.findViewById(R.id.category);
                String category = ""+v.getText();
                if(v.length() == 0)
                    return false;


                SQLiteDatabase db = openOrCreateDatabase(MealsDbHelper.DATABASE_NAME,0,null);
                Cursor c = db.query(
                        IngredientsContract.IngredientsEntry.TABLE_NAME,
                        new String[] {IngredientsContract.IngredientsEntry.COL_NAME_NAME,
                                IngredientsContract.IngredientsEntry.COL_NAME_ID},
                        IngredientsContract.IngredientsEntry.COL_NAME_CAT_ID+"=?",
                        new String[] {category},
                        null,
                        null,
                        null);
                int cnt = c.getCount();
                String[] ingredients = new String[cnt];
                ids = new long[cnt];
                c.moveToFirst();
                for(int i=0;i<ingredients.length;i++) {
                    ingredients[i] = c.getString(c.getColumnIndex(IngredientsContract.IngredientsEntry.COL_NAME_NAME));
                    ids[i] = c.getLong(c.getColumnIndex(IngredientsContract.IngredientsEntry.COL_NAME_ID));
                    c.move(1);
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(IngredientsActivity.this);
                builder.setTitle(R.string.pick_replace)
                        .setItems(ingredients, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int position) {
                                String mealitemid = ""+((TextView) view.findViewById(R.id.meal_item_id)).getText();
                                SQLiteDatabase db = openOrCreateDatabase(MealsDbHelper.DATABASE_NAME,0,null);
                                ContentValues values = new ContentValues();
                                values.put(MealItemsContract.MealItemEntry.COL_NAME_INGREDIENT_ID, ids[position]);
                                int rows = db.update(MealItemsContract.MealItemEntry.TABLE_NAME,
                                        values,
                                        MealItemsContract.MealItemEntry.COL_NAME_ID+"=?",
                                        new String[] {mealitemid});

                                cursor = db.rawQuery(query, new String[]{meal_id});
                                adapter.swapCursor(cursor);

                                db.close();
                            }
                        });
                builder.show();

                db.close();
                return true;
            }
        });

        db.close();
    }
}
