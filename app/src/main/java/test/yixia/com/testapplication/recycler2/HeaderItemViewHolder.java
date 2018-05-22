package test.yixia.com.testapplication.recycler2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import test.yixia.com.testapplication.R;

/**
 * Created by zhangjian on 2018/5/22.
 */
public class HeaderItemViewHolder extends RecyclerView.ViewHolder {
    TextView header;

    public HeaderItemViewHolder(View itemView) {
        super(itemView);
        header = (TextView) itemView.findViewById(R.id.header);
    }
}
