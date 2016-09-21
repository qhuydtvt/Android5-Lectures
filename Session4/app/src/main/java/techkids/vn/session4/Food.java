package techkids.vn.session4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 9/20/16.
 */
public class Food implements Serializable {

    private String title;
    private String address;
    private String description;

    private static List<Food> foodList;
    public static synchronized List<Food> getFoodList() {
        if (foodList == null) {
            foodList = new ArrayList<>();
            foodList.add(new Food("Cơm niêu gà sốt nấm",
                    "KOMBO - Hai Bà Trưng",
                    "Thố cơm nóng đầy, hôi hổi khói bay giữa những hạt cơm giòn rụm. Cưỡng lại thế nào được với miếng thịt bóng bẩy quyện lớp sốt đậm đà, chỉ ngửi thôi đã muốn nức cả mũi ra"));
            foodList.add(new Food("Bánh trứng ngô feeling tea",
                    "Feeling Tea - 147 Trần Đại Nghĩa",
                    "Bánh trứng ngô có bột, trứng và ngô thôi mà nghiện ghê gớm :))"));
            foodList.add(new Food("Ốc xào me dừa + nem chua rán",
                    "Dũng Béo - 105Y9 - Tập Thể Kinh Tế Quốc Dân Quận Hai Bà Trưng",
                    "Mình bị nghiện mấy món ốc đặc biệt là ốc xào me, ngon không từ nào diễn tả nổi. Nhưng khuyến cáo các bạn đừng gọi cùng lúc 3 món đều xào như mình, ngấy lắm"));
        }
        return foodList;
    }

    public Food(String title, String address, String description) {
        this.title = title;
        this.address = address;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
