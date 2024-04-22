package com.example.androidweather.model

import com.google.gson.annotations.SerializedName

data class WeatherNow(

	@field:SerializedName("elevation")
	val elevation: Any? = null,

	@field:SerializedName("generationtime_ms")
	val generationtimeMs: Any? = null,

	@field:SerializedName("current")
	val current: Current? = null,

	@field:SerializedName("timezone_abbreviation")
	val timezoneAbbreviation: String? = null,

	@field:SerializedName("current_units")
	val currentUnits: CurrentUnits? = null,

	@field:SerializedName("timezone")
	val timezone: String? = null,

	@field:SerializedName("latitude")
	val latitude: Any? = null,

	@field:SerializedName("utc_offset_seconds")
	val utcOffsetSeconds: Int? = null,

	@field:SerializedName("longitude")
	val longitude: Any? = null
)

data class Current(

	@field:SerializedName("temperature_2m")
	val temperature2m: Any? = null,

	@field:SerializedName("interval")
	val interval: Int? = null,

	@field:SerializedName("time")
	val time: String? = null
)

data class CurrentUnits(

	@field:SerializedName("temperature_2m")
	val temperature2m: String? = null,

	@field:SerializedName("interval")
	val interval: String? = null,

	@field:SerializedName("time")
	val time: String? = null
)
