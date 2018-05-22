package test.yixia.com.testapplication.recycler2;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import test.yixia.com.testapplication.R;

/**
 * Created by zhangjian on 2018/5/22.
 */

public class BookFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private BookAdapter bookAdapter;
    private List<Book> data;
    private RecyclerView recyclerview;
    private View root;
    private SwipeRefreshLayout swipeRefreshLayout;
    private Handler handler = new Handler();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = LayoutInflater.from(getContext()).inflate(R.layout.fragment_book, null);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        recyclerview = (RecyclerView) root.findViewById(R.id.recyclerview);
        swipeRefreshLayout = (SwipeRefreshLayout) root.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(this);
        bookAdapter = new BookAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.setAdapter(bookAdapter);
        recyclerview.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.top = 5;
                outRect.bottom = 5;
            }
        });
        data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Book book = new Book();
            book.type = i % 3 == 0 ? 1 : 2;
            book.name = "book-" + i;
            book.resId = R.mipmap.ic_launcher;
            data.add(book);
        }

        bookAdapter.setData(data);
        bookAdapter.addHeader(new HeaderItemViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.header, null, false)));
        bookAdapter.addFooter(new HeaderItemViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.footer, null, false)));

    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
                data = new ArrayList<>();
                for (int i = 0; i < 20; i++) {
                    Book book = new Book();
                    book.type = i % 3 == 0 ? 1 : 2;
                    book.name = "new book-" + i;
                    book.resId = R.mipmap.ic_launcher;
                    data.add(book);
                }
                bookAdapter.setData(data);
            }
        },3000);

    }
}
