package test.yixia.com.testapplication.recycler2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import test.yixia.com.testapplication.R;

/**
 * Created by zhangjian on 2018/5/22.
 */

public abstract class BaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int HEADER = 1;
    public static final int FOOTER = 2;
    private List<Book> mList;
    private List<RecyclerView.ViewHolder> mHeaders;
    private List<RecyclerView.ViewHolder> mFooters;
    private List<RecyclerView.ViewHolder> mItems;

    public BaseAdapter() {
        mList = new ArrayList<>();
        mHeaders = new ArrayList<>();
        mFooters = new ArrayList<>();
    }

    public void addHeader(RecyclerView.ViewHolder header) {
        mHeaders.add(header);
        notifyDataSetChanged();
    }

    public void removeHeader(RecyclerView.ViewHolder header) {
        mHeaders.remove(header);
        notifyDataSetChanged();
    }

    public void addFooter(RecyclerView.ViewHolder footer) {
        mFooters.add(footer);
    }

    public void removeFooter(RecyclerView.ViewHolder footer) {
        mFooters.remove(footer);
        notifyDataSetChanged();
    }

    private void addData(List<Book> list) {
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEADER) {
            return createHeaderViewHolder(parent);
        } else if (viewType == FOOTER) {
            return createFooterViewHolder(parent);
        } else {
            return createItemViewHolder(parent);
        }
    }

    public abstract RecyclerView.ViewHolder createHeaderViewHolder(ViewGroup parent);

    public abstract RecyclerView.ViewHolder createFooterViewHolder(ViewGroup parent);

    public abstract RecyclerView.ViewHolder createItemViewHolder(ViewGroup parent);

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == HEADER) {
            bindHeaderView(holder);
        } else if (viewType == FOOTER) {
            bindFooterView(holder);
        } else {

            bindItemView(holder);
        }
    }


    public abstract void bindHeaderView(RecyclerView.ViewHolder holder);

    public abstract void bindFooterView(RecyclerView.ViewHolder holder);

    public abstract void bindItemView(RecyclerView.ViewHolder holder);


    @Override
    public int getItemViewType(int position) {

        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
