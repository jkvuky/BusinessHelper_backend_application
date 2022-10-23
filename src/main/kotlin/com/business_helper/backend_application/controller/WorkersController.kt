package com.business_helper.backend_application.controller

import com.business_helper.backend_application.dto.workers.WorkersDTO
import com.business_helper.backend_application.service.WorkersService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/workers")
class WorkersController(val service: WorkersService) {

    @GetMapping("/all")
    fun getWorkers(): List<WorkersDTO> {
        return service.getWorkers()
    }

    @GetMapping("/name")
    fun getWorkerByName(@RequestParam("worker_name") workerName: String): WorkersDTO {
        return service.getWorkerByName(workerName)
    }

    @GetMapping("/id")
    fun getWorkerById(@RequestParam("worker_id") workerId: Int): WorkersDTO {
        return service.getWorkerById(workerId)
    }

    @PostMapping("/add",
        produces = ["application/json"],
        consumes = ["application/json"])
    @ResponseStatus(HttpStatus.CREATED)
    fun addWorker(@RequestBody @Valid worker: WorkersDTO): WorkersDTO {
        return service.addWorker(worker)
    }

    @PutMapping("/update/{worker_id}")
    fun updateWorker(
        @RequestBody worker: WorkersDTO, @PathVariable("worker_id") workerId: Int
    ) = service.updateWorker(worker, workerId)

    @DeleteMapping("/delete/{worker_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteWorker(@PathVariable("worker_id") workerId: Int) = service.deleteWorker(workerId)
}