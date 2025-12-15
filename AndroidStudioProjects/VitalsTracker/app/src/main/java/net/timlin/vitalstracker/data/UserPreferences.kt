package net.timlin.vitalstracker.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class UserPreferences (
    private val context: Context
){
    object PrefKeys {
        val USERNAME = stringPreferencesKey("username")
        val EMAIL = stringPreferencesKey("email")
    }
    val Context.dataStore by preferencesDataStore(name = "user_preferences")

    val username: Flow<String> = context.dataStore.data
        .map { it[PrefKeys.USERNAME] ?: "" }

    val email: Flow<String> = context.dataStore.data
        .map { it[PrefKeys.EMAIL] ?: "" }

    suspend fun setName(username: String) {
        context.dataStore.edit {
            it[PrefKeys.USERNAME] = username
        }
    }

    suspend fun setEmail(email: String) {
        context.dataStore.edit {
            it[PrefKeys.EMAIL] = email
        }
    }
}