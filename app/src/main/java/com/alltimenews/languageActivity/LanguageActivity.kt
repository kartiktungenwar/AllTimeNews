package com.alltimenews.languageActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.alltimenews.R
import com.alltimenews.countryActivity.Country
import com.alltimenews.countryActivity.CountryAdapter
import com.alltimenews.countryActivity.CountryViewModel
import com.alltimenews.utill.SharedPreferenceManager
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import org.intellij.lang.annotations.Language

class LanguageActivity : AppCompatActivity() {

    var context: LanguageActivity? = null
    var sharedPreferenceManager: SharedPreferenceManager? = null
    var viewModel: LanguageViewModel? = null
    var recyclerView: RecyclerView? = null
    var recyclerViewAdapter: LanguageAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)
        supportActionBar!!.setTitle(resources.getString(R.string.select_language))
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        context = this
        sharedPreferenceManager = SharedPreferenceManager(context)
        recyclerView = findViewById(R.id.languageRecyclerView)
        viewModel = ViewModelProviders.of(context!!).get(LanguageViewModel::class.java)
        viewModel!!.getUserMutableLiveData()?.observe(context!!, userListUpdateObserver)
    }

    private var userListUpdateObserver: Observer<ArrayList<Languages?>?> = object :
        Observer<ArrayList<Languages?>?> {
        override fun onChanged(userArrayList: ArrayList<Languages?>?) {
            recyclerViewAdapter = LanguageAdapter(context, sharedPreferenceManager, userArrayList)
            val layoutManager = FlexboxLayoutManager()
            layoutManager.flexWrap = FlexWrap.WRAP
            layoutManager.flexDirection = FlexDirection.ROW
            layoutManager.alignItems = AlignItems.FLEX_START
            recyclerView!!.layoutManager = layoutManager
            recyclerView!!.adapter = recyclerViewAdapter

            println("TAG Action " + userArrayList?.size);
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}