package appmoviles.com.holamundo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView register;
    private Button login;
    private EditText user,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("LifeCycle","onCreate");
        register = (TextView) findViewById(R.id.TVRegister);
        login = (Button) findViewById(R.id.BTLogIn);
        user = (EditText) findViewById(R.id.ETUserName);
        password = (EditText) findViewById(R.id.ETPassword);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Profile.class);
                i.putExtra("name",user.getText().toString());
                i.putExtra("password",password.getText().toString());
                startActivity(i);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Register.class);
                startActivity(i);


            }
        });

    }

    @Override
    protected void onPause() {
        Log.e("LifeCycle","onPause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.e("LifeCycle","onResume");
        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.e("LifeCycle","onResume");
        super.onStart();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this).setTitle("Salir").setMessage("Desea salir?").setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.super.onBackPressed();
            }
        });
        builder.show();
    }
}
