package os.cloud.core.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import os.cloud.core.model.cache.Student

@Repository
interface StudentCacheRepository : CrudRepository<Student, String> {
}