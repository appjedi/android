package com.cs211d.movietracker.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map


class UserPreferences (
    private val context: Context
){
    val Context.dataStore by preferencesDataStore(name = "user_preferences")

    suspend fun setName(name:String)=
        context.dataStore.edit { settings ->
            settings[nameKey]=name
        }
    val name=context.dataStore.data.map {preferences ->
        preferences[nameKey]
    }
    companion object{
        val nameKey= stringPreferencesKey("nameKey")
    }
}