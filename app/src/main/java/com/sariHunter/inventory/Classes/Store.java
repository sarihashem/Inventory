package com.sariHunter.inventory.Classes;

public class Store {
    private String name;
    private String description;
    private String dateofCreation;
    private String imgURL;

    private double value;
    private double totalSales;
    private double salesOfTheMonth;
    private double salesOfTheDay;
    private double salesOfTheYear;
    private double productsId;

    private int productsNum;

    private int id;

    public Store() {
    }

    public Store(String name, String description, String dateofCreation,
                 double value, double totalSales, double salesOfTheMonth,
                 double salesOfTheDay, double salesOfTheYear, double productsId,
                 int productsNum, int id) {
        this.name = name;
        this.description = description;
        this.dateofCreation = dateofCreation;
        this.value = value;
        this.totalSales = totalSales;
        this.salesOfTheMonth = salesOfTheMonth;
        this.salesOfTheDay = salesOfTheDay;
        this.salesOfTheYear = salesOfTheYear;
        this.productsId = productsId;
        this.productsNum = productsNum;
        this.id = id;
    }

    public Store(String name, String description, String dateofCreation, double value, double totalSales,
                 double salesOfTheMonth, double salesOfTheDay, double salesOfTheYear, double productsId, int productsNum) {
        this.name = name;
        this.description = description;
        this.dateofCreation = dateofCreation;
        this.value = value;
        this.totalSales = totalSales;
        this.salesOfTheMonth = salesOfTheMonth;
        this.salesOfTheDay = salesOfTheDay;
        this.salesOfTheYear = salesOfTheYear;
        this.productsId = productsId;
        this.productsNum = productsNum;
    }

    public Store(String name, String dateofCreation, double value) {
        this.name = name;
        this.dateofCreation = dateofCreation;
        this.value = value;
    }

    public Store(String name, String dateofCreation, String imgURL, double value) {
        this.name = name;
        this.dateofCreation = dateofCreation;
        this.imgURL = imgURL;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateofCreation() {
        return dateofCreation;
    }

    public void setDateofCreation(String dateofCreation) {
        this.dateofCreation = dateofCreation;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    public double getSalesOfTheMonth() {
        return salesOfTheMonth;
    }

    public void setSalesOfTheMonth(double salesOfTheMonth) {
        this.salesOfTheMonth = salesOfTheMonth;
    }

    public double getSalesOfTheDay() {
        return salesOfTheDay;
    }

    public void setSalesOfTheDay(double salesOfTheDay) {
        this.salesOfTheDay = salesOfTheDay;
    }

    public double getSalesOfTheYear() {
        return salesOfTheYear;
    }

    public void setSalesOfTheYear(double salesOfTheYear) {
        this.salesOfTheYear = salesOfTheYear;
    }

    public double getProductsId() {
        return productsId;
    }

    public void setProductsId(double productsId) {
        this.productsId = productsId;
    }

    public int getProductsNum() {
        return productsNum;
    }

    public void setProductsNum(int productsNum) {
        this.productsNum = productsNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateofCreation='" + dateofCreation + '\'' +
                ", imgURL='" + imgURL + '\'' +
                ", value=" + value +
                ", totalSales=" + totalSales +
                ", salesOfTheMonth=" + salesOfTheMonth +
                ", salesOfTheDay=" + salesOfTheDay +
                ", salesOfTheYear=" + salesOfTheYear +
                ", productsId=" + productsId +
                ", productsNum=" + productsNum +
                ", id=" + id +
                '}';
    }
}
