package test.yixia.com.testapplication.recycler2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import test.yixia.com.testapplication.R;

/**
 * Created by zhangjian on 2018/5/22.
 */
public class TextItemViewHolder extends RecyclerView.ViewHolder {
    TextView footer;

    public TextItemViewHolder(View itemView) {
        super(itemView);
        footer = (TextView) itemView.findViewById(R.id.footer);
    }
}
