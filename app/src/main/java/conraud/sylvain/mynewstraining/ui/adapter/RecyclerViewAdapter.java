package conraud.sylvain.mynewstraining.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import conraud.sylvain.mynewstraining.R;
import conraud.sylvain.mynewstraining.data.Article;
import conraud.sylvain.mynewstraining.ui.fragment.ItemViewHolder;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    public List<Article> lstArticle;

    public RecyclerViewAdapter(List<Article> lstArticle) {
        this.lstArticle = lstArticle;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.fragment_main_item, viewGroup,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        itemViewHolder.displayItem(lstArticle.get(i));

    }

    @Override
    public int getItemCount() {
        return lstArticle.size();
    }
}
