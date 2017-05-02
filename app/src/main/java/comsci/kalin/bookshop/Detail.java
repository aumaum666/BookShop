package comsci.kalin.bookshop;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {
    Button btn2;
    int num = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Intitial View   ผูด View ที่หน้า UI with ตัวแปร จาวา
        TextView titleTextView = (TextView) findViewById(R.id.txtTitleDetail);
        TextView detailTextView = (TextView) findViewById(R.id.txtDetailScroll);
        ImageView ImageView = (ImageView) findViewById(R.id.imvImageDetail);



        //show data from MainActivity (get information from Maninactivity to show on detail)

        titleTextView.setText(getIntent().getStringExtra("Title"));
        detailTextView.setText(getIntent().getStringExtra("Detail"));
        ImageView.setImageResource(getIntent().getIntExtra("Image",R.drawable.op));



        btn2 = (Button) findViewById(R.id.btnbuy);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num++;

            }
        });

    } // Main Method
    public void clickBack(View view ){
        finish();
    }

    public void onClickShop (View view) {
        Intent intent = new Intent(Detail.this, Shop.class);
        startActivity(intent);
    }




}  //Main Class
