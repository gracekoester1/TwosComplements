package com.example.aweso.twoscomplement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import java.lang.Character;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{
    private TextView answerTV;
    private EditText inputET;
    private Switch negativeSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.answerTV = (TextView)this.findViewById(R.id.answerTV);
        this.inputET = (EditText)this.findViewById(R.id.inputET);
        this.negativeSwitch = (Switch)this.findViewById(R.id.negativeSwitch);
    }

    private String flipTheBits(String bin)
    {
        String answer = "";
        for(int i = 0; i < bin.length(); i++)
        {
            answer += bin.charAt(i) == '0' ? '1' : '0';
        }
        return answer;
    }

    private String addOne(String bin)
    {
        //will return a new String that is the given String with 1 added to it

        int length = bin.length();

        //bin = bin + length;
        //reverse string
        for(int i = length; i > 0; i--)
        {
            String reverseBin = "";
            reverseBin = bin;
            bin = reverseBin;

        }

        char[] binArray = new char[length];

        char carriedNumber = 0;



        for(int i = 0; i < 1; i++)
        {
            if(binArray[i] == '0')
            {
                binArray[i] = '1';
            }

            else
            {
                binArray[i] = '0';
                carriedNumber = '1';

                for(int x = 1; x < binArray.length; x++)
                {
                    if(binArray[i] == '0')
                    {
                        binArray[i] = carriedNumber;

                    }
                    else
                    {
                        binArray[i] = '0';
                        continue;

                    }
                }
            }
        }

        bin = binArray.toString();


        //reverse string back to normal
        for(int i = length; i > 0; i--)
        {
            String reverseBin = "";
            reverseBin = bin;
            bin = reverseBin;

        }


        return bin;
    }

    private String encodeAsTwosComplement(String bin)
    {
        String bitsFlipped = this.flipTheBits(bin);
        String oneAdded = this.addOne(bitsFlipped);
        return oneAdded;
    }

    public void onConvertButtonPressed(View v)
    {
        String theBinaryNumber = this.inputET.getText().toString();

        if(this.negativeSwitch.isChecked())
        {
            this.answerTV.setText(this.encodeAsTwosComplement(theBinaryNumber));
        }
        else
        {
            this.answerTV.setText(theBinaryNumber);
        }

    }
}
