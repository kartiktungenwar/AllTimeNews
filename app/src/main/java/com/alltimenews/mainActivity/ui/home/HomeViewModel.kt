package com.alltimenews.mainActivity.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.alltimenews.mainActivity.ui.home.model.Category
import com.alltimenews.util.Repository
import com.alltimenews.utill.Resource
import kotlinx.coroutines.Dispatchers

class HomeViewModel(private val mainRepository: Repository)  : ViewModel() {

    private val categoryName = arrayOf(
        "All", "Business", "Entertainment", "Health", "Science", "Sports", "Technology"
    )

    private val categoryId = arrayOf(
        "", "business", "entertainment", "health", "science", "sports", "technology"
    );

    private val categoryList: MutableLiveData<ArrayList<Category?>?>?  = MutableLiveData<ArrayList<Category?>?>()

    private var categoryArrayList: ArrayList<Category?>? = ArrayList()

        fun getCategoryMutableLiveData(): MutableLiveData<ArrayList<Category?>?>? {
        getCategory()
        return categoryList
    }

    private fun getCategory(){
        populateList()
        categoryList!!.value = categoryArrayList;
        println("TAG Action"+categoryList?.value)
    }

    private fun populateList(){
        for (i in 0..categoryId.size-1) {
            val data: Category = Category()
            data.setCategoryId(categoryId[i])
            data.setCategoryName(categoryName[i])
            categoryArrayList!!.add(data)
        }
    }

    fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUsers()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

}