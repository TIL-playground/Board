package module.board.domain;

import lombok.RequiredArgsConstructor;
import module.board.common.DataProxy;
import module.board.common.exception.BadRequestException;
import module.board.common.exception.ServerException;
import module.board.common.query.ExistsUserByEmailQuery;
import module.board.common.query.ExistsUserByNicknameQuery;
import module.board.common.query.GetUserByEmailQuery;
import module.board.common.query.GetUserByNicknameQuery;
import module.board.common.request.PageRequest;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class UserDataProxy extends DataProxy<UserDto> {
    private final UserRepository repository;

    @Override
    public UserDto save(final Object... args) {
        return proceedSave(args);
    }

    @Override
    public Object get(final Object... args) {
        if (args.length == 1) {
            switch (args[0]) {
                case GetUserByEmailQuery q -> repository.getByEmail(q.email());
                case GetUserByNicknameQuery q -> repository.getByNickname(q.nickname());
                case ExistsUserByEmailQuery q -> repository.existsByEmail(q.email());
                case ExistsUserByNicknameQuery q -> repository.existsByNickname(q.nickname());
                default -> throw new ServerException("쿼리 타입 변형 오류가 발생하였습니다.");
            }
        }
        else if (args.length == 2 && args[1] instanceof final PageRequest pageRequest) {
            return repository.searchByNickname((String) args[0], pageRequest.page(), pageRequest.size());
        }

        return proceedGet(args);
    }

    @Override
    public void delete(final Object... args) {
        proceedDelete(args);
    }
}
