package service;

import java.util.List;

public interface ChuyenDeInterface<T> {

    public List<T> getAll();

    public void them(T chuyenDe) throws Exception;

    public void sua(T chuyenDe) throws Exception;

    public void xoa(int index) throws Exception;

    public List<T> sortGiamDan();

    public List<T> search(T chuyenDe);
}
