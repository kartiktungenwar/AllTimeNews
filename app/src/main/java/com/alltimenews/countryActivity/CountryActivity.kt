package com.alltimenews.countryActivity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.alltimenews.R
import com.alltimenews.utill.SharedPreferenceManager
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager


class CountryActivity : AppCompatActivity() {

    var context: CountryActivity? = null
    var sharedPreferenceManager: SharedPreferenceManager? = null
    var viewModel: CountryViewModel? = null
    var recyclerView: RecyclerView? = null
    var recyclerViewAdapter: CountryAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)
        supportActionBar!!.setTitle(resources.getString(R.string.select_country))
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        context = this
        sharedPreferenceManager = SharedPreferenceManager(context);
        recyclerView = findViewById(R.id.countryRecyclerView)
        viewModel = ViewModelProviders.of(context!!).get(CountryViewModel::class.java)
        viewModel!!.getUserMutableLiveData()?.observe(context!!, this.userListUpdateObserver)
    }

     private var userListUpdateObserver: Observer<ArrayList<Country?>?> = object : Observer<ArrayList<Country?>?>  {
        override fun onChanged(userArrayList: ArrayList<Country?>?) {
            recyclerViewAdapter = CountryAdapter(context, sharedPreferenceManager, userArrayList)
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

