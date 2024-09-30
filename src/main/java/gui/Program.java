package gui;

import javax.swing.SwingUtilities;

/**
 *
 * Họ tên sinh viên: Phạm Thành Đạt
 */
public class Program {
    public static void main(String[] args) {
        // Khởi chạy giao diện FrmQLKhachHang trong luồng sự kiện của Swing
        SwingUtilities.invokeLater(() -> {
            FrmQLKhachHang frm = new FrmQLKhachHang();
            frm.setVisible(true);  // Hiển thị giao diện
        });
    }
}
