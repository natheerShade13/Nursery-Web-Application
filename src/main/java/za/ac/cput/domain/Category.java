package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.Objects;

@Entity
public class Category {

    @Id
    private long categoryId;
    private String categoryName;
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    protected Category(){}

    private Category(Builder builder){
        this.categoryId = builder.categoryId;
        this.categoryName = builder.categoryName;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return categoryId == category.categoryId && Objects.equals(categoryName, category.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, categoryName);
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

    public static class Builder{

        private long categoryId;
        private String categoryName;

        public Builder setCategoryId(long categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public Builder setCategoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        public Builder copy(Category category){
            this.categoryId = category.categoryId;
            this.categoryName = category.categoryName;
            return this;
        }

        public Category build(){return new Category(this);}

    }

}
