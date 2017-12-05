package romisfrag.whatshouldiplay.GamePackage;

import android.app.Application;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.Toast;

import romisfrag.whatshouldiplay.ApplicationCustom;
import romisfrag.whatshouldiplay.Display.DisplayCards;
import romisfrag.whatshouldiplay.Display.HeroButton;
import romisfrag.whatshouldiplay.Enumerations.HeroClass;
import romisfrag.whatshouldiplay.Enumerations.Mode;
import romisfrag.whatshouldiplay.R;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static android.widget.Toast.LENGTH_SHORT;

public class ParameterMenu extends AppCompatActivity {

    //GameInstance game_instance;
    Mode mode = Mode.WILD;
    HeroClass heroClass = HeroClass.DRUID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parameter_menu_layout);

        final ApplicationCustom app = (ApplicationCustom)getApplication();

        //game_instance = new GameInstance(app.getAppCards(), );
//        Toast.makeText(app, "test : " + game_instance.get_listeCard().size(), Toast.LENGTH_SHORT).show();

        final Button validate = (Button)findViewById(R.id.parameter_validate_button);
        validate.setEnabled(false);

        //SECTION : generating the mode selection buttons

        LinearLayout hero_class_layout = (LinearLayout) findViewById(R.id.class_id_layout);

        HeroClass choice = null;
        Button current;
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);;
        LinearLayout newLine = null;
        int count = 0;

        for (HeroClass h : HeroClass.values()) {
            final HeroClass currentHero = h;
            if (count%3 == 0) {
                newLine = new LinearLayout(getApplicationContext());
                newLine.setLayoutParams(lp);
                newLine.setOrientation(LinearLayout.HORIZONTAL);
                hero_class_layout.addView(newLine);
            }
            current = new HeroButton(getApplicationContext(),
                                     getResources().getDrawable(R.drawable.warrior),
                                     getResources().getDrawable(R.drawable.warrior),
                                     currentHero);
            current.setText(h.toString());
            current.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    validate.setEnabled(true);
                    heroClass = currentHero;
                    Toast.makeText(app, currentHero.toString(), LENGTH_SHORT).show();
                }
            });
            newLine.addView(current);
            count++;
        }

        LinearLayout gameMode_l = (LinearLayout) findViewById(R.id.parameter_linear_game_mode);

        for(Mode m : Mode.values()){
            final Mode currentMode = m;
            //instanciation before looping
            current = new Button(getApplicationContext());
            lp = new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
            current.setText(currentMode.toString());
            current.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mode = currentMode;
                }
            });
//            switch(m){
//                case ARENA :
//                    current.setText("Arena");
//                    current.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            game_instance.set_game_mode(Mode.ARENA);
//                        }
//                    });
//                    break;
//                case STANDARD:
//                    current.setText("Standard");
//                    current.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            game_instance.set_game_mode(Mode.STANDARD);
//                        }
//                    });
//                    break;
//                case WILD:
//                    current.setText("Wild");
//                    current.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            game_instance.set_game_mode(Mode.WILD);
//                        }
//                    });
//                    break;
//            }
            current.setLayoutParams(lp);
            //adding the button to the layout
            gameMode_l.addView(current);
        }

        /*current = new Button(this);
        current.setText("Easy");
        gameMode_l.addView(current);
        */


        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameInstance game_instance = new GameInstance(app.getAppCards(), heroClass, mode);
                Intent i = new Intent(ParameterMenu.this,DisplayCards.class);
                i.putExtra("gameinstance", game_instance);
                startActivity(i);
            }
        });

    }



}
