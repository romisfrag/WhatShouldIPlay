package romisfrag.whatshouldiplay.GamePackage;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.IOException;
import java.io.InputStream;

import romisfrag.whatshouldiplay.ApplicationCustom;
import romisfrag.whatshouldiplay.Display.DisplayCards;
import romisfrag.whatshouldiplay.Display.CustomButton;
import romisfrag.whatshouldiplay.Enumerations.HeroClass;
import romisfrag.whatshouldiplay.Enumerations.Mode;
import romisfrag.whatshouldiplay.R;
import romisfrag.whatshouldiplay.sortList.Filters;

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
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(WRAP_CONTENT,
                WRAP_CONTENT/*(int)getResources().getDimension(R.dimen.linearOptionMenuHeight)*/);;
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

                // get input stream
                //InputStream ims1 = getAssets().open(h.toString().toLowerCase()+".png");
                //InputStream ims2 = getAssets().open(h.toString().toLowerCase()+"_s.png");
                // load image as Drawable
                int res_img = getResources().getIdentifier(h.toString().toLowerCase(),"drawable",getPackageName());
                int res_img_s = getResources().getIdentifier(h.toString().toLowerCase()+"_s",
                        "drawable",getPackageName());

                // set image to ImageView
                //heroButton = new CustomButton(getApplicationContext(),d1,d2,
                 //       currentHero);
                heroButton = new CustomButton(getApplicationContext(),
                        getResources().getDrawable(res_img),
                        getResources().getDrawable(res_img_s),
                        currentHero);


            heroButton.setImageDrawable(heroButton.getImg());

            LinearLayout.LayoutParams param =
                    new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1);
            heroButton.setLayoutParams(param);
            heroButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
            heroButton.setBackgroundColor(0);
            heroButton.setAdjustViewBounds(true);

            final ImageButton finalCurrent1 = heroButton;
            heroButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //heroButton.setEnabled(true);
                    heroButton.setImageDrawable(heroButton.getImg());
                    heroButton = (CustomButton) finalCurrent1;
                    //finalCurrent1.setEnabled(false);
                    finalCurrent1.setImageDrawable(((CustomButton) finalCurrent1).getSelectedImg());
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
                GameInstance game_instance = new GameInstance(app.getAppCards(), heroClass, mode,new Filters(heroClass,mode));
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
