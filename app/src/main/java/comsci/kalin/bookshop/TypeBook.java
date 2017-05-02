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
    private int[] ints = new int[]{R.drawable.op, R.drawable.toe,R.drawable.net,R.drawable.know};

    private String[] titleStrings, detailStrings,shorts,price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_book);

        //Intitial View

        listView = (ListView) findViewById(R.id.tyebook);
        //get value

        titleStrings = getResources().getStringArray(R.array.title);
        detailStrings = getResources().getStringArray(R.array.detail);
        shorts = getResources().getStringArray(R.array.shorts);
        price = getResources().getStringArray(R.array.price);



        //create ListView

        Myadepter myAdepter = new Myadepter(TypeBook.this, ints, titleStrings,shorts );
        listView.setAdapter(myAdepter);

        //Active when click List View link go to detail

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //when click item anywhere It will keep that Position

                Intent intent = new Intent(TypeBook.this, Detail.class);
                intent.putExtra("Title", titleStrings[position]);
                intent.putExtra("Detail", detailStrings[position]);
                intent.putExtra("Image", ints[position]);
                intent.putExtra("Price",ints[position]);
                startActivity(intent);

            }
        });
    }
    public void btnback (View view){
        finish();
    }
}
