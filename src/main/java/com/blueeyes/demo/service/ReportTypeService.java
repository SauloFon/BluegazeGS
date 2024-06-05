package com.blueeyes.demo.service;

import com.blueeyes.demo.domain.Report;
import com.blueeyes.demo.domain.ReportType;
import com.blueeyes.demo.exceptions.AddressNotFoundException;
import com.blueeyes.demo.repository.ReportRepository;
import com.blueeyes.demo.repository.ReportTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ReportTypeService {

    private final ReportTypeRepository reportTypeRepository;

    public ReportType save(ReportType reportType) {
        return reportTypeRepository.save(reportType);
    }

    public ReportType findById(Long id) {
        return reportTypeRepository.findById(id).orElseThrow(() -> new AddressNotFoundException("Not Found Report with id: " + id));
    }

    public List<ReportType> findAll() {
        return reportTypeRepository.findAll();
    }

}
