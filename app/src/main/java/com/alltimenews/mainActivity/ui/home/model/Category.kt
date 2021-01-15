package com.alltimenews.mainActivity.ui.home.model;

public class Category {

    private var categoryId: String? = null
    private var categoryName: String? = null

    fun getCategoryId(): String? {
        return categoryId;
    }

    fun  setCategoryId(categoryId: String?) {
        this.categoryId = categoryId;
    }

    fun getCategoryName(): String? {
        return categoryName;
    }

    fun  setCategoryName(categoryName: String?) {
        this.categoryName = categoryName;
    }
}
