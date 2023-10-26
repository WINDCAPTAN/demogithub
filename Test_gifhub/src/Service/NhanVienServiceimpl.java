package Service;

import model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NhanVienServiceimpl implements NhanVienService {

    private Connection conn = DBConnect.getConnection();

    @Override
    public List<NhanVien> getAll() {
        try {
            String sSQL = "SELECT MaNV, HoTen, MatKhau, VaiTro FROM NhanVien";
            conn = DBConnect.getConnection();

            Statement pstm = conn.createStatement();
            ResultSet rs = pstm.executeQuery(sSQL);

            List<NhanVien> List = new ArrayList<>();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString(1));
                nv.setHoTen(rs.getString(2));
                nv.setMatKhau(rs.getString(3));
                nv.setVaiTro(rs.getBoolean(4));

                List.add(nv);
            }

            return List;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    @Override
    public boolean add(NhanVien nhanVien) {
        String sql = "INSERT INTO NhanVien(MaNV, HoTen, MatKhau, VaiTro) VALUES(?, ?, ?, ?)";

        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, nhanVien.getMaNV());
            stm.setString(2, nhanVien.getHoTen());
            stm.setString(3, nhanVien.getMatKhau());

            stm.setBoolean(4, nhanVien.isVaiTro());
            stm.executeUpdate();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();

            return false;
        }
    }

    @Override
    public void delete(String MaNV) {
        try {
            String sql = "DELETE FROM NhanVien WHERE MaNV=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, MaNV);
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
