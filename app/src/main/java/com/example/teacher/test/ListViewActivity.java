package com.example.teacher.test;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.teacher.test.dto.CustomerDto;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListViewActivity extends BaseActivity {

    @BindView(R.id.lv_sample)
    ListView mLvSample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ButterKnife.bind(this);

        // ListViewの表示項目作成
        List<CustomerDto> lst = createTestCustomer();

        // Adapterへリストのバインド
        CustomerAdapter adapter = new CustomerAdapter(this);

        // Adapterへリストを追加
        adapter.add(lst);

        // ListviewにAdapterを設定
        mLvSample.setAdapter(adapter);
    }

    // 20人分のテスト顧客データ　※本当はサーバから情報を取得するはず
    private List<CustomerDto> createTestCustomer(){

        List<CustomerDto> lst = new ArrayList<>();
        for(int i = 1; i <= 20; i++) {
            CustomerDto dto = new CustomerDto();
            dto.setId(i);
            dto.setName("hoge" + i);
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
                convertView.setTag(holder);
            }else{
                holder = (Holder) convertView.getTag();
            }

            // 顧客の名前を表示
            holder.txtName.setText(_lst.get(position).getName());

            return convertView;
        }

        private class Holder{
            TextView txtName;
        }
    }
}
