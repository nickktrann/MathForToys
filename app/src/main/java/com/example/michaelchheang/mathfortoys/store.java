package com.example.michaelchheang.mathfortoys;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class store extends AppCompatActivity{
    Button coupon1;
    Button coupon2;
    Button coupon3;
    Button yes;
    Button no;
    final Context context = this;
    menuScreen menu = new menuScreen();

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store);

        coupon1 = (Button) findViewById(R.id.coupon1);
        coupon2 = (Button) findViewById(R.id.coupon2);
        coupon3 = (Button) findViewById(R.id.coupon3);

        coupon1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(menu.getCurrency() >= -10) {
                    handleClick(-10);
                }
                else{
                    Toast.makeText(store.this, "Not enough coins", Toast.LENGTH_SHORT).show();
                }
            }
        });
        coupon2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(menu.getCurrency() >= -20) {
                    handleClick(-20);
                }
                else{
                    Toast.makeText(store.this, "Not enough coins", Toast.LENGTH_SHORT).show();
                }
            }
        });
        coupon3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(menu.getCurrency() >= -30) {
                    handleClick(-30);
                }
                else{
                    Toast.makeText(store.this, "Not enough coins", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void handleClick(int n){
        final Dialog myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.confirmation);
        final int var = n;
        yes = (Button) findViewById(R.id.yes);
        no = (Button) findViewById(R.id.no);

        yes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                menu.update(var);
                Toast.makeText(store.this, "Congratulations ", Toast.LENGTH_SHORT).show();
                myDialog.dismiss();
            }
        });
        no.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }
}
