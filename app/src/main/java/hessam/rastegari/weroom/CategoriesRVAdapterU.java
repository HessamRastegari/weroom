package hessam.rastegari.weroom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import hessam.rastegari.weroom.data.CategoryData;

public class CategoriesRVAdapterU extends RecyclerView.Adapter<CategoriesRVAdapterU.MyHolder> {

    private List<CategoryData> listCategoryDataItems;

    public void setListDataItem(List<CategoryData> listCategoryDataItems){
        this.listCategoryDataItems = listCategoryDataItems;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_rv_item, parent, false);
        return new MyHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        holder.tvTitle.setText(listCategoryDataItems.get(position).catName);

    }




    @Override
    public int getItemCount() {

        if(listCategoryDataItems == null)
            return 0;
        else
            return listCategoryDataItems.size();
    }



    public class MyHolder extends RecyclerView.ViewHolder{


        TextView tvTitle;
        ImageView imgMainIcon;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.txtTitle);
            imgMainIcon = itemView.findViewById(R.id.imgIcon);

        }
    }

}
