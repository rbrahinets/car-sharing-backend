package com.carsharing.controllers;

import com.carsharing.models.Status;
import com.carsharing.services.StatusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/api/v1/statuses")
public class StatusController {
    private final StatusService statusService;

    public StatusController(
        StatusService statusService
    ) {
        this.statusService = statusService;
    }

    @GetMapping("")
    public List<Status> findAll() {
        return statusService.findAll();
    }

    @GetMapping("/{id}")
    public Status findById(@PathVariable long id) {
        return statusService.findById(id);
    }

    @PostMapping("")
    public Status save(@RequestBody Status status) {
        return statusService.save(status);
    }

    @PutMapping("/{id}")
    public Status update(
        @PathVariable long id,
        @RequestBody Status status
    ) {
        return statusService.update(id, status);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        statusService.delete(id);
    }

    @GetMapping("/name/{name}")
    public Status findByName(@PathVariable String name) {
        return statusService.findByName(name);
    }
}
