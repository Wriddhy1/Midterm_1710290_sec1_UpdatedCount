package com.oop.midterm_1710290_sec1;

public class Book {
    private int bookId;
    private String bookTitle;
    private String bookGenre;
    private Float price;
    private static int count=0;

    public Book(int bookId, String bookTitle, String bookGenre, Float price) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookGenre = bookGenre;
        this.price = price;
        count++;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Book.count = count;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookGenre='" + bookGenre + '\'' +
                ", price=" + price +
                '}';
    }
}