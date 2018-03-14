package com.example.akjsn.hw1_marriage;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;

        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText sex, age;
    private TextView mTextR;
    public Button mBtnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sex = (EditText)findViewById(R.id.editGender);
        age = (EditText)findViewById(R.id.editAge);
        mTextR = (TextView)findViewById(R.id.suggestion);
        mBtnOK = (Button)findViewById(R.id.submit);
        mBtnOK.setOnClickListener(btnOKOnClick);


    }

    private View.OnClickListener btnOKOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String strSex = sex.getText().toString();
            int iAge = Integer.parseInt(age.getText().toString());

            String strSug = getString(R.string.result);
            if (strSex.equals(getString(R.string.sex_male)))
                if (iAge < 30)
                    strSug += getString(R.string.sug_not_hurry);
                else if (iAge > 35)
                    strSug += getString(R.string.sug_get_marry);
                else
                    strSug += getString(R.string.sug_find_couple);
            else
                if (iAge < 28)
                    strSug += getString(R.string.sug_not_hurry);
                else if (iAge > 32)
                    strSug += getString(R.string.sug_get_marry);
                else
                    strSug += getString(R.string.sug_find_couple);
            mTextR.setText(strSug);


        }
    };


}