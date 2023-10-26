package Service;

import java.util.List;
import model.NhanVien;

public interface NhanVienService {

    public List<NhanVien> getAll();

    public boolean add(NhanVien NhanVien);

    public void delete(String Id);
}
