package com.alltimenews.mainActivity.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alltimenews.R
import com.alltimenews.mainActivity.ui.home.`interface`.CategoryChangeInterface
import com.alltimenews.mainActivity.ui.home.model.Category
import com.alltimenews.utill.*

class HomeFragment : Fragment(),Constant, CategoryChangeInterface {

    var viewModel: HomeViewModel? = null
    var sharedPreferenceManager: SharedPreferenceManager? = null
    var recyclerView: RecyclerView? = null
    var progressBar: ProgressBar? = null
    var recyclerViewNews: RecyclerView? = null
    var recyclerViewAdapter: CategoryAdapter? = null
    var newsAdapter: NewsAdapter? = null
    var country: String? = ""
    var category: String? = ""
    var apiKey: String? = ""
    var language: String? = "en"
    var categoryChangeInterface: CategoryChangeInterface? = null
    var root: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_home, container, false)
        categoryChangeInterface = this
        callHome(category);
        inti(root);
        return root
    }

    private fun callHome(category: String?) {
        sharedPreferenceManager = SharedPreferenceManager(context)
        sharedPreferenceManager!!.connectDB()
        country = sharedPreferenceManager!!.getString(COUNTRY_ID)
        //language = sharedPreferenceManager!!.getString(LANGUAGE)
        sharedPreferenceManager!!.closeDB()
        apiKey = API_KEY

        println("TAG home apiKey "+apiKey)
        println("TAG home country "+country)
        println("TAG home category "+category)
        println("TAG home language "+language)
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(Helper(NetworkModule.apiService,country,language,category,apiKey))
        ).get(HomeViewModel::class.java)
        progressBar = view?.findViewById(R.id.main_progress)
        recyclerViewNews = view?.findViewById(R.id.newsListRecyclerView)
        setupObservers()
    }


    private fun inti(view: View?) {
        recyclerView = view?.findViewById(R.id.categoryRecyclerView)
        viewModel!!.getCategoryMutableLiveData()?.observe(viewLifecycleOwner!!, this.userListUpdateObserver)
    }

    private var userListUpdateObserver: Observer<ArrayList<Category?>?> = object :
        Observer<ArrayList<Category?>?> {
        override fun onChanged(userArrayList: ArrayList<Category?>?) {
            recyclerViewAdapter = CategoryAdapter(activity, sharedPreferenceManager,categoryChangeInterface, userArrayList)
            val layoutManager =  LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
            recyclerView!!.layoutManager = layoutManager
            recyclerView!!.adapter = recyclerViewAdapter
        }
    }

    private fun setupObservers() {
        viewModel?.getUsers()?.observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        recyclerViewNews?.visibility = View.VISIBLE
                        progressBar?.visibility = View.GONE
                        resource.data?.let { users ->
                            println("TAG Action articles "+users.toString())
                            if (users.articles.isEmpty())

                            else
                                newsAdapter = NewsAdapter(context,sharedPreferenceManager,users.articles)
                                recyclerViewNews?.visibility = View.VISIBLE
                                val layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
                                recyclerViewNews!!.layoutManager = layoutManager
                                recyclerViewNews!!.adapter = newsAdapter

                        }
                    }
                    Status.ERROR -> {
                        recyclerViewNews?.visibility = View.VISIBLE
                        progressBar?.visibility = View.GONE
                        println("TAG Action articles"+it.message)
                    }
                    Status.LOADING -> {
                        progressBar?.visibility = View.VISIBLE
                        recyclerViewNews?.visibility = View.GONE
                    }
                }
            }
        })
    }

    override fun categoryChange(category: String?) {
        callHome(category)
    }

}