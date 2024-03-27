package denglu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Mapper<E> {
	public List<E> map(ResultSet rs) throws SQLException;
}
