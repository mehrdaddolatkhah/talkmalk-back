package com.talkmalk.plugins

import com.talkmalk.room.RoomController
import com.talkmalk.route.chatSocket
import com.talkmalk.route.getAllMessages
import io.ktor.routing.*
import io.ktor.application.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val roomController by inject<RoomController>()
    install(Routing) {
        chatSocket(roomController = roomController)
        getAllMessages(roomController = roomController)
    }
}
