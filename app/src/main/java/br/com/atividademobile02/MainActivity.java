package br.com.atividademobile02;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.text.NumberFormat;



public class MainActivity extends AppCompatActivity {

    private static final NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();

    private TextView priceGasTextview;
    private TextView priceEtanolTextView;
    private TextInputEditText resultTextInput;
    private ImageView imageView;

    private double valueGas = 500.0;
    private double valueEtanol = 500.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        priceGasTextview =
                findViewById(R.id.priceGasTextview);
        priceEtanolTextView =
                findViewById(R.id.priceEtanolTextView);

        resultTextInput = findViewById(R.id.resultTextInput);

        imageView = findViewById(R.id.fuel_imageVIew);


        SeekBar gasolinaSeekBar =
                findViewById(R.id.gasolinaSeekBar);

        SeekBar etanolSeekBar =
                findViewById(R.id.etanolSeekBar);





        gasolinaSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueGas = progress * 0.01D;
                priceGasTextview.setText(currencyFormat.format(valueGas));

                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        etanolSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueEtanol =  progress * 0.01D;
                priceEtanolTextView.setText(currencyFormat.format(valueEtanol));
                calcular();


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });





    }

    private void calcular (){
        double result =  valueEtanol / valueGas ;


        if (result >= 0.7) {

            resultTextInput.setText(getString(R.string.fuelGas));
            imageView.setImageDrawable(getDrawable(R.drawable.gasolina));
        }
        else {
            resultTextInput.setText(getString(R.string.fuelEthanol));
            imageView.setImageDrawable(getDrawable(R.drawable.ethanol));
        }

    }
}
