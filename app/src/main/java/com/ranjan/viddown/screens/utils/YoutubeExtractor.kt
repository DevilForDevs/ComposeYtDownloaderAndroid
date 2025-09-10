package com.ranjan.viddown.screens.utils

import com.ranjan.viddown.screens.utils.RandomStringGenerator.generateContentPlaybackNonce
import com.ranjan.viddown.screens.utils.RandomStringGenerator.generateTParameter
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject

fun YoutubeExtractor(videoId: String): JSONObject {

    val streamingData = getStreamingData(videoId)
    if (streamingData.has("playerResponse")) {
        val thumbnailUrl = "https://img.youtube.com/vi/$videoId/hqdefault.jpg"
        val playerResponse = streamingData.getJSONObject("playerResponse")
        val result = JSONObject()
        val adaptiveFormats = playerResponse
            .getJSONObject("streamingData")
            .getJSONArray("adaptiveFormats")

        val finalFormats = JSONArray()
        val seenItags = mutableSetOf<Int>()
        val seenQualityLabels = mutableSetOf<String>()

        for (i in 0 until adaptiveFormats.length()) {
            val format = adaptiveFormats.getJSONObject(i)
            val mimeType = format.optString("mimeType", "")
            val itag = format.optInt("itag", -1)
            val qualityLabel = format.optString("qualityLabel", "")

            // Skip if itag is invalid or already seen
            if (itag == -1 || seenItags.contains(itag)) continue

            // Only include mp4 video or mp4a audio formats
            val isMp4Video = mimeType.contains("mp4", ignoreCase = true) && !mimeType.contains("mp4a", ignoreCase = true)
            val isMp4Audio = mimeType.contains("mp4a", ignoreCase = true)
            val isWebmOrOpus = mimeType.contains("webm", ignoreCase = true) || mimeType.contains("opus", ignoreCase = true)

            if (isWebmOrOpus || (!isMp4Video && !isMp4Audio)) continue

            // For video formats, skip if qualityLabel is already seen
            if (isMp4Video && qualityLabel.isNotEmpty() && seenQualityLabels.contains(qualityLabel)) continue

            finalFormats.put(format)
            seenItags.add(itag)
            if (isMp4Video && qualityLabel.isNotEmpty()) {
                seenQualityLabels.add(qualityLabel)
            }
        }

        val title = playerResponse
            .getJSONObject("videoDetails")
            .getString("title")

        result.put("videoId", videoId)
        result.put("title", title)
        result.put("thumbnail", thumbnailUrl)
        result.put("formats", finalFormats)

        return result
    } else {
        println(streamingData)
    }

    return JSONObject()
}





fun videoId(url: String): String? {
    val regex = """^.*(?:(?:youtu\.be\/|v\/|vi\/|u\/\w\/|embed\/|shorts\/|live\/)|(?:(?:watch)?\?v(?:i)?=|\&v(?:i)?=))([^#\&\?]*).*""".toRegex()
    val matchResult = regex.find(url)
    if (matchResult != null) {
        val videoId = matchResult.groupValues[1]
        return videoId
    }
    return null
}
fun androidPlayerResponse(cpn:String,visitorData:String,videoId:String,t:String): Request {
    val url = "https://youtubei.googleapis.com/youtubei/v1/reel/reel_item_watch?prettyPrint=false&t=$t&id=$videoId&fields=playerResponse"

    // Create the JSON request body
    val jsonBody = JSONObject().apply {
        put("cpn", cpn)
        put("contentCheckOk", true)
        put("context", JSONObject().apply {
            put("request", JSONObject().apply {
                put("internalExperimentFlags", JSONArray())
                put("useSsl", true)
            })
            put("client", JSONObject().apply {
                put("androidSdkVersion", 35)
                put("utcOffsetMinutes", 0)
                put("osVersion", "15")
                put("hl", "en-GB")
                put("clientName", "ANDROID")
                put("gl", "GB")
                put("clientScreen", "WATCH")
                put("clientVersion", "19.28.35")
                put("osName", "Android")
                put("platform", "MOBILE")
                put("visitorData", visitorData)
            })
            put("user", JSONObject().apply {
                put("lockedSafetyMode", false)
            })
        })
        put("racyCheckOk", true)
        put("videoId", videoId)
        put("playerRequest", JSONObject().apply {
            put("videoId", videoId)
        })
        put("disablePlayerResponse", false)
    }

    // Define the request headers
    val headers = mapOf(
        "User-Agent" to "com.google.android.youtube/19.28.35 (Linux; U; Android 15; GB) gzip",
        "X-Goog-Api-Format-Version" to "2",
        "Content-Type" to "application/json",
        "Accept-Language" to "en-GB, en;q=0.9"
    )
    val requestBody = jsonBody.toString().toRequestBody("application/json".toMediaTypeOrNull())
    val requestBuilder = Request.Builder()
        .url(url)
        .post(requestBody)
    headers.forEach { (key, value) ->
        requestBuilder.addHeader(key, value)
    }
    val request = requestBuilder.build()
    return request

}
fun getVisitorId(): String {
    val client = OkHttpClient()
    val url = "https://youtubei.googleapis.com/youtubei/v1/visitor_id?prettyPrint=false"

    // JSON Body
    val jsonBody = JSONObject(
        mapOf(
            "context" to mapOf(
                "request" to mapOf(
                    "internalExperimentFlags" to emptyList<Any>(),
                    "useSsl" to true
                ),
                "client" to mapOf(
                    "androidSdkVersion" to 35,
                    "utcOffsetMinutes" to 0,
                    "osVersion" to "15",
                    "hl" to "en-GB",
                    "clientName" to "ANDROID",
                    "gl" to "GB",
                    "clientScreen" to "WATCH",
                    "clientVersion" to "19.28.35",
                    "osName" to "Android",
                    "platform" to "MOBILE"
                ),
                "user" to mapOf(
                    "lockedSafetyMode" to false
                )
            )
        )
    )

    // Headers
    val headers = mapOf(
        "User-Agent" to "com.google.android.youtube/19.28.35 (Linux; U; Android 15; GB) gzip",
        "X-Goog-Api-Format-Version" to "2",
        "Content-Type" to "application/json",
        "Accept-Language" to "en-GB, en;q=0.9"
    )

    // Convert JSON to Request Body
    val requestBody = jsonBody.toString().toRequestBody("application/json".toMediaTypeOrNull())

    // Build Request
    val requestBuilder = Request.Builder()
        .url(url)
        .post(requestBody)

    // Add Headers
    headers.forEach { (key, value) ->
        requestBuilder.addHeader(key, value)
    }

    // Final Request
    val request = requestBuilder.build()
    val respons=client.newCall(request).execute()
    val responseString=respons.body?.string()
    val responseJson=JSONObject(responseString)
    return responseJson.getJSONObject("responseContext").getString("visitorData")

}
fun getStreamingData(videoId: String): JSONObject {
    val requestResponse = JSONObject()
    val cpn = generateContentPlaybackNonce()
    val tp = generateTParameter()
    val visitorData = getVisitorId()
    val request = androidPlayerResponse(cpn, visitorData, videoId, tp)
    val client = OkHttpClient()

    try {
        val response = client.newCall(request).execute()
        if (response.code == 200) {
            val responseString = response.body?.string()
            return JSONObject(responseString)
        } else {
            requestResponse.put("error", "Returning fail: HTTP ${response.code}")
        }
    } catch (e: Exception) {
        requestResponse.put("error", e.message ?: "Unknown error")
    }
    return JSONObject()
}

