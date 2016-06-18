package com.example.teacher.test;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teacher.test.dto.CustomerDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListViewActivity extends BaseActivity {

    @BindView(R.id.lv_sample)
    ListView mLvSample;

    @BindView(R.id.swipeListSample)
    SwipeRefreshLayout mSwipeListSample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ButterKnife.bind(this);

        // ListViewの表示項目作成
        final List<CustomerDto> lst = createTestCustomer();

        // Adapterへリストのバインド
        final CustomerAdapter adapter = new CustomerAdapter(this);

        // Adapterへリストを追加
        adapter.add(lst);

        // ListviewにAdapterを設定
        mLvSample.setAdapter(adapter);

        // クリックイベント
        mLvSample.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // dto取得
                CustomerDto dto = lst.get(position);

                // トースト表示
                Toast.makeText(
                        ListViewActivity.this,
                        dto.getName(),
                        Toast.LENGTH_LONG
                ).show();

            }
        });

        mSwipeListSample.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                // Adapterをクリア
                adapter.listClear();

                // Adapterへリストのバインド
                CustomerAdapter adapter = new CustomerAdapter(ListViewActivity.this);

                // Adapterへリストを追加
                adapter.add(createTestCustomer());

                // ListviewにAdapterを設定
                mLvSample.setAdapter(adapter);

                // プログレスstop
                if(mSwipeListSample.isRefreshing()){
                    mSwipeListSample.setRefreshing(false);
                }
            }
        });
    }

    // 20人分のテスト顧客データ　※本当はサーバから情報を取得するはず
    private List<CustomerDto> createTestCustomer(){

        List<CustomerDto> lst = new ArrayList<>();
        for(int i = 1; i <= 20; i++) {
            CustomerDto dto = new CustomerDto();
            dto.setId(i);
            dto.setName("hoge" + i);
            dto.setDate(new Date());
            lst.add(dto);
        }
        return lst;
    }

    public class CustomerAdapter extends BaseAdapter{

        private Context _context;
        private List<CustomerDto> _lst;
        private LayoutInflater _layoutInflater;

        public CustomerAdapter(Context context){
            _context = context;
            _lst = new ArrayList<>();
            _layoutInflater = (LayoutInflater) context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        // リストをバインド
        public void add(List<CustomerDto> lst){
            for(CustomerDto dto : lst){
                _lst.add(dto);
            }
            notifyDataSetChanged();
        }

        public void listClear(){
            _lst.clear();
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return _lst.size();
        }

        @Override
        public Object getItem(int position) {
            return _lst.get(position);
        }

        @Override
        public long getItemId(int position) {
            return _lst.get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder = null;
            if(convertView == null){
                convertView = _layoutInflater.inflate(R.layout.customer_list_item,null);
                holder = new Holder();
                holder.txtName = (TextView) convertView.findViewById(R.id.txt_name);
                holder.txtDate = (TextView) convertView.findViewById(R.id.txt_date);
                convertView.setTag(holder);
            }else{
                holder = (Holder) convertView.getTag();
            }

            // 顧客の名前を表示
            holder.txtName.setText(_lst.get(position).getName());
            // 現在日時を表示
            holder.txtDate.setText(_lst.get(position).getDate());

            return convertView;
        }

        private class Holder{
            TextView txtName;
            TextView txtDate;
        }
    }
}
