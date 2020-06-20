package com.gohool.tipcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText amnt;
    private SeekBar skbr;
    private Button bt;
    private TextView tv;
    private TextView prcnt;
    private int s=0;
    private double r=0.0;
    private AlertDialog.Builder alert;
    private TextView ttamt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amnt=(EditText) findViewById(R.id.amountid);
        skbr=(SeekBar) findViewById(R.id.seekbarid);
        bt=(Button) findViewById(R.id.buttonid);
        tv=(TextView) findViewById(R.id.textviewid);
        prcnt=(TextView) findViewById(R.id.percentid);
        ttamt=(TextView) findViewById(R.id.ttamntid);
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();




        skbr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                prcnt.setText(String.valueOf(progress)+" %");
                s=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        alert=new AlertDialog.Builder(MainActivity.this);
        alert.setTitle(R.string.t);
        alert.setMessage(R.string.msg);
        alert.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                r=s*0.01*Integer.parseInt(amnt.getText().toString());
                int a=(int)r;
                tv.setText("Tip is: Rs "+a);
                ttamt.setText("Your Total Amount paid is: Rs "+(a+Integer.parseInt(amnt.getText().toString())));
            }
        });
        alert.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog at=alert.create();
                at.show();
            }
        });





    }
}