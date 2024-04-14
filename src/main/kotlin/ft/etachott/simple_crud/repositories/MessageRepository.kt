package ft.etachott.simple_crud.repositories

import ft.etachott.simple_crud.models.Message
import org.springframework.data.repository.CrudRepository

interface MessageRepository : CrudRepository<Message, String>