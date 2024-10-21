package com.fatec.cineapp.core.util

import com.fatec.cineapp.BuildConfig

fun String?.toPostUrl( )= "${BuildConfig.BASE_URL}$this"

fun String?.toBackdropUrl() = "${BuildConfig.BASE_URL_IMAGE}$this"