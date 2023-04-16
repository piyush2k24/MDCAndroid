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
import com.piyush2k24.mdcandroid.databinding.MdcButtonBinding;

public class MDCButton extends AppCompatActivity {
    MdcButtonBinding binding;
    MaterialAlertDialogBuilder mdc;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=MdcButtonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Caller();
    }

    private void Caller() {
        binding.MDCbtn.setOnClickListener(v -> {
            mdcFloat();
        });
        assert binding.floatingBtn != null;
        binding.floatingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("You clicked Floating Action Button");
            }
        });
        assert binding.btnSourceCode != null;
        binding.btnSourceCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/material-components/material-components-android/blob/master/docs/components/Button.md"));
                startActivity(intent);
            }
        });
    }

    private void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    private void mdcFloat() {
        mdc=new MaterialAlertDialogBuilder(this)
                .setTitle("Material Button Demo")
                .setMessage("This is The MaterialButton !")
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("i Know", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        mdc.create().show();
    }

}