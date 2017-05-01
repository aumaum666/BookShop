package comsci.kalin.bookshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private UserTABLE objUserTABLE;
    private BookTABLE objBookTABLE;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectedSQLite();
        //testAddValue();

    }

    private void connectedSQLite(){
        objBookTABLE = new BookTABLE(this);
        objUserTABLE = new UserTABLE(this);
    }
    /*private void testAddValue(){
        objUserTABLE.addNewUser("testUser","testPass","testName","testAddress");
        objBookTABLE.addNewBook("testBook","testType","testPrice");
    }*/
}
