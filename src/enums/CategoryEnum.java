package enums;

public enum CategoryEnum {
    BOOKS ("Libros"),
    BABYS("Bebé"),
    TOYS("Juguetes");
    private String nameCategory;

    CategoryEnum(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
