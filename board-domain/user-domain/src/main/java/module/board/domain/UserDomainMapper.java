package module.board.domain;

import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Stream;

import static org.mapstruct.ReportingPolicy.IGNORE;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
interface UserDomainMapper {
    UserDto toDto(User entity);
    User toEntity(UserDto dto);

    default List<UserDto> toDtos(List<User> entities) {
        return entities.stream()
                .map(this::toDto)
                .toList();
    }
}
