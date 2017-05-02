package comsci.kalin.bookshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Shop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        TextView titlename = (TextView) findViewById(R.id.textView5);
        ImageView ImageView = (ImageView) findViewById(R.id.imageView);

        titlename.setText(getIntent().getStringExtra("Title"));
        ImageView.setImageResource(getIntent().getIntExtra("Image",R.drawable.op));

    }

    public void clickBack2(View view ){
        Toast.makeText(getApplicationContext(), "Order Complete", Toast.LENGTH_LONG).show();
        finish();
    }
}
