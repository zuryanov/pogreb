package ru.supervin.node.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.supervin.node.entity.RawData;

public interface RawDataDao extends JpaRepository<RawData, Long> {

}
