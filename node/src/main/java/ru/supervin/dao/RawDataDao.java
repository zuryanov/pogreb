package ru.supervin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.supervin.entity.RawData;

public interface RawDataDao extends JpaRepository<RawData, Long> {

}
