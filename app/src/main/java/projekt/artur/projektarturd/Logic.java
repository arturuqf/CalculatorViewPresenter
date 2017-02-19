package projekt.artur.projektarturd;


import android.widget.Button;
import java.math.BigDecimal;



class Logic {
    
    
    private MainActivity mainActivity = new MainActivity();

    private double last, present, result;
    private boolean lastNumeric, lastDot, firstAction, isMinus, lastEq, lastZero;
    private int lastBtn;
    private int lenN = 0;
    private int op = 0;



    void zeroO() {
        
        if (lenN == 0) {

            if (op != 4) {
                number(mainActivity.btnZero);
                lastZero = true;
            }

        }
        else {

            if (lenN == 1) {
                if (!lastZero) number(mainActivity.btnZero);
                else if (lastDot) number(mainActivity.btnZero);
            }
            else number(mainActivity.btnZero);

        }
    }


    void clear() {

        mainActivity.textView.setText("");
        mainActivity.textViewS.setText("");
        targetZero();
        firstAction = false;
        lastEq = false;
        lastZero = false;
        lastBtn = 0;
        op = 0;
        last = 0;
        present = 0;
        result = 0;
    }


    void equalL() {

        if (firstAction) {
            if (lastNumeric) eqAct();
            else if (op != 0 && !lastDot) eqAct();
        }
    }


    void btnDotT() {

        if (!lastDot && !lastEq) {

            if (lastNumeric) {
                mainActivity.textView.append(".");
                mainActivity.textViewS.append(".");
                lastNumeric = false;
                lastDot = true;
                lastZero = false;
            }
        }
    }


    void number(Button c) {

        if (!lastEq) {

            if (lenN < 15) {

                if (lenN == 1) {

                    if (lastZero) {

                        mainActivity.textView.setText("");
                        mainActivity.textViewS.setText("");
                        numAction(c);
                    }
                    else numAction(c);
                }
                else numAction(c);
            }

        }

    }


    void body(Button a, int b) {


        if (lastNumeric) {

            if (firstAction) {
                if (lastEq) {
                    last = result;
                    lastEq = false;
                }
                else {
                    action();
                    lastEq = false;
                }
            }
            else {
                last = Double.parseDouble(mainActivity.textView.getText().toString());
                lastNumeric = false;
            }


            mainActivity.textViewS.setText("");
            mainActivity.textView.append(a.getText());
            op = b;
            lastBtn = b;
            targetZero();
            firstAction = true;

        }
        else if (!lastDot) {

            if (firstAction) {
                if (b != lastBtn) {
                    String tV = mainActivity.textView.getText().toString();
                    mainActivity.textView.setText(tV.substring(0, tV.length() - 1));
                    mainActivity.textView.append(a.getText());
                    lastBtn = b;
                }
            }
            else if (b == 2 && !isMinus) {
                mainActivity.textView.append(mainActivity.btnMinus.getText());
                isMinus = true;
            }

        }
    }



    private void eqAct() {

        action();
        lastEq = true;
    }


    private void targetZero() {

        lastNumeric = false;
        lastDot = false;
        isMinus = false;
        lenN = 0;
    }


    private void numAction(Button f) {

        mainActivity.textView.append(f.getText());
        mainActivity.textViewS.append(f.getText());
        lastNumeric = true;
        lenN++;
        lastZero = false;
    }


    private void calculator() {

        switch (op) {

            case 1:
                result = last + present;
                last = result;
                break;

            case 2:
                result = last - present;
                last = result;
                break;

            case 3:
                result = last * present;
                last = result;
                break;

            case 4:
                result = last / present;
                last = result;
                break;
        }
    }


    private void action() {

        present = Double.parseDouble(mainActivity.textViewS.getText().toString());
        calculator();

        if (result == 0) mainActivity.textView.setText("0");

        else {

            BigDecimal bigDec = new BigDecimal(result);
            String bigStr = bigDec.setScale(10, BigDecimal.ROUND_DOWN).toString();
            int ini = 9;

            while (bigStr.endsWith("0") && !bigStr.endsWith(".0") ) {

                bigStr = bigDec.setScale(ini, BigDecimal.ROUND_DOWN).toString();
                ini--;
            }

            if (bigStr.endsWith(".0")) bigStr = bigDec.setScale(ini, BigDecimal.ROUND_DOWN).toString();

            if (bigStr.length() > 15) { mainActivity.textView.setText(String.valueOf(result)); }
            else mainActivity.textView.setText(bigStr);
        }

        targetZero();
        lastNumeric = true;

    }


}

