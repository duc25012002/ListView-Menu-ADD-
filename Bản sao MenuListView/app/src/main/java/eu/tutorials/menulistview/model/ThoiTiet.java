package eu.tutorials.menulistview.model;

public class ThoiTiet {
    private String tenThanhPho;
    private String trangThai;
    private int anhTrangThai;
    private int nhietDo;

    public ThoiTiet(String tenThanhPho, String trangThai, int anhTrangThai, int nhietDo) {
        this.tenThanhPho = tenThanhPho;
        this.trangThai = trangThai;
        this.anhTrangThai = anhTrangThai;
        this.nhietDo = nhietDo;
    }

    public String getTenThanhPho() {
        return tenThanhPho;
    }

    public void setTenThanhPho(String tenThanhPho) {
        this.tenThanhPho = tenThanhPho;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getAnhTrangThai() {
        return anhTrangThai;
    }

    public void setAnhTrangThai(int anhTrangThai) {
        this.anhTrangThai = anhTrangThai;
    }

    public int getNhietDo() {
        return nhietDo;
    }

    public void setNhietDo(int nhietDo) {
        this.nhietDo = nhietDo;
    }
}
