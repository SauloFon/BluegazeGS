package com.blueeyes.demo.repository;

import com.blueeyes.demo.domain.Address;
import com.blueeyes.demo.domain.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
