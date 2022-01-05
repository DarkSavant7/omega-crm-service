package ru.darksavant.omegacrmservice.common.controllers.interfaces;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import ru.darksavant.omegacrmservice.common.entities.dto.GoodDto;

@Tag(name = "Контроллер для товаров")
@CrossOrigin("*")
@RequestMapping("/api/v1/goods")
public interface GoodsController {

    @GetMapping("/{id}")
    @Operation(summary = "Поиск товара по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Товар найден",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GoodDto.class))})})
    ResponseEntity<GoodDto> findByID(@Parameter(description = "ID товара") @PathVariable(name = "id")Long id);

    @GetMapping("/codes")
    @Operation(summary = "Поиск товара по коду")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Товар найден",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GoodDto.class))})})
    ResponseEntity<GoodDto> findByVendorCode(@Parameter(description = "артикул товара") @RequestParam(name = "code") int code);

    @GetMapping()
    @Operation(summary = "Поиск товаров по названию, описанию или категории")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Товары успешно найдены в системе",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GoodDto.class))})})
    ResponseEntity<Page<GoodDto>> findGoods(@Parameter(hidden = true) @RequestParam(name = "page", defaultValue = "1") Integer page,
                                            @Parameter(hidden = true) @RequestParam(name = "page_size", defaultValue = "10") Integer pageSize,
                                            @Parameter(description = "Название") @RequestParam(required = false, name = "title") @Nullable String title,
                                            @Parameter(description = "Описание") @RequestParam(required = false, name = "description") @Nullable String description,
                                            @Parameter(description = "Категория") @RequestParam(required = false, name = "category") @Nullable String category);

    @PostMapping()
    @Operation(summary = "Создание нового товара")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Новый товар успешно создан",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))})})
    ResponseEntity<String> save(@Parameter(description = "Артикул") @RequestParam(required = false, name = "vendor_code") @Nullable String vendorCode,
                                @Parameter(description = "Название") @RequestParam(required = false, name = "title") String title,
                                @Parameter(description = "Цена") @RequestParam(required = false, name = "price") String price);

    @PutMapping()
    @Operation(summary = "Обновление информации о товаре")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Информация обновлена успешно",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GoodDto.class))})})
    ResponseEntity<GoodDto> update(@Parameter(description = "DTO товара") @RequestBody GoodDto dto);


    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление товара по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Товар успешно удален",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))})})
    ResponseEntity<String> delete(@Parameter(description = "ID") @PathVariable (name = "id") Long id);

}
