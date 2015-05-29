package mytoastapp.com.myapptoast;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private final static String LOG_TAG = MainActivity.class
            .getCanonicalName();

    private  Button button2, button3, button4, button5, button6, button7;
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //standard
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);


        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);

        //using butterknife librairy
        ButterKnife.inject(this);
    }

    //it repeated but it works
    // http://stackoverflow.com/questions/3795439/one-onclickhandler-for-multiple-buttons
    @Override
    public void onClick(View v) {
        mToast = Toast.makeText( this  , "" , Toast.LENGTH_SHORT );
        switch(v.getId()) {
            case R.id.button2:
                // do a Toast;
                mToast.setText(button2.getText().toString() );
                mToast.show();
                break;
            case R.id.button3:
                // do stuff;
                mToast.setText(button3.getText().toString() );
                mToast.show();
                break;
            case R.id.button4:
                mToast.setText(button4.getText().toString() );
                mToast.show();
                break;
            case R.id.button5:
                mToast.setText(button5.getText().toString() );
                mToast.show();
                break;
            case R.id.button6:
                mToast.setText(button6.getText().toString() );
                mToast.show();
                break;
            case R.id.button7:
                mToast.setText(button7.getText().toString());
                mToast.show();
                break;
        }
    }


    //using butterknife librairy
    @InjectView(R.id.button8)
    protected Button btn8;

    @OnClick(R.id.button8)
    public void button1_theCat(){
        Toast.makeText(
                getApplicationContext(),
                btn8.getText().toString(),
                Toast.LENGTH_SHORT).show();
    }
    /************/

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
