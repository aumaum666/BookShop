package comsci.kalin.bookshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class TypeBook extends AppCompatActivity {

    //Explicit
    ListView listView;
    private int[] ints = new int[]{R.drawable.a1, R.drawable.b2, R.drawable.c3};

    private String[] titleStrings, detailStrings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_book);

        //Intitial View

        listView = (ListView) findViewById(R.id.tyebook);
        //get value

        titleStrings = getResources().getStringArray(R.array.title);
        detailStrings = getResources().getStringArray(R.array.detail);

        Myadepter myadepter = new Myadepter(TypeBook.this,ints,titleStrings);

        listView.setAdapter(myadepter);

        //Active when click List View link go to detail
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //when click item anywhere It will keep that Position

                Intent intent = new Intent(TypeBook.this, Detail.class);
                intent.putExtra("Title", titleStrings[position]);
                intent.putExtra("Detail", detailStrings[position]);
                intent.putExtra("Image", ints[position]);
                startActivity(intent);

            }
        });
    }
    public void btnback (View view){
        finish();
    }
}
