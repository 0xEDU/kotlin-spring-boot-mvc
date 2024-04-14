package ft.etachott.simple_crud.controllers

import ft.etachott.simple_crud.models.Message
import ft.etachott.simple_crud.services.MessageService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageController(val service: MessageService) {
    @GetMapping("/")
    fun index(): List<Message> = service.findMessages()

    @GetMapping("/{id}")
    fun index(@PathVariable id: String): List<Message> =
        service.findMessageById(id)

    @PostMapping("/")
    fun post(@RequestBody message: Message) {
        service.save(message)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) {
        service.delete(id)
    }

    @PatchMapping("/{id}")
    fun patch(@PathVariable id: String, @RequestBody message: Message) {
        service.patch(id, message)
    }
}