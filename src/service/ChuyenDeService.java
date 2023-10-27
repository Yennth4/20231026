package service;

import java.util.List;
import model.ChuyenDe;
import repository.ChuyenDeRepository;

public class ChuyenDeService {

    ChuyenDeRepository dao;
    
    public ChuyenDeService() {
        dao = new ChuyenDeRepository();
    }
    
    public List<ChuyenDe> getAll() {
        return dao.getAll();
    }
    
    public void them(ChuyenDe chuyenDe) throws Exception {
        dao.them(chuyenDe);
    }
    
    public void sua(ChuyenDe chuyenDe) throws Exception {
        dao.sua(chuyenDe);
    }
    
    public void xoa(int index) throws Exception {
        dao.xoa(index);
    }
    
    public List<ChuyenDe> sortGiamDan() {
        return dao.sortGiamDan();
    }
    
    public List<ChuyenDe> search(ChuyenDe chuyenDe) {
        return dao.search(chuyenDe);
    }
}
