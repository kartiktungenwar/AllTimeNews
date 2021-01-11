package com.alltimenews.countryActivity

class Country {


    private var countryId: String? = null
    private var countryName: String? = null
    private var countryIcon = 0

    fun getCountryId(): String? {
        return countryId
    }

    fun setCountryId(countryId: String?) {
        this.countryId = countryId
    }

    fun getCountryName(): String? {
        return countryName
    }

    fun setCountryName(countryName: String?) {
        this.countryName = countryName
    }

    fun getCountryIcon(): Int {
        return countryIcon
    }

    fun setCountryIcon(countryIcon: Int) {
        this.countryIcon = countryIcon
    }


}
