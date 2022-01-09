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
import ru.darksavant.omegacrmservice.common.entities.dto.ContactDto;
import ru.darksavant.omegacrmservice.common.entities.dto.GoodDto;
import ru.darksavant.omegacrmservice.common.entities.dto.UpdateContactDto;

@Tag(name = "Контроллер для контактов")
@CrossOrigin("*")
@RequestMapping("/api/v1/contacts")
public interface ContactsController {

    @GetMapping()
    @Operation(summary = "Поиск контактов по ФИО, должности, телефонным номерам или почтовым адресам")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Товары успешно найдены в системе",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GoodDto.class))})})
    ResponseEntity<Page<GoodDto>> findContacts(@Parameter(hidden = true) @RequestParam(name = "page", defaultValue = "1") Integer page,
                                            @Parameter(hidden = true) @RequestParam(name = "page_size", defaultValue = "10") Integer pageSize,
                                            @Parameter(description = "ФИО") @RequestParam(required = false, name = "FIO") @Nullable String FIO,
                                            @Parameter(description = "Должность") @RequestParam(required = false, name = "position") @Nullable String position,
                                            @Parameter(description = "Телефон") @RequestParam(required = false, name = "phone") @Nullable Integer phone,
                                            @Parameter(description = "Email") @RequestParam(required = false, name = "email") @Nullable String email);

    @GetMapping("/{id}")
    @Operation(summary = "Поиск контакта по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Товар найден",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ContactDto.class))})})
    ResponseEntity<ContactDto> findByID(@Parameter(description = "ID контакта") @PathVariable(name = "id") Long id);

    @PostMapping()
    @Operation(summary = "Создание нового контакта")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Новый контакт успешно создан",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))})})
    ResponseEntity<String> save(@Parameter(description = "фИО, обязательный") @RequestParam(required = false, name = "FIO") String FIO,
                                @Parameter(description = "Должность") @RequestParam(required = false, name = "title") String position,
                                @Parameter(description = "Основной телефон, обязательный") @RequestParam(required = false, name = "primary_phone") Integer primaryPhone,
                                @Parameter(description = "Дополнительный телефон") @RequestParam(required = false, name = "secondary_phone") @Nullable Integer secondaryPhone,
                                @Parameter(description = "Основной email, обязательный") @RequestParam(required = false, name = "primary_email") String primaryEmail,
                                @Parameter(description = "Дополнительный телефон") @RequestParam(required = false, name = "secondary_email") @Nullable String secondaryEmail);

    @PutMapping()
    @Operation(summary = "Обновление информации о контакте: ФИО, должность, основной телефон, дополнительный телефон,основной email, дополнительный email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Информация обновлена успешно",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ContactDto.class))})})
    ResponseEntity<ContactDto> update(@Parameter(description = "DTO товара") @RequestBody UpdateContactDto dto);

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление контакта по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Контакт успешно удален",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))})})
    ResponseEntity<String> delete(@Parameter(description = "ID") @PathVariable(name = "id") Long id);

}
