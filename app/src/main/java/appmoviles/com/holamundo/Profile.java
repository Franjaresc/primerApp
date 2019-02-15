package appmoviles.com.holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

public class Profile extends AppCompatActivity {

    private RelativeLayout root_profile;
    private Button BTExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        BTExit = (Button) findViewById(R.id.BTExit);
        root_profile = (RelativeLayout) findViewById(R.id.profile_root);

        root_profile.setOnTouchListener(new View.OnTouchListener() {
            float Xini = 0;
            float Yini = 0;

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Xini = event.getX();
                        Yini = event.getY();
                        BTExit.setText("DOWN: "+ event.getX() + " , " + event.getY());
                        break;

                    case MotionEvent.ACTION_MOVE:
                        BTExit.setText("MOVE: "+ event.getX() + " , " + event.getY());
                        break;

                    case MotionEvent.ACTION_UP:
                        float deltaX = event.getX()-Xini;
                        if (deltaX>500){
                            Intent i = new Intent(Profile.this, MainProfile.class);
                            startActivity(i);
                        }
                        else if(deltaX<-500){

                            finish();
                        }
                        BTExit.setText("UP : "+ event.getX() + " , " + event.getY());

                }
                return true;
            }
        });


        Intent datos = getIntent();
        String name = datos.getExtras().getString("Name");
        String password = datos.getExtras().getString("password");
        Toast.makeText(Profile.this,name+password, Toast.LENGTH_LONG).show();

    }


}
