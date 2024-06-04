package com.blueeyes.demo.repository;

import com.blueeyes.demo.domain.Address;
import com.blueeyes.demo.domain.ReportType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportTypeRepository extends JpaRepository<ReportType, Long> {
}
