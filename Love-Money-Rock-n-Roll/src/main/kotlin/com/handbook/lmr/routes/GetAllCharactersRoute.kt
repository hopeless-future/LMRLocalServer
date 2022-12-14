package com.handbook.lmr.routes

import com.handbook.lmr.constants.ErrorConstants.NOT_FOUND
import com.handbook.lmr.repository.CharacterRepository
import com.handbook.lmr.utils.DatabaseUtils.errorResponse
import com.handbook.lmr.utils.DatabaseUtils.isDatabaseQueryResultEmpty
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.getAllCharacters() {
    val characterRepository: CharacterRepository by inject()
    get {
        val allCharacters = characterRepository.getAllCharacters()
        if (isDatabaseQueryResultEmpty(allCharacters)) errorResponse(NOT_FOUND, HttpStatusCode.NotFound) else call.respond(HttpStatusCode.OK, allCharacters)
    }
}