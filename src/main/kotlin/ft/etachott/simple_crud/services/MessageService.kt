package ft.etachott.simple_crud.services

import ft.etachott.simple_crud.models.Message
import ft.etachott.simple_crud.repositories.MessageRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class MessageService(val db: MessageRepository) {
    fun findMessages(): List<Message> = db.findAll().toList()

    fun findMessageById(id: String): List<Message> = db.findById(id).toList()

    fun save(message: Message) = db.save(message)

    fun <T: Any> Optional<out T>.toList(): List<T> = if (isPresent) listOf(get()) else emptyList()

    fun delete(id: String) = db.deleteById(id)

    fun patch(id: String, message: Message) {
        findMessageById(id).map {
            db.save(Message(id, message.text))
        }
    }
}