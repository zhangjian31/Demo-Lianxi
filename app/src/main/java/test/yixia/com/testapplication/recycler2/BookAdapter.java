package test.yixia.com.testapplication.recycler2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import test.yixia.com.testapplication.R;

/**
 * Created by zhangjian on 2018/5/22.
 */

public class BookAdapter extends BaseAdapter<Book> {
    public static final int ITEM_TEXT = 100;
    public static final int ITEM_IMAGE = 101;


    @Override
    public RecyclerView.ViewHolder createHeaderViewHolder(ViewGroup parent, int viewType) {
        return mHeaders.get(0);
    }

    @Override
    public RecyclerView.ViewHolder createFooterViewHolder(ViewGroup parent, int viewType) {
        return mFooters.get(0);
    }

    @Override
    public RecyclerView.ViewHolder createItemViewHolder(ViewGroup parent, int viewType) {
        if (ITEM_TEXT == viewType) {
            return new TextItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.text_item, parent, false));
        } else if (ITEM_IMAGE == viewType) {
            return new ImageItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item, parent, false));
        }
        return null;
    }

    @Override
    public void bindHeaderView(RecyclerView.ViewHolder holder, int position) {
        HeaderItemViewHolder viewHolder = (HeaderItemViewHolder) holder;
        viewHolder.header.setText("this is header");
    }

    @Override
    public void bindFooterView(RecyclerView.ViewHolder holder, int position) {
        FooterItemViewHolder viewHolder = (FooterItemViewHolder) holder;
        viewHolder.footer.setText("this is footer");
    }

    private void bindImageItemView(ImageItemViewHolder holder, int position) {
        ImageItemViewHolder viewHolder = holder;
        viewHolder.imageview.setImageResource(getData().get(position-getHeaderCount()).resId);
    }

    private void bindTextItemView(TextItemViewHolder holder, int position) {
        TextItemViewHolder viewHolder = holder;
        viewHolder.text.setText("this is text:" + getData().get(position - getHeaderCount()));
    }

    @Override
    public void bindItemView(RecyclerView.ViewHolder holder, int position) {
        if (ITEM_TEXT == getItemViewTypeCustom(position)) {
            bindTextItemView((TextItemViewHolder) holder, position);
        }
        if (ITEM_IMAGE == getItemViewTypeCustom(position)) {
            bindImageItemView((ImageItemViewHolder) holder, position);
        }
    }


    @Override
    public int getItemViewTypeCustom(int position) {
        if (getData().get(position - getHeaderCount()).type == 1) {
            return ITEM_TEXT;
        } else if (getData().get(position - getHeaderCount()).type == 2) {
            return ITEM_IMAGE;
        }
        return 0;
    }
}
