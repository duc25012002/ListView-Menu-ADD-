package eu.tutorials.menulistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import eu.tutorials.menulistview.R;
import eu.tutorials.menulistview.model.ThoiTiet;

public class ThoiTietAdapter extends BaseAdapter {


    private int layout;
    private Context context;
    List<ThoiTiet> thoiTiets;

    public ThoiTietAdapter(int layout, Context context, List<ThoiTiet> thoiTiets) {
        this.layout = layout;
        this.context = context;
        this.thoiTiets = thoiTiets;
    }

    @Override
    public int getCount() {
        return thoiTiets.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);

        ImageView img_anh_trang_thai = convertView.findViewById(R.id.img_anh_trang_thai);
        TextView txt_ten_thanh_pho = convertView.findViewById(R.id.txt_ten_thanh_pho);
        TextView txt_trang_thai = convertView.findViewById(R.id.txt_trang_thai);
        TextView txt_nhiet_do = convertView.findViewById(R.id.txt_nhiet_do);
        ImageButton btn_chon = convertView.findViewById(R.id.btn_chon);

        ThoiTiet thoiTiet = thoiTiets.get(position);
        img_anh_trang_thai.setImageResource(thoiTiet.getAnhTrangThai());
        txt_ten_thanh_pho.setText(thoiTiet.getTenThanhPho());
        txt_trang_thai.setText(thoiTiet.getTrangThai());
        txt_nhiet_do.setText(thoiTiet.getNhietDo() + "");


        btn_chon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context, btn_chon);
                popupMenu.getMenuInflater().inflate(R.menu.menu_pop, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.update:
                                Toast.makeText(context, "UPDATE", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.delete:
                                Toast.makeText(context, "DELETE", Toast.LENGTH_SHORT).show();

                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });


        return convertView;
    }


}
