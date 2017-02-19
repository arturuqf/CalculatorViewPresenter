package projekt.artur.projektarturd;


import android.widget.Button;
import android.widget.TextView;
import java.math.BigDecimal;



class Logic {


    private static double last, present, result;
    private static boolean lastNumeric, lastDot, firstAction, isMinus, lastEq, lastZero;
    private static int lastBtn;
    private static int lenN = 0;
    private static int op = 0;



    void zeroO(Button btnZero, TextView textView, TextView textViewS) {

        if (lenN == 0) {

            if (op != 4) {
                number(btnZero, textView, textViewS);
                lastZero = true;
            }

        }
        else {

            if (lenN == 1) {
                if (!lastZero) number(btnZero, textView, textViewS);
                else if (lastDot) number(btnZero, textView, textViewS);
            }
            else number(btnZero, textView, textViewS);

        }
    }


    void clear(TextView textView, TextView textViewS) {

        textView.setText("");
        textViewS.setText("");
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


     void equalL(TextView textView, TextView textViewS) {

        if (firstAction) {
            if (lastNumeric) eqAct(textView, textViewS);
            else if (op != 0 && !lastDot) eqAct(textView, textViewS);
        }
    }


    void btnDotT(TextView textView, TextView textViewS) {

        if (!lastDot && !lastEq) {

            if (lastNumeric) {
                textView.append(".");
                textViewS.append(".");
                lastNumeric = false;
                lastDot = true;
                lastZero = false;
            }
        }
    }


     void number(Button c, TextView textView, TextView textViewS) {

        if (!lastEq) {

            if (lenN < 15) {

                if (lenN == 1) {

                    if (lastZero) {

                        textView.setText("");
                        textViewS.setText("");
                        numAction(c, textView, textViewS);
                    }
                    else numAction(c, textView, textViewS);
                }
                else numAction(c, textView, textViewS);
            }

        }

    }


    void body(Button a, int b, TextView textView, TextView textViewS, Button btnMinus) {


        if (lastNumeric) {

            if (firstAction) {
                if (lastEq) {
                    last = result;
                    lastEq = false;
                }
                else {
                    action(textView, textViewS);
                    lastEq = false;
                }
            }
            else {
                last = Double.parseDouble(textView.getText().toString());
                lastNumeric = false;
            }


            textViewS.setText("");
            textView.append(a.getText());
            op = b;
            lastBtn = b;
            targetZero();
            firstAction = true;

        }
        else if (!lastDot) {

            if (firstAction) {
                if (b != lastBtn) {
                    String tV = textView.getText().toString();
                    textView.setText(tV.substring(0, tV.length() - 1));
                    textView.append(a.getText());
                    lastBtn = b;
                }
            }
            else if (b == 2 && !isMinus) {
                textView.append(btnMinus.getText());
                isMinus = true;
            }

        }
    }



    private void eqAct(TextView textView, TextView textViewS) {

        action(textView, textViewS);
        lastEq = true;
    }


    private void targetZero() {

        lastNumeric = false;
        lastDot = false;
        isMinus = false;
        lenN = 0;
    }


    private void numAction(Button f, TextView textView, TextView textViewS) {

        textView.append(f.getText());
        textViewS.append(f.getText());
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


    private void action(TextView textView, TextView textViewS) {

        present = Double.parseDouble(textViewS.getText().toString());
        calculator();

        if (result == 0) textView.setText("0");

        else {

            BigDecimal bigDec = new BigDecimal(result);
            String bigStr = bigDec.setScale(10, BigDecimal.ROUND_DOWN).toString();
            int ini = 9;

            while (bigStr.endsWith("0") && !bigStr.endsWith(".0") ) {

                bigStr = bigDec.setScale(ini, BigDecimal.ROUND_DOWN).toString();
                ini--;
            }

            if (bigStr.endsWith(".0")) bigStr = bigDec.setScale(ini, BigDecimal.ROUND_DOWN).toString();

            if (bigStr.length() > 15) { textView.setText(String.valueOf(result)); }
            else textView.setText(bigStr);
        }

        targetZero();
        lastNumeric = true;

    }


}

