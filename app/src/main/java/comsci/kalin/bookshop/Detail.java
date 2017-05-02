package comsci.kalin.bookshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Intitial View   ผูด View ที่หน้า UI with ตัวแปร จาวา
        TextView titleTextView = (TextView) findViewById(R.id.txtTitleDetail);
        TextView detailTextView = (TextView) findViewById(R.id.txtDetailScroll);
        ImageView ImageView = (ImageView) findViewById(R.id.imvImageDetail);
        Button Button = (Button) findViewById(R.id.btnback);

        //show data from MainActivity (get information from Maninactivity to show on detail)

        titleTextView.setText(getIntent().getStringExtra("Title"));
        detailTextView.setText(getIntent().getStringExtra("Detail"));
        ImageView.setImageResource(getIntent().getIntExtra("Image",R.drawable.a1));

    } // Main Method
    public void clickBack(View view ){
        finish();


    }


}  //Main Class
