package com.alltimenews.languageActivity

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alltimenews.R
import com.alltimenews.mainActivity.MainActivity
import com.alltimenews.utill.Constant
import com.alltimenews.utill.SharedPreferenceManager
import de.hdodenhof.circleimageview.CircleImageView


class LanguageAdapter(private val context: Activity?, private val sharedPreferenceManager: SharedPreferenceManager?, private val languageArrayList: ArrayList<Languages?>?) : RecyclerView.Adapter<LanguageAdapter.ViewHolder>(),Constant {


    override fun onCreateViewHolder(viewGroup: ViewGroup, index: Int): LanguageAdapter.ViewHolder {
        val rootView = LayoutInflater.from(viewGroup.context).inflate(R.layout.row_laguage, viewGroup, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, index: Int) {
        viewHolder.languageName.text = languageArrayList?.get(index)?.getLanguageName()
        viewHolder.languageIcon.setImageResource(languageArrayList?.get(index)?.getLanguageIcon()!!)
        viewHolder.languageLinearLayout.setOnClickListener(View.OnClickListener {
            sharedPreferenceManager?.connectDB()
            sharedPreferenceManager?.setString(LANGUAGE,languageArrayList?.get(index)?.getLanguageId())
            sharedPreferenceManager?.setBoolean(FIRST_TIME,true)
            sharedPreferenceManager?.closeDB()
            context?.startActivity(Intent(context, MainActivity::class.java).setFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TOP or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK or
                        Intent.FLAG_ACTIVITY_NEW_TASK
            ))
        })
    }


    override fun getItemCount(): Int {
        return languageArrayList?.size!!;
    }

    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        var languageLinearLayout: LinearLayout = itemView.findViewById(R.id.languageLinearLayout) as LinearLayout
        var languageName: TextView = itemView.findViewById(R.id.languageName) as TextView
        var languageIcon: CircleImageView = itemView.findViewById(R.id.languageIcon) as CircleImageView
    }
}