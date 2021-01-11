package com.alltimenews.countryActivity

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.alltimenews.R
import com.alltimenews.languageActivity.LanguageActivity
import com.alltimenews.utill.Repository
import com.alltimenews.utill.SharedPreferenceManager
import de.hdodenhof.circleimageview.CircleImageView


class CountryAdapter(private val context: Activity?, private val sharedPreferenceManager: SharedPreferenceManager?, private val countryArrayList: ArrayList<Country?>?) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, index: Int): CountryAdapter.ViewHolder {
        val rootView = LayoutInflater.from(viewGroup.context).inflate(R.layout.row_country, viewGroup, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, index: Int) {
        viewHolder.countryName.text = countryArrayList?.get(index)?.getCountryName()
        viewHolder.countryIcon.setImageResource(countryArrayList?.get(index)?.getCountryIcon()!!)
        viewHolder.countryLinearLayout.setOnClickListener(View.OnClickListener {
            sharedPreferenceManager?.connectDB()
            sharedPreferenceManager?.setString("country",countryArrayList?.get(index)?.getCountryId())
            sharedPreferenceManager?.closeDB()
            context?.startActivity(Intent(context,LanguageActivity::class.java))
        })
    }


    override fun getItemCount(): Int {
        return countryArrayList?.size!!;
    }

    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        var countryLinearLayout: LinearLayout = itemView.findViewById(R.id.countryLinearLayout) as LinearLayout
        var countryName: TextView = itemView.findViewById(R.id.countryName) as TextView
        var countryIcon: CircleImageView = itemView.findViewById(R.id.countryIcon) as CircleImageView
    }
}