package com.alltimenews.countryActivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alltimenews.R


class CountryViewModel : ViewModel() {

    private val countryName = arrayOf(
        "Argentia", "Australia", "Austria", "Belgium", "Brazil", "Bulgaria",
        "Canada", "China", "Colombia", "Cuba", "Czech Republic", "Egypt", "France", "Germany",
        "Greece", "Hong Kong", "Hungary", "India", "Indonesia",
        "Ireland", "Israel", "Italy", "Japan", "Latvia ", "Lithuania ", "Malaysia",
        "Mexico", "Morocco", "Netherlands ", "New Zealand ", "Nigeria ", "Norway",
        "Philippines", "Poland ", "Portugal ", "Romania ", "Russia ", "Saudi Arabia",
        "Serbia", "Singapore ", "Slovakia ", "Slovenia ", "South Africa",
        "South Korea", "Sweden", "Switzerland", "Taiwan", "Thailand",
        "Turkey", "UAE", "Ukraine", "United Kingdom", "United States", "Venuzuela"
    )

    private val countryId = arrayOf(
        "ar", "au", "at", "be", "br", "bg", "ca", "cn", "co", "cu", "cz", "eg",
        "fr", "de", "gr", "hk", "hu", "in", "id", "ie", "il",
        "it", "jp", "lv", "lt", "my", "mx", "ma",
        "nl", "nz", "ng", "no", "ph", "pl", ",pt",
        "ro", "sa", "sg", " sk. si", "za", "kr",
        "se", "ch", "tw", "th", "tr", "ae", "ua",
        "gb", "us", "ve"
    );

    private val countryList: MutableLiveData<ArrayList<Country?>?>?  = MutableLiveData<ArrayList<Country?>?>()

    private var userArrayList: ArrayList<Country?>? = ArrayList()

    fun getUserMutableLiveData(): MutableLiveData<ArrayList<Country?>?>? {
        getCountry()
        return countryList
    }

    private fun getCountry(){
        populateList()
        countryList!!.value = userArrayList;
        println("TAG Action"+countryList?.value)
    }

    private fun populateList(){
        for (i in 0..countryId.size-1) {
            val data: Country = Country()
            data.setCountryId(countryId[i])
            data.setCountryName(countryName[i])
            data.setCountryIcon(R.drawable.logo)
            userArrayList!!.add(data)
        }
    }

}
