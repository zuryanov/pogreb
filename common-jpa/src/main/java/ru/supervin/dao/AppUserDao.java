package ru.supervin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.supervin.commonjpa.entity.AppUser;

public interface AppUserDao extends JpaRepository<AppUser, Long> {
    AppUser findAppUserByTelegramUserId(Long id);
}
