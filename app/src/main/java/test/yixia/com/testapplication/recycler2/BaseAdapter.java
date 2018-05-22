package test.yixia.com.testapplication.recycler2;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjian on 2018/5/22.
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int HEADER = 0x1110;
    public static final int FOOTER = 0x1111;
    protected List<T> mList;
    protected List<RecyclerView.ViewHolder> mHeaders;
    protected List<RecyclerView.ViewHolder> mFooters;
    protected List<RecyclerView.ViewHolder> mItems;

    public BaseAdapter() {
        mList = new ArrayList<>();
        mHeaders = new ArrayList<>();
        mFooters = new ArrayList<>();
        mItems = new ArrayList<>();
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

    public int getHeaderCount() {
        return mHeaders.size();
    }

    public int getFooterCount() {
        return mFooters.size();
    }

    public void setData(List<T> list) {
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }
    public void addData(List<T> list) {
        mList.addAll(list);
        notifyDataSetChanged();
    }

    public List<T> getData() {
        return mList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEADER) {
            return createHeaderViewHolder(parent, viewType);
        } else if (viewType == FOOTER) {
            return createFooterViewHolder(parent, viewType);
        } else {
            return createItemViewHolder(parent, viewType);
        }
    }

    public abstract RecyclerView.ViewHolder createHeaderViewHolder(ViewGroup parent, int viewType);

    public abstract RecyclerView.ViewHolder createFooterViewHolder(ViewGroup parent, int viewType);

    public abstract RecyclerView.ViewHolder createItemViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == HEADER) {
            bindHeaderView(holder, position);
        } else if (viewType == FOOTER) {
            bindFooterView(holder, position);
        } else {
            bindItemView(holder, position);
        }
    }


    public abstract void bindHeaderView(RecyclerView.ViewHolder holder, int position);

    public abstract void bindFooterView(RecyclerView.ViewHolder holder, int position);

    public abstract void bindItemView(RecyclerView.ViewHolder holder, int position);


    @Override
    public int getItemViewType(int position) {
        if (position < mHeaders.size()) {
            return HEADER;
        } else if ((position >= mHeaders.size() + mList.size()) && (position < mHeaders.size() + mList.size() + mFooters.size())) {
            return HEADER;
        } else {
            return getItemViewTypeCustom(position);
        }
    }

    public abstract int getItemViewTypeCustom(int position);

    @Override
    public int getItemCount() {
        return mHeaders.size() + mList.size() + mFooters.size();
    }


}
