
package model;

public class ChuyenDe {
    private int ma;
    private String ten;
    private Double hocPhi;
    private int thoiLuong;
    private String moTa;

    public ChuyenDe() {
    }

    public ChuyenDe(int ma, String ten, Double hocPhi, int thoiLuong, String moTa) {
        this.ma = ma;
        this.ten = ten;
        this.hocPhi = hocPhi;
        this.thoiLuong = thoiLuong;
        this.moTa = moTa;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Double getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(Double hocPhi) {
        this.hocPhi = hocPhi;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    
}
