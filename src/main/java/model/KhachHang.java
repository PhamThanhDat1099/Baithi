package model;

/**
 *
 * Họ tên sinh viên: Phạm Thành Đạt
 */

public final class KhachHang {
    private String maso;
    private String hoten;
    private double tieuThu;
    private double dinhMuc;
    private double chiSoMoi;
    private int soNhanKhau;
    private double tienTra;


    // Constructor để khởi tạo đối tượng KhachHang
    public KhachHang(String maso, String hoten, int tieuThu, double dinhMuc, double chiSoMoi, int soNhanKhau) {
        this.maso = maso;
        this.hoten = hoten;
        this.tieuThu = tieuThu;
        this.dinhMuc = dinhMuc;
        this.chiSoMoi = chiSoMoi;
        this.soNhanKhau = soNhanKhau;
        this.tienTra = tinhTienTra();  // Tự động tính tiền trả khi tạo đối tượng
    }

    KhachHang(String string, String string0, int parseInt, double parseDouble, double parseDouble0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getter và Setter cho mã số khách hàng
    public String getMaso() {
        return maso;
    }

    public void setMaso(String maso) {
        this.maso = maso;
    }

    // Getter và Setter cho họ tên
    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    // Getter và Setter cho số khối nước tiêu thụ
    public int getTieuThu() {
        return (int) tieuThu;
    }

    public void setTieuThu(int tieuThu) {
        this.tieuThu = tieuThu;
    }

    // Getter và Setter cho định mức nước
    public double getDinhMuc() {
        return dinhMuc;
    }

    public void setDinhMuc(double dinhMuc) {
        this.dinhMuc = dinhMuc;
    }

    // Getter và Setter cho chỉ số mới
    public double getChiSoMoi() {
        return chiSoMoi;
    }

    public void setChiSoMoi(double chiSoMoi) {
        this.chiSoMoi = chiSoMoi;
    }

    // Getter và Setter cho số nhân khẩu
    public int getSoNhanKhau() {
        return soNhanKhau;
    }

    public void setSoNhanKhau(int soNhanKhau) {
        this.soNhanKhau = soNhanKhau;
    }

    // Getter và Setter cho tiền trả
    public double getTienTra() {
        return tienTra;
    }

    public void setTienTra(double tienTra) {
        this.tienTra = tienTra;
    }

    // Phương thức tính tiền trả
    public double tinhTienTra() {
       
        if (tieuThu <= dinhMuc) {
            return tieuThu * 5000;  // Tính tiền trong phạm vi định mức
        } else {
            return dinhMuc * 5000 + (tieuThu - dinhMuc) * 10000;  // Tính tiền vượt định mức
        }
    }

    // Phương thức hiển thị thông tin khách hàng 
    @Override
    public String toString() {
        return "KhachHang{" +
                "maso='" + maso + '\'' +
                ", hoten='" + hoten + '\'' +
                ", tieuThu=" + tieuThu +
                ", dinhMuc=" + dinhMuc +
                ", chiSoMoi=" + chiSoMoi +
                ", soNhanKhau=" + soNhanKhau +
                ", tienTra=" + tienTra +
                '}';
    }
}

