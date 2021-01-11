package com.alltimenews.languageActivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alltimenews.R


class LanguageViewModel : ViewModel() {

    private val languageName = arrayOf(
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

    private val languageId = arrayOf(
        "ar", "au", "at", "be", "br", "bg", "ca", "cn", "co", "cu", "cz", "eg",
        "fr", "de", "gr", "hk", "hu", "in", "id", "ie", "il",
        "it", "jp", "lv", "lt", "my", "mx", "ma",
        "nl", "nz", "ng", "no", "ph", "pl", ",pt",
        "ro", "sa", "sg", " sk. si", "za", "kr",
        "se", "ch", "tw", "th", "tr", "ae", "ua",
        "gb", "us", "ve"
    );

    private val countryList: MutableLiveData<ArrayList<Languages?>?>?  = MutableLiveData<ArrayList<Languages?>?>()
    private var userArrayList: ArrayList<Languages?>? = ArrayList()



    fun getUserMutableLiveData(): MutableLiveData<ArrayList<Languages?>?>? {
        getCountry()
        return countryList
    }

    private fun getCountry(){
        populateList()
        countryList!!.value = userArrayList;
        println("TAG Action"+countryList?.value)
    }

    private fun populateList(){
        for (i in 0..languageId.size-1) {
            val data: Languages = Languages()
            data.setLanguageId(languageId[i])
            data.setLanguageName(languageName[i])
            data.setLanguageIcon(R.drawable.logo)
            userArrayList!!.add(data)
        }
    }

}
