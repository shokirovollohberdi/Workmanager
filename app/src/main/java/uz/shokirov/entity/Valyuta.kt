package uz.shokirov.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Valyuta {
    var Ccy: String? = null
    var CcyNm_EN: String? = null
    var CcyNm_RU: String? = null
    var CcyNm_UZ: String? = null
    var CcyNm_UZC: String? = null
    var Code: String? = null
    var Date: String? = null
    var Diff: String? = null
    var Nominal: String? = null
    var Rate: String? = null
    @PrimaryKey
    var id: Int? = null
}