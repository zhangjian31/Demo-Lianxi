package test.yixia.com.testapplication.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import test.yixia.com.testapplication.R;

/**
 * Created by zhangjian on 2018/5/22.
 */

public class ManageAddressAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<AllAddress> mList;

    public ManageAddressAdapter() {
        if (mList == null) {
            mList = new ArrayList<>();
        }
    }

    public void setList(List<AllAddress> data) {

        this.mList.clear();
        this.mList.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ManageAddressAdapter.ManageAddressViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_manage_address, parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ManageAddressViewHolder mHolder = (ManageAddressViewHolder) holder;
        mHolder.title.setText(mList.get(position).title);
        mHolder.text.setText(mList.get(position).text);
        mHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onTitleClick(position);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return this.mList.size();
    }

    public static class ManageAddressViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView text;

        public ManageAddressViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            text = (TextView) itemView.findViewById(R.id.text);

        }
    }

    public OnTitleClickListener mListener;

    public void setOnTitleClickListener(OnTitleClickListener listener) {//自己写了一个方法，用上我们的接口
        mListener = listener;
    }

    public interface OnTitleClickListener {//自己写了一个点击事件的接口

        void onTitleClick(int id);
    }
}
