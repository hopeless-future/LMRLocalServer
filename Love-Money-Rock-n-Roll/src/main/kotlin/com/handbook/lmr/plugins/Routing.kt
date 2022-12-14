package com.handbook.lmr.plugins

import com.handbook.lmr.constants.RoutesConstants.CHARACTERS_ROUTE
import com.handbook.lmr.repository.CharacterRepository
import com.handbook.lmr.repository.CharacterRepositoryImplementation
import com.handbook.lmr.routes.*
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {
    
    routing {
        route(CHARACTERS_ROUTE) {
            getAllCharacters()
            getCharacterById()
            searchCharactersByFirstLastName()
            updateCharactersWithIsFavorite()
            getAllFavoriteCharactersRoute()
        }

        static {
            resources("static")
        }
    }

}
