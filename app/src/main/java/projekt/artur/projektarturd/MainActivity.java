package projekt.artur.projektarturd;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {


    @BindView(R.id.textView) TextView textView;
    @BindView(R.id.textViewS) TextView textViewS;
    @BindView(R.id.btnOne) Button btnOne;
    @BindView(R.id.btnTwo) Button btnTwo;
    @BindView(R.id.btnThree) Button btnThree;
    @BindView(R.id.btnFour) Button btnFour;
    @BindView(R.id.btnFive) Button btnFive;
    @BindView(R.id.btnSix) Button btnSix;
    @BindView(R.id.btnSeven) Button btnSeven;
    @BindView(R.id.btnEight) Button btnEight;
    @BindView(R.id.btnNine) Button btnNine;
    @BindView(R.id.btnZero) Button btnZero;
    @BindView(R.id.btnPlus) Button btnPlus;
    @BindView(R.id.btnMinus) Button btnMinus;
    @BindView(R.id.btnMulti) Button btnMulti;
    @BindView(R.id.btnDivide) Button btnDivide;
    @BindView(R.id.btnDot) Button btnDot;
    @BindView(R.id.btnClear) Button btnClear;
    @BindView(R.id.btnEqual) Button btnEqual;

    @OnClick(R.id.btnOne) public void btnOne() { Logic.number(btnOne, textView, textViewS); }
    @OnClick(R.id.btnTwo) public void btnTwo() { Logic.number(btnTwo, textView, textViewS); }
    @OnClick(R.id.btnThree) public void btnThree() { Logic.number(btnThree, textView, textViewS); }
    @OnClick(R.id.btnFour) public void btnFour() { Logic.number(btnFour, textView, textViewS); }
    @OnClick(R.id.btnFive) public void btnFive() { Logic.number(btnFive, textView, textViewS); }
    @OnClick(R.id.btnSix) public void btnSix() { Logic.number(btnSix, textView, textViewS); }
    @OnClick(R.id.btnSeven) public void btnSeven() { Logic.number(btnSeven, textView, textViewS); }
    @OnClick(R.id.btnEight) public void btnEight() { Logic.number(btnEight, textView, textViewS); }
    @OnClick(R.id.btnNine) public void btnNine() { Logic.number(btnNine, textView, textViewS); }

    @OnClick(R.id.btnPlus) public void btnPlus() { Logic.body (btnPlus, 1, textView, textViewS, btnMinus); }
    @OnClick(R.id.btnMinus) public void btnMinus() { Logic.body (btnMinus, 2, textView, textViewS, btnMinus); }
    @OnClick(R.id.btnMulti) public void btnMulti() { Logic.body (btnMulti, 3, textView, textViewS, btnMinus); }
    @OnClick(R.id.btnDivide) public void btnDivide() { Logic.body (btnDivide, 4, textView, textViewS, btnMinus); }

    @OnClick(R.id.btnZero) public void btnZero() { Logic.zeroO(btnZero, textView, textViewS); }
    @OnClick(R.id.btnClear) public void btnClear() { Logic.clear(textView, textViewS); }
    @OnClick(R.id.btnEqual) public void btnEqual() { Logic.equalL(textView, textViewS); }
    @OnClick(R.id.btnDot) public void btnDot() { Logic.btnDotT(textView, textViewS); }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

}
