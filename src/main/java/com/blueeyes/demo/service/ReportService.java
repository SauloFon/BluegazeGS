package com.blueeyes.demo.service;

import com.blueeyes.demo.domain.Address;
import com.blueeyes.demo.domain.Report;
import com.blueeyes.demo.exceptions.AddressNotFoundException;
import com.blueeyes.demo.repository.AddressRepository;
import com.blueeyes.demo.repository.ReportRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ReportService {

    private final ReportRepository reportRepository;

    public Report save(Report report) {
        return reportRepository.save(report);
    }

    public Report findById(Long id) {
        return reportRepository.findById(id).orElseThrow(() -> new AddressNotFoundException("Not Found Report with id: " + id));
    }

    public List<Report> findAll() {
        return reportRepository.findAll();
    }

}
