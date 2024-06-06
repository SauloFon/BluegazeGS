package com.blueeyes.demo.controller;

import com.blueeyes.demo.domain.Report;
import com.blueeyes.demo.domain.ReportType;
import com.blueeyes.demo.service.ReportService;
import com.blueeyes.demo.service.ReportTypeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report-type")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ReportTypeController {

    private final ReportTypeService reportTypeService;

    @PostMapping
    public ResponseEntity<EntityModel<ReportType>> save(@Valid @RequestBody ReportType reportType){
        ReportType savedReportType = reportTypeService.save(reportType);
        return ResponseEntity.created(savedReportType.toEntityModel().getRequiredLink("self").toUri())
                .body(savedReportType.toEntityModel());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<EntityModel<ReportType>> findById(@PathVariable Long id){
        ReportType report = reportTypeService.findById(id);
        return ResponseEntity.ok(report.toEntityModel());
    }

    @GetMapping
    public ResponseEntity<List<ReportType>> findAll(){
        List<ReportType> reports = reportTypeService.findAll();
        return ResponseEntity.ok(reports);
    }


}
