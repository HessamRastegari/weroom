package hessam.rastegari.weroom.loading;


import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;

import hessam.rastegari.weroom.R;

public class LoadingDialog {

    private Activity activity;
    private AlertDialog alertDialog;

    public LoadingDialog(Activity myActivity) {

        activity = myActivity;

    }

    public void showLoading(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.custom_snackbar_layout,null));
        builder.setCancelable(true);

        alertDialog= builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alertDialog.show();

    }

    public void dismissDialog(){
        alertDialog.dismiss();
    }
}
