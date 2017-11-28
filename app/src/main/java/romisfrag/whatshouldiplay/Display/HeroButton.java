package romisfrag.whatshouldiplay.Display;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.Button;

import romisfrag.whatshouldiplay.Enumerations.HeroClass;

/**
 * Created by 3364533 on 28/11/17.
 */

@SuppressLint("AppCompatCustomView")
public class HeroButton extends Button {

    private Drawable img;
    private Drawable selectedImg;
    private HeroClass hero;

    public HeroButton(Context context, Drawable img1, Drawable selectedImg, HeroClass hero) {
        super(context);
        this.img = img;
        this.img = selectedImg;
        this.hero = hero;
    }

    public HeroClass getHeroClass() {
        return hero;
    }
}
