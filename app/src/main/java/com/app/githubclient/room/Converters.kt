package com.app.githubclient.room

import androidx.room.TypeConverter
import com.app.githubclient.pojo.License
import com.app.githubclient.pojo.Owner
import com.fasterxml.jackson.databind.ObjectMapper

class Converters {

    private val objectMapper = ObjectMapper()

    @TypeConverter
    fun fromOwner(owner: Owner?): String? {
        return owner?.let { objectMapper.writeValueAsString(it) }
    }

    @TypeConverter
    fun toOwner(ownerString: String?): Owner? {
        return ownerString?.let { objectMapper.readValue(it, Owner::class.java) }
    }

    @TypeConverter
    fun fromLicense(license: License?): String? {
        return license?.let { objectMapper.writeValueAsString(it) }
    }

    @TypeConverter
    fun toLicense(licenseString: String?): License? {
        return licenseString?.let { objectMapper.readValue(it, License::class.java) }
    }

}