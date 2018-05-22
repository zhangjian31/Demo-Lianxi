package test.yixia.com.testapplication.recycler2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import test.yixia.com.testapplication.R;

/**
 * Created by zhangjian on 2018/5/22.
 */
public class ImageItemViewHolder extends RecyclerView.ViewHolder {
    ImageView imageview;

    public ImageItemViewHolder(View itemView) {
        super(itemView);
        imageview = (ImageView) itemView.findViewById(R.id.image);
    }
}
