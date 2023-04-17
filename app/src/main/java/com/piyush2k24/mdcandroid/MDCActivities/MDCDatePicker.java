package com.piyush2k24.mdcandroid.MDCActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.piyush2k24.mdcandroid.MDCAdapter;
import com.piyush2k24.mdcandroid.R;
import com.piyush2k24.mdcandroid.databinding.MdcDatepickerBinding;

public class MDCDatePicker extends AppCompatActivity {
MdcDatepickerBinding binding;
Intent intent;
MaterialDatePicker<Long> materialDatePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= MdcDatepickerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Callers();
    }

    private void Callers() {
        binding.MDC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker=MaterialDatePicker.Builder.datePicker()
                        .setTitleText("Choose Your date")
                        .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                        .build();
                materialDatePicker.show(getSupportFragmentManager(),"MDC");
                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
                    @Override
                    public void onPositiveButtonClick(Long selection) {
                        binding.MDC2.setText(materialDatePicker.getHeaderText());
                    }
                });
            }
        });
        binding.btnSourceCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/material-components/material-components-android/blob/master/docs/components/DatePicker.md"));
                startActivity(intent);
            }
        });
    }
}