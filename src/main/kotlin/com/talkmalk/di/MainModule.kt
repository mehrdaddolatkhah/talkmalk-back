package com.talkmalk.di

import com.talkmalk.data.MessageDataSource
import com.talkmalk.data.MessageDataSourceImpl
import com.talkmalk.room.RoomController
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val mainModule = module {
    single {
        KMongo.createClient().coroutine.getDatabase("message_db")
    }

    single<MessageDataSource> { MessageDataSourceImpl(get()) }

    single { RoomController(get()) }
}