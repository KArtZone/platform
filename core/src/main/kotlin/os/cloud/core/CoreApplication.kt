package os.cloud.core

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component
import os.cloud.core.model.cache.Student
import os.cloud.core.repository.StudentCacheRepository
import java.util.function.Function

@SpringBootApplication
class CoreApplication

fun main(args: Array<String>) {
    runApplication<CoreApplication>(*args)
}

@Component
class TestFunction : Function<Message<String>, Message<String>> {
    override fun apply(t: Message<String>): Message<String> {
        val payload = t.payload
        println(payload)
        return MessageBuilder
            .withPayload("Hello, $payload}")
            .build()
    }
}

@Component
class StudentFunction(
    val studentCacheRepository: StudentCacheRepository
) : Function<Message<Student>, Message<Student>> {
    override fun apply(t: Message<Student>): Message<Student> {
        val payload = t.payload
        studentCacheRepository.save(payload)
        println("Cached object:")
        println(payload)
        return MessageBuilder
            .withPayload(payload)
            .build()
    }
}