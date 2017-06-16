package dongting.bwei.com.spannablestring;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView tv;
    private EditText et;

    public  static  int[] resId ={R.drawable.heng,R.drawable.kiss,R.drawable.wa};
    public  static String[] picArray = {"{heng}","{kiss}","{wa}"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        et = (EditText) findViewById(R.id.et);

       String content = "123456789";

       final SpannableString spannableString =new SpannableString(content);

        //背景色
        //spannableString.setSpan(new BackgroundColorSpan(Color.RED),0,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //前景色
        //spannableString.setSpan(new ForegroundColorSpan(Color.RED),0,5,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //下划线
        //spannableString.setSpan(new UnderlineSpan(),0,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //显示图片
        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
        drawable.setBounds(0,0,50,50);
        spannableString.setSpan
                (new ImageSpan(drawable),0,3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //加粗加倾斜
        //spannableString.setSpan(new StyleSpan(Typeface.BOLD_ITALIC),0,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //下标
        //spannableString.setSpan(new SubscriptSpan(),0,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //上标
        //spannableString.setSpan(new SuperscriptSpan(),3,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //超链接
        /*spannableString.setSpan(new URLSpan("http://www.baidu.com"),4,6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.setMovementMethod(new LinkMovementMethod());*/

        //
       /* final ClickableSpan clickableSpan =new ClickableSpan() {
            @Override
            public void onClick(View widget) {
            //点击会走的方法
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                //目标文字属性设置
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(false);//下划线。默认有
            }
        };
        spannableString.setSpan(clickableSpan,3,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        */

        tv.setText(spannableString);


//第四个参数讲解
       /* spannableString.setSpan
                (new BackgroundColorSpan(Color.GRAY),0,3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);*/

       /* spannableString.setSpan
                (new BackgroundColorSpan(Color.GRAY),0,3, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        et.setText(spannableString);*/


//图文混排
       /* String str ="{heng},{kiss},{wa}";
        tv.setText(toImageSpan(this,str,resId,picArray));*/
    }
    public static SpannableString toImageSpan(Context context,String content,int[] emoimag,String[] emotext){
       //包装
        SpannableString spannableString =new SpannableString(content);
        for (int i=0;i<emotext.length;i++){

            int startpo =0;
            String rep = emotext[i];
            int fromPos= 0;

            while((startpo = content.indexOf(rep,fromPos)) !=-1){

                fromPos =startpo + rep.length();

                Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),emoimag[i]);

                BitmapDrawable bitmapDrawable =new BitmapDrawable(bitmap);

                bitmapDrawable.setBounds(0,0,50,50);

                ImageSpan imageSpan =new ImageSpan(bitmapDrawable);
                spannableString.setSpan(imageSpan,startpo,fromPos,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        return spannableString;
    }
}
