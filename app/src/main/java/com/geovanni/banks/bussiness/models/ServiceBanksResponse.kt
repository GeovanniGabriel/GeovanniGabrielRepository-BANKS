package com.geovanni.banks.bussiness.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class ServiceBanksResponse:Serializable {

    @PrimaryKey
    var bankName: String = ""
    @ColumnInfo(name = "description")
    var description: String? = null
    @ColumnInfo(name = "age")
    var age: String? = null
    @ColumnInfo(name = "url")
    var url: String? = null

}