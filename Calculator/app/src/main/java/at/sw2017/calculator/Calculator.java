package at.sw2017.calculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Calculator extends Activity implements View.OnClickListener {
    ArrayList<Button> numberButtons;
    TextView          numberView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        numberButtons = new ArrayList<Button>();

        setContentView(R.layout.activity_calculator);

        setUpNumberButtonListener();

        Button buttonAdd = (Button)findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(this);
        Button buttonSub = (Button)findViewById(R.id.buttonSub);
        buttonSub.setOnClickListener(this);
        Button buttonMul = (Button)findViewById(R.id.buttonMul);
        buttonMul.setOnClickListener(this);
        Button buttonDiv = (Button)findViewById(R.id.buttonDiv);
        buttonDiv.setOnClickListener(this);

        Button buttonEqual = (Button)findViewById(R.id.buttonDiv);
        buttonEqual.setOnClickListener(this);
        Button buttonClear = (Button)findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(this);

        numberView = (TextView)findViewById(R.id.textView);
    }

    public void setUpNumberButtonListener() {
        for (int i = 0; i <= 9; i++) {
            String buttonName = "button" + i;

            int id = getResources().getIdentifier(buttonName, "id",
                    R.class.getPackage().getName());
            Button button = (Button)findViewById(id);
            button.setOnClickListener(this);
            numberButtons.add(button);
        }
    }

    @Override
    public void onClick(View v) {
        Button clickButton = (Button) v;

        switch (clickButton.getId()) {
            case R.id.buttonAdd:
                break;
            case R.id.buttonSub:
                break;
            case R.id.buttonMul:
                break;
            case R.id.buttonDiv:
                break;
            case R.id.buttonEqual:
                break;
            case R.id.buttonClear:
                clearTextView();
                break;
            default:
                String recentNumber = numberView.getText().toString();
                if (recentNumber.equals("0")) {
                    recentNumber = "";
                }
                recentNumber += clickButton.getText().toString();
                numberView.setText(recentNumber);
                break;
        }
    }

    public void clearTextView() {
        numberView.setText("0");
    }
}
