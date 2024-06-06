package com.blueeyes.demo.controller;

import com.blueeyes.demo.domain.Report;
import com.blueeyes.demo.domain.Users;
import com.blueeyes.demo.dtos.UsersDTO;
import com.blueeyes.demo.service.ReportService;
import com.blueeyes.demo.service.UsersService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ReportsController {

    private final ReportService reportService;

    @PostMapping
    public ResponseEntity<EntityModel<Report>> save(@Valid @RequestBody Report report){
        Report savedReport = reportService.save(report);
        return ResponseEntity.created(savedReport.toEntityModel().getRequiredLink("self").toUri())
                .body(savedReport.toEntityModel());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<EntityModel<Report>> findById(@PathVariable Long id){
        Report report = reportService.findById(id);
        return ResponseEntity.ok(report.toEntityModel());
    }

    @GetMapping
    public ResponseEntity<List<Report>> findAll(){
        List<Report> reports = reportService.findAll();
        return ResponseEntity.ok(reports);
    }


}
