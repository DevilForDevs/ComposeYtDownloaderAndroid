package com.ranjan.viddown.screens.utils

import org.json.JSONObject


fun LinksManager(link: String): JSONObject {
    // Trim the link to remove leading/trailing spaces
    println(link)
    val cleanLink = link.trim()

    // Check for all common YouTube URL formats
    val ytVideoId=videoId(cleanLink)
    if (ytVideoId!=null){
        val videoDetails=YoutubeExtractor(ytVideoId)
        return videoDetails
    }

    // Return empty JSONObject if it's not a recognized YouTube link
    return JSONObject()
}