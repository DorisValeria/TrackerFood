import java.util.List;

public interface FoodRepository {
    List<Food> findAll();
    Food findById(int id);
    void save(Food film);
    void delete(int id);
}
