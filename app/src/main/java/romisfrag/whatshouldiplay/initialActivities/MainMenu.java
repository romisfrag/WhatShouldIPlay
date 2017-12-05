package romisfrag.whatshouldiplay.initialActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import romisfrag.whatshouldiplay.ApplicationCustom;
import romisfrag.whatshouldiplay.GamePackage.ParameterMenu;
import romisfrag.whatshouldiplay.Interfaces.UseRequester;
import romisfrag.whatshouldiplay.R;

public class MainMenu extends AppCompatActivity implements UseRequester{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_layout);

        final ApplicationCustom app = (ApplicationCustom)getApplication();


        Button game_instance_button = (Button)findViewById(R.id.GameInstanceButton);
        game_instance_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, ParameterMenu.class);
                startActivity(intent);
            }
        });

        Button update_button = (Button)findViewById(R.id.updateButton);
        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        //gold mode CheckBox
        CheckBox goldMode = (CheckBox)findViewById(R.id.goldModeCheckBox);
        goldMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                app.switchGoldMode();
            }
        });

    }

    @Override
    public void notifyEndRequest() {

    }
}
