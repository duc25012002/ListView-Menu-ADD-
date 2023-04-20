package eu.tutorials.menulistview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import eu.tutorials.menulistview.adapter.ThoiTietAdapter;
import eu.tutorials.menulistview.model.ThoiTiet;

public class MainActivity extends AppCompatActivity {

    EditText edt_ten_quoc_gia, edt_nhiet_do;
    Button btn_add, btn_view;
    ListView lv_thoi_tiet;
    ThoiTietAdapter thoiTietAdapter;
    ArrayList<ThoiTiet> thoiTiets = new ArrayList<>();

    String tenQuocGia, trangThai;

    int nhietDo, anhTrangThai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        xuLySuKien();
    }

    private void xuLySuKien() {
        thoiTiets.add(new ThoiTiet("Thái Nguyên", "Sunny", R.drawable.sunny, 34));
        thoiTietAdapter = new ThoiTietAdapter(R.layout.item_thoi_tiet, this, thoiTiets);
        lv_thoi_tiet.setAdapter(thoiTietAdapter);
        themThoiTiet();
    }

    private void themThoiTiet() {
        btn_add.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tenQuocGia = edt_ten_quoc_gia.getText().toString().trim();
                nhietDo = Integer.parseInt(edt_nhiet_do.getText().toString());
                if (nhietDo >= 30) {
                    anhTrangThai = R.drawable.sunny;
                    trangThai = "Sunny";
                }
                if (nhietDo > 20 && nhietDo < 30) {
                    anhTrangThai = R.drawable.cloud;
                    trangThai = "Cloudy";
                }
                if (nhietDo <= 20) {
                    anhTrangThai = R.drawable.rainy;
                    trangThai = "Rainy";
                }
                thoiTiets.add(new ThoiTiet(tenQuocGia, trangThai, anhTrangThai, nhietDo));
                thoiTietAdapter.notifyDataSetChanged();
            }
        }));
    }

    private void anhXa() {
        edt_ten_quoc_gia = findViewById(R.id.edt_ten_quoc_gia);
        edt_nhiet_do = findViewById(R.id.edt_nhiet_do);
        btn_add = findViewById(R.id.btn_add);
        btn_view = findViewById(R.id.btn_view);
        lv_thoi_tiet = findViewById(R.id.lv_thoi_tiet);
    }
}