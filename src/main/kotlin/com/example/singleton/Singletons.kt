package com.example.singleton

import com.example.helpers.Constants
import com.example.model.db.Lobby
import com.example.model.db.User
import com.typesafe.config.ConfigFactory
import org.litote.kmongo.reactivestreams.*
import org.litote.kmongo.coroutine.*
import org.mindrot.jbcrypt.BCrypt
import io.ktor.config.*

object Singletons {

    val db by lazy {
        KMongo.createClient(HoconApplicationConfig(ConfigFactory.load()).property("mongo.connection").getString()).coroutine.getDatabase("Archimedes-Rest") }
    val Lobbies by lazy { db.getCollection<Lobby>() }
    val Users by lazy { db.getCollection<User>() }
    val crypt by lazy { BCrypt() }
    val const by lazy { Constants() }
}