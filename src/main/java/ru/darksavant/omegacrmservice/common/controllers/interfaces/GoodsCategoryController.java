package ru.darksavant.omegacrmservice.common.controllers.interfaces;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.darksavant.omegacrmservice.common.entities.dto.CategoryDto;

import java.util.List;

@Tag(name = "Контроллер для категорий товаров")
@CrossOrigin("*")
@RequestMapping("/api/v1/goods_category")
public interface GoodsCategoryController {

    @GetMapping("/all")
    @Operation(summary = "Список всех категории товаров")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Категории успешно найдены",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))})})
    ResponseEntity<List<CategoryDto>> findByName();

    @PostMapping("/new")
    @Operation(summary = "Создание новой категории товаров")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Новая категория успешно создана",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))})})
    ResponseEntity<String> save(@Parameter(description = "Название") @RequestParam(name = "name") String name);

    @PutMapping("/update")
    @Operation(summary = "Изменение названия категории товаров")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Название успешно изменено",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))})})
    ResponseEntity<String> update(@Parameter(description = "Текущее название") @RequestParam(name = "oldname") String oldname,
                                  @Parameter(description = "Новое название") @RequestParam(name = "newname") String newname);

    @DeleteMapping("/delete")
    @Operation(summary = "Удаление категории товаров")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Категория успешно удалена",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))})})
    ResponseEntity<String> delete(@Parameter(description = "Название") @RequestParam(name = "name") String name);

    void deleteById(Long id);

}
