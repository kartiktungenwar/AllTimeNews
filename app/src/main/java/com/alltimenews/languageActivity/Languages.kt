package com.alltimenews.languageActivity

class Languages {

    private var languageId: String? = null
    private var languageName: String? = null
    private var languageIcon = 0

    fun getLanguageId(): String? {
        return languageId
    }

    fun setLanguageId(languageId: String?) {
        this.languageId = languageId
    }

    fun getLanguageName(): String? {
        return languageName
    }

    fun setLanguageName(languageName: String?) {
        this.languageName = languageName
    }

    fun getLanguageIcon(): Int {
        return languageIcon
    }

    fun setLanguageIcon(languageIcon: Int) {
        this.languageIcon = languageIcon
    }
}
