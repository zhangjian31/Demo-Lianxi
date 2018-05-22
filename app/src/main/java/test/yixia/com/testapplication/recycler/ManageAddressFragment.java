package test.yixia.com.testapplication.recycler;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import test.yixia.com.testapplication.R;

/**
 * Created by zhangjian on 2018/5/22.
 */

public class ManageAddressFragment extends Fragment {

    private ManageAddressAdapter manageAddressAdapter;
    private List<AllAddress> data;
    private RecyclerView recyclerview;
    private View root;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = LayoutInflater.from(getContext()).inflate(R.layout.fragment_manage_address, null);

        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        recyclerview = (RecyclerView) root.findViewById(R.id.recyclerview);


        manageAddressAdapter = new ManageAddressAdapter();
        manageAddressAdapter.setOnTitleClickListener(new ManageAddressAdapter.OnTitleClickListener() {
            @Override
            public void onTitleClick(int id) {
                Toast.makeText(ManageAddressFragment.this.getContext(), data.get(id).toString(), Toast.LENGTH_SHORT).show();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.setAdapter(manageAddressAdapter);
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
            AllAddress add = new AllAddress();
            add.title = "title:" + i;
            add.text = "text:" + i;
            data.add(add);
        }

        manageAddressAdapter.setList(data);

    }
}
