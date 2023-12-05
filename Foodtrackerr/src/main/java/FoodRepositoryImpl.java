import java.util.ArrayList;
import java.util.List;

public class FoodRepositoryImpl implements FoodRepository {
    private List<Food> foods = new ArrayList<>();

    @Override
    public List<Food> findAll() {
        return new ArrayList<>(foods);
    }

    @Override
    public Food findById(int id) {
        for (Food food : foods) {
            if (food.getId() == id) {
                return food;
            }
        }
        return null;
    }

    @Override
    public void save(Food food) {
        foods.add(food);
    }

    @Override
    public void delete(int id) {
        foods.removeIf(food -> food.getId() == id);
    }
}
