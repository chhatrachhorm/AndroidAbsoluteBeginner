package chhatrachhorm.onenterpise.userinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class GridViewActivity extends AppCompatActivity {

    /**
     * Grid View
     * 1. include GridView in activity_grid_view.xml
     * 2. create an Adapter class (e.g. ImageAdapter or whatever name)
     *    as the source of items to display in grid by extends BaseView class
     * 3. .setOnItemClickListener is used to perform action corresponding to each item
     * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        // map grid view and it's adapter
        GridView mGridView = findViewById(R.id.gridview_gridview);
        mGridView.setAdapter(new ImageAdapter(GridViewActivity.this));
        // set onclick listener for each grid
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long i) {
                Toast.makeText(GridViewActivity.this, "You have just clicked on "+ position, Toast.LENGTH_LONG).show();

            }
        });


    }
}
