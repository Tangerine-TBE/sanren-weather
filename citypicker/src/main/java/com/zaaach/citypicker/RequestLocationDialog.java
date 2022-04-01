package com.zaaach.citypicker;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;

public class RequestLocationDialog extends Dialog {
    public RequestLocationDialog(Context context) {
        super(context);
        getWindow().getDecorView().setBackgroundColor(Color.TRANSPARENT);
        getWindow().getDecorView().setPadding(0,0,0,0);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        setContentView(R.layout.dialog_open_location);
        final View notAsk=findViewById(R.id.notAsk);
        notAsk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        findViewById(R.id.closeDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notAsk.performClick();
            }
        });
    }

    public void requestAction(final Activity activity, final int requestCode){
        findViewById(R.id.openPermission).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    ((Activity) activity).requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION}, requestCode);
                }
                RequestLocationDialog.this.dismiss();
            }
        });
    }
}
