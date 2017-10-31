package romisfrag.whatshouldiplay.GamePackage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;

import romisfrag.whatshouldiplay.Display.DisplayCards;
import romisfrag.whatshouldiplay.Enumerations.Mode;
import romisfrag.whatshouldiplay.R;

public class ParameterMenu extends AppCompatActivity {

    GameInstance game_instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parameter_menu_layout);

        game_instance = new GameInstance();

        //SECTION : generating the mode selection buttons


        LinearLayout gameMode_l = (LinearLayout) findViewById(R.id.parameter_linear_game_mode);


        LinearLayout.LayoutParams lp;
        Button current;
        for(Mode m : Mode.values()){
            //instanciation before looping
            current = new Button(getApplicationContext());
            lp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            switch(m){
                case ARENA :
                    current.setText("Arena");
                    current.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            game_instance.set_game_mode(Mode.ARENA);
                        }
                    });
                    break;
                case STANDARD:
                    current.setText("Standard");
                    current.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            game_instance.set_game_mode(Mode.STANDARD);
                        }
                    });
                    break;
                case WILD:
                    current.setText("Wild");
                    current.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            game_instance.set_game_mode(Mode.WILD);
                        }
                    });
                    break;
            }

            current.setLayoutParams(lp);
            //adding the button to the layout
            gameMode_l.addView(current);
        }

        /*current = new Button(this);
        current.setText("Easy");
        gameMode_l.addView(current);
        */


        Button validate = (Button)findViewById(R.id.parameter_validate_button);
        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ParameterMenu.this,DisplayCards.class);
                i.putExtra("gameinstance", game_instance);
                startActivity(i);
            }
        });

    }



}
