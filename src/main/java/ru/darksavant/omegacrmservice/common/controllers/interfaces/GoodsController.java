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
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.darksavant.omegacrmservice.common.entities.Good;
import ru.darksavant.omegacrmservice.common.entities.dto.GoodDTO;
import ru.darksavant.omegacrmservice.common.entities.dto.JwtResponse;
import ru.darksavant.omegacrmservice.common.entities.dto.UserDTO;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Контроллер для товаров")
@CrossOrigin("*")
@RequestMapping("/api/v1/goods")
public interface GoodsController {

    @GetMapping("/codes")
    @Operation(summary = "Поиск товара по коду")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Товар найден",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GoodDTO.class))})})
    ResponseEntity<GoodDTO> findByVendorCode(@Parameter(description = "Имя нового пользователя") @RequestParam(name = "code") int code);

    @GetMapping("/get_goods")
    @Operation(summary = "Поиск товаров по имени")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Товары успешно найдены в системе",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDTO.class))})})
    ResponseEntity<Page<UserDTO>> findGoods(@Parameter(hidden = true) @RequestParam(name = "page", defaultValue = "1") Integer page,
                                            @Parameter(hidden = true) @RequestParam(name = "page_size", defaultValue = "10") Integer pageSize,
                                            @Parameter(description = "Название") @RequestParam(required = false, name = "title") @Nullable String userName,
                                            @Parameter(description = "Описание") @RequestParam(required = false, name = "description") @Nullable String email,
                                            @Parameter(description = "Категория") @RequestParam(required = false, name = "category") @Nullable String category);

    @PostMapping("/new")
    @Operation(summary = "Создание нового товара")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Новый товар успешно создан",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))})})
    ResponseEntity<String> save(@Parameter(description = "Артикул") @RequestParam(required = false, name = "vendor_code") @Nullable String vendorCode,
                                @Parameter(description = "Название") @RequestParam(required = false, name = "title") String title,
                                @Parameter(description = "Цена") @RequestParam(required = false, name = "price") String price);

    @PutMapping("/update")
    @Operation(summary = "Обновление информации о товаре")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Информация обновлена успешно",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GoodDTO.class))})})
    ResponseEntity<GoodDTO> update(@Parameter(description = "Артикул") @RequestParam(required = false, name = "vendor_code") @Nullable String vendorCode,
                                   @Parameter(description = "Название") @RequestParam(required = false, name = "title") @Nullable String title,
                                   @Parameter(description = "Цена") @RequestParam(required = false, name = "price") @Nullable String price,
                                   @Parameter(description = "Ссылка на файл превью") @RequestParam(required = false, name = "urlPreview") @Nullable String urlPreview, //todo - возможно нужны сами файлы а не ссылки
                                   @Parameter(description = "Ссылка на файл общий") @RequestParam(required = false, name = "urlFull") @Nullable String urlFull,
                                   @Parameter(description = "Описание") @RequestParam(required = false, name = "description") @Nullable String description,
                                   @Parameter(description = "Категория") @RequestParam(required = false, name = "category") @Nullable String category);


    @DeleteMapping("/delete")
    @Operation(summary = "Удаление товара")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Товар успешно удален",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))})})
    ResponseEntity<String> delete(@Parameter(description = "Артикул") @RequestParam(required = false, name = "vendor_code") @Nullable String vendorCode,
                                  @Parameter(description = "Название") @RequestParam(required = false, name = "title") @Nullable String title);

}
