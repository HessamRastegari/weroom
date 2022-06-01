package hessam.rastegari.weroom.loading;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import hessam.rastegari.weroom.R;

public class LoadingSnackbar {

    private View view;
    private Activity activity;

    public LoadingSnackbar(Activity activity) {
        this.activity = activity;
    }


    public void ShowSnackBar(View view){
        // create an instance of the snackbar
        this.view = view;


        final Snackbar snackbar = Snackbar.make(view, "", Snackbar.LENGTH_INDEFINITE);

        // inflate the custom_snackbar_view created previously
        View customSnackView = activity.getLayoutInflater().inflate(R.layout.custom_snackbar_layout, null);
//                customSnackView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));

        // set the background of the default snackbar as transparent
        snackbar.getView().setBackgroundColor(Color.TRANSPARENT);

        // now change the layout of the snackbar
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();

        // set padding of the all corners as 0
        snackbarLayout.setPadding(0, 0, 0, 0);
//                snackbarLayout.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;

        // register the button from the custom_snackbar_view layout file
        Button bGotoWebsite = customSnackView.findViewById(R.id.gotoWebsiteButton);

        // now handle the same button with onClickListener
        bGotoWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Redirecting to Website", Toast.LENGTH_SHORT).show();
                snackbar.dismiss();
            }
        });

        // add the custom snack bar layout to snackbar layout
        snackbarLayout.addView(customSnackView, 0);

        snackbar.setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE);
        snackbar.show();

    }
}
