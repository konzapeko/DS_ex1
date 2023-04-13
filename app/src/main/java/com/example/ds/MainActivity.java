package com.example.ds;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText _txtTaille, _txtPoids, _txtAge;
    TextView _txtView, _txtView2,_txtView3,_Iblresultat,_IblInterpretation;
    Button _btncalculimg;
    RadioButton _rdbHomme, _rdbFemme;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _txtTaille = (EditText)findViewById(R.id.txtTaille);
        _txtPoids = (EditText)findViewById(R.id.txtpoids);
        _txtAge = (EditText)findViewById(R.id.txtAge);

        _rdbHomme =(RadioButton)findViewById(R.id.rdbhomme);
        _rdbFemme =(RadioButton)findViewById(R.id.rdbfemme);
        _btncalculimg =(Button)findViewById(R.id.btncalculerimg);

        _Iblresultat=(TextView)findViewById(R.id.lblResultat);
        _IblInterpretation=(TextView)findViewById(R.id.lblInterpretationModule);

        _btncalculimg.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                float imc;
                float img;
                imc = Float.parseFloat(_txtPoids.getText().toString()) / ((Float.parseFloat(_txtTaille.getText().toString())/100) * (Float.parseFloat(_txtTaille.getText().toString())/100));
                if (Float.parseFloat(_txtAge.getText().toString()) >= 16)
                {
                    if (_rdbHomme.isChecked())
                        {
                        img = (float) ((1.20 * imc) + (0.23 * Float.parseFloat(_txtAge.getText().toString())) - (10.8 * 1) - 5.4);
                            _Iblresultat.setText(String.valueOf(img));
                            if (img<15)
                            {
                                _IblInterpretation.setText("trop maigre");
                            }
                            else if (img>20)
                            {
                                _IblInterpretation.setText("trop de graisse");
                            } else
                            {
                                _IblInterpretation.setText("taux normale");
                            }
                        }
                        else
                            {
                            img = (float) ((1.51 * imc) + (0.23 * Float.parseFloat(_txtAge.getText().toString())) - (10.8 * 0) - 5.4);
                                _Iblresultat.setText(String.valueOf(img));
                                if (img<15)
                                {
                                    _IblInterpretation.setText("trop maigre");
                                }
                                else if (img>20)
                                {
                                    _IblInterpretation.setText("trop de graisse");
                                } else
                                {
                                    _IblInterpretation.setText("taux normale");
                                }
                            }
                }
                else
                {
                    if (_rdbFemme.isChecked())
                        {
                        img = (float) ((1.51 * imc) + (0.70 * Float.parseFloat(_txtAge.getText().toString())) - (3.6 * 0) - 1.4);
                            _Iblresultat.setText(String.valueOf(img));
                            if (img<25)
                            {
                                _IblInterpretation.setText("trop maigre");
                            }
                            else if (img>30)
                            {
                                _IblInterpretation.setText("trop de graisse");
                            } else
                            {
                                _IblInterpretation.setText("taux normale");
                            }
                        }
                        else
                        {
                        img = (float) ((1.51 * imc) + (0.70 * Float.parseFloat(_txtAge.getText().toString())) - (3.6 * 1) - 1.4);
                            _Iblresultat.setText(String.valueOf(img));
                            if (img<25)
                            {
                                _IblInterpretation.setText("trop maigre");
                            }
                            else if (img>30)
                            {
                                _IblInterpretation.setText("trop de graisse");
                            } else
                            {
                                _IblInterpretation.setText("taux normale");
                            }
                        }
                }

            }
        });


    }
}