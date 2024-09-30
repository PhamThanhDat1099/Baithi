package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.*;

/**
 *
 * Họ tên sinh viên: Phạm Thành Đạt
 */

public class QLKhachHang {
    private ArrayList<KhachHang> dsKhachHang;
    
    public QLKhachHang() {
        dsKhachHang = new ArrayList<>();        
    }

    public QLKhachHang(ArrayList<KhachHang> ds) {
        this.dsKhachHang = ds;
    }
    
    public ArrayList<KhachHang> getDsKhachHang() {
        return dsKhachHang;
    }

    public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    // Phương thức đọc danh sách khách hàng từ tập tin
    public void DocDanhSachKhachHang(String filename) {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(";");
                    KhachHang kh = new KhachHang(data[0], data[1], Integer.parseInt(data[2]),
                            Double.parseDouble(data[3]), Double.parseDouble(data[4]));
                    dsKhachHang.add(kh);
                }
            }
        } catch (IOException e) {
        }
    }

    // Phương thức ghi danh sách hóa đơn ra tập tin
    public boolean GhiDanhSachKhachHang(String filename) {
        try {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
                for (KhachHang kh : dsKhachHang) {
                    bw.write(kh.getMaso() + ";" + kh.getHoten() + ";" + kh.getTieuThu() + ";" + kh.tinhTienTra());
                    bw.newLine();
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    // Phương thức thêm khách hàng
    public boolean themKH(KhachHang kh) {
        return dsKhachHang.add(kh);
    }

    // Phương thức xóa khách hàng dựa trên mã số đồng hồ
    public boolean xoaKH(String maso) {
        for (KhachHang kh : dsKhachHang) {
            if (kh.getMaso().equals(maso)) {
                dsKhachHang.remove(kh);
                return true;
            }
        }
        return false;
    }

    // Phương thức tìm số khối nước tiêu thụ thấp nhất
    public KhachHang timKhachHangTieuThuThapNhat() {
        if (dsKhachHang.isEmpty()) return null;
        KhachHang khMin = Collections.min(dsKhachHang, Comparator.comparing(KhachHang::getTieuThu));
        return khMin;
    }

    // Phương thức tính số khối nước tiêu thụ trung bình
    public double tinhTieuThuTrungBinh() {
        if (dsKhachHang.isEmpty()) return 0;
        double total = 0;
        for (KhachHang kh : dsKhachHang) {
            total += kh.getTieuThu();
        }
        return total / dsKhachHang.size();
    }

    // Phương thức sắp xếp khách hàng theo mức tiêu thụ tăng dần
    public void sapXepTheoMucTieuThu() {
        dsKhachHang.sort(Comparator.comparing(KhachHang::getTieuThu));
    }
}