package se.frand.app.dietplan;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleCursorAdapter;

import se.frand.app.dietplan.data.MealItemsContract;
import se.frand.app.dietplan.data.MealsContract;
import se.frand.app.dietplan.data.MealsDbHelper;


public class MainActivity extends ListActivity {

    SimpleCursorAdapter adapter;
    MealsDbHelper mDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new MealsDbHelper(this);

        String[] from = {
                MealsContract.MealEntry.COL_NAME_NAME
        };
        int[] to = {
                R.id.meal_label
        };
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        Cursor res = db.query(
                MealsContract.MealEntry.TABLE_NAME,
                new String[] {MealsContract.MealEntry.COL_NAME_ID, MealsContract.MealEntry.COL_NAME_NAME},
                null,
                null,
                null,
                null,
                null
        );
        adapter = new SimpleCursorAdapter(this,R.layout.meal_item,res,from,to,0);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // open another activity and send the meal position number as extra or arg
                Intent intent = new Intent(MainActivity.this, IngredientsActivity.class);
                intent.putExtra(MealItemsContract.MealItemEntry.COL_NAME_MEAL_ID,position);
                startActivity(intent);
            }
        });
        db.close();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
