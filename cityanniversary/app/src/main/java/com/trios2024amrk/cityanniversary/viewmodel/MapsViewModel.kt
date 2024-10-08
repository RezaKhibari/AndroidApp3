package com.trios2024amrk.cityanniversary.viewmodel

import android.app.Application
import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.google.android.libraries.places.api.model.Place
import com.trios2024amrk.cityanniversary.repository.BookmarkRepo

// 1
class MapsViewModel(application: Application) :
    AndroidViewModel(application) {

    private val TAG = "MapsViewModel"
    // 2
    private val bookmarkRepo: BookmarkRepo = BookmarkRepo(
        getApplication())
    // 3
    fun addBookmarkFromPlace(place: Place, image: Bitmap?) {
        // 4
        val bookmark = bookmarkRepo.createBookmark()
        bookmark.placeId = place.id
        bookmark.name = place.name.toString()
        bookmark.longitude = place.latLng?.longitude ?: 0.0
        bookmark.latitude = place.latLng?.latitude ?: 0.0
        bookmark.phone = place.phoneNumber.toString()
        bookmark.address = place.address.toString()
        // 5
        val newId = bookmarkRepo.addBookmark(bookmark)

        Log.i(TAG, "New bookmark $newId added to the database.")
    }
}
