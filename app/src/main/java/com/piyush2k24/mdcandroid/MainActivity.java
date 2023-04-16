package com.piyush2k24.mdcandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.piyush2k24.mdcandroid.MDCActivities.MDCAlertDialogueBox;
import com.piyush2k24.mdcandroid.MDCActivities.MDCButton;
import com.piyush2k24.mdcandroid.MDCActivities.MDCDatePicker;
import com.piyush2k24.mdcandroid.databinding.ActivityMainBinding;
import com.piyush2k24.mdcandroid.databinding.MdcAlertDialogueBoxBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
MaterialAlertDialogBuilder materialAlertDialogBuilder;
Intent intent;
String[] Widgets={"1. MDC Button","2. MDC DatePicker","3. MDC AlertDialogueBox"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Callers();
    }

    private void Callers() {
        MDCAdapter mdcAdapter=new MDCAdapter(getApplicationContext(),Widgets);
        binding.LstView.setAdapter(mdcAdapter);
        MDCWidgetListener();
    }

    private void MDCWidgetListener() {
        binding.LstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                materialAlertDialogBuilder=new MaterialAlertDialogBuilder(MainActivity.this)
                        .setTitle("User Information")
                        .setMessage("You are selected "+Widgets[position].substring(7)+" !")
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                             // showToast("Working");
                                if(position==0){
                                    intent=new Intent(MainActivity.this, MDCButton.class);
                                    startActivity(intent);
                                } else if (position==1) {
                                    intent=new Intent(MainActivity.this, MDCDatePicker.class);
                                    startActivity(intent);
                                } else if (position==2) {
                                    intent=new Intent(MainActivity.this, MDCAlertDialogueBox.class);
                                    startActivity(intent);
                                }
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                materialAlertDialogBuilder.create().show();
            }
        });
    }

    private void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}