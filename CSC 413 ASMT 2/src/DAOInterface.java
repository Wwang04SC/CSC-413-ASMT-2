import java.sql.SQLException;
import java.util.List;
public interface DAOInterface<E> {
    E get(int id) throws SQLException;
    int save(E e) throws SQLException;
    int insert(E e) throws SQLException;
    int update(E e) throws SQLException;
    int delete(E e) throws SQLException;
}
