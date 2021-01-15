package com.alltimenews.mainActivity.ui.home

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alltimenews.R
import com.alltimenews.mainActivity.ui.home.model.Category
import com.alltimenews.utill.SharedPreferenceManager


class CategoryAdapter(private val context: Activity?, private val sharedPreferenceManager: SharedPreferenceManager?, private val categoryArrayList: ArrayList<Category?>?) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, index: Int): CategoryAdapter.ViewHolder {
        val rootView = LayoutInflater.from(viewGroup.context).inflate(R.layout.row_category, viewGroup, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, index: Int) {
        viewHolder.categoryName.text = categoryArrayList?.get(index)?.getCategoryName()
        viewHolder.categoryLinearLayout.setOnClickListener(View.OnClickListener {
            
        })
    }


    override fun getItemCount(): Int {
        return categoryArrayList?.size!!;
    }

    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        var categoryLinearLayout: LinearLayout = itemView.findViewById(R.id.categoryLinearLayout) as LinearLayout
        var categoryName: TextView = itemView.findViewById(R.id.categoryName) as TextView
    }
}