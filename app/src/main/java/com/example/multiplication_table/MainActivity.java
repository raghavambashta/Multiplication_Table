package com.example.multiplication_table;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    SeekBar numBar;
    ListView myTable;
    TextView numSel;

    public void tableFunc()
    {

        numBar = (SeekBar)findViewById(R.id.numBar);
        myTable = (ListView)findViewById(R.id.myTable);
        numSel = (TextView)findViewById(R.id.numSel);

        numBar.setMax(20);

        numBar.setMin(0);

        numBar.setProgress(0);

        numSel.setText(Integer.toString(numBar.getProgress()));

        numBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                numSel.setText(Integer.toString(numBar.getProgress()));

                final ArrayList<String> parameter = new ArrayList<String>();

                for (int k = 1; k <= 20; k++)
                {

                    parameter.add(Integer.toString(k) + " * " + Integer.toString(numBar.getProgress()) + " = " +  Integer.toString(k * numBar.getProgress()));

                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, parameter);

                myTable.setAdapter(arrayAdapter);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableFunc();

    }
}