package ru.darksavant.omegacrmservice.common.controllers.interfaces;

import ru.darksavant.omegacrmservice.common.entities.TaskStatus;

public interface TaskStatusController {

    TaskStatus findByName(String name);

    TaskStatus save(TaskStatus status);

    void delete(TaskStatus status);

    void deleteById(Long id);

}
