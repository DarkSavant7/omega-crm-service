package ru.darksavant.omegacrmservice.common.services.interfaces;

import ru.darksavant.omegacrmservice.common.entities.TaskStatus;

public interface TaskStatusService {

    TaskStatus findByName(String name);

    TaskStatus save(TaskStatus status);

    void delete(TaskStatus status);

    void deleteById(Long id);

}
