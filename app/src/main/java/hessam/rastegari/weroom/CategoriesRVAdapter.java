package hessam.rastegari.weroom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoriesRVAdapter extends RecyclerView.Adapter<CategoriesRVAdapter.MyHolder> {


    ArrayList<String> data;
    ArrayList<Integer> img;
    Context context;
    public CategoriesRVAdapter(ArrayList<String> data, ArrayList<Integer> img, Context context) {
        this.data = data;
        this.img = img;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.categories_rv_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.tvTitle.setText(data.get(position));
        holder.imgMainIcon.setImageResource(img.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    class MyHolder extends RecyclerView.ViewHolder{


        TextView tvTitle;
        ImageView imgMainIcon;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.txtTitle);
            imgMainIcon = itemView.findViewById(R.id.imgIcon);

        }
    }

}
