package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.QLKhachHang;
import model.KhachHang;

/**
 *
 * Họ tên sinh viên: Phạm Thành Đạt
 */
public class FrmQLKhachHang extends JFrame {
    private final QLKhachHang qlKhachHang;
    private JTable table;
    private DefaultTableModel model;
    private JTextField txtMin, txtAvg, txtChiSoMoi, txtSoNhanKhau, txtTienTra;
    private JButton btnNhap, btnSapXep, btnXuatHoaDon;

    public FrmQLKhachHang() {
        qlKhachHang = new QLKhachHang();
        initUI();
        initActions();
    }

    // Phương thức khởi tạo giao diện
    private void initUI() {
        setTitle("Quản lý thông tin tiêu thụ nước của khách hàng");
        setSize(800, 500);  // Mở rộng kích thước cửa sổ để chứa thêm thông tin
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Bố cục giao diện
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Các nhãn và trường văn bản mới
        JLabel lblMin = new JLabel("Số khối nước thấp nhất:");
        lblMin.setBounds(20, 300, 150, 25);
        panel.add(lblMin);

        txtMin = new JTextField();
        txtMin.setBounds(180, 300, 100, 25);
        txtMin.setEditable(false);
        panel.add(txtMin);

        JLabel lblAvg = new JLabel("Số khối nước trung bình:");
        lblAvg.setBounds(300, 300, 150, 25);
        panel.add(lblAvg);

        txtAvg = new JTextField();
        txtAvg.setBounds(450, 300, 100, 25);
        txtAvg.setEditable(false);
        panel.add(txtAvg);

        // Thêm trường hiển thị chỉ số mới
        JLabel lblChiSoMoi = new JLabel("Chỉ số mới:");
        lblChiSoMoi.setBounds(20, 340, 150, 25);
        panel.add(lblChiSoMoi);

        txtChiSoMoi = new JTextField();
        txtChiSoMoi.setBounds(180, 340, 100, 25);
        txtChiSoMoi.setEditable(false);
        panel.add(txtChiSoMoi);

        // Thêm trường hiển thị số nhân khẩu
        JLabel lblSoNhanKhau = new JLabel("Số nhân khẩu:");
        lblSoNhanKhau.setBounds(300, 340, 150, 25);
        panel.add(lblSoNhanKhau);

        txtSoNhanKhau = new JTextField();
        txtSoNhanKhau.setBounds(450, 340, 100, 25);
        txtSoNhanKhau.setEditable(false);
        panel.add(txtSoNhanKhau);

        // Thêm trường hiển thị tiền trả
        JLabel lblTienTra = new JLabel("Tiền trả (đồng):");
        lblTienTra.setBounds(20, 380, 150, 25);
        panel.add(lblTienTra);

        txtTienTra = new JTextField();
        txtTienTra.setBounds(180, 380, 100, 25);
        txtTienTra.setEditable(false);
        panel.add(txtTienTra);

        // Các nút nhập, sắp xếp, xuất hóa đơn
        btnNhap = new JButton("Nhập dữ liệu");
        btnNhap.setBounds(20, 420, 150, 30);
        panel.add(btnNhap);

        btnSapXep = new JButton("Sắp xếp");
        btnSapXep.setBounds(180, 420, 150, 30);
        panel.add(btnSapXep);

        btnXuatHoaDon = new JButton("Xuất hóa đơn");
        btnXuatHoaDon.setBounds(340, 420, 150, 30);
        panel.add(btnXuatHoaDon);

        // Tạo bảng
        model = new DefaultTableModel(new String[]{"Mã số", "Họ tên", "Số khối", "Vượt định mức", "Chỉ số mới", "Số nhân khẩu", "Tiền trả"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 740, 260);  // Mở rộng bảng để chứa thêm cột
        panel.add(scrollPane);

        add(panel);
    }

    // Phương thức xử lý các sự kiện
    private void initActions() {
        // Nhập dữ liệu từ file input.txt và hiển thị lên bảng
        btnNhap.addActionListener((ActionEvent e) -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnVal = fileChooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                qlKhachHang.DocDanhSachKhachHang(file.getAbsolutePath());
                hienThiDuLieu();
            }
        });

        // Sắp xếp khách hàng theo số khối nước tiêu thụ và cập nhật bảng
        btnSapXep.addActionListener((ActionEvent e) -> {
            qlKhachHang.sapXepTheoMucTieuThu();
            hienThiDuLieu();
        });

        // Xuất hóa đơn ra file output.txt
        btnXuatHoaDon.addActionListener((ActionEvent e) -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnVal = fileChooser.showSaveDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                boolean success = qlKhachHang.GhiDanhSachKhachHang(file.getAbsolutePath());
                if (success) {
                    JOptionPane.showMessageDialog(null, "Xuất hóa đơn thành công!");
                } else {
                    JOptionPane.showMessageDialog(null, "Xuất hóa đơn thất bại!");
                }
            }
        });
    }

    // Phương thức hiển thị dữ liệu lên bảng
    private void hienThiDuLieu() {
        model.setRowCount(0);
        ArrayList<KhachHang> dsKhachHang = qlKhachHang.getDsKhachHang();
        for (KhachHang kh : dsKhachHang) {
            Object[] row = new Object[7];
            row[0] = kh.getMaso();
            row[1] = kh.getHoten();
            row[2] = kh.getTieuThu();
            row[3] = (kh.getTieuThu() > kh.getDinhMuc()) ? "X" : "";
            row[4] = kh.getChiSoMoi();      // Hiển thị chỉ số mới
            row[5] = kh.getSoNhanKhau();    // Hiển thị số nhân khẩu
            row[6] = kh.getTienTra();       // Hiển thị tiền trả
            model.addRow(row);
        }

        // Hiển thị số khối tiêu thụ thấp nhất và trung bình
        KhachHang khThapNhat = qlKhachHang.timKhachHangTieuThuThapNhat();
        if (khThapNhat != null) {
            txtMin.setText(String.valueOf(khThapNhat.getTieuThu()));
        }
        txtAvg.setText(String.format("%.2f", qlKhachHang.tinhTieuThuTrungBinh()));

        // Hiển thị các trường chỉ số mới, số nhân khẩu, và tiền trả
        if (!dsKhachHang.isEmpty()) {
            KhachHang kh = dsKhachHang.get(0);  // Lấy khách hàng đầu tiên làm ví dụ
            txtChiSoMoi.setText(String.valueOf(kh.getChiSoMoi()));
            txtSoNhanKhau.setText(String.valueOf(kh.getSoNhanKhau()));
            txtTienTra.setText(String.valueOf(kh.getTienTra()));
        }
    }

    public static void main(String[] args) {
        new FrmQLKhachHang().setVisible(true);
    }
}