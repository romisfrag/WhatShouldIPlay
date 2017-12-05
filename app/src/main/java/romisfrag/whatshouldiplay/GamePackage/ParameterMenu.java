package romisfrag.whatshouldiplay.GamePackage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import romisfrag.whatshouldiplay.ApplicationCustom;
import romisfrag.whatshouldiplay.Display.DisplayCards;
import romisfrag.whatshouldiplay.Display.CustomButton;
import romisfrag.whatshouldiplay.Enumerations.HeroClass;
import romisfrag.whatshouldiplay.Enumerations.Mode;
import romisfrag.whatshouldiplay.R;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class ParameterMenu extends AppCompatActivity {

    //GameInstance game_instance;
    Mode mode = Mode.WILD;
    HeroClass heroClass = HeroClass.DRUID;
    boolean heroSet = false;
    boolean modeSet = false;

    CustomButton heroButton = null;
    Button modeButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parameter_menu_layout);

        final ApplicationCustom app = (ApplicationCustom)getApplication();


        final Button validate = (Button)findViewById(R.id.parameter_validate_button);
        validate.setEnabled(false);

        //SECTION : generating the mode selection buttons

        LinearLayout hero_class_layout = (LinearLayout) findViewById(R.id.class_id_layout);

        HeroClass choice = null;
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);;
        LinearLayout newLine = null;
        int count = 0;

        for (HeroClass h : HeroClass.values()) {
            if (h.equals(HeroClass.NEUTRAL))
                continue;
            final HeroClass currentHero = h;
            if (count%3 == 0) {
                newLine = new LinearLayout(getApplicationContext());
                newLine.setLayoutParams(lp);
                newLine.setOrientation(LinearLayout.HORIZONTAL);
                hero_class_layout.addView(newLine);
            }
            heroButton = new CustomButton(getApplicationContext(),
                                     getResources().getDrawable(R.drawable.warrior),
                                     getResources().getDrawable(R.drawable.warrior),
                                     currentHero);
            heroButton.setText(h.toString());
            final Button finalCurrent1 = heroButton;
            heroButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    heroButton.setEnabled(true);
                    heroButton = (CustomButton) finalCurrent1;
                    finalCurrent1.setEnabled(false);
                    heroSet = true;
                    validate.setEnabled(heroSet && modeSet);
                    heroClass = currentHero;
                }
            });
            newLine.addView(heroButton);
            count++;
        }

        LinearLayout gameMode_l = (LinearLayout) findViewById(R.id.parameter_linear_game_mode);

        for(Mode m : Mode.values()){
            final Mode currentMode = m;
            //instanciation before looping
            modeButton = new Button(getApplicationContext());
            lp = new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
            modeButton.setText(currentMode.toString());
            final Button finalCurrent = modeButton;
            modeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    modeButton.setEnabled(true);
                    modeButton = finalCurrent;
                    finalCurrent.setEnabled(false);
                    modeSet = true;
                    validate.setEnabled(heroSet && modeSet);
                    mode = currentMode;
                }
            });
            modeButton.setLayoutParams(lp);
            //adding the button to the layout
            gameMode_l.addView(modeButton);
        }

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

    @Override
    protected void onResume() {
        super.onResume();
        final Button validate = (Button)findViewById(R.id.parameter_validate_button);
        validate.setEnabled(false);
        modeSet = false;
        heroSet = false;
        modeButton.setEnabled(true);
        heroButton.setEnabled(true);
    }



}
