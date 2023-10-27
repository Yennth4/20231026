package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ChuyenDe;
import service.ChuyenDeInterface;

public class ChuyenDeRepository implements ChuyenDeInterface<ChuyenDe> {

    private Connection conn;

    public ChuyenDeRepository() {
        try {
            conn = DBContext.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ChuyenDe> getAll() {
        List<ChuyenDe> list = new ArrayList<>();
        try {
            String query = """
                           SELECT MaCD , TenCD , HocPhi , ThoiLuong , MoTa FROM ChuyenDe
                           """;
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ChuyenDe(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void them(ChuyenDe chuyenDe) throws Exception {
        try {
            String query = """
                           INSERT INTO ChuyenDe ( MaCD , TenCD , HocPhi , ThoiLuong , MoTa ) 
                           VALUES (?,?,?,?,?)
                           """;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setObject(1, chuyenDe.getMa());
            ps.setObject(2, chuyenDe.getTen());
            ps.setObject(3, chuyenDe.getHocPhi());
            ps.setObject(4, chuyenDe.getThoiLuong());
            ps.setObject(5, chuyenDe.getMoTa());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void sua(ChuyenDe chuyenDe) throws Exception {
        try {
            String query = """
                           UPDATE ChuyenDe SET TenCD = ? , HocPhi = ? , ThoiLuong = ? , MoTa = ?
                           WHERE MaCD = ?
                           """;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setObject(1, chuyenDe.getTen());
            ps.setObject(2, chuyenDe.getHocPhi());
            ps.setObject(3, chuyenDe.getThoiLuong());
            ps.setObject(4, chuyenDe.getMoTa());
            ps.setObject(5, chuyenDe.getMa());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void xoa(int index) throws Exception {
        try {
            String query = """
                           DELETE FROM KhoaHoc WHERE MaCD = ?
                           DELETE FROM ChuyenDe WHERE MaCD = ?
                           """;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setObject(1, index);
            ps.setObject(2, index);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<ChuyenDe> sortGiamDan() {
        List<ChuyenDe> list = new ArrayList<>();
        try {
            String query = """
                           SELECT MaCD , TenCD , HocPhi , ThoiLuong , MoTa FROM ChuyenDe ORDER BY MaCD DESC
                           """;
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ChuyenDe(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ChuyenDe> search(ChuyenDe chuyenDe) {
        List<ChuyenDe> list = new ArrayList<>();
        try {
            String query = """
                           SELECT MaCD , TenCD , HocPhi , ThoiLuong , MoTa FROM ChuyenDe WHERE TenCD LIKE ? 
                           OR TenCD LIKE ? OR TenCD LIKE ?
                           """;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setObject(1, chuyenDe.getTen() + '%');
            ps.setObject(2, '%' + chuyenDe.getTen() + '%');
            ps.setObject(3, '%' + chuyenDe.getTen());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ChuyenDe(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
