package conraud.sylvain.mynewstraining.ui.fragment;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import conraud.sylvain.mynewstraining.R;
import conraud.sylvain.mynewstraining.data.Article;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    private TextView textViewCategory, textViewDate, textViewTitle;
    private ImageView imageView;
    private RequestManager glide;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        glide = Glide.with(itemView.getContext());
        textViewCategory = itemView.findViewById(R.id.fragment_main_item_text_view_category);
        textViewTitle = itemView.findViewById(R.id.fragment_main_item_text_view_title);
        textViewDate = itemView.findViewById(R.id.fragment_main_item_text_view_date);
        imageView = itemView.findViewById(R.id.fragment_main_item_image_view);
    }

    @SuppressLint("SetTextI18n")
    public void displayItem(Article article) {
        textViewCategory.setText(article.getSection() + "/" + article.getSubsection());
        textViewTitle.setText(article.getTitle());
        textViewDate.setText(article.getPublishedDate().substring(0,10));

       if(article.getMultimedia() != null && article.getMultimedia().size() > 0){
           glide.load(article.getMultimedia().get(0).getUrl()).into(imageView);
       }else if(article.getMedia() != null && article.getMedia().size() > 0){
           glide.load(article.getMedia().get(0).getMediaMetadata().get(0).getUrl()).into(imageView);

       }

       else{
           imageView.setImageResource(R.drawable.ic_launcher_foreground);
       }


    }
}
