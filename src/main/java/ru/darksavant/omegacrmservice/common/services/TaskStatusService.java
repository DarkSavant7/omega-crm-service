package ru.darksavant.omegacrmservice.common.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.entities.TaskStatus;
import ru.darksavant.omegacrmservice.common.repositories.TaskStatusRepository;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

@Service
@AllArgsConstructor
public class TaskStatusService {
    private final TaskStatusRepository taskStatusRepository;

    public TaskStatus findByName(String name){
         return taskStatusRepository.findByDescription(name).orElseThrow(()-> new ResourceNotFoundException("Task status not found"));
    }

    public boolean save (TaskStatus status){
        taskStatusRepository.save(status);
        return findByName(status.getDescription())!=null;
    }

    public boolean delete (TaskStatus status){
        try {
            taskStatusRepository.delete(status);
            return true;
        } catch (ResourceNotFoundException e){
            return false;
        }
    }


}
