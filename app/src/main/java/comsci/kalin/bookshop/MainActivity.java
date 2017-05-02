package comsci.kalin.bookshop;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.Menu;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private UserTABLE objUserTABLE;
    private BookTABLE objBookTABLE;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectedSQLite();
        //testAddValue();
        //synJSONtoSQLite();

    }

    private void connectedSQLite(){
        objBookTABLE = new BookTABLE(this);
        objUserTABLE = new UserTABLE(this);
    }
    /*private void testAddValue(){
        objUserTABLE.addNewUser("testUser","testPass","testName","testAddress");
        objBookTABLE.addNewBook("testBook","testType","testPrice");
    }*/

    /*private void synJSONtoSQLite(){
        StrictMode.ThreadPolicy myPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(myPolicy);

        int intTimes = 0;
        while (intTimes <= 1){

            InputStream objInputStream = null ;
            String strJSON = null ;
            String strUserURL = "";
            String strBookURL = "";
            HttpPost objHttpPost;

            try{
                HttpClient objHttpClient = new DefaultHttpClient();
                switch (intTimes){
                    case 0:
                        objHttpPost = new HttpPost(strUserURL);
                        break;
                    default:
                        objHttpPost = new HttpPost(strBookURL);
                        break;
                }
                HttpResponse objHttpResponse = objHttpClient.execute(objHttpPost);
                HttpEntity objHttpEntity = objHttpResponse.getEntity();
                objInputStream = objHttpEntity.getContent();
            }catch(Exception e){
                Log.d("masterUNG", "InputStream ==> " + e.toString());
            }

            try{
                BufferedReader objBufferedReader = new BufferedReader(new InputStreamReader(objInputStream, "UTF-8"));
                StringBuilder objStringBuilder = new StringBuilder();
                String strLine = null;
                while ((strLine = objBufferedReader.readLine()) !=null){
                    objStringBuilder.append(strLine);
                }
                objInputStream.close();
                strJSON = objStringBuilder.toString();
            }catch (Exception e){
                Log.d("masterUNG", "strJSON ==> " + e.toString());
            }

            try{
                JSONArray objJsonArray = new JSONArray(strJSON);
                for (int i = 0; i < objJsonArray.length();i++){
                    JSONObject jsonObject = objJsonArray.getJSONObject(i);
                    switch (intTimes){
                        case 0:
                            String strUser = jsonObject.getString("User");
                            String strPassword = jsonObject.getString("Password");
                            String strName = jsonObject.getString("Name");
                            String strAddress = jsonObject.getString("Address");
                            objUserTABLE.addNewUser(strUser, strPassword, strName, strAddress);
                            break;
                        default:
                            String strBook = jsonObject.getString("BookName");
                            String strType = jsonObject.getString("BookType");
                            String strSource = jsonObject.getString("BookSource");
                            String strPrice = jsonObject.getString("BookPrice");

                            objBookTABLE.addNewBook(strBook, strType, strSource, strPrice);
                            break;
                    }
                }
            }catch (Exception e){
                Log.d("masterUNG", "Update SQLite ==> " + e.toString());
            }

            intTimes +=1;
        }
    }*/
}
