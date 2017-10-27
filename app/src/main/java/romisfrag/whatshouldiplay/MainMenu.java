package romisfrag.whatshouldiplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import romisfrag.whatshouldiplay.GamePackage.ParameterMenu;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_layout);

        Button game_instance_button = (Button)findViewById(R.id.GameInstanceButton);
        game_instance_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, ParameterMenu.class);
                startActivity(intent);
            }
        });

    }
}
