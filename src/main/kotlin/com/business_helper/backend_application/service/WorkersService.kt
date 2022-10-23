package com.business_helper.backend_application.service

import com.business_helper.backend_application.dto.workers.WorkersDTO
import com.business_helper.backend_application.entity.Workers
import com.business_helper.backend_application.exception.WorkerNotFoundException
import com.business_helper.backend_application.repository.WorkersRepository
import org.springframework.stereotype.Service

@Service
class WorkersService(private val repository: WorkersRepository) {

    fun getWorkers(): List<WorkersDTO> {
        return repository.findAll()
            .map {
                WorkersDTO(
                    id = it.id,
                    name = it.name,
                    surname = it.surname,
                    email = it.email,
                    phone = it.phone,
                    password = it.password,
                    role = it.role,

                    )
            }
    }

    fun getWorkerByName(workerName: String): WorkersDTO {
        val worker = repository.findByName(workerName)
        return WorkersDTO(
            id = worker.id,
            name = worker.name,
            surname = worker.surname,
            email = worker.email,
            phone = worker.phone,
            password = worker.password,
            role = worker.role,
        )
    }

    fun getWorkerById(workerId: Int): WorkersDTO {
        val worker = repository.findById(workerId)
            ?: throw WorkerNotFoundException("Worker with id $workerId not found")
        return WorkersDTO(
            id = worker.id,
            name = worker.name,
            surname = worker.surname,
            email = worker.email,
            phone = worker.phone,
            password = worker.password,
            role = worker.role,
        )
    }

    fun addWorker(worker: WorkersDTO): WorkersDTO {
        val workerEntity = worker.let {
            Workers(
                id = it.id,
                name = it.name,
                surname = it.surname,
                email = it.email,
                phone = it.phone,
                password = it.password,
                role = it.role,
            )
        }
        return repository.save(workerEntity)
            .let {
                WorkersDTO(
                    id = it.id,
                    name = it.name,
                    surname = it.surname,
                    email = it.email,
                    phone = it.phone,
                    password = it.password,
                    role = it.role,
                )
            }
    }

    fun updateWorker(worker: WorkersDTO, workerId: Int): WorkersDTO {
        val workerEntity = worker.let {
            Workers(
                id = it.id,
                name = it.name,
                surname = it.surname,
                email = it.email,
                phone = it.phone,
                password = it.password,
                role = it.role,
            )
        }
        repository.save(workerEntity)
        return workerEntity.let {
            WorkersDTO(
                id = it.id,
                name = it.name,
                surname = it.surname,
                email = it.email,
                phone = it.phone,
                password = it.password,
                role = it.role,
            )
        }
    }
}

