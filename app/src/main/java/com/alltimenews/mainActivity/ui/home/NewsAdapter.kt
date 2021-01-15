package com.alltimenews.mainActivity.ui.home

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alltimenews.R
import com.alltimenews.countryActivity.CountryAdapter
import com.alltimenews.mainActivity.ui.home.model.Articles
import com.alltimenews.mainActivity.ui.home.model.Category
import com.alltimenews.utill.SharedPreferenceManager
import com.bumptech.glide.Glide


class NewsAdapter(private val context: Context?, private val sharedPreferenceManager: SharedPreferenceManager?, private val txtNewsArrayList: List<Articles?>?) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    var VIEW_TYPE: Int = 0
    override fun onCreateViewHolder(viewGroup: ViewGroup, index: Int): NewsAdapter.ViewHolder {
        var rootView: View? = null
        println("TAG Action list "+(VIEW_TYPE))
        if (VIEW_TYPE == 0)
            rootView = LayoutInflater.from(viewGroup.context).inflate(R.layout.row_news_even, viewGroup, false)
        else
            rootView = LayoutInflater.from(viewGroup.context).inflate(R.layout.row_news_odd, viewGroup, false)
        return ViewHolder(rootView)
    }

    override fun getItemViewType(position: Int): Int {
        if (position % 2 == 0)
            VIEW_TYPE = 0
        else
            VIEW_TYPE = 1

        return VIEW_TYPE
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, index: Int) {
        viewHolder.txtNewsAuthor.text = txtNewsArrayList?.get(index)?.source?.name
        viewHolder.txtNewsTitle.text = txtNewsArrayList?.get(index)?.title
        viewHolder.txtNewsDate.text = txtNewsArrayList?.get(index)?.publishedAt

        context?.let {
            Glide.with(it)
                .load(txtNewsArrayList?.get(index)?.urlToImage)
                .error(R.drawable.logo)
                .placeholder(R.drawable.logo)
                .into(viewHolder.imNewsImage)
        };
        viewHolder.txtNewsLinearLayout.setOnClickListener(View.OnClickListener {
            
        })
    }


    override fun getItemCount(): Int {
        return txtNewsArrayList?.size!!;
    }

    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        var txtNewsLinearLayout: LinearLayout = itemView.findViewById(R.id.txtNewsLinearLayout) as LinearLayout
        var txtNewsAuthor: TextView = itemView.findViewById(R.id.txtNewsAuthor) as TextView
        var txtNewsTitle: TextView = itemView.findViewById(R.id.txtNewsTitle) as TextView
        var txtNewsDate: TextView = itemView.findViewById(R.id.txtNewsDate) as TextView
        var imNewsImage: ImageView = itemView.findViewById(R.id.imNewsImage) as ImageView
    }
}