package ru.darksavant.omegacrmservice.common.services.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.entities.TaskStatus;
import ru.darksavant.omegacrmservice.common.repositories.TaskStatusRepository;
import ru.darksavant.omegacrmservice.common.services.interfaces.TaskStatusService;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

@Service
@AllArgsConstructor
public class TaskStatusServiceImpl implements TaskStatusService {
    private final TaskStatusRepository taskStatusRepository;

    public TaskStatus findByName(String name){
         return taskStatusRepository.findByDescription(name).orElseThrow(()-> new ResourceNotFoundException("Task status not found"));
    }

    public TaskStatus save (TaskStatus status){
        return taskStatusRepository.save(status);
    }

    public void delete (TaskStatus status){
            taskStatusRepository.delete(status);
    }

    public void deleteById(Long id){
        taskStatusRepository.deleteById(id);
    }


}
