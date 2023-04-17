package com.piyush2k24.mdcandroid.MDCActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.piyush2k24.mdcandroid.R;
import com.piyush2k24.mdcandroid.databinding.MdcAlertDialogueBoxBinding;

public class MDCAlertDialogueBox extends AppCompatActivity {
MdcAlertDialogueBoxBinding binding;
Intent intent;
MaterialAlertDialogBuilder materialAlertDialogBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=MdcAlertDialogueBoxBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Caller();
    }

    private void Caller() {
        binding.MDC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialAlertDialogBuilder= new MaterialAlertDialogBuilder(MDCAlertDialogueBox.this)
                        .setIcon(R.mipmap.ic_launcher)
                        .setMessage("This is the material dialogue box")
                        .setTitle("MDC-AlertDialogueBox")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                showToast("MDC Clicked ! Working");
                            }
                        })
                        .setNegativeButton("Na", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                showToast("Dismiss 👍");
                            }
                        });
                        materialAlertDialogBuilder.create().show();
            }
        });
        binding.btnSourceCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/material-components/material-components-android/blob/master/docs/components/Dialog.md"));
                startActivity(intent);
            }
        });
    }

    private void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}