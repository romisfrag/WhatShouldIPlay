package romisfrag.whatshouldiplay.Display;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.Button;
import android.widget.ImageButton;

import romisfrag.whatshouldiplay.Enumerations.HeroClass;

/**
 * Created by 3364533 on 28/11/17.
 */

@SuppressLint("AppCompatCustomView")
public class CustomButton extends ImageButton {

    private Drawable img;
    private Drawable selectedImg;
    private HeroClass hero;

    public CustomButton(Context context, Drawable img1, Drawable selectedImg, HeroClass hero) {
        super(context);
        this.img = img1;
        this.selectedImg = selectedImg;
        this.hero = hero;
    }

    public HeroClass getHeroClass() {
        return hero;
    }
    public Drawable getImg(){ return img; }
    public Drawable getSelectedImg() {return selectedImg;}
}
